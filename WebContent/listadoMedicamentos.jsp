<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/menu_topexpand.css" />
		<link rel="stylesheet" type="text/css" href="css/table.css" />
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
						<a href="ServletListadoMedicamentosFarmacia"><i class="fa fa-fw fa-bell-o"></i><span>Listar Medicamentos Propios</span></a>
						<a href="ServletListadoMedicamentos"><i class="fa fa-fw fa-comment-o"></i><span>Existencias</span></a>
						<a href="ServletLogOut"><i class="fa fa-fw fa-bar-chart-o"></i><span>Cerrar Sesion</span></a>
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
						<h1>Listado Medicamentos</h1>
							
							<div>
								<c:if test= "${desdeAnterior >= 0}">
									<a href="ServletListadoMedicamentos?desde=${desdeAnterior}&cuantos=20"> Anterior </a> &nbsp;
								</c:if>
								<c:if test="${desdeSiguiente < sessionScope.medicamentosTotales}">
								<a href="ServletListadoMedicamentos?desde=${desdeSiguiente}&cuantos=20"> Siguiente </a>
								</c:if>
							</div>

						<c:forEach items="${medicamentos}" var="m">
							<form action="ServletSeleccionMedicamentos?id=${datosMedicamento.id}" method="post">								
								<table>
							  <tr>
								<th>Fármaco</th>
    							<th>Precio</th> 								
    							<th>Cantidad</th>
    							<th>Codigo Nacional</th>
    							<th>Farmacia</th>
    							<th>Correo eléctrónico</th>
    							<th>Teléfono</th>
    							<th>Dirección</th>
    							
							  </tr>
							   <tr>
							   <td>${m.nombre}</td>
							   <td>${m.precio}</td>
							   <td>${m.cantidad}</td>
							   <td>${m.codigoMedicamento}</td>
							   <td>${m.farmacia.nombre}</td>
							   <td>${m.farmacia.email}</td>
							   <td>${m.farmacia.telefono}</td>
							   <td>${m.farmacia.direccion}</td>
							   <td><input type="submit" href="" value="Intercambiar"/></td>
							   </tr>
								</table>
							</form>
						</c:forEach>
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



