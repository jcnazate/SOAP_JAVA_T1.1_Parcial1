<%-- 
    Document   : login
    Author     : jcnaz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - Conversión de Unidades</title>
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Fredoka:wght@400;500;600&display=swap" rel="stylesheet">

<style>
  :root{
    --c1:#05abda; /* gradiente del título */
    --c2:#b2c7db;
    --c3:#e4f5f8;
  }
  *{margin:0;padding:0;box-sizing:border-box}

  /* ===== Fondo con imagen y centrado del contenido ===== */
  body{
    font-family:'Fredoka',sans-serif;
    min-height:100vh;
    display:grid;
    place-items:center;          /* centra TODO al medio */
    background-image:url('Imagenes/fondoLogin.jpg'); /* <-- tu imagen */
    background-size:cover;
    background-position:center;
    background-attachment:fixed; /* se siente más “premium” */
  }

  /* capa oscura suave para dar contraste al cuadro */
  body::before{
    content:"";
    position:fixed; inset:0;
    background:rgba(0,0,0,.25);
    pointer-events:none;
  }

  /* ===== Tarjeta de login (blanco translúcido) ===== */
  .login-card{
    width:min(92vw, 440px);
    background:rgba(255,255,255,.72);       /* blanco translúcido */
    backdrop-filter:saturate(140%) blur(6px);/* efecto “glass” */
    -webkit-backdrop-filter:saturate(140%) blur(6px);
    border-radius:18px;
    box-shadow:0 18px 60px rgba(0,0,0,.35);
    padding:28px 26px 26px;
    position:relative;
    z-index:1;
  }

  /* ===== Encabezado ===== */
  .header{
    text-align:center;
    margin-bottom:18px;
  }
  .header h1{
    font-family:'Fredoka One',cursive;
    font-size:clamp(1.6rem,4.6vw,2rem);
    line-height:1.1;
    background:linear-gradient(135deg,var(--c1),var(--c2),var(--c3));
    -webkit-background-clip:text;
    background-clip:text;
    color:transparent;
    margin-bottom:6px;
  }
  .header p{
    color:#334155; /* gris azulado sobre el blanco translúcido */
    font-weight:600;
    letter-spacing:.3px;
  }

  /* ===== Formulario ===== */
  .form-group{margin-top:16px}
  label{
    display:block;
    margin-bottom:6px;
    color:#223046;
    font-size:.93rem;
    font-weight:600;
    letter-spacing:.4px;
    text-transform:uppercase;
  }
  input{
    width:100%;
    padding:13px 14px;
    border:2px solid rgba(15,23,42,.15);
    border-radius:12px;
    background:#ffffffd9; /* un poco más opaco para escribir */
    font-size:1rem;
    color:#0f172a;
    transition:border-color .2s, box-shadow .2s, transform .15s;
  }
  input::placeholder{color:#6b7280}
  input:focus{
    outline:none;
    border-color:var(--c1);
    box-shadow:0 0 0 4px rgba(5,171,218,.18);
    transform:translateY(-1px);
  }

  .login-btn{
    margin-top:18px;
    width:100%;
    padding:14px;
    border:none;
    border-radius:12px;
    color:#fff;
    font-family:'Fredoka One',cursive;
    font-size:1.05rem;
    letter-spacing:.5px;
    cursor:pointer;
    background:linear-gradient(135deg,#44b4cc 0%, #05abda 100%);
    box-shadow:0 10px 28px rgba(5,171,218,.35);
    transition:transform .15s, box-shadow .2s, filter .2s;
  }
  .login-btn:hover{ transform:translateY(-2px); box-shadow:0 14px 36px rgba(5,171,218,.45); }
  .login-btn:active{ transform:translateY(0); filter:saturate(110%); }

  .error{
    margin-top:10px;
    background:rgba(239,68,68,.1);
    border:1px solid rgba(239,68,68,.35);
    color:#991b1b;
    padding:10px 12px;
    border-radius:10px;
    font-weight:600;
  }

  /* footer pequeño opcional dentro de la tarjeta */
  .footer{
    margin-top:14px;
    text-align:center;
    color:#475569;
    font-size:.92rem;
  }
</style>
</head>

<body>
  <section class="login-card">
    <div class="header">
      <h1>Conversión de Unidades GR08</h1>
      <p>Inicio de sesión</p>
    </div>

    <form action="SoapController" method="post" autocomplete="off">
      <input type="hidden" name="action" value="login">

      <div class="form-group">
        <label for="username">Usuario</label>
        <input type="text" id="username" name="user" placeholder="Ingresa tu usuario" required>
      </div>

      <div class="form-group">
        <label for="password">Contraseña</label>
        <input type="password" id="password" name="password" placeholder="Ingresa tu contraseña" required>
      </div>

      <% if (request.getAttribute("error") != null) { %>
        <p class="error"><%= request.getAttribute("error") %></p>
      <% } %>

      <button type="submit" class="login-btn">Ingresar</button>

      <div class="footer">
        <!-- Puedes colocar links de ayuda / recuperación -->
      </div>
    </form>
  </section>
</body>
</html>
