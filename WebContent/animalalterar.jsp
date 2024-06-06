<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastrar Animal</title>
</head>
<body>
<h1>Alterar Animal</h1>
<form action="ServletAnimalAlterar" method="get">
  <label for="id">ID</label><br>
  <input type="text" name="id" id="id" value="${animal.id}" readonly><br>
  
  <label for="nome">Nome</label><br>
  <input type="text" name="nome" id="nome" value="${animal.nome}"><br>
  
  <label for="peso">Peso</label><br>
  <input type="number" step="0.01" name="peso" id="peso" value="${animal.peso}"><br>
  
  <label for="raca">Raça</label><br>
  <select name="raca" id="raca">
    <c:forEach var="raca" items="${racas}">
    <option value ="${raca.id}" <c:if test="${animal.raca.id == raca.id}" >selected</c:if>>${raca.nome}</option>
    </c:forEach>
  </select><br>
  <label for="raca">Lote</label><br>
  <select name="lote" id="lote">
    <c:forEach var="lote" items="${lotes}">
    <option value ="${lote.id}" <c:if test="${animal.lote.id == lote.id}" >selected</c:if>>${lote.nome}</option>
    </c:forEach>
  </select><br>
  <br>
  <input type="submit" value="Submit">
</form>
</body>
