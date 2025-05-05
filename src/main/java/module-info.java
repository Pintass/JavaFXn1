module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jdk.compiler;
    requires java.desktop;

    exports com.example.vue;
    exports com.example.modele;
}