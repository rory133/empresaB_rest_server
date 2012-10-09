<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Clientes</title>
</head>
<body>
<c:if  test="${!empty clientes}">

<table class="table">
<tr>
	<th>NOMBRE</th>
    <th>APELLIDOS</th>
    <th>DNI/NIF</th>
    <th>E-MAIL</th>
    <th>LOGIN</th>
    <th>FECHA ALTA</th>
    <th>DIRECCION</th>
    <th>PROVINCIA</th>
    <th>CODIGO POSTAL</th>
  
</tr>

<c:forEach items="${clientes}" var="cliente">
    <tr>
        <td>
                ${cliente.nombre_b}
        </td>
        <td>
                ${cliente.apellidos_b}
        </td>
        <td>
                ${cliente.dni_nif_b}
        </td>
        <td>
                ${cliente.email_b}
        </td>
        <td>
                ${cliente.login_usuario_b}
        </td>
        <td>
                ${cliente.fecha_alta_b}
        </td>
        <td>
                ${cliente.direccion_b}
        </td>
        <td>
                ${cliente.provincia_b}
        </td>
        <td>
                ${cliente.codigopostal_b}
        </td>
        <td>
        	<c:url var="editUrl" value="/clientes/cliente/edit" />
			<a href="${editUrl}?id=${cliente.idusuarios_b}"   onclick="return confirm('¿Quieres cambiar datos de este cliente?')" onmouseover="window.status = 'Pulse para Editar cliente'; return true" onmouseout="window.status=''"><span title='Pulse para Editar datos cliente'> <img border=0 src="../../resources/imagenes/modificar.jpg" height=68 width=53> </a>
			
		</td>
		
		<td>

        	<c:url var="editUrl" value="/clientes/admin/borrar" />
			<a href="${editUrl}?id=${cliente.idusuarios_b}"   onclick="return confirm('¿Quieres borrar este cliente?')"onmouseover="window.status = 'Pulse para eliminara'; return true" onmouseout="window.status=''"><span title='Pulse para Eliminar cliente'> <img border=0 src="../../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
		</td>
	
    </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>