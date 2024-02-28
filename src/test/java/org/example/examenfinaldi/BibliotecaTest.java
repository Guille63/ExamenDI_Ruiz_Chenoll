package org.example.examenfinaldi;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    /**
     * Test para comprobar que se añade un libro a la lista de libros
     * Se añade un libro a la lista de libros
     * Luego se añade otro libro a la lista de libros con atributos diferentes
     * y se comprueba que se han añadido los dos libros a la lista de libros
     */
    @Test
    void altaLibroConAtributosUnicos() {
        Libro libro = new Libro("1", "El Quijote", "1234567890");
        Libro libro2 = new Libro("2", "El Señor de los Anillos", "9876543210");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(libro.getIdLibro(), libro.getTitulo(), libro.getIsbn());
        biblioteca.altaLibro(libro2.getIdLibro(), libro2.getTitulo(), libro2.getIsbn());

        assertEquals(2, biblioteca.getLibros().size());
    }

    /**
     * Test para comprobar que no se añade un libro con atributos repetidos
     * Se añade un libro a la lista de libros
     * Se añade un libro con los mismos atributos a la lista de libros y se comprueba que no se ha añadido
     * ese libro a la lista de libros
     */
    @Test
    void altaLibroConAtributosRepetidos() {
        Libro libro = new Libro("1", "El Quijote", "1234567890");
        Libro libro2 = new Libro("1", "El Quijote", "1234567890");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(libro.getIdLibro(), libro.getTitulo(), libro.getIsbn());
        biblioteca.altaLibro(libro2.getIdLibro(), libro2.getTitulo(), libro2.getIsbn());

        assertEquals(1, biblioteca.getLibros().size());
    }

    /**
     * Test para comprobar que se da de alta un usuario
     * Se añade primero un usuario a la lista de usuarios y se comprueba que se ha añadido
     * un prestamo a la lista de prestamos
     */
    @Test
    void prestarSiElUsuarioExiste() {
        Usuario usuario = new Usuario("12345678A");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getUsuarios().add(usuario);
        biblioteca.altaLibro("1", "El Quijote", "1234567890");

        biblioteca.prestar("1", usuario.getDniUsuario());
        assertEquals(1, biblioteca.getPrestamos().size());
    }

    /**
     * Test para comprovar que se presta un libro a un usuario que no existe
     * Se añade primero un libro a la lista de libros y se comprueba que se ha añadido
     * un prestamo a la lista de prestamos , como se espera que el usuario se
     * cree automaticamente se comprueba que se ha añadido un usuario a la lista de usuarios
     */
    @Test
    void prestarSiElUsuarioNoExiste() {
        Usuario usuario = new Usuario("12345678A");
        Libro libro = new Libro("1", "El Quijote", "1234567890");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(libro.getIdLibro(), libro.getTitulo(), libro.getIsbn());

        biblioteca.prestar("1", usuario.getDniUsuario());
        assertEquals(1, biblioteca.getPrestamos().size());
    }

    /**
     * Test para comprobar que si se presta un libro que existe
     * Se añade primero un libro a la lista de libros y se comprueba que se ha añadido
     * un prestamo a la lista de prestamos
     * Se añade un usuario a la lista de usuarios y se comprueba que se ha añadido
     * un prestamo a la lista de prestamos
     */
    @Test
    void prestarSiElLibroExiste() {
        Libro libro = new Libro("1", "El Quijote", "1234567890");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(libro.getIdLibro(), libro.getTitulo(), libro.getIsbn());
        biblioteca.prestar(libro.getIdLibro(), "12345678A");
        assertEquals(1, biblioteca.getPrestamos().size());
    }

    /**
     * Test para comprobar que si se presta un libro que no existe.
     * Se añade primero un usuario a la lista de usuarios, luego, intentamos prestar un libro
     * que no existe, y comprobamos que no se ha añadido ningun prestamo a la lista de prestamos
     */
    @Test
    void prestarSiElLibroNoExiste() {
        Usuario usuario = new Usuario("12345678A");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getUsuarios().add(usuario);
        biblioteca.prestar("1111111", "12345678A");
        assertEquals(0, biblioteca.getPrestamos().size());
    }

    /**
     * Test para comprobar que se devuelve un libro en fecha
     * Se añade primero un libro a la lista de libros
     * Se añade un usuario a la lista de usuarios
     * Se presta el libro al usuario
     * Se devuelve el libro y se comprueba que el prestamo se ha devuelto a tiempo
     */
    @Test
    void devolucionEnFecha() {
        Libro libro = new Libro("1", "El Quijote", "1234567890");
        Usuario usuario = new Usuario("12345678A");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(libro.getIdLibro(), libro.getTitulo(), libro.getIsbn());
        biblioteca.getUsuarios().add(usuario);
        biblioteca.prestar(libro.getIdLibro(), usuario.getDniUsuario());
        biblioteca.devolver(libro.getIdLibro(), usuario.getDniUsuario());
        assertTrue(biblioteca.getPrestamos().get(0).isDevueltoATiempo());
    }

    /**
     * Test para comprobar que se devuelve un libro fuera de fecha
     * Se añade primero un libro a la lista de libros
     * Se añade un usuario a la lista de usuarios
     * Se presta el libro al usuario
     * Se devuelve el libro y se comprueba que el prestamo se ha devuelto fuera de tiempo
     */
    @Test
    void devolucionFueraDeFecha() {
        // 1. Crear una instancia de Biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // 2. Añadir un Libro y un Usuario a la Biblioteca
        String idLibro = "1";
        String dniUsuario = "12345678A";
        biblioteca.altaLibro(idLibro, "El Quijote", "1234567890");
        biblioteca.getUsuarios().add(new Usuario(dniUsuario));

        // 3. Prestar el libro al usuario
        biblioteca.prestar(idLibro, dniUsuario);

        // 4. Devolver el libro
        // Simular una fecha de devolución que está después de la fecha de vencimiento
        Prestamo prestamo = biblioteca.getPrestamos().get(0);
        prestamo.setFechaDevolucion(LocalDate.now().plusDays(15)); // Suponiendo que el plazo de préstamo es de 10 días
        biblioteca.devolver(idLibro, dniUsuario);

        // 5. Comprobar si el libro se ha devuelto fuera de fecha
        assertFalse(biblioteca.getPrestamos().get(0).isDevueltoATiempo());
    }
}