/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicio;


/**
 *
 * @author jcnaz
 */
public class ConversionUnidades {

    private static final double FACTOR_PULGADA_CENTIMETRO = 2.54;
    private static final double FACTOR_KILOGRAMO_GRAMO = 1000.0;
    private static final double OFFSET_CELSIUS_KELVIN = 273.15;

    public double convertirPulgadasACentimetros(double pulgadas) {
        return pulgadas * FACTOR_PULGADA_CENTIMETRO;
    }

    public double convertirCentimetrosAPulgadas(double centimetros) {
        return centimetros / FACTOR_PULGADA_CENTIMETRO;
    }

    public double convertirKilogramosAGramos(double kilogramos) {
        return kilogramos * FACTOR_KILOGRAMO_GRAMO;
    }

    public double convertirGramosAKilogramos(double gramos) {
        return gramos / FACTOR_KILOGRAMO_GRAMO;
    }

    public double convertirCelsiusAKelvin(double celsius) {
        return celsius + OFFSET_CELSIUS_KELVIN;
    }

    public double convertirKelvinACelsius(double kelvin) {
        return kelvin - OFFSET_CELSIUS_KELVIN;
    }
}