package org.example.examenfinaldi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class PrestamoViewContoller {

    @FXML
    private Button btPrestar;

    @FXML
    private Label labelPrestado;

    @FXML
    private TextField tfDni;

    @FXML
    private TextField tfIdLibro;

    private Biblioteca biblioteca;

    @FXML
    public void initialize() {
        biblioteca = new Biblioteca();
    }

    @FXML
    void onTomarPrestadoButtonClick(ActionEvent event) throws IOException {
        String dni = tfDni.getText();
        String idLibro = tfIdLibro.getText();
        System.out.println("Prestar libro con ISBN: " + idLibro + " a usuario con DNI: " + dni);

        if (dni.isEmpty() || idLibro.isEmpty()) {
            labelPrestado.setText("Rellena todos los campos");
            return;
        }

        int numeroPrestamos = biblioteca.getPrestamos().size();
        biblioteca.prestar(idLibro, dni);
        if (biblioteca.getPrestamos().size() > numeroPrestamos) {
            limpiar();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Libro prestado");
            alert.setHeaderText("Libro prestado");
            alert.setContentText("El libro con ISBN: " + idLibro + " ha sido prestado al usuario con DNI: " + dni);
            alert.showAndWait();

            if (alert.getResult().getText().equals("Aceptar")) {
                ScreenLoader.loadScreen("main-view.fxml", (Stage) btPrestar.getScene().getWindow());
            }
        } else {
            labelPrestado.setTextFill(Color.RED);
            labelPrestado.setText("No se ha podido prestar el libro");
        }

    }

    public void limpiar() {
        tfDni.clear();
        tfIdLibro.clear();
    }

}
