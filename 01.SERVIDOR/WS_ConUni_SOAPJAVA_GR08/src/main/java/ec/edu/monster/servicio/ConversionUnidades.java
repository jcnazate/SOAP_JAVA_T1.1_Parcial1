/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicio;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

/**
 *
 * @author jcnaz
 */
@WebService(serviceName = "ConversionUnidades")
public class ConversionUnidades {
    /**
     * WebServices Operations 1
     */
    @WebMethod(operationName = "pulgadasACentimetros")
    public double pulgadasACentimetros(@WebParam(name = "pulgadas") double pulgadas) {
        return pulgadas * 2.54;
    }
    
    /**
     * WebServices Operations 1
     */
    @WebMethod(operationName = "centimetrosAPulgadas")
    public double centimetrosAPulgadas(@WebParam(name = "centimeros") double centimeros) {
        return centimeros / 2.54;
    }
     /**
     * WebServices Operations 1
     */
    @WebMethod(operationName = "kilogramosAGramos")
    public double kilogramosAGramos(@WebParam(name = "kilogramos") double kilogramos) {
        return kilogramos * 1000.0;
    }
    
      /**
     *WebServices Operations 2
     * Masa: g -> kg
     */
    @WebMethod(operationName = "gramosAkilogramos")
    public double gramosAkilogramos(@WebParam(name = "gramos") double gramos) {
        return gramos / 1000.0;
    }

    /**
     * WebServices Operations 3
     * Temperatura: °C -> K
     * Fórmula: K = °C + 273.15
     */
    @WebMethod(operationName = "celsiusAKelvin")
    public double celsiusAKelvin(@WebParam(name = "celsius") double celsius) {
        return celsius + 273.15;
    }
     /**
     * WebServices Operations 3
     * Temperatura: K -> °C
     * Fórmula: K = °C + 273.15
     */
    @WebMethod(operationName = "kelvinAcelcius")
    public double kelvinAcelcius(@WebParam(name = "kelvin") double kelvin) {
        return kelvin - 273.15;
    }
}