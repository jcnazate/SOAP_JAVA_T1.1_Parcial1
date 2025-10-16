/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ec.edu.monster.ws;
import ec.edu.monster.servicio.ConversionUnidades;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;



/**
 *
 * @author jcnaz
 */


/**
 * Servicio SOAP que expone operaciones matemáticas y conversiones básicas.
 */
@WebService(serviceName = "WSConUni")
public class WSConUni {

    private final ConversionUnidades conversionUnidades = new ConversionUnidades();


    @WebMethod(operationName = "pulgadasACentimetros")
    public double pulgadasACentimetros(@WebParam(name = "pulgadas") double pulgadas) {
        return conversionUnidades.convertirPulgadasACentimetros(pulgadas);
    }

    @WebMethod(operationName = "centimetrosAPulgadas")
    public double centimetrosAPulgadas(@WebParam(name = "centimetros") double centimetros) {
        return conversionUnidades.convertirCentimetrosAPulgadas(centimetros);
    }

    @WebMethod(operationName = "kilogramosAGramos")
    public double kilogramosAGramos(@WebParam(name = "kilogramos") double kilogramos) {
        return conversionUnidades.convertirKilogramosAGramos(kilogramos);
    }

    @WebMethod(operationName = "gramosAKilogramos")
    public double gramosAKilogramos(@WebParam(name = "gramos") double gramos) {
        return conversionUnidades.convertirGramosAKilogramos(gramos);
    }

    @WebMethod(operationName = "celsiusAKelvin")
    public double celsiusAKelvin(@WebParam(name = "celsius") double celsius) {
        return conversionUnidades.convertirCelsiusAKelvin(celsius);
    }

    @WebMethod(operationName = "kelvinACelsius")
    public double kelvinACelsius(@WebParam(name = "kelvin") double kelvin) {
        return conversionUnidades.convertirKelvinACelsius(kelvin);
    }
}