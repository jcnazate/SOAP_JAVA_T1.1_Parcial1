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
@WebService(serviceName = "Login")
public class LoginService {
   
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "user") String user,@WebParam(name = "password") String password) {
        return ((user.equals("monster")) && (password.equals("monster9")));
    }
}
