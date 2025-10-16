/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.ws.WSConUni;
import ec.edu.monster.ws.WSConUni_Service;

/**
 *
 * @author jcnaz
 */
public class ConversionModelo {
    private final WSConUni conversionServicio;
    
    public ConversionModelo() {
        WSConUni_Service conversionService = new WSConUni_Service();
        this.conversionServicio = conversionService.getWSConUniPort();
    }
    
      public double centimetrosAPulgadas(double centimetros) {
        try {
            return conversionServicio.centimetrosAPulgadas(centimetros);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir centímetros a pulgadas: " + e.getMessage());
        }
    }

    public double pulgadasACentimetros(double pulgadas) {
        try {
            return conversionServicio.pulgadasACentimetros(pulgadas);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir pulgadas a centímetros: " + e.getMessage());
        }
    }
    
    public double kelvinACelsius(double kelvin) {
        try {
            return conversionServicio.kelvinACelsius(kelvin);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir kelvin a celcius: " + e.getMessage());
        }
    }
    public double celsiusAKelvin(double celcius) {
        try {
            return conversionServicio.celsiusAKelvin(celcius);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir  celcius a kelvin : " + e.getMessage());
        }
    }
    public double gramosAKilogramos(double gramos) {
        try {
            return conversionServicio.gramosAKilogramos(gramos);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir  gramos a kilogramos: " + e.getMessage());
        }
    }
    public double kilogramosAGramos(double gramos) {
        try {
            return conversionServicio.kilogramosAGramos(gramos);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir  celcius a kilogramos : " + e.getMessage());
        }
    }
      
     
    
}
