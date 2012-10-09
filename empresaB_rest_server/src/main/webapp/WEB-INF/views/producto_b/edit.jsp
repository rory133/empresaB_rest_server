<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%-- <%@page language="java" contentType="text/html;  charset=UTF-8"   pageEncoding="UTF-8" %> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Crear producto</title>


</head>
<body>

<h2>Introducir Producto_B</h2>
<%-- <form:form method="POST" commandName="producto_b"> --%>
<%-- <form:form method="POST" modelAttribute="producto_b" id="producto_b" type="producto_b" action="crearProductoB" enctype="multipart/form-data"> --%>
<form:form method="POST" modelAttribute="producto_b" id="producto_b" type="producto_b" action="crearProductoB" enctype="multipart/form-data">
<%-- <form:form method="POST" modelAttribute="producto_b"> --%>

			
	<fieldset>
	 
	  <table>
	     <tr>
			
	     	<th><label for="nombre_productoB">Codigo producto:</label></th>
			<td><form:input path="nombre_productoB" maxlength="15"  id="nombre_productoB"/>
				<form:errors path="nombre_productoB" cssClass="error" />
				
			</td>
		</tr>
		<tr>
				<th><label for="longitud_b">Longitud :</label></th>
				<td><form:input path="longitud_b" maxlength="15" id="longitud_b"/>
					<form:errors path="longitud_b" cssClass="error" />
					<h2>${exception.customMsg}</h2>
				</td>
		</tr>
		
		<tr>
				<th><label for="diametro_b">Diametro :</label></th>
				<td><form:input path="diametro_b" maxlength="15" id="diametro_b"/>
					<form:errors path="diametro_b" cssClass="error" />
				</td>
		</tr>
		<tr>
				<th><label for="cantidad_existencias">Cantidad de existencias :</label></th>
				<td><form:input path="cantidad_existencias" maxlength="15" id="cantidad_existencias"/>
					<form:errors path="cantidad_existencias" cssClass="error" />
				</td>
		</tr>
		<tr>
				<th><label for="precio_b">Precio :</label></th>
				<td><form:input path="precio_b" maxlength="15" id="precio_b"/>
					<form:errors path="precio_b" cssClass="error" />
				</td>
		</tr>
		
		<tr>
				<th><label for="image">Imagen :</label></th>
				<td><input name="image" type="file"/>
				
				</td>
		</tr>
				
				
				
	<%-- 		<td><form:label path="nombre_productoB">nombr e_productoB</form:label></td>
			<td><form:input path="nombre_productoB"></form:input></td> --%>
			<%-- <form:input path="nombre_productoB"/> --%>
			<%-- <td><form:input path="nombre_productoB"></form:input></td>   --%> 
			<%-- <form:input path="nombre_productoB" id="nombre_productoB"/> --%>
			<%--<td><form:input path="nombre_productoB" size="33"/></td> --%>
		
	     <tr>
    	  
    	     <td><input name="producto_b" type="submit" value="Crear Producto" /></td>
  	   </tr>

	</table>	

	</fieldset>
	

	
</form:form>

</body>
</html>