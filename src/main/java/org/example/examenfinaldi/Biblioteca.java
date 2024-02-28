package org.example.examenfinaldi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
    private List<Libro> libros;
    private List<Prestamo> prestamos;
    private List<Usuario> usuarios;

    public Biblioteca(List<Libro> libros, List<Prestamo> prestamos, List<Usuario> usuarios) {
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    /**
     * Añade un libro a la biblioteca, si ya existe un libro con el mismo id o isbn, lo
     *
     * @param idLibro id del libro
     * @param titulo  titulo del libro
     * @param isbn    isbn del libro
     */
    public void altaLibro(String idLibro, String titulo, String isbn) {
        for (Libro l : libros) {
            if (l.getIdLibro().equals(idLibro) || l.getIsbn().equals(isbn)) {
                return; // Si ya existe un libro con el mismo id o isbn, no añadimos el nuevo libro y salimos del método
            }
        }
        Libro libro = new Libro(idLibro, titulo, isbn);
        libros.add(libro);
    }

    public void bajaLibro(String idLibro) {
        for (Libro libro : libros) {
            if (libro.getIdLibro().equals(idLibro)) {
                libros.remove(libro);
                break;
            }
        }
    }


    /**
     * Añade un prestamo a la lista de prestamos
     * si el usuario no existe, lo añade a la lista de usuarios
     * si el libro no existe, no añade el prestamo
     *
     * @param idLibro    id del libro
     * @param dniUsuario dni del usuario
     */
    public void prestar(String idLibro, String dniUsuario) {
        boolean usuarioExiste = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getDniUsuario().equals(dniUsuario)) {
                usuarioExiste = true;
                break;
            }
        }
        if (!usuarioExiste) {
            Usuario usuario = new Usuario(dniUsuario);
            usuarios.add(usuario);
        }

        boolean libroExiste = false;
        for (Libro libro : libros) {
            if (libro.getIdLibro().equals(idLibro)) { // Corregido aquí
                libroExiste = true;
                break;
            }
        }
        if (libroExiste) {
            Prestamo prestamo = new Prestamo(idLibro, dniUsuario, LocalDate.now().plusDays(10));
            prestamos.add(prestamo);
        }
    }

    public void devolver(String idLibro, String dniUsuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdLibro().equals(idLibro) && prestamo.getDniUsuario().equals(dniUsuario)) {
                if (prestamo.getFechaDevolucion().isAfter(LocalDate.now().plusDays(10))) {
                    prestamo.setDevueltoATiempo(false);
                } else {
                    prestamo.setDevueltoATiempo(true);
                }
            }
        }
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

//    public static void main(String[] args) {
//        Libro libro = new Libro("1", "El Quijote", "1234567890");
//        Libro libro3 = new Libro("1", "El Quijote", "1234567890");
//        Libro libro2 = new Libro("2", "El Señor de los Anillos", "9876543210");
//
//        Biblioteca biblioteca = new Biblioteca();
//        biblioteca.altaLibro(libro.getIdLibro(), libro.getTitulo(), libro.getIsbn());
//        biblioteca.altaLibro(libro2.getIdLibro(), libro2.getTitulo(), libro2.getIsbn());
//
//        System.out.println(biblioteca.getLibros().size());
//    }


}
