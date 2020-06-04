 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">		
		<link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/bootstrap.min.css">
    	<link rel="stylesheet" href="webjars/mdbootstrap-bootstrap-material-design/4.7.4/css/mdb.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
		<link rel="stylesheet" href="resources/css/fondo.css" /> 
		<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
		<c:url value="../../resources/img/background.jpg" var="fondo"></c:url>
		<title>Operaciones CRUD</title>
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
				            	<a class="nav-link" href="ListadoLibros">Libros</a>
				          	</li>
				          	<li class="nav-item">
				            	<a class="nav-link" href="ListadoAutores">Autores</a>
				          	</li>
				          	<li class="nav-item active">
				            	<a class="nav-link" href="administracion">Administración
				            		<span class="sr-only">(actual)</span>
				            	</a>				            	
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
				                <h3 class="display-3 font-weight-bold white-text mb-0 pt-md-5 pt-5">Operaciones CRUD</h3>
	                  			<hr class="hr-light my-4 w-75">
	                  			<h4 class="subtext-header mt-2 mb-4">En los siguientes botones se acceden a los modales que te permiten realizar las acciones crud</h4>
							</div>
						</div>
					</div>
		  		</div>	          	
			</div>		  	
		</header>
		<main>
			<div class="modal fade" id="modalInsertarLibro" tabindex="-1" role="dialog" aria-labelledby="modalInsertarLibro" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header text-center">
				        <h4 class="modal-title w-100 font-weight-bold">Insertar un nuevo libro</h4>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <form id="formularioInsertarlibro">
					      <div class="modal-body mx-3">
					        <div class="md-form">
					          <i class="fas fa-book prefix grey-text"></i>
					          <label for="titulo">Título</label>
					      	  <input name="titulo" id="titulo_insertar" type="text" class="form-control" />
					      	  <span id="tituloErr" class="red-text"></span>			      	  
					        </div>
					        <div class="md-form">
					          <i class="fas fa-user prefix grey-text"></i>			          
					          <label for="nombreAutor">Autor</label>
					          <input name="nombreAutor" id="nombre_autor_insertar" type="text" class="form-control" />
					          <span id="autorErr" class="red-text"></span>	
					        </div>
					        <div class="md-form">
					          <i class="fas fa-barcode prefix grey-text"></i>			          
					          <label for="isbn">ISBN</label>
					          <input name="isbn" id="isbn_insertar" type="text" class="form-control" />
					          <span id="isbnErr" class="red-text"></span>
					        </div>				
					        <div class="md-form ">
					          <i class="far fa-file-alt prefix grey-text"></i>
					          <label for="numPaginas">Numero de páginas</label>
					          <input name="numPaginas" id="numPaginas_insertar" type="text" class="form-control" />	
					          <span id="paginasErr" class="red-text"></span>					  			        
					        </div> 
					        <div class="md-form">
					          <i class="far fa-calendar-alt prefix grey-text"></i>
					          <label for="fechaPublicacion">Fecha de publicación</label>
					          <input name="fechaPublicacion" id="fechaPublicacion_insertar" type="text" class="form-control" />						  			        
					          <span id="publicacionErr" class="red-text"></span>
					        </div>
					        <div class="md-form">
					          <i class="far fa-calendar-alt prefix grey-text"></i>
					          <label for="fechaEdicion">Fecha de edición</label>
					          <input name="fechaEdicion" id="fechaEdicion_insertar" type="text" class="form-control" />
					          <span id="edicionErr" class="red-text"></span>						  			        
					        </div>
					        <div class="md-form">
					        	<input type="file" name="file" id="anadirPortadaLibro"/>
					        	<div id="errorExtensionArchivo">
					      		</div>
					        </div>
					        <div class="modal-footer d-flex justify-content-center">
					        	<button type="submit" id="submit" class="btn btn-deep-orange">Añadir</button>
					        </div>
					      </div>			      
				      </form>      
				    </div>
				  </div>
				</div>
				<div class="modal fade" id="modalModificarLibro" tabindex="-1" role="dialog" aria-labelledby="modaModificarLibro"
				  aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header text-center">
				        <h4 class="modal-title w-100 font-weight-bold">Modificar libro</h4>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body mx-3">
				        <div class="md-form">
				        	<select class="libroAModificar custom-select" id="libroAModificarSeleccionado" >
							  <c:forEach items="${listaLibros}" var="sLibros" >
							  		<option>${sLibros.getTitulo()}</option>
							  </c:forEach>
							</select>
				      	</div>
					  </div>
					  <form id="formularioModificarLibro">
					  	  	<label for="id"></label>
					  	  	<input name="id" id="id" />
					      <div class="modal-body mx-3">
					        <div class="md-form ">
					          <i class="fas fa-book prefix grey-text"></i>
					          <label for="titulo" id="titulo">Título</label>
					      	  <input name="titulo" type="text" id="titulo_resp" value="" class="form-control " />
					        </div>
					        <div class="md-form ">
					          <i class="fas fa-user prefix grey-text"></i>			          
					          <label for="nombreAutor">Autor</label>
					          <input name="nombreAutor" type="text" id="nombre_autor" class="form-control " />
					        </div>
					        <div class="md-form ">
					          <i class="fas fa-barcode prefix grey-text"></i>			          
					          <label for="isbn">ISBN</label>
					          <input name="isbn" type="text" id="isbn_resp" class="form-control " />
					        </div>				
					        <div class="md-form ">
					          <i class="far fa-file-alt prefix grey-text"></i>
					          <label for="numPaginas">Numero de páginas</label>
					          <input name="numPaginas" type="text" id="numero_paginas" class="form-control " />						  			        
					        </div>
					        <div class="md-form ">
					          <i class="far fa-calendar-alt prefix grey-text"></i>
					          <label for="fechaPublicacion">Fecha de publicación</label>
					          <input name="fechaPublicacion" type="text" id="fecha_publicacion" class="form-control " />						  			        
					        </div>
					        <div class="md-form ">
					          <i class="far fa-calendar-alt prefix grey-text"></i>
					          <label for="fechaEdicion">Fecha de edición</label>
					          <input name="fechaEdicion" type="text" id="fecha_edicion" class="form-control " />						  			        
					        </div>		
					      </div>
					      <div class="modal-footer d-flex justify-content-center">
					        <button type="submit" id="submit" class="btn btn-deep-orange">Modificar</button>
					      </div>
				      </form>
				    </div>
				  </div>
				</div>			
				<div class="modal fade" id="modalBorrarLibro" tabindex="-1" role="dialog" aria-labelledby="modalBorrarLibro"
				  aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header text-center">
				        <h4 class="modal-title w-100 font-weight-bold">Borrar libro</h4>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          	<span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body mx-3">
				        <div class="md-form text-center">
				        	<select id="libroABorrarSeleccionado" class="libroABorrar custom-select">
							  <c:forEach items="${listaLibros}" var="libroEnSeleccionBorrar">
							  		<option>${libroEnSeleccionBorrar.getTitulo()}</option>
							  </c:forEach>
							</select>						
				      	</div>
					  </div>	
					  <form id="formularioBorrarLibro">
					  	  <div>
					  	  	<label for="id"></label>
					  	  	<input name="id" id="id_borrar" />
					  	  </div>		      	  
					      <div class="modal-body mx-3">
					        <div class="md-form">
					          <i class="fas fa-book prefix grey-text"></i>
					          <label for="titulo" id="titulo">Título</label>
					      	  <input name="titulo" type="text" id="titulo_resp_borrar" class="form-control"/>
					        </div>
					        <div class="md-form">
					          <i class="fas fa-user prefix grey-text"></i>			          
					          <label for="nombreAutor">Autor</label>
					          <input name="nombreAutor" type="text" id="nombre_autor_borrar" class="form-control"/>
					        </div>
					        <div class="md-form">
					          <i class="fas fa-barcode prefix grey-text"></i>			          
					          <label for="isbn">ISBN</label>
					          <input name="isbn" type="text" id="isbn_borrar" class="form-control"/>
					        </div>				
					        <div class="md-form">
					          <i class="far fa-file-alt prefix grey-text"></i>
					          <label for="numPaginas">Numero de páginas</label>
					          <input name="numPaginas" type="text" id="numero_paginas_borrar" class="form-control"/>						  			        
					        </div>
					        <div class="md-form">
					          <i class="far fa-calendar-alt prefix grey-text"></i>
					          <label for="fechaPublicacion">Fecha de publicación</label>
					          <input name="fechaPublicacion" type="text" id="fecha_publicacion_borrar" class="form-control" />						  			        
					        </div>
					        <div class="md-form">
					          <i class="far fa-calendar-alt prefix grey-text"></i>
					          <label for="fechaEdicion">Fecha de edición</label>
					          <input name="fechaEdicion" type="text" id="fecha_edicion_borrar" class="form-control"/>						  			        
					        </div>		
					      </div>
					      <div class="modal-footer d-flex justify-content-center">
					        	<button type="submit" id="submit" class="btn btn-deep-orange">Borrar</button>
					   	  </div>
					   </form>	   			 
				    </div>
				</div>
			</div>
			<div class="text-center mb-4">
				<a class="btn btn-purple btn-rounded mb-4" data-toggle="modal" data-target="#modalInsertarLibro">Añadir libro</a>
				<a class="btn btn-purple btn-rounded mb-4" data-toggle="modal" data-target="#modalModificarLibro">Modificar libro</a>
				<a class="btn btn-purple btn-rounded mb-4" data-toggle="modal" data-target="#modalBorrarLibro">Borrar libro</a>
			</div>
			<div class="container pb-5 mb-5">
				<div class="row mt-2">
		    		<c:forEach items="${listaLibros}" var="imagen" varStatus="loop">
		    			<c:if test="${imagen.getTieneImagen() == true }">
		    				<div class="col-md-2 mb-2 mt-2">
			                    <span id="tituloImagen${loop.index}" data-titulo="${imagen.getTitulo()}"></span>
			                    <img height="250" width="150" src="<c:url value="/administracion/obtenerImagenes"><c:param name="id" value="${imagen.getId()}"/></c:url>" 
			                    	 id="id${loop.index}" onmouseover="mostrarDetallesLibros('${loop.index}')"/>
		           			</div>
		           		</c:if>
		            </c:forEach>
				</div>
	    	</div>
		</main>
		<script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/popper.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="webjars/mdbootstrap-bootstrap-material-design/4.7.4/js/mdb.min.js"></script>
		<script type="text/javascript" src="resources/js/administracion.js"></script>
	</body>
</html>