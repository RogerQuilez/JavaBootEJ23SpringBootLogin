<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Inter', sans-serif;
	color: #343a40;
	line-height: 1;
	display: flex;
	justify-content: center;
}

table {
	width: 800px;
	border-right-color: #ffffff;
	margin-top: 100px;
	font-size: 18px;
	/* /* border: 1px solid #343a40; */
	border-collapse: collapse;
}

th, td {
	/* border: 1px solid #343a40; */
	padding: 16px 24px;
	text-align: left;
}

th {
	background-color: #087f5b;
	color: #fff;
	width: 25%;
}

tbody tr:nth-child(odd) {
	background-color: #f8f9fa;
}

a {
	text-decoration: none;
}

tbody tr:nth-child(even) {
	background-color: #e9ecef;
}

button {
	display: block;
	height: 50px;
	width: 100px;
	background-color: #5F4785;
	color: #FFFFFF;
	font-family: Open Sans;
	font-weight: 200;
	font-size: 15px;
	text-transform: uppercase;
	border-radius: 3px 3px;
}

.eliminar {
	background-color: #D61818;
}

.modificar {
	background-color: #087f5b;
}

.float {
	position: fixed;
	width: 60px;
	height: 60px;
	bottom: 40px;
	right: 40px;
	background-color: #0C9;
	color: #FFF;
	border-radius: 50px;
	text-align: center;
	box-shadow: 2px 2px 3px #999;
}

.my-float {
	margin-top: 8px;
	font-size: 40px;
}

.price {
	text-align: center;
}
</style>

</head>
<body>


	<table>
	
		
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Compañia</th>
				<th>Nota Media</th>
				<th>Precio</th>
				<th></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${listaCompra}" var="videojuego">
				<tr>
					<td><c:out value="${videojuego.id}"></c:out></td>
					<td><c:out value="${videojuego.nombre}"></c:out></td>
					<td><c:out value="${videojuego.compania}"></c:out></td>
					<td><c:out value="${videojuego.nota}"></c:out></td>
					<td><fmt:formatNumber value="${videojuego.price}" type="currency"
														currencySymbol="euro" pattern="#,###,##0.00 "/></td>
					<td><a
						href="<c:url value="addVideojuego">
                				<c:param name="id" value="${videojuego.id}"/>
         				</c:url>"><span
							class="glyphicon glyphicon-plus-sign"></span> </a> <a
						href="<c:url value="removeVideojuego">
                				<c:param name="id" value="${videojuego.id}"/>
         				</c:url>"><span
							class="glyphicon glyphicon-minus-sign"></span> </a></td>
					
				</tr>
			</c:forEach>
				<tr>
					<td colspan="2">Total Price:</td>
					<td class="price" colspan="3">${total}</td>
					<td><a href="carritoCompra/comprar"><button>Comprar!</button></a></td>
				</tr>
		</tbody>
	</table>
</body>
</html>