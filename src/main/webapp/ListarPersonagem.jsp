<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de Personagem</title>
	</head>
	<body>W
		<h3>lista de Personagem</h3>
		<ul>
			<c:forEach var="personagem" items="${personagem}"> 
				Nome:<li>${personagem.nome}</li>	<br>
				Personalidade:<li>${personagem.maiorPersonalidade}</li>		<br>	
				Pontos de Vida:<li>${personagem.pontosDeVida}</li>		<br>		
				Pontos de Energia<li>${personagem.pontosDeEnergia}</li>		<br>		
				Level:<li>${personagem.level}</li>		<br>
				Raca:<li>${personagem.raca}</li>	<br>
				Usuario:<li>${personagem.usuario}</li>		<br>
				Sala<li>${personagem.sala}</li>		<br>
					
			<%-- 	<a href="AlterarPersonagemServlet?id=${personagem.id}" type="submit">Editar</a> --%>
				<a href="DeletarPersonagemServlet?id=${personagem.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>