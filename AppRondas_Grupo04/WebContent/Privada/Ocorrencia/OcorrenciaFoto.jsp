<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ocorrências | AppMonitoramento</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<form action="OcorrenciaServlet" method="post" enctype="multipart/form-data">
		<fieldset>
			<label><h3 class="titulo">INSIRA A FOTO DA
					OCORRÊNCIA:</h3></label>

			<div class="row">
				<div class="col">
					<label hidden>ID:</label> <input type="hidden" class="form-control" id="id" name="id"
					value="${o.id}" placeholder="Id" readonly="readonly">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Insira a foto:</label> 
					<input type="file" id="foto" name="foto"/><br>
					<div id="areaImagem">
						<img name="imagem" id="imagem" width="200" height="200"
							src="data:image/jpg;base64,${o.fotoBase64}" />
					</div>
				</div>
			</div>
			<br> <br> <br>
			<button type="submit" name="gravarFoto" class="botao">
				<i class="fas fa-check"></i> Gravar
			</button>
			<button type="submit" name="cancelar" class="botao">
				<i class="fas fa-times"></i> Cancelar
			</button>	
		</fieldset>
	</form>

</body>
</html>