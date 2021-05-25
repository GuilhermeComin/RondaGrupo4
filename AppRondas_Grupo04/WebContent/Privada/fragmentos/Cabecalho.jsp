<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastros</title>
<!-- Bootstrap -->
<link href="../../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (necessário para os plugins Javascript do Bootstrap) -->
<script src="../../resources/jquery/jquery-3.6.0.min.js"></script>
<!-- Incluir plugins do Bootstrap -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
<!-- FontAwesome -->
<link href="../../resources/fontawesome/css/all.css" rel="stylesheet">
<!-- SmartMenus core CSS (required) -->
<link href="../../resources/smartmenus/css/sm-core-css.css"
	rel="stylesheet" type="text/css" />
<!-- "sm-clean" menu theme (optional, you can use your own CSS, too) -->
<link href="../../resources/smartmenus/css/sm-clean/sm-clean.css"
	rel="stylesheet" type="text/css" />
<!-- Estilos personalizados da página -->
<link href="../../resources/estilos.css" rel="stylesheet">


</head>
<body class="titulo">
	<nav class="main-nav" role="navigation">
		<!-- Sample menu definition -->
		<ul id="main-menu" class="sm sm-clean botao">
			<li><a href="../Home/Home.jsp">Home</a></li>
			<li><a href="#">Cadastros</a>
				<ul>
					<li><a href="../Usuario/UsuarioServlet">Usuários</a>
					<li><a href="../Pessoa/PessoaServlet">Pessoas</a>
					<li><a href="../Locomocao/LocomocaoServlet">Locomoção</a>
					<li><a href="../Localizacao/LocalizacaoServlet">Localização</a>
					<li><a href="#">Mais Cadastros </a>
						<ul>
							<li><a href="#">Em Breve</a></li>
							<li><a href="#">Em Breve</a></li>
							<li><a href="#">Em breve</a></li>
						</ul></li>
				</ul></li>
			<li><a href="../SairServlet">Sair</a>	
		</ul>
	</nav>
	<!-- jQuery -->
	<script type="text/javascript"
		src="../../resources/smartmenus/libs/jquery/jquery.js"></script>
	<!-- SmartMenus jQuery plugin -->
	<script type="text/javascript"
		src="../../resources/smartmenus/jquery.smartmenus.js"></script>
	<!-- SmartMenus jQuery init -->
	<script type="text/javascript">
		$(function() {
			$('#main-menu').smartmenus({
				subMenusSubOffsetX : 1,
				subMenusSubOffsetY : -8
			});
		});
	</script>
	<br>


</body>
</html>