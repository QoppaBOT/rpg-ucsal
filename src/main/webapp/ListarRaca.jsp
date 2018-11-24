<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de mestre</title>
	</head>
	<body>
		<h3>lista de mestre</h3>
		<ul>
			<c:forEach var="raca" items="${raca}"> 
				<li>${raca.nome_id}</li>
				<li>${raca.forca}</li>	
				<li>${raca.destreza}</li>			
				<li>${raca.constituicao}</li>			
				<li>${raca.inteligencia}</li>			
				<li>${raca.percepicao}</li>			
				<li>${raca.carisma}</li>			
				<a href="AlterarRacaServlet?id=${mestre.id}" type="submit">Editar</a>
				<a href="DeletarRacaServlet?id=${Raca.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>