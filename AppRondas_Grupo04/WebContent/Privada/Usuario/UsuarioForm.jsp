<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuários</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<form action="UsuarioServlet" method="post">
		<fieldset>


			<label><h3 class="titulo">INSIRA AS INFORMAÇÕES DE
					USUÁRIO:</h3></label><br>

			<div class="row">
				<div class="col">
					<label hidden>ID:</label> <input type="hidden" readonly="readonly"
						name="id" id="id" class="form-control" value="${o.id}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Nome:</label> <input type="text" name="nome" id="nome"
						class="form-control" value="${o.nome}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Email:</label> <input type="email" name="email" id="email"
						class="form-control" value="${o.email}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Senha:</label> <input type="password" name="senha"
						id="senha" class="form-control" value="${o.senha}">
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
