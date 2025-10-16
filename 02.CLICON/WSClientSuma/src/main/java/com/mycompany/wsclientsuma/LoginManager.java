package com.mycompany.wsclientsuma;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Gestor sencillo de credenciales en memoria para la autenticación del cliente.
 */
public class LoginManager {

    private static final int MAX_ATTEMPTS = 3;

    private final Map<String, String> credentials = new HashMap<>();
    private final Scanner scanner;

    public LoginManager(Scanner scanner) {
        this.scanner = scanner;
        credentials.put("admin", "admin123");
        credentials.put("user", "user123");
    }

    public boolean authenticate() {
        System.out.println("=== Inicio de sesión requerido ===");
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Usuario: ");
            String username = scanner.nextLine().trim();
            System.out.print("Contraseña: ");
            String password = scanner.nextLine().trim();

            if (isValidCredential(username, password)) {
                System.out.println("Inicio de sesión exitoso.\n");
                return true;
            }

            int remaining = MAX_ATTEMPTS - attempt;
            if (remaining > 0) {
                System.out.printf("Credenciales incorrectas. Intentos restantes: %d%n", remaining);
            }
        }
        System.out.println("Ha excedido el número máximo de intentos.\n");
        return false;
    }

    private boolean isValidCredential(String username, String password) {
        return password.equals(credentials.get(username));
    }
}
