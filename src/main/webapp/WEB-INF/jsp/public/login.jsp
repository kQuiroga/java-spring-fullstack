<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/mdb.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
        <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
        <fmt:setBundle basename="messages" />
		<title>Gestor Libros - Resultado búsqueda autores</title>
	</head>
	<body>
		<div class="container mt-5" id="formularioContainer">
			<form action="login" method="POST" class="text-center border border-light p-5" id="loginFormulario" onsubmit="return validarFormularioLogin()">		
			    <p class="h4 mb-4">Iniciar sesión</p>
			    <input type="text" name="username" id="usuario" class="usuario form-control mb-4" placeholder="Usuario">
			    <input type="password" name="password" id="contrasena" class="form-control mb-4" placeholder="Contraseña">
			    <button class="btn btn-info btn-block my-4" type="submit" name="submit" value="submit" >Sign in</button>
				<c:if test="${param.error != null}">
					<div id="error">
						<spring:message code="message.badCredentials"></spring:message>
					</div>
				</c:if>
			</form>
		</div>
		<script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/jquery-3.3.1.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/popper.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/mdb.min.js"></script>
		<script type="text/javascript" src="resources/js/login.js"></script>
	</body>
</html>