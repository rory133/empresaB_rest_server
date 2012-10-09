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
<title>LISTA DE PRODUCTOS</title>

<style type="text/css">
h1 {color:#3B0B0B;}
p {color:blue;}
h4 {color:#B40431;}
</style>

<!-- <script language="javascript">
function comprobarCampos(fila) 
{


var e=document.forms[fila].elements['cantidad'];
e.focus();
var texto=e.value;
var numero=parseInt(texto);
if (numero==''){
	document.forms[fila].elements[0].value='';
	document.forms[fila].elements[1].select();
	alert("la cantidad no puede estar vacia");
	}
else if (isNaN(numero)){
		document.forms[fila].elements[0].value='';
		document.forms[fila].elements[1].select();
		alert("la cantidad tiene que ser un numero");
		}
else{
	document.forms[fila].elements[0].value=numero;
}
}


</script>
 -->
<script language="javascript">
function comprobarCampos(fila) 
{


var e=document.forms[fila].elements['cantidad'];
e.focus();
var texto=e.value;
var numero=parseInt(texto);
if (texto==''){
	document.forms[fila].elements[0].value='';
	document.forms[fila].elements[0].select();
	alert("la cantidad no puede estar vacia");
	}
else if (isNaN(numero)){
		document.forms[fila].elements[0].value='';
		document.forms[fila].elements[0].select();
		alert("la cantidad tiene que ser un numero");
		}
else if (numero<0){
	document.forms[fila].elements[0].value='';
	document.forms[fila].elements[0].select();
	alert("la cantidad tiene que ser un numero positivo");
	}
else{
	document.forms[fila].elements['cantidad'].value=numero;
	document.forms[fila].elements['pedido'].value=numero;


}

}

</script>





<!-- <script language="javascript">
function comprobarCampos()
{
form1.campo1.value="hola";
form1.campo2.select();
alert("este campo no está vacío");
}
</script> -->



</head>
<body class="body">
<h2><c:out value="${bienvenida1}" /></h2>
<h2><c:out value="${bienvenida2}" /></h2>
<h2><c:out value="${bienvenida3}" /></h2>


<!-- <style type="text/css">body{background-color:red;}</style> -->
<h3> BIENVENIDO A LA PAGINA DE EMPRESAB <c:out value="${pageContext.request.userPrincipal.name}"/></h3>
<h4> ${errorCarroVacio}	</h4>

<h1> Lista de productos</h1>

<%-- <c:out value="${pageContext.request.contextPath}"/> --%>

<%-- <c:if  test="${empty pageContext.request.userPrincipal.name}">
	<c:redirect url="login" />
</c:if> --%>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td>
        	<c:url var="editUrl" value="/productos/admin/?new" />
			<a href="${editUrl}"   onclick="return confirm('¿Quieres añdir un nuevo producto?')" onmouseover="window.status = 'Pulse para añadir un producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Añadir un Producto'> <img border=0 src="../resources/imagenes/nuevo.jpg" height=68 width=53> </a>
			
		</td>
		</sec:authorize>

<c:if  test="${!empty productos}">


<c:set var="fila" value="${0}" scope="page" />


<table class="table">
<tr>
	<th>IMAGEN</th>
    <th>CODIGO</th>
    <th>Diametro</th>
    <th>longitud</th>
    <th>precio</th>
    <th>Existencias</th>
  
</tr>

<c:forEach items="${productos}" var="producto">
    <tr>
<%--     
    	<td>
                ${producto.idproductob}
        </td> --%>
    
        <td>  
              

             
             


              <c:set var="variable" value="${pageContext.request.contextPath}/imagen/${producto.idproductob}.jpg" />              
              <img  src="${variable}"width="100" height="100" /> 
              

              




        </td>

        <td>
                ${producto.nombre_productoB}
        </td>
        <td>
                ${producto.diametro_b}
        </td>
        <td>
                ${producto.longitud_b}
        </td>
        <td>
                ${producto.precio_b}
        </td>
        <td>
                ${producto.cantidad_existencias}
                
                
        </td>
        
        <sec:authorize access="hasRole('ROLE_CLIENTE')">
        <td> 
			<form id="form1" name="form1" method="GET" action="${pageContext.request.contextPath}/carro/sumaProducto/" >
			<label >Cantidad deseada:</label>
			<input name="cantidad" type="text" id="cantidad" onChange="comprobarCampos(${fila})"  />

			<c:if  test="${!empty productosSeleccionados}">
					<c:forEach items="${productosSeleccionados}" var="productoSelec">
					<c:set var="esteProducto" value="${producto.idproductob}"/>
					<c:set var="productoPasado" value="${productoSelec.idproducto_b}"/>
					  <c:if  test="${esteProducto==productoPasado}">
			
							<h4>Seleccionadas ${productoSelec.cantidad} unidades </h4>

					   </c:if>	
					</c:forEach>
			</c:if>
		
		
			 
			<input type= "hidden" name="idProducto" id="idProducto" value= "${producto.idproductob}"/>
				
			<input  type="submit" value="Sumar a Carro" onFocus="comprobarCampos(${fila})" />
			<c:set var="esteProducto" value="${producto.idproductob}"/>
			<c:set var="productoPedido" value="${productoPedido}"/>
			 <c:if  test="${esteProducto==productoPedido}">
	        	<h4> ${errordeCantidad}	</h4>
			</c:if>	
			</form>	
		</td>
       </sec:authorize> 
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td>
        	<c:url var="editUrl" value="/productos/admin/edit" />
			<a href="${editUrl}?id=${producto.idproductob}"   onclick="return confirm('¿Quieres cambiar datos de este producto?')" onmouseover="window.status = 'Pulse para Editar Producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Editar Producto'> <img border=0 src="../resources/imagenes/modificar.jpg" height=68 width=53> </a>
			
		</td>
		
		<td>

        	<c:url var="editUrl" value="/productos/admin/borrar" />
			<a href="${editUrl}?id=${producto.idproductob}"    onclick="return confirm('¿Quieres borrar este producto?')" onmouseover="window.status = 'Pulse para Borrar Producto'; return true" onmouseout="window.status=''"> <span title='Pulse para Borrar Producto'> <img border=0 src="../resources/imagenes/borrar.jpg" height=68 width=53> </a>
			
		</td>
		</sec:authorize>
		
		


	<c:set var="fila" value="${fila+1}" scope="page" />
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>