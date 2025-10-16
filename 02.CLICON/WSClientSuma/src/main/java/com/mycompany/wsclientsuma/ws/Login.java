package com.mycompany.wsclientsuma.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(targetNamespace = "http://servicio.monster.edu.ec/")
public interface Login {

    @WebMethod(operationName = "login")
    boolean login(@WebParam(name = "user") String user,
                  @WebParam(name = "password") String password);
}
