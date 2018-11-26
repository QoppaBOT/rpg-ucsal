<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de Personagem</title>
	</head>
	<body>
		<h3>lista de Personagem</h3>
		<ul>
			<c:forEach var="personagem" items="${personagem}"> 
				<li>${personagem.nome}</li>
				<li>${personagem.maiorPersonalidade}</li>		
				<li>${personagem.pontosDeVida}</li>			
				<li>${personagem.pontosDeEnergia}</li>			
				<li>${personagem.level}</li>	
				<li>${personagem.raca}</li>	
				<li>${personagem.sala}</li>	
					
			<%-- 	<a href="AlterarPersonagemServlet?id=${personagem.id}" type="submit">Editar</a> --%>
				<a href="DeletarPersonagemServlet?id=${personagem.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>