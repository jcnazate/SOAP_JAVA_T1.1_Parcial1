<%-- 
    Document   : login
    Created on : 17 oct 2025, 18:10:38
    Author     : jcnaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Para responsividad -->
    <title>Login - Conversión de Unidades</title>
    <link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Fredoka:wght@400;500;600&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Fredoka', sans-serif;
            background: linear-gradient(135deg, #05abda 0%, #b2c7db 50%, #e4f5f8 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
            position: relative;
        }

        /* <CHANGE> Agregar círculos morados de fondo */
        .background-circles {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            pointer-events: none;
            z-index: 0;
        }

        .circle {
            position: absolute;
            background: #e4dcee;   /* color solicitado */
            opacity: 0.6;  
            border-radius: 50%;
            animation: float 20s infinite ease-in-out;
        }

        .circle-large {
            width: 400px;
            height: 400px;
            top: -100px;
            left: -100px;
            animation-duration: 25s;
        }

        .circle-medium {
            width: 250px;
            height: 250px;
            top: 50%;
            right: -50px;
            animation-duration: 20s;
            animation-delay: 2s;
        }

        .circle-small {
            width: 150px;
            height: 150px;
            bottom: 10%;
            left: 10%;
            animation-duration: 18s;
            animation-delay: 4s;
        }

        .circle-medium-2 {
            width: 300px;
            height: 300px;
            bottom: -50px;
            right: 10%;
            animation-duration: 22s;
            animation-delay: 1s;
        }

        .circle-small-2 {
            width: 120px;
            height: 120px;
            top: 20%;
            right: 15%;
            animation-duration: 19s;
            animation-delay: 3s;
        }

        @keyframes float {
            0%, 100% {
                transform: translateY(0px) translateX(0px);
            }
            50% {
                transform: translateY(30px) translateX(20px);
            }
        }

        .container {
            display: flex;
            gap: 60px;
            align-items: center;
            justify-content: center;
            max-width: 1200px;
            width: 90%;
            position: relative;
            z-index: 1;
        }

        .login-section {
            flex: 1;
            min-width: 350px;
        }

        .sullivan-section {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            min-width: 300px;
        }

        .sullivan-img {
            width: 100%;
            max-width: 400px;
            height: auto;
            animation: float-sullivan 3s ease-in-out infinite;
            filter: drop-shadow(0 20px 40px rgba(0, 0, 0, 0.3));
        }

        @keyframes float-sullivan {
            0%, 100% {
                transform: translateY(0px) scale(1);
            }
            50% {
                transform: translateY(-20px) scale(1.02);
            }
        }

        .header {
            text-align: center;
            margin-bottom: 40px;
            animation: slideDown 0.8s ease-out;
        }

        @keyframes slideDown {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .header h1 {
            font-family: 'Fredoka One', cursive;
            font-size: 2.5rem;
            color: #b2c7db ;
            text-shadow: 3px 3px 0px rgba(107, 84, 148, 0.4), 
                         6px 6px 0px rgba(0, 0, 0, 0.2);
            margin-bottom: 10px;
            letter-spacing: 2px;
            animation: glow 2s ease-in-out infinite;
        }

        @keyframes glow {
            0%, 100% {
                text-shadow: 3px 3px 0px rgba(107, 84, 148, 0.4), 
                             6px 6px 0px rgba(0, 0, 0, 0.2),
                             0 0 20px rgba(5, 171, 218, 0.3);
            }
            50% {
                text-shadow: 3px 3px 0px rgba(107, 84, 148, 0.6), 
                             6px 6px 0px rgba(0, 0, 0, 0.3),
                             0 0 40px rgba(5, 171, 218, 0.6);
            }
        }

        .header p {
            color: #b2c7db;
            font-size: 1rem;
            font-weight: 500;
            letter-spacing: 1px;
        }

        .form-group {
            margin-bottom: 25px;
            animation: slideUp 0.8s ease-out;
            animation-fill-mode: both;
        }

        .form-group:nth-child(1) {
            animation-delay: 0.2s;
        }

        .form-group:nth-child(2) {
            animation-delay: 0.4s;
        }

        @keyframes slideUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #6c5494;
            font-weight: 600;
            font-size: 0.95rem;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        input {
            width: 100%;
            padding: 14px 16px;
            border: 2px solid #329164;
            border-radius: 12px;
            background: rgba(255, 255, 255, 0.95);
            font-family: 'Fredoka', sans-serif;
            font-size: 1rem;
            color: #142351;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }

        input:focus {
            outline: none;
            border-color: #05abda;
            background: #f4f9f8;
            box-shadow: 0 0 0 4px rgba(5, 171, 218, 0.2), 
                        0 4px 15px rgba(0, 0, 0, 0.15);
            transform: translateY(-2px);
        }

        input::placeholder {
            color: #8a86a3;
        }

        .login-btn {
            width: 100%;
            padding: 14px;
            background: linear-gradient(135deg, #947cbc 0%, #05abda 100%);
            color: white;
            border: none;
            border-radius: 12px;
            font-family: 'Fredoka One', cursive;
            font-size: 1.1rem;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 1px;
            box-shadow: 0 6px 20px rgba(5, 171, 218, 0.3);
            animation: slideUp 0.8s ease-out 0.6s both;
            position: relative;
            overflow: hidden;
        }

        .login-btn::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: gradient(135deg, #947cbc 0%, #e4dcee 100%);
            transition: left 0.3s ease;
        }

        .login-btn:hover::before {
            left: 100%;
        }

        .login-btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 10px 30px rgba(5, 171, 218, 0.5);
            background: linear-gradient(135deg, #44b4cc 0%, #05abda 100%);
        }

        .login-btn:active {
            transform: translateY(-1px);
        }

        .footer-text {
            text-align: center;
            margin-top: 25px;
            color: #8a86a3;
            font-size: 0.9rem;
            animation: slideUp 0.8s ease-out 0.8s both;
        }

        .footer-text a {
            color: #05abda;
            text-decoration: none;
            font-weight: 600;
            position: relative;
            transition: all 0.3s ease;
        }

        .footer-text a::after {
            content: '';
            position: absolute;
            bottom: -2px;
            left: 0;
            width: 0;
            height: 2px;
            background: #05abda;
            transition: width 0.3s ease;
        }

        .footer-text a:hover::after {
            width: 100%;
        }

        @media (max-width: 768px) {
            .container {
                flex-direction: column;
                gap: 40px;
            }

            .header h1 {
                font-size: 2rem;
            }

            .sullivan-section {
                order: -1;
            }

            .sullivan-img {
                max-width: 250px;
            }

            .circle-large {
                width: 300px;
                height: 300px;
            }

            .circle-medium {
                width: 200px;
                height: 200px;
            }
        }
    </style>
    
    </head>
        <body>
        <!-- <CHANGE> Agregar círculos morados de fondo -->
        <div class="background-circles">
            <div class="circle circle-large"></div>
            <div class="circle circle-medium"></div>
            <div class="circle circle-small"></div>
            <div class="circle circle-medium-2"></div>
            <div class="circle circle-small-2"></div>
        </div>

        <div class="container">
            <div class="login-section">
                <div class="header">
                    <!-- <CHANGE> Cambiar texto a "Cliente Web GR08" -->
                    <h1>Conversión de Unidades GR08</h1>
                    <p>Cliente Web</p>
                </div>

                <form>
                    <div class="form-group">
                        <label for="username">Usuario</label>
                        <input type="text" id="username" placeholder="Ingresa tu usuario" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input type="password" id="password" placeholder="Ingresa tu contraseña" required>
                    </div>
                    <% if (request.getAttribute("error") != null) { %>
                        <p class="error"><%= request.getAttribute("error") %></p>
                    <% } %>

                    <button type="submit" class="login-btn">Ingresar</button>


                </form>
            </div>

            <div class="sullivan-section">
                <img src="Imagenes/sullivan.png" alt="Sullivan - Monsters Inc" class="sullivan-img">
            </div>
        </div>
    </body>
</html>
