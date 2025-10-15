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
 * @author David
 */
@WebService(serviceName = "Login")
public class LoginService {
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "user") String user,@WebParam(name = "password") String password) {
        return ((user.equals("monster")) && (password.equals("beaafa510bcc774b1be0c7f3fbb033017cd97f2c73455ec2d7747c2e993759b5")));
    }
}
