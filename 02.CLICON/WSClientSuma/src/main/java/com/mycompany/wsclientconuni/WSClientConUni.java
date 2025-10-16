/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.wsclientconuni;

import ec.edu.monster.controlador.ControladorPrincipal;
import ec.edu.monster.modelo.ConversionModelo;
import ec.edu.monster.modelo.LoginModelo;
import ec.edu.monster.vista.InterfazUsuario;

/**
 *
 * @author jcnaz
 */
public class WSClientConUni {

    public static void main(String[] args) {
        LoginModelo loginModelo = new LoginModelo();
        ConversionModelo conversionModelo = new ConversionModelo();
        InterfazUsuario vista = new InterfazUsuario();
        ControladorPrincipal controlador = new ControladorPrincipal(loginModelo, conversionModelo, vista);
        controlador.iniciar();
    }
}
