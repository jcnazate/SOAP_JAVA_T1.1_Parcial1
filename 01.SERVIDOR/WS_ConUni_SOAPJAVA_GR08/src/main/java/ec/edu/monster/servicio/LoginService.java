/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicio;

import ec.edu.monster.utils.HashUtil;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author jcnaz
 */
@WebService(serviceName = "Login")
public class LoginService {
   
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        if (user == null || password == null) {
            return false;
        }

        user = user.trim();
        password = password.trim();

        if (!"monster".equals(user)) {
            return false;
        }

        final String storedPassword = "monster9";
        final String storedHash = HashUtil.hashSHA256(storedPassword);

        if (storedPassword.equals(password)) {
            return true;
        }

        if (storedHash.equalsIgnoreCase(password)) {
            return true;
        }

        String providedHash = HashUtil.hashSHA256(password);
        return storedHash.equalsIgnoreCase(providedHash);
    }
}
