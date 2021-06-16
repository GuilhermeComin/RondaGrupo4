<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rondas</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	 
	<h3>LISTAGEM DE VIGILANTES DA RONDA</h3>

<form action="RondaServlet">
	
	<input type="hidden" name="idRonda" value="${r.id}">
	<div class="col-md-7 my-3">
		<label for="vigilante">Vigilantes:</label>
		<select name="vigilante" id="vigilante">
			<c:forEach items="${pessoas}" var="p" varStatus="index">
				<option value="${p.id}">${p.id} - ${p.nome}</option>
			</c:forEach>
		</select>
	</div>
	<button class="botao" type="submit" name="incluirVigilante"><i class="fas fa-plus"></i> Incluir Vigilantes</button>
	<button class="botao" type="submit">Voltar</button><br><br>
	
	<table border="1" class="table table-hover table-light">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Ações</th>
			</tr>
		</thead>
		<c:forEach items="${r.vigilantes}" var="v" varStatus="index">
			<tr>
				<td>${v.id}</td>
				<td>${v.nome}</td>
				<td><button name="excluirVigilante" value="${v.id}">Excluir</button></td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>