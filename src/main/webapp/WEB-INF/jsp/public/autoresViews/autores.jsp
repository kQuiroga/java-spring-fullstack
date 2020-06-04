<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/mdb.min.css">
        <link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/addons/datatables.min.css">
  		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
  		<link rel="stylesheet" href="resources/css/fondo.css" />			
        <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  
        <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>	        
        <title>Listado de Autores</title>
	</head>
	<body>
	    <header>
	    	<nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
			  	<div class="container">
			    	<a class="navbar-brand" href="inicio" target="_blank">
			        	<span>GL</span>
			      	</a>
			    	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7"
			        	aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
			        	<span class="navbar-toggler-icon"></span>
			      	</button>
			      	<div class="collapse navbar-collapse " id="navbarSupportedContent-7">
			        	<ul class="navbar-nav mr-auto">
			          		<li class="nav-item">
			            		<a class="nav-link" href="inicio">Inicio</a>
			          		</li>
				          	<li class="nav-item">
				            	<a class="nav-link" href="ListadoLibros">Libros
				            	</a>
				          	</li>
				          	<li class="nav-item active">
				            	<a class="nav-link" href="ListadoAutores">Autores
				            		<span class="sr-only">(actual)</span>				            	
				            	</a>
				          	</li>
				          	<li class="nav-item	">
				            	<a class="nav-link" href="administracion">Administración</a>				            	
				          	</li>
				        </ul>
				        <ul class="nav inline-right">
				          	<li class="nav-item mt-3">
					          	<security:authorize access="isAuthenticated()">
							    	<span class="text-white">&nbsp;<i class="fas fa-user prefix green-text"></i>&nbsp;&nbsp;<security:authentication property="principal.username" /></span>
								</security:authorize>
			   				</li>
			   				<li class="nav-item ml-2">
			   					<security:authorize access="isAuthenticated()">
			   						<a class="nav-link white-text" href="logout">
			   							<button class="btn btn-rounded btn-outline-white btn-sm">Desconectarse</button>
			   						</a>
			   					</security:authorize>
			   				</li>
			       		 </ul>		
			    	</div>
			  	</div>
		  	</nav>
		  	<div class="view">
	          	<video class="video-intro" poster= "${fondo}" playsinline autoplay muted loop>
	          		<source src="https://mdbootstrap.com/img/video/animation.mp4" type="video/mp4">
	        	</video>
	        	<div class="mask rgba-gradient align-items-center">
		          	<div class="container px-md-3 px-sm-0">
		          		<div class="row wow zoomIn">
							<div class="crud-informacion col-md-12 mb-4 white-text text-center">
				                <h3 class="display-3 font-weight-bold white-text mb-0 pt-md-5 pt-5">Autores disponibles</h3>
	                  			<hr class="hr-light my-4 w-75">
	                  			<h4 class="subtext-header mt-2 mb-4">Parte solo accesible para usuarios con permisos de usuario</h4>
							</div>
						</div>
					</div>
		  		</div>	          	
			</div>		  	
	    </header>
	    <main>
		    <div class="container">
		    	<div class="table-responsive table-white">
			    	<table id="tablaAutores" class="table table-striped table-hover table-bordered" cellspacing="0">
			            <thead class="thead-light">
			              <tr>
			                <th>Nombre</th>
			                <th>Lugar de nacimiento</th>
			                <th>Fecha de nacimiento</th>
			                <th>Fecha de fallecimiento</th>
			              </tr>
			            </thead>
			            <tbody>
			                <c:forEach items="${lista}" var="autor">
			                      <tr>
			                        <td><c:out value="${autor.getNombre()}"/></td>
			                        <td><c:out value="${autor.getLugarNacimiento()}"/></td>
			                        <td><c:out value="${autor.getFechaNacimiento()}"/></td>   
			                        <td><c:out value="${autor.getFechaFallecimiento()}"/></td>
			                      </tr>
			                  </c:forEach>
			            </tbody>
		        	</table>
		        </div>
		    </div>
	    </main>
	    <footer>
	    </footer>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/jquery-3.3.1.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/popper.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/mdb.min.js"></script>1
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/addons/datatables.min.js"></script>
	    <script type="text/javascript" src="resources/js/iniciarDatatables.js"></script>
	</body>
</html>