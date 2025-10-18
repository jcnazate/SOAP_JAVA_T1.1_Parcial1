/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import com.sun.net.httpserver.HttpServer;
import ec.edu.monster.modelo.LoginModelo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author jcnaz
 */
@WebServlet(name = "SoapController", urlPatterns = {"/SoapController"})
public class SoapController extends HttpServlet{
     private final LoginModelo loginModelo;


    public SoapController() {
        this.loginModelo = new LoginModelo();
       
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
        HttpSession session = request.getSession(true);

        try {
            if ("login".equals(action)) {
                String user = request.getParameter("user");
                String password = request.getParameter("password");
                if (user != null) {
                    user = user.trim();
                }
                if (password != null) {
                    password = password.trim();
                }
                boolean autenticado = loginModelo.autenticar(user, password);
                if (autenticado) {
                    session.setAttribute("autenticado", true);
                    response.sendRedirect("menu.jsp");
                } else {
                    request.setAttribute("error", "Usuario o contraseña incorrectos");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // Verificar si el usuario está autenticado antes de procesar conversiones
                if (session.getAttribute("autenticado") == null) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }

               
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Por favor, ingrese un valor numérico válido");
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
            if ("login".equals(action)) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("menu.jsp").forward(request, response);
            }
        }
    }

}
