<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Locomoções | AppMonitoramento</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<form action="LocalizacaoServlet" method="post">
		<fieldset>
			<label><h3 class="titulo">INSIRA AS INFORMAÇÕES DE
					LOCOMOÇÃO:</h3></label>

			<div class="row">
				<div class="col">
					<label hidden>ID:</label> <input type="hidden" class="form-control" id="id" name="id"
					value="${o.id}" placeholder="Id" readonly="readonly">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Data:</label> <input type="datetime-local" class="form-control" id="dataHora"
					name="dataHora" pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value="${o.dataHora}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${o.dataHora}" pattern="HH:mm"/>"
					placeholder="Data e Hora">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Latitude:</label> <input type="number" class="form-control" id="lat" name="lat"
					value="${o.lat}" placeholder="Latitude">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>Longitude:</label> <input type="number" class="form-control" id="lon" name="lon"
					value="${o.lon}" placeholder="Longitude">
				</div>
			</div>
			<br>
			<div class="row">
				<select name="ronda" id="ronda">
					<c:forEach items="${rondas}" var="r" varStatus="index">
						<option value="${r.id}">${r.id}- ${r.locomocao.descricao}
							-
							<fmt:formatDate value="${r.dataHoraInicio}"
								pattern="dd/MM/yyyy HH:mm" /></option>
					</c:forEach>
				</select>
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