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
     * ignora y no lo añade
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

    /**
     * Da de baja un libro de la biblioteca
     * Si la id del libro coincide con la id de un libro de la lista de libros, lo elimina
     *
     * @param idLibro id del libro a dar de baja
     */
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

    /**
     * Devuelve un libro
     * Si el libro se devuelve fuera de plazo, se marca como devuelto fuera de tiempo
     * Si el libro se devuelve en plazo, se marca como devuelto a tiempo
     *
     * @param idLibro    id del libro a devolver
     * @param dniUsuario id del usuario que devuelve el libro
     */
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


}
