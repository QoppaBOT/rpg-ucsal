<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de raca</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/css/app.css" rel="stylesheet">
	</head>
	<body>
<div>
<c:import url="topo.jsp"></c:import>
</div>
		<h3>lista de raca</h3>
		<ul>
			<c:forEach var="raca" items="${raca}"> 
				Nome:<li>${raca.nome}</li>	<br>
				Forca:<li>${raca.forca}</li>		<br>
				Destreza:<li>${raca.destreza}</li>			<br>	
				Constituicao:<li>${raca.contituicao}</li>	<br>			
				Inteligencia:<li>${raca.inteligencia}</li>		<br>		
				Percep��o:<li>${raca.percepicao}</li>		<br>		
				Carisma: <li>${raca.carisma}</li>			<br>
					
				<a href="AlterarRacaServlet?id=${raca.id}" type="submit">Editar</a>
				<a href="DeletarRacaServlet?id=${raca.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
			<div>
		<c:import url="rodape.jsp"></c:import>

	</div>
			<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>