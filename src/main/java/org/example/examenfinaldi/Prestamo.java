package org.example.examenfinaldi;

import java.time.LocalDate;

/**
 * Clase que representa un prestamo
 *
 * @author Guillem
 * @version 1.0
 */
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

    /**
     * Comprueba si el préstamo se ha devuelto a tiempo.
     *
     * @return true si el préstamo se ha devuelto a tiempo, false en caso contrario.
     */
    public boolean isDevueltoATiempo() {
        return devueltoATiempo;
    }

    /**
     * Establece si el préstamo se ha devuelto a tiempo.
     *
     * @param devueltoATiempo el nuevo estado de devolución del préstamo.
     */
    public void setDevueltoATiempo(boolean devueltoATiempo) {
        this.devueltoATiempo = devueltoATiempo;
    }

    /**
     * Obtiene el ID del libro asociado al préstamo.
     *
     * @return el ID del libro.
     */
    public String getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el ID del libro asociado al préstamo.
     *
     * @param idLibro el nuevo ID del libro.
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Obtiene el DNI del usuario asociado al préstamo.
     *
     * @return el DNI del usuario.
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Establece el DNI del usuario asociado al préstamo.
     *
     * @param dniUsuario el nuevo DNI del usuario.
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Obtiene la fecha de devolución del préstamo.
     *
     * @return la fecha de devolución.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Establece la fecha de devolución del préstamo.
     *
     * @param fechaDevolucion la nueva fecha de devolución.
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
