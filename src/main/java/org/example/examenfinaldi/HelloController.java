package org.example.examenfinaldi;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btAñadirLibro;

    @FXML
    private TextField tfIsbn;

    @FXML
    private TextField tfTitulo;

    private Biblioteca biblioteca;
    @FXML
    private Label labelAnadido;

    private MainViewController mainViewController;


    @FXML
    void onAñadirLibroButtonClick(ActionEvent event) throws IOException {
        String isbn = tfIsbn.getText();
        String titulo = tfTitulo.getText();


        int numeroLibros = biblioteca.getLibros().size();

        if (isbn.isEmpty() || titulo.isEmpty()) {
            labelAnadido.setTextFill(Color.RED);
            labelAnadido.setText("Rellena todos los campos");
            return;
        }

        biblioteca.altaLibro(isbn, titulo, isbn);

        if (biblioteca.getLibros().size() > numeroLibros) {
            labelAnadido.setTextFill(Color.GREEN);
            labelAnadido.setText("Libro añadido");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Libro añadido");
            alert.setHeaderText("Libro añadido");
            alert.setContentText("El libro con ISBN: " + isbn + " y título: " + titulo + " ha sido añadido a la biblioteca");
            alert.showAndWait();

            if (alert.getResult().getText().equals("Aceptar")) {
                mainViewController.setBiblioteca(biblioteca);
                mainViewController.getLvLibros().setItems(FXCollections.observableArrayList(biblioteca.getLibros()));
                ScreenLoader.loadScreen("main-view.fxml", (Stage) btAñadirLibro.getScene().getWindow());
            }

            limpiar();
        } else {
            labelAnadido.setTextFill(Color.RED);
            labelAnadido.setText("No se ha podido añadir el libro");
        }

        System.out.println("Número de libros en la biblioteca: " + biblioteca.getLibros().size());
    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
        biblioteca = mainViewController.getBiblioteca();
        System.out.println(biblioteca.getLibros());
    }

    public void limpiar() {
        tfIsbn.clear();
        tfTitulo.clear();
    }

}
