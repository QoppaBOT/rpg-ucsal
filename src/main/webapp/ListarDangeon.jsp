<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="ISO-8859-1">
		<title>Listagem de Dangeon</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/css/app.css" rel="stylesheet">
	</head>
	<body>
<div>
<c:import url="topo.jsp"></c:import>
</div>
		<h3>lista de Dangeon</h3>
		<ul>
			<c:forEach var="dangeon" items="${dangeon}"> 
				<li>${dangeon.id}</li>	<br>
				Nome:<li>${dangeon.nome}</li>		<br>
				Descri��o:<li>${dangeon.descricao}</li>		<br>		
			<%--    <a href="AlterarDangeonServlet?id=${dangeon.id}" type="submit">Editar</a> --%>			
					<a href="DeletarDangeonServlet?id=${dangeon.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>

		<div>
		<c:import url="rodape.jsp"></c:import>

	</div>
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="/bootstrap/js/bootstrap.min.js"></script>
</html>