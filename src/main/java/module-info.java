module com.example.projetjavafx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.projetjavafx2 to javafx.fxml;
    exports com.example.projetjavafx2;
}