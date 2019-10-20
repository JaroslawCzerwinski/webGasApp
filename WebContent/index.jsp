<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Auto Gas Calculator - home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	type="text/css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a href="#" class="navbar-brand">Auto Gaz Kalkulator</a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="glyphicon glyphicon-list"></span>
			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${not empty sessionScope.user}">
							<li><a href="${pageContext.request.contextPath}/logout">Wyloguj
									się</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/login">Zaloguj
									się</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>

		</div>
	</nav>

	<table class="table table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Przebieg</th>
				<th scope="col">Data</th>
				<th scope="col">Zatankowano LPG</th>
				<th scope="col">Cena LPG</th>
				<th scope="col">Zatankowano benzyny</th>
				<th scope="col">Cena benzyny</th>
				<th scope="col">Zapłacono</th>
				<th scope="col">Oszczędność</th>
				<th scope="col">Efektywność gazu</th>
			</tr>
		</thead>

		<tbody>
				<c:if test="${not empty requestScope.refuelings}">
					<c:forEach var="refuel" items="${requestScope.refuelings}">
					<tr>
					<td scope="row"><c:out value="${refuel.distance} " /> km</td>
					<td scope="row"><c:out value="${refuel.date} " /></td>
					<td scope="row"><c:out value="${refuel.lpgAmount} " /> l</td>
					<td scope="row"><c:out value="${refuel.lpgPrice} " /> zł</td>
					<td scope="row"><c:out value="${refuel.petrolAmount} " /> l</td>
					<td scope="row"><c:out value="${refuel.petrolPrice} " /> zł</td>
					<td scope="row"><c:out value="${refuel.paid} " /> zł</td>
					<td scope="row"><c:out value="${refuel.saiving} " /> zł</td>
					<td scope="row"><c:out value="${refuel.gasEfficiency} " /> %</td>
					</tr>
					</c:forEach>
				</c:if>
		</tbody>
	</table>


	<footer class="footer">
		<div class="container">
			<p class="navbar-text">
				Gaz Kalkulator - developed by <a
					href="http://linkedin.com/in/jarosław-czerwiński-6170b7121/">Jarosław
					Czerwiński</a>
			</p>
		</div>
	</footer>

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>