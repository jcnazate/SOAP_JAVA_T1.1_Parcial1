/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ConversionModelo;
import ec.edu.monster.modelo.LoginModelo;
import ec.edu.monster.vista.InterfazUsuario;

/**
 *
 * @author jcnaz
 */
public class ControladorPrincipal {
    private final LoginModelo loginModelo;
    private final ConversionModelo conversionModelo;
    private final InterfazUsuario vista;

    public ControladorPrincipal(LoginModelo loginModelo, ConversionModelo conversionModelo, InterfazUsuario vista) {
        this.loginModelo = loginModelo;
        this.conversionModelo = conversionModelo;
        this.vista = vista;
    }
    
    public void iniciar() {
        // Autenticación
        boolean autenticado = false;
        while (!autenticado) {
            String usuario = vista.obtenerUsuario();
            String contraseña = vista.obtenerContraseña();
            try {
                autenticado = loginModelo.autenticar(usuario, contraseña);
                if (autenticado) {
                    vista.mostrarLoginExitoso();
                } else {
                    vista.mostrarLoginFallido();
                }
            } catch (Exception e) {
                vista.mostrarError(e.getMessage());
                return;
            }
        }

        // Bucle para conversiones
        boolean continuar = true;
        while (continuar) {
            int opcion = vista.obtenerOpcionConversion();
            try {
                switch (opcion) {
                    case 1: // Centímetros a pulgadas
                        double centimetros = vista.obtenerCentimetros();
                        double pulgadas = conversionModelo.centimetrosAPulgadas(centimetros);
                        vista.mostrarResultadoCentimetrosAPulgadas(pulgadas);
                        break;
                    case 2: // Pulgadas a centímetros
                        double pulgadasInput = vista.obtenerPulgadas();
                        double centimetrosOutput = conversionModelo.pulgadasACentimetros(pulgadasInput);
                        vista.mostrarResultadoPulgadasACentimetros(centimetrosOutput);
                        break;  
                    case 3: // Kelvin a Celcius
                        double kelvinInput = vista.obtenerkelvin();
                        double celciusOutput = conversionModelo.kelvinACelsius(kelvinInput);
                        vista.mostrarResultadoKelvinACelcius(celciusOutput);
                        break;
                    case 4: // Celcius a Kelvin 
                        double celciusInput = vista.obtenercelcius();
                        double kelvinOutput = conversionModelo.celsiusAKelvin(celciusInput);
                        vista.mostrarResultadoCelciusAKelvin(kelvinOutput);
                        break;
                    case 5: // Gramos a Kilogramos 
                        double gramosInput = vista.obtenergramos();
                        double kilogramosOutput = conversionModelo.gramosAKilogramos(gramosInput);
                        vista.mostrarResultadoGramosAKilogramos(kilogramosOutput);
                        break;
               
                    case 6: // Kilogramos a Gramos 
                        double kilogramosInput = vista.obtenerkilogramos();
                        double gramosOutput = conversionModelo.kilogramosAGramos(kilogramosInput);
                        vista.mostrarResultadoKilogramosAGramos(gramosOutput);
                        break;
                        
                     
                    case 0: // Salir
                        System.out.println("Saliendo de la aplicación...");
                        continuar = false;
                        break;
                    default:
                        vista.mostrarError("Opción no válida.");
                }
            } catch (Exception e) {
                vista.mostrarError(e.getMessage());
            }
        }
    }
    
}
