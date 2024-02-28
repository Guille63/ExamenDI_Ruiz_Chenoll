package org.example.examenfinaldi;

import java.time.LocalDate;

/**
 * Clase que representa un usuario
 * @version 1.0
 * @author Guillem
 */
public class Usuario {
    private String dniUsuario;
    private LocalDate fechaAltaSancion;

    public Usuario(String dniUsuario, LocalDate fechaAltaSancion) {
        this.dniUsuario = dniUsuario;
        this.fechaAltaSancion = fechaAltaSancion;
    }

    public Usuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Usuario() {
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public LocalDate getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    public void setFechaAltaSancion(LocalDate fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }

    public void sancionar() {
        this.fechaAltaSancion = LocalDate.now();
    }

    public void quitarSancion() {
        this.fechaAltaSancion = null;
    }
}
