<%-- 
    Document   : temperatura
    Created on : 18 oct 2025
    Author     : jcnaz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Conversión de Temperatura</title>
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Fredoka:wght@400;500;600&display=swap" rel="stylesheet">

<style>
  :root{ --c1:#05abda; --c2:#b2c7db; --c3:#e4f5f8; }
  *{margin:0;padding:0;box-sizing:border-box}
  body{
    font-family:'Fredoka',sans-serif;
    min-height:100vh;
    display:grid; place-items:center;
    background-image:url('Imagenes/fondoOpciones.jpg'); /* cambia si quieres otra */
    background-size:cover; background-position:center; background-attachment:fixed;
  }
  body::before{content:""; position:fixed; inset:0; background:rgba(0,0,0,.25); pointer-events:none;}

  .card{
    width:min(94vw, 560px);
    background:rgba(255,255,255,.75);
    backdrop-filter:saturate(140%) blur(6px);
    -webkit-backdrop-filter:saturate(140%) blur(6px);
    border-radius:22px;
    box-shadow:0 22px 60px rgba(0,0,0,.35);
    padding:28px 24px 26px;
  }

  .title{
    text-align:center; margin-bottom:6px;
    font-family:'Fredoka One',cursive;
    font-size:clamp(1.4rem,4.6vw,1.9rem);
    background:linear-gradient(135deg,var(--c1),var(--c2),var(--c3));
    -webkit-background-clip:text; background-clip:text; color:transparent;
  }
  .subtitle{ text-align:center; color:#334155; font-weight:600; margin-bottom:18px; }

  .section{ margin-top:18px; padding-top:10px; border-top:2px solid rgba(15,23,42,.08); }
  .section h3{
    font-family:'Fredoka One',cursive; font-size:1.05rem; color:#0f172a;
    letter-spacing:.3px; margin-bottom:10px; text-transform:uppercase;
  }

  .row{ display:grid; grid-template-columns:1fr auto; gap:10px; align-items:center; }
  @media (max-width:460px){ .row{ grid-template-columns:1fr; } }

  label{ display:block; color:#223046; font-weight:600; font-size:.9rem; margin-bottom:6px; }
  input[type="number"]{
    width:100%; padding:13px 14px; border:2px solid rgba(15,23,42,.15); border-radius:12px;
    background:#ffffffd9; font-size:1rem; color:#0f172a;
    transition:border-color .2s, box-shadow .2s, transform .15s;
  }
  input[type="number"]:focus{
    outline:none; border-color:var(--c1); box-shadow:0 0 0 4px rgba(5,171,218,.18); transform:translateY(-1px);
  }

  .btn{
    padding:13px 18px; border:none; border-radius:12px; cursor:pointer;
    background:linear-gradient(135deg,#44b4cc 0%, #05abda 100%);
    color:#fff; font-weight:700; letter-spacing:.4px; font-family:'Fredoka One',cursive;
    box-shadow:0 10px 28px rgba(5,171,218,.35);
    transition:transform .15s, box-shadow .2s; white-space:nowrap;
  }
  .btn:hover{ transform:translateY(-2px); box-shadow:0 14px 34px rgba(5,171,218,.45); }
  .btn:active{ transform:translateY(0); }

  .result{
    margin-top:10px; padding:12px 14px; border-radius:12px; background:#ffffffc9;
    box-shadow:inset 0 0 0 2px rgba(15,23,42,.06);
    color:#0f172a; font-weight:700; display:flex; justify-content:space-between; align-items:center;
  }
  .unit{ color:#475569; font-weight:800; margin-left:8px; }

  .back{
    display:block; margin:20px auto 0; text-align:center; text-decoration:none;
    padding:12px 16px; border-radius:12px; width:100%;
    color:#fff; font-weight:700; letter-spacing:.4px; font-family:'Fredoka One',cursive;
    background:linear-gradient(135deg,#8b5cf6 0%, #a855f7 100%);
    box-shadow:0 10px 28px rgba(168,85,247,.35);
    transition:transform .15s, box-shadow .2s;
  }
  .back:hover{ transform:translateY(-2px); box-shadow:0 14px 34px rgba(168,85,247,.45); }
</style>
</head>
<body>

  <section class="card" role="region" aria-label="Conversión de temperatura">
    <h1 class="title">CONVERSIÓN DE TEMPERATURA</h1>
    <p class="subtitle">De Kelvin a Celsius y de Celsius a Kelvin</p>

    <!-- ===== K -> °C ===== -->
    <div class="section" id="kToC">
      <h3>De Kelvin a Celsius</h3>
      <label for="kInput">Valor (K)</label>
      <div class="row">
        <input type="number" id="kInput" step="any" placeholder="Ingresa el valor en K">
        <button type="button" class="btn" id="btnKToC">Convertir</button>
      </div>
      <div class="result">
        <span id="cOut">0.00</span><span class="unit">°C</span>
      </div>
    </div>

    <!-- ===== °C -> K ===== -->
    <div class="section" id="cToK">
      <h3>De Celsius a Kelvin</h3>
      <label for="cInput">Valor (°C)</label>
      <div class="row">
        <input type="number" id="cInput" step="any" placeholder="Ingresa el valor en °C">
        <button type="button" class="btn" id="btnCToK">Convertir</button>
      </div>
      <div class="result">
        <span id="kOut">0.00</span><span class="unit">K</span>
      </div>
    </div>

    <a class="back" href="menu.jsp">Regresar al menú</a>
  </section>

<script>
  const fmt = n => (isFinite(n) ? Number(n).toFixed(2) : '0.00');

  // K -> °C   (°C = K - 273.15)
  const kIn  = document.getElementById('kInput');
  const cOut = document.getElementById('cOut');
  document.getElementById('btnKToC').addEventListener('click', () => {
    const K = parseFloat(kIn.value);
    cOut.textContent = fmt(K - 273.15);
  });
  kIn.addEventListener('keydown', e => { if(e.key==='Enter') document.getElementById('btnKToC').click(); });

  // °C -> K   (K = °C + 273.15)
  const cIn  = document.getElementById('cInput');
  const kOut = document.getElementById('kOut');
  document.getElementById('btnCToK').addEventListener('click', () => {
    const C = parseFloat(cIn.value);
    kOut.textContent = fmt(C + 273.15);
  });
  cIn.addEventListener('keydown', e => { if(e.key==='Enter') document.getElementById('btnCToK').click(); });
</script>

</body>
</html>
