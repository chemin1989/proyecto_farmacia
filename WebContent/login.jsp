<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es" >

<head>
  <meta charset="UTF-8">
  <title>Login Farmacias</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="shortcut icon" href="img/logo.ico">
  
</head>

<body>

  <div class="login-page">
  <div class="form">
    <form class="register-form" action="ServletRegistroFarmacias" method="post" enctype="multipart/form-data" 
    		onsubmit="registroCorrecto()">
      <input type="text" placeholder="Nombre farmacia" name="campoNombre" />
      <input type="password" placeholder="Contraseña" name="campoContraseña"/>
      <input type="password" placeholder="Repita contraseña" name=""/>
      <input type="text" placeholder="Correo electrónico" name="campoEmail"/>
      <input type="text" placeholder="Dirección" name="campoDireccion"/>
      <input type="text" placeholder="Código postal" name="campoCp"/>
      <input type="text" placeholder="Teléfono" value="" name="campoTelefono"/>
      <label>Adjunte licencia farmacéutica:</label>
      <input type="file" name="campoImagen">
      <button type="submit">Registrar</button>
      <p class="message">¿Ya estás registrado? <a href="#">Identifícate</a></p>
    </form>
    <form class="login-form" action="ServletLoginFarmacias" method="post" >
      <input type="text" placeholder="Correo electrónico" name="campoEmail"/>
      <input type="password" placeholder="Contraseña" name="campoContraseña"/>
      <button>Entrar</button>
      <p class="message">¿No estás registrado?<a href="#"> Crear cuenta</a></p>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>
    
    <script type="text/javascript" src="js/registroCorrecto.js"></script>

</body>

</html>
