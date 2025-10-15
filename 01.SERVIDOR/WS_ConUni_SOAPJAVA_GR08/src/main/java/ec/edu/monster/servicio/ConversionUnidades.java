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
}