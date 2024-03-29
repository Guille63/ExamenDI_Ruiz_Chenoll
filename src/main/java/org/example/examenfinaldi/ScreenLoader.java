package org.example.examenfinaldi;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase que carga una nueva vista
 */
public class ScreenLoader {
    public static void loadScreen(String viewPath, Stage stage) throws IOException {
        Parent view = FXMLLoader.load(ScreenLoader.class.getResource(viewPath));
        Scene scene = new Scene(view);
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
}
