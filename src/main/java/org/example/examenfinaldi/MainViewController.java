package org.example.examenfinaldi;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    public ListView<Libro> lvLibros;

    private Biblioteca biblioteca;

    @FXML
    void initialize() {
        Libro libro1 = new Libro("El Quijote", "Cervantes", "1605");
        Libro libro2 = new Libro("La Celestina", "Fernando de Rojas", "1499");
        biblioteca.getLibros().add(libro1);
        biblioteca.getLibros().add(libro2);
        lvLibros.setItems(FXCollections.observableArrayList(biblioteca.getLibros()));
    }

    public MainViewController() {
        if (biblioteca == null) {
            biblioteca = new Biblioteca();
        }
    }

    //Abrir la ventana de añadir libro
    @FXML
    void onAnadirLibroClick(ActionEvent event) throws IOException {
        // Carga la vista de HelloController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Obtiene la instancia de HelloController y le pasa la instancia de MainViewController
        HelloController helloController = loader.getController();
        helloController.setMainViewController(this);

        // Muestra la vista de HelloController
        Stage stage = (Stage) btAnadirLlibro.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

        System.out.println(biblioteca.getLibros().size() + " libros en la biblioteca desde ka vista principal");
        lvLibros.refresh();
        //lvLibros.setItems(FXCollections.observableArrayList(biblioteca.getLibros()));
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
