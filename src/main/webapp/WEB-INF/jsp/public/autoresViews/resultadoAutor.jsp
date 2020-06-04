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
		<title>Gestor Libros - Resultado búsqueda autores</title>
	</head>
	<body>
		<div>
	       <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Nombre</th>
		        <th>Fecha</th>
		      </tr>
		    </thead>
		    <tbody>
			    <c:forEach items="${listaFiltradaAutores}" var="autor">
			          <tr>
				        <td><c:out value="${autor.getNombre()}"/></td>
				        <td><c:out value="${autor.getFecha()}"/></td>			    
			          </tr>
			      </c:forEach>
		    </tbody>
		  </table>
	    </div>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/jquery-3.3.1.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/popper.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/mdb.min.js"></script>
	</body>
</html>