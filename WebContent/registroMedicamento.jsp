<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>PharmaLance</title>
		<meta name="description" content="Modern effects and styles for off-canvas navigation with CSS transitions and SVG animations using Snap.svg" />
		<meta name="keywords" content="PharmaLance, reciclar, medicamento, farmacias, comprar, intercambiar" />
		<link rel="shortcut icon" href="img/logo.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/menu_topexpand.css" />
		
		
		<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	</head>
	<body>
		<div class="container">
			<div class="menu-wrap">
				<nav class="menu">
					<div class="icon-list">
						<a href="buscador.jsp"><i class="fa fa-fw fa-star-o"></i><span>Registra tu medicamento</span></a>
						<a href="ServletListadoMedicamentosFarmacia"><i class="fa fa-fw fa-bell-o"></i><span>Listar Medicamento Propios</span></a>
						<a href="buscador2.jsp"><i class="fa fa-fw fa-comment-o"></i><span>Buscar medicamentos</span></a>
						<a href="ServletLogOut"><i class="fa fa-fw fa-bar-chart-o"></i><span>Cerrar Sesión</span></a>
						</form>
					</div>
				</nav>
			</div>
			<button class="menu-button" id="open-button"></button>
			<div class="content-wrap">
				<div class="content">
					<header class="codrops-header">
						<div class="codrops-links">
							<a class="codrops-icon codrops-icon-prev" href="index.jsp"><span>Inicio</span></a>
						</div>
						<h1>PharmaLance</h1>
						<h2 style="color:red" align="center"><b>Registro de medicamentos</b></h2>
						<form class="form-horizontal" method="post" action="ServletRegistroMedicamento">
						  <div class="form-group">
						    <label for="text1" class="control-label col-xs-4">Nombre</label> 
						    <div class="col-xs-8">
						      <input id="text1" name="campoNombre" type="text" value="${medicamentoSeleccionado.nombre}" class="form-control" readonly>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="text2" class="control-label col-xs-4">Código Nacional</label> 
						    <div class="col-xs-8">
						      <input id="text2" name="campoCodigo" value="${medicamentoSeleccionado.codigoMedicamento}" type="text" class="form-control" readonly>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="text3" class="control-label col-xs-4">Precio</label> 
						    <div class="col-xs-8">
						      <input id="text3" name="campoPrecio" value="${medicamentoSeleccionado.precio}" type="text" class="form-control" readonly>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="text" class="control-label col-xs-4">Cantidad</label> 
						    <div class="col-xs-8">
						      <input id="text" name="campoCantidad" type="text" class="form-control" required="required">
						    </div>
						  </div> 
						  <div class="form-group row">
						    <div class="col-xs-offset-4 col-xs-8">
						      <button name="submit" type="submit" class="btn btn-primary"> Registrar </button>
						    </div>
						  </div>
						</form>
						</nav>
						</p>
					</header>
					<!-- Related demos -->
					
				</div>
			</div><!-- /content-wrap -->
		</div><!-- /container -->
		<script src="js/classie.js"></script>
		<script src="js/main.js"></script>
	</body>
</html>










