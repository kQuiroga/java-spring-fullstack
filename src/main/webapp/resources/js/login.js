function validarFormularioLogin() {
	var valorUsuario = $("#usuario").val();
	var valorContrasena = $("#contrasena").val();
	
	if (valorUsuario == "" && valorContrasena == ""){			
		console.log("entra en el if")
		alert("Se deben de introducir usuario y contraseña")
		$("#usuario").focus();
		return false;
	}
	
	if(valorUsuario == ""){
		alert("Se debe de introducir un usuario obligatoriamente");
		$("#usuario").focus()
		return false;
	}
	
	if(valorContrasena == ""){
		alert("Se debe de introducir una contraseña");
		$("#contrasena").focus()
		return false;
	}
	
	return true;
}


