<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usu�rios</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<h3 class="titulo">LISTAGEM DE USU�RIOS</h3>
	<br>

	<form action="UsuarioServlet">
		<button name="incluir" class="botao">
			<i class="fas fa-plus"></i> Incluir
		</button>
		<br> <br>
		<table border="1" class="table table-hover table-light">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
			<c:forEach items="${lista}" var="o" varStatus="index">
				<tr>
					<td>${o.id}</td>
					<td>${o.nome}</td>
					<td>${o.email}</td>
					<td>${o.senha}</td>
					<td><button name="alterar" value="${o.id}">
							<i class="fas fa-hammer"></i> Alterar
						</button></td>
					<td><button name="excluir" value="${o.id}">
							<i class="fas fa-trash"></i> Excluir
						</button></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>