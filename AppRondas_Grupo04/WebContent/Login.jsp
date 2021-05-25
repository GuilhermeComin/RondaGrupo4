<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- FontAwesome -->
<link href="resources/fontawesome/css/all.css" rel="stylesheet">
<!-- Estilos personalizados da página -->
<link href="resources/estilos.css" rel="stylesheet">
</head>
<body>
	<form action="LoginServlet" method="post">
		<div class="panel panel-default"
			style="width: 300px; margin: auto; margin-top: 30vh;">
			<div class="panel-heading">
				<!-- cabeçalho do painel -->
				<i class="fas fa-user-lock"></i>
			</div>
			<div class="panel-body">
				<!-- corpo do painel -->
				<label>Email:</label> <input type="email" name="email" id="email"
					class="form-control" placeholder="Endereço de Email..."><br>
				<label>Senha:</label> <input type="password" name="senha" id="senha"
					class="form-control" placeholder="Senha...">

			</div>
			<div class="panel-footer">
				<!-- rodapé do painel -->
				<button type="submit" class="botao" style="width:30%">
					<i class="fas fa-unlock-alt"></i> Login </button>
			</div>
		</div>
	</form>
	<p style="text-align:center">${requestScope.mensagemLogin}</p>
</body>
</html>