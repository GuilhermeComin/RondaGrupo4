<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locomoções</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<form action="LocomocaoServlet" method="post">
		<fieldset>

			<label><h3 class="titulo">INSIRA AS INFORMAÇÕES DE
					LOCOMOÇÃO:</h3></label><br>

			<div class="row">
				<div class="col">
					<label hidden>ID:</label> <input type="hidden" readonly="readonly"
						name="id" id="id" class="form-control" value="${o.id}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Descrição:</label> <input type="text" name="descricao" id="descricao"
						class="form-control" value="${o.descricao}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Placa:</label> <input type="text" name="placa" id="placa"
						class="form-control" value="${o.placa}">
				</div>
			</div>
			<br> <br> <br>
			<button type="submit" name="gravar" class="botao">
				<i class="fas fa-check"></i> Gravar
			</button>
			<button type="submit" name="cancelar" class="botao">
				<i class="fas fa-times"></i> Cancelar
			</button>
		</fieldset>
	</form>
</body>
</html>