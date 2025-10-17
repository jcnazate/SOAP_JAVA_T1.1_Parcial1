/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;


import ec.edu.monster.ws.LoginService;
import ec.edu.monster.ws.Login_Service;

/**
 *
 * @author jcnaz
 */
public class LoginModelo {
    private final LoginService loginServicio;
    
    public LoginModelo() {
        Login_Service loginService = new Login_Service();
        this.loginServicio = loginService.getLoginServicePort();
    }

    // Método para autenticar al usuario
    public boolean autenticar(String usuario, String contraseña) {
        try {
          
            return loginServicio.login(usuario, contraseña);
        } catch (Exception e) {
            throw new RuntimeException("Error al autenticar: " + e.getMessage());
        }
    }
    
}
