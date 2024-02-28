package org.example.examenfinaldi;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btAnadirLlibro;

    @FXML
    private Button btPrestar;

    @FXML
    private ListView<Libro> lvLibros;

    private Biblioteca biblioteca;

    public MainViewController() {
        biblioteca = new Biblioteca();
    }

    //Abrir la ventana de añadir libro
    @FXML
    void onAnadirLibroClick(ActionEvent event) throws IOException {
        ScreenLoader.loadScreen("hello-view.fxml", (Stage) btAnadirLlibro.getScene().getWindow());

    }

    @FXML
    void onPrestarButtonClick(ActionEvent event) throws IOException {
        ScreenLoader.loadScreen("prestamo-view.fxml", (Stage) btPrestar.getScene().getWindow());

    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public ListView<Libro> getLvLibros() {
        return lvLibros;
    }

    public void setLvLibros(ListView<Libro> lvLibros) {
        this.lvLibros = lvLibros;
    }
}
