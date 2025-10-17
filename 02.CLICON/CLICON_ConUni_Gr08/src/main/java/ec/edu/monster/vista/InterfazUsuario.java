/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vista;

import java.util.Scanner;

/**
 *
 * @author jcnaz
 */
public class InterfazUsuario {
    private final Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public String obtenerUsuario() {
        System.out.print("Ingrese su usuario: ");
        return scanner.nextLine();
    }

    public String obtenerContraseña() {
        System.out.print("Ingrese su contrasenia: ");
        return scanner.nextLine();
    }

    public void mostrarLoginExitoso() {
        System.out.println("Login exitoso. Bienvenido!");
    }

    public void mostrarLoginFallido() {
        System.out.println("Usuario o contrasenia incorrectos. Intente de nuevo.");
    }

    public int obtenerOpcionConversion() {
        int opcion = -1;
        while (true) {
            try {
                System.out.println("\nSeleccione una opcion:");
                System.out.println("1. Convertir centimetros a pulgadas");
                System.out.println("2. Convertir pulgadas a centimetros");
                System.out.println("3. Convertir Kelvin a celcius");
                System.out.println("4. Convertir celcius a kelvin");
                System.out.println("5. Convertir gramos a kilogramos");
                System.out.println("6. Convertir kilogramos a gramos");
                System.out.println("0. Salir");
                System.out.print("Opcion: ");
                String input = scanner.nextLine().trim();

                opcion = Integer.parseInt(input);

                if (opcion >= 0 && opcion <= 6) {
                    return opcion;
                } else {
                    System.out.println("Error: Opción invalida. Ingrese 0, 1, 2, 3, 4, 5 o 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número valido.");
            }
        }
    }

    public double obtenerCentimetros() {
        while (true) {
            System.out.print("Ingrese la longitud en centimetros: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double centimetros = Double.parseDouble(input);
                if (centimetros > 0) {
                    return centimetros;
                } else {
                    System.out.println("Error: La longitud debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
    }

    public double obtenerPulgadas() {
        double pulgadas;
        while (true) {
            try {
                System.out.print("Ingrese la longitud en pulgadas: ");
                pulgadas = Double.parseDouble(scanner.nextLine());
                if (pulgadas > 0) {
                    return pulgadas;
                } else {
                    System.out.println("Error: La longitud debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
    }
     public double obtenerkelvin() {
        while (true) {
            System.out.print("Ingrese la temperatura en kelvin: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double kelvin = Double.parseDouble(input);
                if (kelvin > 0) {
                    return kelvin;
                } else {
                    System.out.println("Error: La temperatura debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número valido.");
            }
        }
    }
    public double obtenercelcius() {
        while (true) {
            System.out.print("Ingrese la temperatura en celcius: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double celcius = Double.parseDouble(input);
                if (celcius > 0) {
                    return celcius;
                } else {
                    System.out.println("Error: La temperatura debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número valido.");
            }
        }
    }
    
    public double obtenergramos() {
        while (true) {
            System.out.print("Ingrese el peso en gramos: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double gramos = Double.parseDouble(input);
                if (gramos > 0) {
                    return gramos;
                } else {
                    System.out.println("Error: La temperatura debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número valido.");
            }
        }
    }
    
    public double obtenerkilogramos() {
        while (true) {
            System.out.print("Ingrese el peso en kilogramos: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double kilogramos = Double.parseDouble(input);
                if (kilogramos > 0) {
                    return kilogramos;
                } else {
                    System.out.println("Error: La temperatura debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número valido.");
            }
        }
    }
    
    

    public void mostrarResultadoCentimetrosAPulgadas(double pulgadas) {
        System.out.println("Longitud en pulgadas: " + pulgadas);
    }

    public void mostrarResultadoPulgadasACentimetros(double centimetros) {
        System.out.println("Longitud en centimetros: " + centimetros);
    }
     public void mostrarResultadoKelvinACelcius(double kelvin) {
        System.out.println("Temperatura en Celsius: " + kelvin);
    }
      public void mostrarResultadoCelciusAKelvin(double celcius) {
        System.out.println("Temperatura en Kelvin: " + celcius);
    }
       public void mostrarResultadoGramosAKilogramos(double gramos) {
        System.out.println("Peso en kilogramos: " + gramos);
    }
        public void mostrarResultadoKilogramosAGramos(double kilogramos) {
        System.out.println("Peso en gramos: " + kilogramos);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }
    
}
