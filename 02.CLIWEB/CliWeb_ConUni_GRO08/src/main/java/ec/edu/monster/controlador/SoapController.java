/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ConversionUnidades;
import ec.edu.monster.modelo.LoginModelo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 *
 * @author jcnaz
 */
@WebServlet(name = "SoapController", urlPatterns = {"/SoapController"})
public class SoapController extends HttpServlet{
    private final LoginModelo loginModelo;
    private final ConversionUnidades conversionUnidades;

    public SoapController() {
        this.loginModelo = new LoginModelo();
        this.conversionUnidades = new ConversionUnidades();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        // Si no hay sesión o el usuario no está autenticado, mostrar la página de login
        if (session == null || session.getAttribute("autenticado") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            response.sendRedirect("menu.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("menu.jsp");
            return;
        }

        try {
            switch (action) {
                case "login" -> manejarLogin(request, response);
                case "temperatura" -> manejarTemperatura(request, response);
                case "longitud" -> manejarLongitud(request, response);
                case "masa" -> manejarMasa(request, response);
                default -> response.sendRedirect("menu.jsp");
            }
        } catch (NumberFormatException e) {
            String destino = obtenerDestinoPorAccion(action);
            request.setAttribute("error", "Por favor, ingrese un valor numérico válido.");
            request.getRequestDispatcher(destino).forward(request, response);
        } catch (Exception e) {
            String destino = obtenerDestinoPorAccion(action);
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher(destino).forward(request, response);
        }
    }

    private void manejarLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        boolean autenticado = loginModelo.autenticar(user, password);

        if (autenticado) {
            session.setAttribute("autenticado", true);
            response.sendRedirect("menu.jsp");
        } else {
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void manejarTemperatura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!estaAutenticado(request)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String tipo = request.getParameter("tipo");
        double valor = Double.parseDouble(request.getParameter("valor"));

        switch (tipo) {
            case "kToC" -> {
                double resultado = conversionUnidades.kelvinACelsius(valor);
                request.setAttribute("valorK", formatear(valor));
                request.setAttribute("resultadoKToC", formatear(resultado));
            }
            case "cToK" -> {
                double resultado = conversionUnidades.celsiusAKelvin(valor);
                request.setAttribute("valorC", formatear(valor));
                request.setAttribute("resultadoCToK", formatear(resultado));
            }
            default -> request.setAttribute("error", "Conversión de temperatura no reconocida.");
        }

        request.getRequestDispatcher("temperatura.jsp").forward(request, response);
    }

    private void manejarLongitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!estaAutenticado(request)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String tipo = request.getParameter("tipo");
        double valor = Double.parseDouble(request.getParameter("valor"));

        switch (tipo) {
            case "cmToIn" -> {
                double resultado = conversionUnidades.centimetrosAPulgadas(valor);
                request.setAttribute("valorCm", formatear(valor));
                request.setAttribute("resultadoCmToIn", formatear(resultado));
            }
            case "inToCm" -> {
                double resultado = conversionUnidades.pulgadasACentimetros(valor);
                request.setAttribute("valorIn", formatear(valor));
                request.setAttribute("resultadoInToCm", formatear(resultado));
            }
            default -> request.setAttribute("error", "Conversión de longitud no reconocida.");
        }

        request.getRequestDispatcher("longitud.jsp").forward(request, response);
    }

    private void manejarMasa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!estaAutenticado(request)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String tipo = request.getParameter("tipo");
        double valor = Double.parseDouble(request.getParameter("valor"));

        switch (tipo) {
            case "kgToG" -> {
                double resultado = conversionUnidades.kilogramosAGramos(valor);
                request.setAttribute("valorKg", formatear(valor));
                request.setAttribute("resultadoKgToG", formatear(resultado));
            }
            case "gToKg" -> {
                double resultado = conversionUnidades.gramosAKilogramos(valor);
                request.setAttribute("valorG", formatear(valor));
                request.setAttribute("resultadoGToKg", formatear(resultado));
            }
            default -> request.setAttribute("error", "Conversión de masa no reconocida.");
        }

        request.getRequestDispatcher("masa.jsp").forward(request, response);
    }

    private boolean estaAutenticado(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && Boolean.TRUE.equals(session.getAttribute("autenticado"));
    }

    private String formatear(double valor) {
        return String.format(Locale.US, "%.2f", valor);
    }

    private String obtenerDestinoPorAccion(String action) {
        return switch (action) {
            case "login" -> "login.jsp";
            case "temperatura" -> "temperatura.jsp";
            case "longitud" -> "longitud.jsp";
            case "masa" -> "masa.jsp";
            default -> "menu.jsp";
        };
    }
}