<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/bootstrap.min.css">
    	<link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/mdb.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
		<fmt:setBundle basename="messages" />
	</head>
	<body>
		<div class="container my-5">
			<form:form method="POST" action="procesoRegistro" modelAttribute="userForm" class="border border-light p-5">
			    <p class="h4 mb-4 text-center">Registrarse</p>
			    <form:label path="username"> </form:label>
			    <form:input path="username" type="text" cssClass="form-control" placeholder="Usuario" />
			    <form:label path="password">  </form:label>
			    <form:input path="password" type="password" cssClass="form-control" placeholder="Contraseña"/>	
			    <form:label path="confirmacionPassword"> </form:label>
			    <form:input path="confirmacionPassword" type="password" cssClass="form-control" placeholder="Confirmar contraseña" />	
			    <button class="btn btn-info my-4 btn-block" type="submit">Registrarse</button>
				<p>${error}</p>
			</form:form>
		</div>
		<script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/popper.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/mdb.min.js"></script>
	</body>
</html>	