module org.example.examenfinaldi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.examenfinaldi to javafx.fxml;
    exports org.example.examenfinaldi;
}