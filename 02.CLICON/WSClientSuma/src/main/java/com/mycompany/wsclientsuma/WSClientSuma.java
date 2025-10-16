package com.mycompany.wsclientsuma;

import com.mycompany.wsclientsuma.ws.Login;
import com.mycompany.wsclientsuma.ws.WSConUni;
import jakarta.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;
import javax.xml.namespace.QName;

/**
 * Cliente de consola para consumir el servicio SOAP WSConUni.
 */
public class WSClientSuma {

    private static final String DEFAULT_WSDL_URL =
            "http://localhost:8080/WS_ConUni_SOAPJAVA_GR08/WSConUni?wsdl";
    private static final QName SERVICE_NAME = new QName("http://ws.monster.edu.ec/", "WSConUni");
    private static final QName PORT_NAME = new QName("http://ws.monster.edu.ec/", "WSConUniPort");

    private static final String DEFAULT_LOGIN_WSDL_URL =
            "http://localhost:8080/WS_ConUni_SOAPJAVA_GR08/Login?wsdl";
    private static final QName LOGIN_SERVICE_NAME = new QName("http://servicio.monster.edu.ec/", "Login");
    private static final QName LOGIN_PORT_NAME = new QName("http://servicio.monster.edu.ec/", "LoginPort");

    public static void main(String[] args) {
        Locale.setDefault(new Locale("es", "EC"));
        Scanner scanner = new Scanner(System.in);

        Login loginPort;
        try {
            loginPort = createLoginPort();
        } catch (MalformedURLException ex) {
            System.err.println("URL del servicio de login inválida: " + ex.getMessage());
            return;
        }

        LoginManager loginManager = new LoginManager(scanner, loginPort);

        if (!loginManager.authenticate()) {
            return;
        }

        WSConUni port;
        try {
            port = createPort();
        } catch (MalformedURLException ex) {
            System.err.println("URL del servicio inválida: " + ex.getMessage());
            return;
        }

        boolean exit = false;
        while (!exit) {
            printMenu();
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine().trim();
            switch (option) {
                case "1" -> executeSumar(scanner, port);
                case "2" -> executePulgadasACentimetros(scanner, port);
                case "3" -> executeCentimetrosAPulgadas(scanner, port);
                case "4" -> executeKilogramosAGramos(scanner, port);
                case "5" -> executeGramosAKilogramos(scanner, port);
                case "6" -> executeCelsiusAKelvin(scanner, port);
                case "7" -> executeKelvinACelsius(scanner, port);
                case "0" -> exit = true;
                default -> System.out.println("Opción no válida. Intente nuevamente.\n");
            }
        }

        System.out.println("Gracias por usar el cliente WSConUni.");
    }

    private static WSConUni createPort() throws MalformedURLException {
        String wsdlUrl = System.getProperty("wsconuni.wsdl", DEFAULT_WSDL_URL);
        URL url = new URL(wsdlUrl);
        Service service = Service.create(url, SERVICE_NAME);
        return service.getPort(PORT_NAME, WSConUni.class);
    }

    private static Login createLoginPort() throws MalformedURLException {
        String wsdlUrl = System.getProperty("login.wsdl", DEFAULT_LOGIN_WSDL_URL);
        URL url = new URL(wsdlUrl);
        Service service = Service.create(url, LOGIN_SERVICE_NAME);
        return service.getPort(LOGIN_PORT_NAME, Login.class);
    }

    private static void printMenu() {
        System.out.println("=== Menú de operaciones ===");
        System.out.println("1. Sumar");
        System.out.println("2. Convertir pulgadas a centímetros");
        System.out.println("3. Convertir centímetros a pulgadas");
        System.out.println("4. Convertir kilogramos a gramos");
        System.out.println("5. Convertir gramos a kilogramos");
        System.out.println("6. Convertir Celsius a Kelvin");
        System.out.println("7. Convertir Kelvin a Celsius");
        System.out.println("0. Salir");
    }

    private static void executeSumar(Scanner scanner, WSConUni port) {
        try {
            System.out.print("Primer número entero: ");
            int n1 = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Segundo número entero: ");
            int n2 = Integer.parseInt(scanner.nextLine().trim());
            int resultado = port.sumar(n1, n2);
            System.out.printf("Resultado de la suma: %d%n%n", resultado);
        } catch (NumberFormatException ex) {
            System.out.println("Entrada inválida. Por favor ingrese números enteros.\n");
        } catch (Exception ex) {
            System.out.println("Error al invocar el servicio: " + ex.getMessage() + "\n");
        }
    }

    private static void executePulgadasACentimetros(Scanner scanner, WSConUni port) {
        executeDoubleConversion(scanner, port::pulgadasACentimetros,
                "Valor en pulgadas: ", "Resultado en centímetros: %f\n\n");
    }

    private static void executeCentimetrosAPulgadas(Scanner scanner, WSConUni port) {
        executeDoubleConversion(scanner, port::centimetrosAPulgadas,
                "Valor en centímetros: ", "Resultado en pulgadas: %f\n\n");
    }

    private static void executeKilogramosAGramos(Scanner scanner, WSConUni port) {
        executeDoubleConversion(scanner, port::kilogramosAGramos,
                "Valor en kilogramos: ", "Resultado en gramos: %f\n\n");
    }

    private static void executeGramosAKilogramos(Scanner scanner, WSConUni port) {
        executeDoubleConversion(scanner, port::gramosAKilogramos,
                "Valor en gramos: ", "Resultado en kilogramos: %f\n\n");
    }

    private static void executeCelsiusAKelvin(Scanner scanner, WSConUni port) {
        executeDoubleConversion(scanner, port::celsiusAKelvin,
                "Valor en Celsius: ", "Resultado en Kelvin: %f\n\n");
    }

    private static void executeKelvinACelsius(Scanner scanner, WSConUni port) {
        executeDoubleConversion(scanner, port::kelvinACelsius,
                "Valor en Kelvin: ", "Resultado en Celsius: %f\n\n");
    }

    @FunctionalInterface
    private interface DoubleConversion {
        double apply(double value) throws Exception;
    }

    private static void executeDoubleConversion(Scanner scanner, DoubleConversion conversion,
                                                String prompt, String resultFormat) {
        try {
            System.out.print(prompt);
            double value = Double.parseDouble(scanner.nextLine().trim());
            double result = conversion.apply(value);
            System.out.printf(resultFormat, result);
        } catch (NumberFormatException ex) {
            System.out.println("Entrada inválida. Por favor ingrese números.\n");
        } catch (Exception ex) {
            System.out.println("Error al invocar el servicio: " + ex.getMessage() + "\n");
        }
    }
}
