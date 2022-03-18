package com.mycompany.reto11;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController extends lecturaArchivos {

    String ruta = "C:\\Users\\extra\\Desktop\\BTC-USD.csv";
    Path archivo = Paths.get(ruta);
    lecturaArchivos documento = new lecturaArchivos();
    
    
    @FXML
    private Label mostrarTexto;
    @FXML
    private TableView<String> tablaDatos = new TableView<>();
    @FXML
    private Label mostrarFecha;
    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    private void tablaDatos() throws IOException{
        TableColumn<String,String> colNombre = new TableColumn("Nombre prueba");
        tablaDatos.getColumns().add(colNombre);
    }

    @FXML
    private void promedio(ActionEvent event) {
        documento.lecturaArchivo(archivo);
        mostrarTexto.setText(String.valueOf(documento.promedio));
    }

    @FXML
    private void mayorPrecio(ActionEvent event) {
        documento.lecturaArchivo(archivo);
        mostrarTexto.setText(String.valueOf(documento.precioMasAlto));
        mostrarFecha.setText(documento.fechaMasAlto);
    }

    @FXML
    private void desviacionEstandar(ActionEvent event) {
        documento.lecturaArchivo(archivo);
        mostrarTexto.setText(String.valueOf(documento.desviacionEstandar));
    }

    @FXML
    private void menorPrecio(ActionEvent event) {
        documento.lecturaArchivo(archivo);
        mostrarTexto.setText(String.valueOf(documento.precioMasBajo));
        mostrarFecha.setText(documento.fechaMasBajo);
    }
    
}

