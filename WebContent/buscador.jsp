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
						<a href="ServletListadoMedicamentosFarmacia"><i class="fa fa-fw fa-bell-o"></i><span>Listado Medicamentos Propios</span></a>
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
						<h1>PharmaLance <span>Trabajando para mejorar el mundo</span></h1>
						<h2 style="color:red">Buscador de medicamentos en base de datos</h2> 
		
						<form action="ServletBusquedaDatosMedicamentos" method="post"> <div class="input-group"> 
						<input type="text" class="form-control" size="50" placeholder="Buscar medicamento" 
							name="campoBusquedaDatos"/> 
						<button style="inline" type="submit"> BUSCAR </button> 
						</nav>
						</p>
					</header>
					<!-- Related demos -->
					
				</div>
			</div><!-- /content-wrap -->
		</div><!-- /container -->
		
		
		</form> 
	    <script src="js/classie.js"></script>
		<script src="js/main.js"></script>
	</body>
	</html>



