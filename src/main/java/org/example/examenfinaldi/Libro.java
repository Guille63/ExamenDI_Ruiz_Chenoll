package org.example.examenfinaldi;

import java.time.LocalDate;

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

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }
}
