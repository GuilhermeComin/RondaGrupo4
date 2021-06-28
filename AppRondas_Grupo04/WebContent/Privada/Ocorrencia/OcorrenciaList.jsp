<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista de Ocorrências</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<h3 class="titulo">LISTAGEM DE OCORRÊNCIAS</h3>
	<br>

	<form action="OcorrenciaServlet">
		<button name="incluir" class="botao">
			<i class="fas fa-plus"></i> Incluir
		</button>
		<br> <br>
		<table border="1" class="table table-hover table-light">
			<tr>
				<th>Id</th>
				<th>Data e Hora</th>
				<th>Título</th>
				<th>Descrição</th>
				<th>Latitude</th>
				<th>Longitude</th>
				<th>Foto</th>
				<th>Ronda</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
			<c:forEach items="${lista}" var="o" varStatus="index">
				<tr>
					<td>${o.id}</td>
						    <td><fmt:formatDate value="${o.dataHora}" pattern="dd/MM/yyyy HH:mm"/></td>
						    <td>${o.titulo}</td>
						    <td>${o.descricao}</td>
						    <td>${o.lat}</td>
						    <td>${o.lon}</td>
						    <td>
						    <div id="areaImagem">
								<img name="imagem" id="imagem" width="64" height="64"
									src="data:image/jpg;base64,${o.fotoBase64}" />
							</div><button value="${o.id}" name="alterarFoto" id="inserirFoto"> Inserir foto</button></td>
						    <td>${o.ronda.id} - ${o.ronda.locomocao.descricao} - <fmt:formatDate value="${o.ronda.dataHoraInicio}" pattern="dd/MM/yyyy HH:mm"/> </td>
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