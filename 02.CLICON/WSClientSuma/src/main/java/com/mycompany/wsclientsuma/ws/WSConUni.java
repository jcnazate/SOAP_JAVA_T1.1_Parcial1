package com.mycompany.wsclientsuma.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(targetNamespace = "http://ws.monster.edu.ec/")
public interface WSConUni {

    @WebMethod(operationName = "sumar")
    int sumar(@WebParam(name = "n1") int n1, @WebParam(name = "n2") int n2);

    @WebMethod(operationName = "pulgadasACentimetros")
    double pulgadasACentimetros(@WebParam(name = "pulgadas") double pulgadas);

    @WebMethod(operationName = "centimetrosAPulgadas")
    double centimetrosAPulgadas(@WebParam(name = "centimetros") double centimetros);

    @WebMethod(operationName = "kilogramosAGramos")
    double kilogramosAGramos(@WebParam(name = "kilogramos") double kilogramos);

    @WebMethod(operationName = "gramosAKilogramos")
    double gramosAKilogramos(@WebParam(name = "gramos") double gramos);

    @WebMethod(operationName = "celsiusAKelvin")
    double celsiusAKelvin(@WebParam(name = "celsius") double celsius);

    @WebMethod(operationName = "kelvinACelsius")
    double kelvinACelsius(@WebParam(name = "kelvin") double kelvin);
}
