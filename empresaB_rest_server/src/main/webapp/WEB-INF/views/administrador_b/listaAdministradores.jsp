<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Administradores</title>
</head>
<body>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td>
        	<c:url var="editUrl" value="/administradores/?new" />
			<a href="${editUrl}"   onclick="return confirm('¿Quieres añdir un nuevo producto?')" onmouseover="window.status = 'Pulse para añadir otro administrador'; return true" onmouseout="window.status=''"> <span title='Pulse para Añadir otro administrador'> <img border=0 src="../resources/imagenes/nuevo.jpg" height=68 width=53> </a>
			
		</td>
		</sec:authorize>
<c:if  test="${!empty administradores}">

<table class="table">
<tr>
	<th>NOMBRE</th>
    <th>APELLIDOS</th>
    <th>DNI/NIF</th>
    <th>E-MAIL</th>
    <th>USUARIO</th>
    <th>CARGO</th>
    <th>MATRICULA</th>

  
</tr>

<c:forEach items="${administradores}" var="administrador">
    <tr>
        <td>
                ${administrador.nombre_b}
        </td>
        <td>
                ${administrador.apellidos_b}
        </td>
        <td>
                ${administrador.dni_nif_b}
        </td>
        <td>
                ${administrador.email_b}
        </td>
        <td>
                ${administrador.login_usuario_b}
        </td>
        <td>
                ${administrador.cargo_b}
        </td>
        <td>
                ${administrador.matricula_b}
        </td>

        <td>
        	<c:url var="editUrl" value="/administradores/edit" />
			<a href="${editUrl}?id=${administrador.idusuarios_b}"   onclick="return confirm('¿Quieres cambiar datos de este administrador?')"> <img border=0 src="../resources/imagenes/modificar.jpg" height=68 width=53> </a>
			
		</td>
		
		<td>

        	<c:url var="editUrl" value="/administradores/borrar" />
			<a href="${editUrl}?id=${administrador.idusuarios_b}"   onclick="return confirm('¿Quieres borrar este administrador?')"> <img border=0 src="../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
		</td>
	
    </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>