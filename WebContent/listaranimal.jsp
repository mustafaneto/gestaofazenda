<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestão Fazenda - Listar Animais</title>
</head>
<body>
<c:forEach var="animal" items="${animais}">
	<p> ${animal.id} - ${animal.nome} - ${animal.peso} - ${animal.raca.nome} - ${animal.lote.nome} <br>
	
<a href="/gestaofaz/ServletAnimalListarUm?id=${animal.id}"> Alterar </a> <br>
<a href="/gestaofaz/ServletAnimalExcluir?id=${animal.id}"> Excluir </a> <br>
</c:forEach>
</body>
</html>