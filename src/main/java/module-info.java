module com.mycompany.reto11 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.reto11 to javafx.fxml;
    exports com.mycompany.reto11;
}
