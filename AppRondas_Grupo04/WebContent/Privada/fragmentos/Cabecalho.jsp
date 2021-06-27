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
<!-- jQuery (necess�rio para os plugins Javascript do Bootstrap) -->
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
<!-- Estilos personalizados da p�gina -->
<link href="../../resources/estilos.css" rel="stylesheet">


</head>
<body class="titulo">
	<nav class="main-nav" role="navigation">
		<!-- Sample menu definition -->
		<ul id="main-menu" class="sm sm-clean botao">
			<li><a href="../Home/Home.jsp">Home</a></li>
			<li><a href="#">Cadastros</a>
				<ul>
					<li><a href="../Usuario/UsuarioServlet">Usu�rio</a>
					<li><a href="../Pessoa/PessoaServlet">Pessoa</a>
					<li><a href="../Locomocao/LocomocaoServlet">Locomo��o</a>
					<li><a href="../Localizacao/LocalizacaoServlet">Localiza��o</a>
					<li><a href="../Ocorrencia/OcorrenciaServlet">Ocorr�ncia</a>
					<li><a href="../Ronda/RondaServlet">Ronda</a>
					<li><a href="#">Mais Cadastros </a>
						<ul>
							<li><a href="#">Em Breve</a></li>
							<li><a href="#">Em Breve</a></li>
							<li><a href="#">Em breve</a></li>
						</ul></li>
				</ul></li>

			<li><a href="#">Relat�rios</a>
				<ul>
					<li><a href="../Relatorios/RelUsuarioServlet" target="_blank">Usu�rios</a>
					<li><a href="../Relatorios/RelPessoaServlet" target="_blank">Pessoas</a>
					<li><a href="../Relatorios/RelLocomocaoServlet" target="_blank">Locomo��es</a>
					<li><a href="../Relatorios/RelLocalizacaoServlet" target="_blank">Localiza��es</a>
					<li><a href="../Relatorios/RelOcorrenciaServlet" target="_blank">Ocorr�ncias</a>
					<li><a href="../Relatorios/RelRondaServlet" target="_blank">Rondas</a>
				</ul>
			</li>


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