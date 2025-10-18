<%-- 
    Document   : menu
    Created on : 17 oct 2025
    Author     : jcnaz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Protección: si no hay sesión, vuelve al login
    if (session.getAttribute("autenticado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menú de Conversión de Unidades</title>
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Fredoka:wght@400;500;600&display=swap" rel="stylesheet">

<style>
  :root{
    --c1:#05abda; /* colores del login (para acentos y hover) */
    --c2:#b2c7db;
    --c3:#e4f5f8;
  }
  *{margin:0;padding:0;box-sizing:border-box}

  /* ===== Fondo con imagen a pantalla completa ===== */
  body{
    font-family:'Fredoka',sans-serif;
    min-height:100vh;
    display:grid;
    place-items:center;                    /* centrado perfecto */
    background-image:url('Imagenes/fondoMenu.jpg'); /* <-- cambia si quieres otra */
    background-size:cover;
    background-position:center;
    background-attachment:fixed;
  }
  /* oscurecedor suave para contraste */
  body::before{
    content:"";
    position:fixed; inset:0;
    background:rgba(0,0,0,.25);
    pointer-events:none;
  }

  /* ===== Tarjeta translúcida ===== */
  .menu-card{
    width:min(92vw, 700px);
    background:rgba(255,255,255,.72);
    backdrop-filter:saturate(140%) blur(6px);
    -webkit-backdrop-filter:saturate(140%) blur(6px);
    border-radius:22px;
    box-shadow:0 22px 60px rgba(0,0,0,.35);
    padding:28px 26px 30px;
    position:relative;
    z-index:1;
  }

  /* ===== Títulos ===== */
  .subtitle{
    font-family:'Fredoka One',cursive;
    font-size:clamp(1.6rem,4.2vw,2.2rem);
    line-height:1.1;
    text-align:center;
    background:linear-gradient(135deg,var(--c1),var(--c2),var(--c3));
    -webkit-background-clip:text;
    background-clip:text;
    color:transparent;
    margin-bottom:2px;
  }
  .subdesc{
    text-align:center;
    color:#334155;
    font-weight:600;
    letter-spacing:.3px;
    margin-bottom:18px;
  }

  /* ===== Botonera ===== */
  .btns{
    display:grid;
    grid-template-columns:repeat(3,1fr);
    gap:14px;
  }
  @media (max-width:700px){
    .btns{ grid-template-columns:1fr; }
  }

  .btn{
    display:flex; align-items:center; justify-content:center;
    padding:16px 18px;
    border:none;
    border-radius:14px;
    text-decoration:none;
    color:#0f172a;
    font-weight:700;
    font-size:1.05rem;
    letter-spacing:.3px;
    background:#ffffffd9;                 /* más sólido para legibilidad */
    box-shadow:inset 0 0 0 2px rgba(15,23,42,.08), 0 10px 28px rgba(0,0,0,.12);
    transition:transform .15s ease, box-shadow .2s ease, background .2s ease;
    text-align:center;
  }
  .btn:hover{
    transform:translateY(-2px);
    box-shadow:inset 0 0 0 2px rgba(5,171,218,.35), 0 14px 34px rgba(5,171,218,.25);
    background:linear-gradient(135deg,#44b4cc1a 0%, #05abda14 100%);
  }
  .btn:active{ transform:translateY(0) scale(.99); }

  /* resaltar el foco por accesibilidad */
  .btn:focus-visible{
    outline:3px solid var(--c1);
    outline-offset:3px;
  }
</style>
</head>
<body>

  <section class="menu-card" role="region" aria-label="Menú principal">
    <h2 class="subtitle">Menú</h2>
    <p class="subdesc">Conversión de Unidades</p>

    <div class="btns">
      <a class="btn" href="temperatura.jsp" aria-label="Ir a conversión de temperatura">Temperatura</a>
      <a class="btn" href="masa.jsp" aria-label="Ir a conversión de masa">Masa</a>
      <a class="btn" href="longitud.jsp" aria-label="Ir a conversión de longitud">Longitud</a>
    </div>
  </section>

</body>
</html>
