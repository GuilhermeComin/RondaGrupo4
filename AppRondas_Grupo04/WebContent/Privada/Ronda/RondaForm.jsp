<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rondas | AppMonitoramento</title>
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<form action="RondaServlet" method="post">
		<fieldset>
			<label><h3 class="titulo">INSIRA AS INFORMAÇÕES DE
					RONDAS:</h3></label>

			<div class="row">
				<div class="col">
					<label hidden>ID:</label> <input type="hidden" class="form-control" id="id" name="id"
					value="${o.id}" placeholder="Id" readonly="readonly">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Data|Início:</label> <input type="datetime-local" class="form-control" id="dataHoraInicio"
					name="dataHoraInicio" pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value="${o.dataHoraInicio}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${o.dataHoraInicio}" pattern="HH:mm"/>"
					placeholder="Data e Hora de Início">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Data|Fim:</label> <input type="datetime-local" class="form-control" id="dataHoraFim"
					name="dataHoraFim" pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value="${o.dataHoraFim}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${o.dataHoraFim}" pattern="HH:mm"/>"
					placeholder="Data e Hora de Fim">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Última Latitude:</label> <input type="number" class="form-control" id="latUltima" name="latUltima"
					value="${o.latUltima}" placeholder="Última Latitude">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Última Longitude:</label> <input type="number" class="form-control" id="lonUltima" name="lonUltima"
					value="${o.lonUltima}" placeholder="Última Longitude">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Data e Hora|Última:</label> <input type="datetime-local" class="form-control" id="dataHoraUltima"
					name="dataHoraUltima" pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value="${o.dataHoraUltima}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${o.dataHoraUltima}" pattern="HH:mm"/>"
					placeholder="Data e Hora da Última">
				</div>
			</div>
			<br>
			<div class="row">
				<select required name="locomocao" id="locomocao" class="custom-select">
					<option value="" disabled selected > Selecione o meio de locomoção
					<c:forEach items="${locomocoes}" var="r" varStatus="index">
						<option value="${r.id}">${r.id}- ${r.descricao}
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