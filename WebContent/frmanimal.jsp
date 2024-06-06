<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestão Fazenda - Registrar Animal</title>
</head>
<body>
	<form action="/gestaofaz/ServletAnimalAdicionar" method="get">
	Nome: <input type="text" name="nome"> <br>
	Peso: <input type="text" name="peso"> <br>
	
	Raça: <select name="idraca">
		<c:forEach var="raca" items="${racas}">
			<option value ="${raca.id}"> ${raca.nome} </option>			
		</c:forEach>
	</select><br>
	
	Lote: <select name="idlote">
		<c:forEach var="lote" items="${lotes}">
			<option value ="${lote.id}"> ${lote.nome} - ${lote.area} (m²) </option>			
		</c:forEach>
	</select><br>
	<input type="submit"> 
</form>
</body>
</html>