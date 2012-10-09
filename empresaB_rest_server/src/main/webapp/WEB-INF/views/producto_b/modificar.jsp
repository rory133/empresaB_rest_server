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
<title>editar Borrar producto</title>


</head>
<body>

<h2>Modificar Producto_B</h2>
<c:if  test="${!empty producto_b}">
<%-- <form:form method="POST" commandName="producto_b"> --%>
<form:form method="POST" modelAttribute="producto_b" id="producto_b" type="producto_b" action="modificarProductoB" enctype="multipart/form-data">
<%--  <form:form action="/productos/modificarProductoB" method="POST"> --%> 
	<fieldset>
	
	  <table cellspacing="0">
	  
	  	     <tr>
			
	     	<!-- <th><label for="idproductob">idproductob</label></th> -->
			<td><form:hidden path="idproductob" maxlength="15"  id="idproductob" value= "${producto_b.idproductob}"/>
				<form:errors path="idproductob" cssClass="error" />
				
			</td>
		</tr>
	  
	  
	     <tr>
			
	     	<th><label for="nombre_productoB">Codigo producto:</label></th>
			<td><form:input path="nombre_productoB" maxlength="15"  id="nombre_productoB" value= "${producto_b.nombre_productoB}"/>
				<form:errors path="nombre_productoB" cssClass="error" />
				
			</td>
		</tr>
		
		
		<tr>
				<th><label for="longitud_b">Longitud :</label></th>
				<td><form:input path="longitud_b" maxlength="15" id="longitud_b" value= "${producto_b.longitud_b}" />
					<form:errors path="longitud_b" cssClass="error" />
				</td>
		</tr>
		
		<tr>
				<th><label for="diametro_b">Diametro :</label></th>
				<td><form:input path="diametro_b" maxlength="15" id="diametro_b" value= "${producto_b.diametro_b}"/>
					<form:errors path="diametro_b" cssClass="error" />
				</td>
		</tr>
		<tr>
				<th><label for="cantidad_existencias">Cantidad de existencias :</label></th>
				<td><form:input path="cantidad_existencias" maxlength="15" id="cantidad_existencias" value= "${producto_b.cantidad_existencias}"/>
					<form:errors path="cantidad_existencias" cssClass="error" />
				</td>
		</tr>
		<tr>
				<th><label for="precio_b">Precio :</label></th>
				<td><form:input path="precio_b" maxlength="15" id="precio_b" value= "${producto_b.precio_b}"/>
					<form:errors path="precio_b" cssClass="error" />
				</td>
		</tr>
		<tr>      
		      <th><label for="precio_b">imagen producto :</label></th>
		      <td><c:set var="variable" value="${pageContext.request.contextPath}/imagen/${producto_b.idproductob}.jpg" />              
              <img  src="${variable}"width="100" height="100" />
              
       		</td>
		</tr>       
		<tr>
				<th><label for="image">Cambiar Imagen :</label></th>
				<td><input name="image" type="file"/>
					
				</td>
		</tr>
				
				
				
	<%-- 		<td><form:label path="nombre_productoB">nombr e_productoB</form:label></td>
			<td><form:input path="nombre_productoB"></form:input></td> --%>
			<%-- <form:input path="nombre_productoB"/> --%>
			<%-- <td><form:input path="nombre_productoB"></form:input></td>   --%> 
			<%-- <form:input path="nombre_productoB" id="nombre_productoB"/> --%>
			<%--<td><form:input path="nombre_productoB" size="33"/></td> --%>
		</tr>
	     <tr>
    	  
    	     <td><input name="producto_b" type="submit" value="modificar producto." /></td>
    	     
  	   </tr>
	
	</table>	

	</fieldset>
</form:form>
</c:if>
</body>
</html>