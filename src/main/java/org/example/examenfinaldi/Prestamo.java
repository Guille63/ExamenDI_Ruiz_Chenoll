package org.example.examenfinaldi;

import java.time.LocalDate;

public class Prestamo {
    private String idLibro;
    private String dniUsuario;
    private LocalDate fechaDevolucion;
    private boolean devueltoATiempo;

    public Prestamo(String idLibro, String dniUsuario, LocalDate fechaDevolucion) {
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = fechaDevolucion;

    }

    public Prestamo() {
    }

    public boolean isDevueltoATiempo() {
        return devueltoATiempo;
    }

    public void setDevueltoATiempo(boolean devueltoATiempo) {
        this.devueltoATiempo = devueltoATiempo;
    }


    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
