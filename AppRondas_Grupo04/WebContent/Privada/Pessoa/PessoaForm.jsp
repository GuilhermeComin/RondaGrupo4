<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoas</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<form action="PessoaServlet" method="post">

		<fieldset>
			<label><h3 class="titulo">INSIRA AS INFORMAÇÕES DE
					PESSOA:</h3></label><br>

			<div class="row">
				<div class="col-md-1">
					<label hidden for="id">Id:</label> <input type="hidden"
						readonly="readonly" name="id" id="id" value="${o.id}"
						class="form-control">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="nome">Nome:</label> <input type="text" name="nome"
						id="nome" value="${o.nome}" class="form-control"
						placeholder="Nome">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="loginApp">Login App:</label> <input type="text"
						name="loginApp" id="loginApp" value="${o.loginApp}"
						class="form-control" placeholder="login">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="senha">Senha:</label> <input type="password"
						name="senha" id="senha" value="${o.senha}" class="form-control"
						placeholder="senha">
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