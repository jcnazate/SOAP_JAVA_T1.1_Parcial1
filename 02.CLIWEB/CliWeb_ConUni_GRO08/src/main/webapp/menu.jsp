<%-- 
    Document   : menu
    Created on : 17 oct 2025, 21:17:45
    Author     : jcnaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Verifica si el usuario está autenticado
    if (session.getAttribute("autenticado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menú de Conversión de Unidades</title>
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Fredoka:wght@400;500;600&display=swap" rel="stylesheet">
<style>
  *{margin:0;padding:0;box-sizing:border-box}
  :root{
    --c1:#05abda; /* gradiente header */
    --c2:#b2c7db;
    --c3:#e4f5f8;
    --circle:#e4dcee;
  }

  body{
    font-family:'Fredoka',sans-serif;
    min-height:100vh;
    background:#000;              /* FONDO NEGRO */
    color:#e9f2f6;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:flex-start;
    overflow-x:hidden;
  }

  /* ====== HEADER con gradiente y círculos ====== */
  .hero{
    width:100%;
    position:relative;
    padding:48px 16px 32px;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
    text-align:center;
    z-index:1;
  }
  .hero-title{
    font-family:'Fredoka One',cursive;
    font-size:clamp(1.8rem,4.5vw,3rem);
    letter-spacing:1px;
    line-height:1.1;
    background:linear-gradient(135deg,var(--c1),var(--c2),var(--c3));
    -webkit-background-clip:text;
    background-clip:text;
    color:transparent;
    text-shadow:0 0 0 rgba(0,0,0,0);
    animation:glow 3s ease-in-out infinite;
  }
  .hero-sub{
    margin-top:6px;
    color:var(--c2);
    font-weight:600;
  }
  .background-circles{
    position:absolute; inset:0; pointer-events:none; z-index:-1;
  }
  .circle{
    position:absolute; border-radius:50%;
    background:var(--circle);
    opacity:.35; filter:blur(1px);
    animation:float 18s ease-in-out infinite;
  }
  .circle.lg{width:360px;height:360px;top:-120px;left:-80px;animation-duration:22s;}
  .circle.md{width:240px;height:240px;top:20%;right:-60px;animation-duration:19s;animation-delay:1.2s;}
  .circle.sm{width:140px;height:140px;bottom:-30px;left:15%;animation-duration:16s;animation-delay:.8s;}

  @keyframes float{
    0%,100%{transform:translate(0,0)}
    50%{transform:translate(24px,18px)}
  }
  @keyframes glow{
    0%,100%{text-shadow:0 0 18px rgba(5,171,218,.25)}
    50%{text-shadow:0 0 36px rgba(5,171,218,.55)}
  }

  /* ====== GRID de puertas ====== */
  .doors{
    width:min(1100px,92vw);
    margin:20px auto 60px;
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(240px,1fr));
    gap:28px;
    padding:8px;
  }

  .door-card{
    text-decoration:none; color:inherit; outline:none;
  }

  .frame{
    /* marco y perspectiva */
    position:relative;
    padding:14px;
    height:460px;                 /* puedes ajustar */
    background:#3c3f46;
    border-radius:10px;
    box-shadow:0 14px 40px rgba(0,0,0,.6), inset 0 0 0 2px rgba(255,255,255,.05);
    perspective:1200px;
    transition:transform .25s ease, box-shadow .25s ease;
  }
  .door-card:hover .frame{ transform:translateY(-2px); box-shadow:0 18px 48px rgba(0,0,0,.7), inset 0 0 0 2px rgba(255,255,255,.06); }

  .panel{
    position:absolute; inset:14px;
    background-size:cover; background-position:center;
    border-radius:6px;
    transform-origin:left center;      /* bisagra izquierda */
    transform:rotateY(0deg);
    transition:transform .9s cubic-bezier(.2,.7,.2,1), box-shadow .9s;
    box-shadow:inset 0 0 0 2px rgba(0,0,0,.18);
  }
  .frame:hover .panel,
  .frame.open .panel{                 /* para dispositivos táctiles */
    transform:rotateY(-70deg);
    box-shadow:0 10px 28px rgba(0,0,0,.35);
  }

  /* Etiqueta que aparece al abrir */
  .label{
    position:absolute; left:50%; bottom:10px; transform:translateX(-50%);
    background:linear-gradient(135deg,var(--c2),var(--c1));
    color:#0a1020;
    padding:10px 14px;
    border-radius:24px;
    font-weight:700;
    letter-spacing:.3px;
    opacity:.0; transition:opacity .35s ease, transform .35s ease;
    box-shadow:0 6px 20px rgba(5,171,218,.25);
    pointer-events:none;
  }
  .frame:hover .label, .frame.open .label{
    opacity:1; transform:translateX(-50%) translateY(-2px);
  }

  /* Riel de seguridad decorativo */
  .frame::after{
    content:"";
    position:absolute; left:14px; right:14px; bottom:8px; height:12px;
    background:repeating-linear-gradient(90deg,#111 0 16px,#ffd000 16px 32px);
    border-radius:3px; opacity:.55;
  }

  /* Accesibilidad al enfocar con teclado */
  .door-card:focus-visible .frame{
    outline:3px solid var(--c1); outline-offset:3px;
  }

  @media (max-width:560px){
    .frame{height:400px}
  }
</style>
</head>
<body>

  <!-- HEADER -->
  <header class="hero">
    <div class="background-circles">
      <div class="circle lg"></div>
      <div class="circle md"></div>
      <div class="circle sm"></div>
    </div>
    <h1 class="hero-title">Menú de Conversión de Unidades</h1>
    <p class="hero-sub">Selecciona una puerta</p>
  </header>

  <!-- PUERTAS -->
  <main class="doors">
    <!-- Puerta 1: Temperatura -->
    <a href="temperatura.jsp" class="door-card" aria-label="Temperatura">
      <div class="frame">
        <div class="panel" style="background-image:url('Imagenes/puerta1.png');"></div>
        <div class="label">Temperatura</div>
      </div>
    </a>

    <!-- Puerta 2: Masa -->
    <a href="masa.jsp" class="door-card" aria-label="Masa">
      <div class="frame">
        <div class="panel" style="background-image:url('Imagenes/puerta2.png');"></div>
        <div class="label">Masa</div>
      </div>
    </a>

    <!-- Puerta 3: Longitud -->
    <a href="longitud.jsp" class="door-card" aria-label="Longitud">
      <div class="frame">
        <div class="panel" style="background-image:url('Imagenes/puerta3.png');"></div>
        <div class="label">Longitud</div>
      </div>
    </a>
  </main>

  <!-- Soporte táctil: abrir animación y luego navegar -->
  <script>
    // En móviles no hay :hover; abrimos la puerta y luego navegamos.
    document.querySelectorAll('.door-card').forEach(link=>{
      link.addEventListener('click', (e)=>{
        // Si hay hover (desktop) dejamos que navegue normal
        // Para táctil, prevenimos, animamos y luego navegamos:
        const frame = link.querySelector('.frame');
        // Detectar touch de forma simple
        const isTouch = matchMedia('(hover: none)').matches;
        if(isTouch){
          e.preventDefault();
          frame.classList.add('open');
          setTimeout(()=>{ window.location.href = link.getAttribute('href'); }, 650);
        }
      });
    });
  </script>
</body>
</html>
