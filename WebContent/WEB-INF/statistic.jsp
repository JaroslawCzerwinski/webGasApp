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
   <jsp:include page="fragment/navbar.jspf" />
   
	<table class="table table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Koszt /100km</th>
				<th scope="col">Zużycie LPG/100km</th>
				<th scope="col">Całkowicie zaoszczędzono</th>
				<th scope="col">Całkowicie wydano</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${not empty requestScope.statistic}">
					<tr>
						<td scope="row"><c:out value="${statistic.cost100Km} " /> zł</td>
						<td scope="row"><c:out value="${statistic.lpg100Km} " /> l</td>
						<td scope="row"><c:out value="${statistic.totalSaiving} " /> zł</td>
						<td scope="row"><c:out value="${statistic.totalCost} " /> zł</td>
					</tr>
			</c:if>
		</tbody>
	</table>

	  <jsp:include page="fragment/footer.jspf" />

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>