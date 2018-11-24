<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO ADICIONAR RACA</h1>
	<form action="AdicionarRacaServlet" method="post">
		Nome:<br> <input type="text" name="nome"><br>
		Forca:<br> <input type="number" name="forca"><br>
		Destreza:<br> <input type="number" name="destreza"><br>
		Constituicao:<br> <input type="number" name="contituicao"><br>
		Inteligencia:<br> <input type="number" name="inteligencia"><br>
		Percepcao:<br> <input type="number" name="percepicao"><br>
		Carisma:<br> <input type="number" name="carisma"><br>
		
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>