<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Crear administrador</title>


</head>
<body>

<h2>Introducir Administrador_B</h2>

<form:form method="POST" modelAttribute="administrador_b" id="administrador_b" type="administrador_b" enctype="multipart/form-data">


			
	<fieldset>
	 
	  <table>
	     <tr>
			
	     	<th><label for="nombre_b">Nombre :</label></th>
			<td><form:input path="nombre_b" maxlength="55"  id="nombre_b"/>
				<form:errors path="nombre_b" cssClass="error" />
				
			</td>
		</tr>
		<tr>
				<th><label for="apellidos_b">Apellidos :</label></th>
				<td><form:input path="apellidos_b" maxlength="55" id="apellidos_b"/>
					<form:errors path="apellidos_b" cssClass="error" />
					
				</td>
		</tr>
		
		<tr>
				<th><label for="dni_nif_b">DNI/NIF :</label></th>
				<td><form:input path="dni_nif_b" maxlength="9" id="dni_nif_b"/>
					<form:errors path="dni_nif_b" cssClass="error" />
				</td>
		</tr>
		<tr>
				<th><label for="email_b">e-mail :</label></th>
				<td><form:input path="email_b" maxlength="75" id="email_b"/>
					<form:errors path="email_b" cssClass="error" />
				</td>
		</tr>
		
		<tr>
				<th><label for="login_usuario_b">Login :</label></th>
				<td><form:input path="login_usuario_b" maxlength="45" id="login_usuario_b"/>
					<form:errors path="login_usuario_b" cssClass="error" />
					<form:errors cssClass="error" element="loginInvalido"/>
					<small>de 4 a 15 caracteres</small>
				</td>
		</tr>
		<tr>
		<th><label for="password_b">Password :</label></th>
				<td><form:password path="password_b" maxlength="15" id="password_b"/>
					<form:errors path="password_b" cssClass="error" />
					<small>de 4 a 10 caracteres</small>
				</td>
		</tr>
		
		<tr>
				<th><label for="cargo_b">Cargo :</label></th>
				<td><form:input path="cargo_b" maxlength="45" id="cargo_b"/>
					<form:errors path="cargo_b" cssClass="error" />
					
				</td>
		</tr>
		<tr>
		<th><label for="matricula_b">matricula :</label></th>
				<td><form:input path="matricula_b" maxlength="8" id="matricula_b"/>
					<form:errors path="matricula_b" cssClass="error" />
					<small>maximo 8 caracteres</small>
				</td>
		</tr>

				

		
	     <tr>
    	  
    	     <td><input name="administrador_b" type="submit" value="Crear Cuenta administrador" /></td>
  	   </tr>

	</table>	

	</fieldset>
	





	
</form:form>

</body>
</html>