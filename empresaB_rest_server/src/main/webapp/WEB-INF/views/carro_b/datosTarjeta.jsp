<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>datos tarjeta</title>

<style type="text/css">
h1 {color:#3B0B0B;}
p {color:blue;}
h4 {color:#B40431;}
</style>

</head>
<body>
<%-- <form:form method="POST" modelAttribute="tarjetaCredito" id="tarjetaCredito" type="tarjetaCredito" action="validarTarjeta" enctype="multipart/form-data"> --%>
<form:form method="POST" modelAttribute="tarjetaCredito" id="tarjetaCredito" type="tarjetaCredito" action="${pageContext.request.contextPath}/tarjeta/validarTarjeta" enctype="multipart/form-data">
<fieldset>
<table class="table">
<h1>introduzca los datos de la tarjeta:</h1>
	     <tr>
			
	     	<th><label for="numero tarjeta">numero tarjeta:</label></th>
			<td><form:input path="digitos1" maxlength="4"  id="digitos1"  size="4"/>
				<form:errors path="digitos1" cssClass="error" />				
			</td>
			<td><form:input path="digitos2" maxlength="4"  id="digitos2" size="4"/>
				<form:errors path="digitos2" cssClass="error" />				
			</td>
			<td><form:input path="digitos3" maxlength="4"  id="digitos3" size="4"/>
				<form:errors path="digitos3" cssClass="error" />				
			</td>
			<td><form:input path="digitos4" maxlength="4"  id="digitos4" size="4"/>
				<form:errors path="digitos4" cssClass="error" />				
			</td>
			
		</tr>
		<tr>
		<th><label for="año">mes caducidad :</label></th>
				<td><form:input path="mes" maxlength="2" id="mes" size="2"/>
					<form:errors path="mes" cssClass="error" />
					<small>xx</small>
				</td>
		</tr>
		<tr>
		<th><label for="año">año caducidad :</label></th>
				<td><form:input path="anno" maxlength="4" id="anno" size="4"/>
					<form:errors path="anno" cssClass="error" />
					<small>xxxx</small>
				</td>
		</tr>
		
		<td><form:hidden path="idCarro" id="idCarro" value="${idCarro.idcarro_b}"/></td>
		<td><h4>total a pagar: ${total}</h4></td>
		<td><input name="tarjetaCredito" type="submit" value="realizar pago" /></td>


</table>	
<c:url var="editUrl" value="../productos/listado" />
			<a href="${editUrl}"    onmouseover="window.status = 'Pulse para volver al listado de productos'; return true" onmouseout="window.status=''"> <span title='Pulse para volver al listado de productos'> <img border=0 src="../resources/imagenes/listado.jpg" height=68 width=53> </a>


</fieldset>
</form:form>
</body>
</html>