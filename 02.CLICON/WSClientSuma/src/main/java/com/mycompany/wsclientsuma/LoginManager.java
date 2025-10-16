package com.mycompany.wsclientsuma;

import com.mycompany.wsclientsuma.ws.Login;
import java.util.Scanner;

/**
 * Gestor que autentica contra el servicio SOAP de login existente en el
 * servidor.
 */
public class LoginManager {

    private static final int MAX_ATTEMPTS = 3;

    private final Scanner scanner;
    private final Login loginPort;

    public LoginManager(Scanner scanner, Login loginPort) {
        this.scanner = scanner;
        this.loginPort = loginPort;
    }

    public boolean authenticate() {
        System.out.println("=== Inicio de sesión requerido ===");
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Usuario: ");
            String username = scanner.nextLine().trim();
            System.out.print("Contraseña: ");
            String password = scanner.nextLine().trim();

            try {
                if (loginPort.login(username, password)) {
                    System.out.println("Inicio de sesión exitoso.\n");
                    return true;
                }
            } catch (Exception ex) {
                System.out.println("No se pudo validar las credenciales: " + ex.getMessage() + "\n");
                return false;
            }

            int remaining = MAX_ATTEMPTS - attempt;
            if (remaining > 0) {
                System.out.printf("Credenciales incorrectas. Intentos restantes: %d%n", remaining);
            }
        }
        System.out.println("Ha excedido el número máximo de intentos.\n");
        return false;
    }
}
