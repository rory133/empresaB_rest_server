<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<%-- <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/master.css" /> --%>
<!-- <link type="text/css" rel="stylesheet"  href="../resources/css/master.css" /> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTA DE PEDIDOS</title>

<style type="text/css">
h1 {color:#3B0B0B;}
p {color:blue;}
h4 {color:#B40431;}
</style>

<script language="javascript">
function abrirVentana(URL) {
	
window.open(URL,"miventana","width=900,height=400,menubar=no");
}
</script>




</head>



<!-- <style type="text/css">body{background-color:red;}</style> -->
<h3> BIENVENIDO A LA PAGINA DE EMPRESAB <c:out value="${pageContext.request.userPrincipal.name}"/></h3>
<h4> ${errorCarroVacio}	</h4>

<h1> Lista de carros pedidos </h1>


<c:if  test="${!empty TodosLosPedidos}">

<sec:authorize access="hasRole('ROLE_ADMIN')">
<table class="table">
<tr>
  <thead>
  <th>FECHA PEDIDO</th>
  <th>IDCARRO</th>
	<th>IDCLIENTE</th>
	<th>USUARIO</th>
    <th>PAGADO</th>
    <th>ENVIADO</th>
     <thead>
</tr>
  
  <c:forEach items="${TodosLosPedidos}" var="carro">

  <tr>
  
        <td>  
     	 ${carro.fechaPedido} 
   		</td>
   		
   		<td>  
     	 ${carro.idCarro} 
   		</td>
   		
          <td>  
     	 ${carro.idCliente} 
   		</td>
   
        <td>  
      ${carro.loginCliente} 
      
      	</td>
      	
   
       <td>  
   		          <c:set var="carroPagado" value="${carro.pagado}"/>
	        <c:if  test="${carroPagado==true}">
	        <c:url var="editUrl" value="/carro/cambioEstadoCarroPagado" />
			<a href="${editUrl}?idCarro=${carro.idCarro} "    onclick="return confirm('¿Quieres cabiar el estado del Carro a No Pagago?')" onmouseover="window.status = 'Pulse para cambiar estado a No Pagado'; return true" onmouseout="window.status=''"> <span title='Pulse para Cambiar estado a No Pagado'> <img border=0 src="../resources/imagenes/verdadero.jpg" height=34 width=25> </a>
	        
	        </c:if>
	        
	       <c:set var="carroPagado" value="${carro.pagado}"/>
	        <c:if  test="${carroPagado==false}">
	        <c:url var="editUrl" value="/carro/cambioEstadoCarroPagado" />
			<a href="${editUrl}?idCarro=${carro.idCarro} "    onclick="return confirm('¿Quieres cabiar el estado del Carro a Pagado?')" onmouseover="window.status = 'Pulse para cambiar estado a Pagado'; return true" onmouseout="window.status=''"> <span title='Pulse para Cambiar estado a Pagado'> <img border=0 src="../resources/imagenes/false.jpg" height=34 width=25> </a>
	        
	        </c:if>
   		</td>
   		
   		
   		<td>  
          <c:set var="carroEnviado" value="${carro.enviado}"/>
	        <c:if  test="${carroEnviado==true}">
	        <c:url var="editUrl" value="/carro/cambioEstadoCarroEnviado" />
			<a href="${editUrl}?idCarro=${carro.idCarro} "    onclick="return confirm('¿Quieres cabiar el estado del Carro a No enviado?')" onmouseover="window.status = 'Pulse para cambiar estado a No enviado'; return true" onmouseout="window.status=''"> <span title='Pulse para Cambiar estado a No enviado'> <img border=0 src="../resources/imagenes/verdadero.jpg" height=34 width=25> </a>
	        
	        </c:if>
	        
	       <c:set var="carroEnviado" value="${carro.enviado}"/>
	        <c:if  test="${carroEnviado==false}">
	        <c:url var="editUrl" value="/carro/cambioEstadoCarroEnviado" />
			<a href="${editUrl}?idCarro=${carro.idCarro} "    onclick="return confirm('¿Quieres cabiar el estado del Carro a Enviado?')" onmouseover="window.status = 'Pulse para cambiar estado a Enviado'; return true" onmouseout="window.status=''"> <span title='Pulse para Cambiar estado a Enviado'> <img border=0 src="../resources/imagenes/false.jpg" height=34 width=25> </a>
	        
	        </c:if>
	       
   		</td>

     	<td>  
     			 <input  type="submit" name="verDetalles" value="verDetalles" onClick="javascript:abrirVentana('verDetallesCarro?idCarro=${carro.idCarro}')" >
   		</td>
     
     
       </c:forEach>
</table>
      </sec:authorize> 
      
      
  <sec:authorize access="hasRole('ROLE_CLIENTE')">
    <table class="table">
<tr>
  <thead>
  <th>FECHA PEDIDO</th>
  <th>IDCARRO</th>
    <th>PAGADO</th>
    <th>ENVIADO</th>
     <thead>
</tr>
    <c:forEach items="${TodosLosPedidos}" var="carro">
    
    
   <c:set var="loginCliente" value="${carro.loginCliente}"/>  
   <c:set var="clienteSesion" value="${pageContext.request.userPrincipal.name}"/>

   
    <c:if  test="${loginCliente==clienteSesion}">
 <%--   <c:if  test="${true}"> --%>
	 <tr>
  
        <td>  
     	 ${carro.fechaPedido} 
   		</td>
   		
   		<td>  
     	 ${carro.idCarro} 
   		</td>
    
     	
   
       <td>  ${carro.pagado}
   		       
   		</td>
   		
   		
   		<td>  
   		
   		${carro.enviado}
      
   		</td>

     	<td>  
     			 <input  type="submit" name="verDetalles" value="verDetalles" onClick="javascript:abrirVentana('verDetallesCarro?idCarro=${carro.idCarro}')" >
   		</td>
     </tr>
      </c:if>
    </c:forEach>
    
 </sec:authorize> 
 		 	
		</table>

</c:if>
<c:if  test="${empty TodosLosPedidos}">
		<h4>no hay pedidos a mostrar</h4>	
</c:if>
<c:url var="editUrl" value="../productos/listado" />
			<a href="${editUrl}"    onmouseover="window.status = 'Pulse para volver al listado de productos'; return true" onmouseout="window.status=''"> <span title='Pulse para volver al listado de productos'> <img border=0 src="../resources/imagenes/listado.jpg" height=68 width=53> </a>
</body>
</html>