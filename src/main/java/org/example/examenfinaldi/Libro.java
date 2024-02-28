package org.example.examenfinaldi;

import java.time.LocalDate;

/**
 * Clase que representa un libro
 *
 * @author Guillem
 * @version 1.0
 */
public class Libro {
    private String idLibro;
    private String titulo;
    private String isbn;
    private String autor;
    private Tematica tematica;
    private LocalDate fechaEdicion;

    public Libro(String idLibro, String titulo, String isbn, String autor, Tematica tematica, LocalDate fechaEdicion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    public Libro(String idLibro, String titulo, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public Libro() {

    }

    /**
     * Devuelve el id del libro
     *
     * @return id del libro
     */
    public String getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el id del libro
     *
     * @param idLibro id del libro
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Devuelve el titulo del libro
     *
     * @return titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el titulo del libro
     *
     * @param titulo titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el isbn del libro
     *
     * @return isbn del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el isbn del libro
     *
     * @param isbn isbn del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve el autor del libro
     *
     * @return autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro
     *
     * @param autor autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Devuelve la tematica del libro
     *
     * @return tematica del libro
     */
    public Tematica getTematica() {
        return tematica;
    }

    /**
     * Establece la tematica del libro
     *
     * @param tematica tematica del libro
     */
    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    /**
     * Devuelve la fecha de edicion del libro
     *
     * @return fecha de edicion del libro
     */
    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    /**
     * Establece la fecha de edicion del libro
     *
     * @param fechaEdicion fecha de edicion del libro
     */
    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Metodo que devuelve un string con la informacion del libro
     *
     * @return string con la informacion del libro
     */
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro='" + idLibro + '\'' +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
