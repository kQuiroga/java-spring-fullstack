<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/mdb.min.css">
  		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
		<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
		<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%><%@ page isELIgnored="false" %>

		
		<title>Listado Libros</title>
	</head>
	<body>
		<header>
			<div class="container-fluid mt-5">
			    <div class="jumbotron text-center purple-gradient">
					<h1 >Gestor de Libros</h1>
					<a href="ListadoLibros" class="btn transparent"><i class="fas fa-arrow-left"></i>&nbsp;&nbsp;Volver</a>
			    </div>
			</div>
		</header>
		<main>
			<div class="container">
				<div class="card">
					<div class="card-header">
						<span>Error en la búsqueda</span>
					</div>
					<div class="card-body">
						<p>
							Ha ocurrido un error en la búsqueda. Inténtelo de nuevo y compruebe que se ha introducido los datos
							correctamente.
						</p>
					</div>
				</div>
				
			</div>
		</main>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/jquery-3.3.1.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/popper.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/mdb.min.js"></script>
	</body>
</html>