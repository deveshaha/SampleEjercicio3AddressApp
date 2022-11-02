module com.ej3.ejercicio3addressapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ej3.ejercicio3addressapp to javafx.fxml;
    exports com.ej3.ejercicio3addressapp;
}