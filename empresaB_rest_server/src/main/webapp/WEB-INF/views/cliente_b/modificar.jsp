<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Modificar cliente</title>


</head>
<body>

<h2>modificar Cliente_B</h2>

<c:if  test="${!empty cliente_b}">

<form:form method="POST" modelAttribute="cliente_b" id="cliente_b" type="cliente_b" action="${pageContext.request.contextPath}/clientes/cliente/modificarCliente_B" enctype="multipart/form-data">


			
	<fieldset>
	 
	  <table>
	  
	  	     <tr>
			
	     	<!-- <th><label for="nombre_b">idusuarios_b :</label></th> -->
			<td><form:hidden path="idusuarios_b" maxlength="15"  id="nombre_b" value= "${cliente_b.idusuarios_b}" />
				<form:errors path="idusuarios_b" cssClass="error" />
				
			</td>
		</tr>
	     <tr>
			
	     	<th><label for="nombre_b">Nombre :</label></th>
			<td><form:input path="nombre_b" maxlength="15"  id="nombre_b" value= "${cliente_b.nombre_b}"/>
				<form:errors path="nombre_b" cssClass="error" />
				
			</td>
		</tr>
		<tr>
				<th><label for="apellidos_b">Apellidos :</label></th>
				<td><form:input path="apellidos_b" maxlength="15" id="apellidos_b" value= "${cliente_b.apellidos_b}"/>
					<form:errors path="apellidos_b" cssClass="error" />
					
				</td>
		</tr>
		
		<tr>
				<th><label for="dni_nif_b">DNI/NIF :</label></th>
				<td><form:input path="dni_nif_b" maxlength="15" id="dni_nif_b" value= "${cliente_b.dni_nif_b}"/>
					<form:errors path="dni_nif_b" cssClass="error" />
				</td>
		</tr>
		<tr>
				<th><label for="email_b">e-mail :</label></th>
				<td><form:input path="email_b" maxlength="75" id="email_b"  value= "${cliente_b.email_b}"/>
					<form:errors path="email_b" cssClass="error" />
				</td>
		</tr>
		<tr>
				<th><label for="login_usuario_b">Login :</label></th>
				<td><form:input path="login_usuario_b" maxlength="15" id="login_usuario_b" value= "${cliente_b.login_usuario_b}"/>
					<form:errors path="login_usuario_b" cssClass="error" />
					<form:errors cssClass="error" element="loginInvalido"/>
					<small>login de usuario</small>
				</td>
		</tr>
		<tr>
		<th><label for="password_b">Password :</label></th>
				<td><form:password path="password_b" maxlength="15" id="password_b" value= "${cliente_b.password_b}"/>
					<form:errors path="password_b" cssClass="error" />
					<small>de 4 a 10 caracteres</small>
				</td>
		</tr>
				
		<tr>
				<th><label for="direccion_b">Dirección :</label></th>
				<td><form:input path="direccion_b" maxlength="15" id="direccion_b" value= "${cliente_b.direccion_b}"/>
					<form:errors path="direccion_b" cssClass="error" />
				</td>
		</tr>	

		
		<tr>
      <td>provincia_b:</td>
      <td>
       <select name= provincia_b>
		<option value="Alava" selected="selected">Alava</option>
		<option value="Albacete">Albacete</option>
		<option value="Alicante">Alicante</option>
		<option value="Almeria">Almeria</option>
		<option value="Asturias">Asturias</option>
		<option value="Avila">Avila</option>
		<option value="Badajoz">Badajoz</option>
		<option value="Barcelona">Barcelona</option>
		<option value="Burgos">Burgos</option>
		<option value="Caceres">Caceres</option>
		<option value="Cadiz">Cadiz</option>
		<option value="Cantabria">Cantabria</option>
		<option value="Castellon">Castellon</option>
		<option value="Ceuta">Ceuta</option>
		<option value="Ciudad Real">Ciudad Real</option>
		<option value="Cordoba">Cordoba</option>
		<option value="Coruña, A">Coruña, A</option>
		<option value="Cuenca">Cuenca</option>
		<option value="Girona">Girona</option>
		<option value="Granada">Granada</option>
		<option value="Guadalajara">Guadalajara</option>
		<option value="Guipuzcoa">Guipuzcoa</option>
		<option value="Huelva">Huelva</option>
		<option value="Huesca">Huesca</option>
		<option value="Illes Balears">Illes Balears</option>
		<option value="Jaen">Jaen</option>
		<option value="Leon">Leon</option>
		<option value="Lleida">Lleida</option>
		<option value="Lugo">Lugo</option>
		<option value="Madrid">Madrid</option>
		<option value="Malaga">Malaga</option>
		<option value="Melilla">Melilla</option>
		<option value="Murcia">Murcia</option>
		<option value="Navarra">Navarra</option>
		<option value="Ourense">Ourense</option>
		<option value="Palencia">Palencia</option>
		<option value="Palmas, Las">Palmas, Las</option>
		<option value="Pontevedra">Pontevedra</option>
		<option value="Rioja, La">Rioja, La</option>
		<option value="Salamanca">Salamanca</option>
		<option value="Santa Cruz De Tenerife">Santa Cruz De Tenerife</option>
		<option value="Segovia">Segovia</option>
		<option value="Sevilla">Sevilla</option>
		<option value="Soria">Soria</option>
		<option value="Tarragona">Tarragona</option>
		<option value="Teruel">Teruel</option>
		<option value="Toledo">Toledo</option>
		<option value="Valencia">Valencia</option>
		<option value="Valladolid">Valladolid</option>
		<option value="Vizcaya">Vizcaya</option>
		<option value="Zamora">Zamora</option>
		<option value="Zaragoza">Zaragoza</option>
       </select>
      </td>
   </tr>
	
		<tr>
				<th><label for="codigopostal_b">Codigo postal :</label></th>
				<td><form:input path="codigopostal_b" maxlength="15" id="codigopostal_b" value= "${cliente_b.codigopostal_b}"/>
					<form:errors path="codigopostal_b" cssClass="error" />
				</td>
		</tr>	
				

		
	     <tr>
    	  
    	     <td><input name="cliente_b" type="submit" value="Gruardar cambios" /></td>
  	   </tr>

	</table>	

	</fieldset>
	





	
</form:form>
</c:if>
<c:url var="editUrl" value="../../productos/listado" />
			<a href="${editUrl}"    onmouseover="window.status = 'Pulse para volver al listado de productos'; return true" onmouseout="window.status=''"> <span title='Pulse para volver al listado de productos'> <img border=0 src="../../resources/imagenes/listado.jpg" height=68 width=53> </a>
</body>
</html>