package com.mycompany.reto11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class lecturaArchivos {
    double precioMasAlto=0;
    double precioMasBajo=0;
    double DIAS=366;
    double promedio=0;
    double desviacionEstandar=0;
    String fechaMasBajo;
    String fechaMasAlto;

    public lecturaArchivos() {
    }
    
    
    public void lecturaArchivo(Path archivo){
        try {
            List<String> lineasArchivo = Files.readAllLines(archivo);
            boolean saltarLinea = true;
            for(String lineaActual : lineasArchivo){
                if(saltarLinea==false){
                    String[] lineaActualSeparada = lineaActual.split(",");
                    precioBajo(Double.parseDouble(lineaActualSeparada[3]),lineaActualSeparada[0]);
                    precioAlto(Double.parseDouble(lineaActualSeparada[2]),lineaActualSeparada[0]);
                    this.promedio+= Double.parseDouble(lineaActualSeparada[1]);
                }
                else{
                    saltarLinea=false;
                }
            }
            saltarLinea=true;
            this.promedio = this.promedio/this.DIAS;
            for(String lineaActual : lineasArchivo){
                if(saltarLinea==false){
                    String[] lineaActualSeparada = lineaActual.split(",");
                    this.desviacionEstandar+= Math.pow((Double.parseDouble(lineaActualSeparada[1])-promedio), 2);
                }
                else{
                    saltarLinea=false;
                }
                
            }
            this.desviacionEstandar = this.desviacionEstandar/this.DIAS;
        } catch (IOException ex) {
            System.out.println("Hubo un error al acceder al archivo: "+ ex.getMessage());
        }  
    }
    public void precioBajo(double precio, String fecha){
        if(precio<this.precioMasBajo || this.precioMasBajo==0){
            this.precioMasBajo = precio;
            this.fechaMasBajo = fecha;
        }
    }
    public void precioAlto(double precio, String fecha){
        if(precio>this.precioMasAlto){
            this.precioMasAlto = precio;
            this.fechaMasAlto = fecha;
        }
    }
}
