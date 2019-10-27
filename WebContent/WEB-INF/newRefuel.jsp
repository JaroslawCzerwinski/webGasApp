<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Auto Gas Calculator - Dodaj nowe tankowanie</title>
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

	<div class="container">
		<h1 class="form-signin-heading">Dodaj nowe tankowanie</h1>
		<form class="form-signin" method="post" action="add">
			<div class="row">

				<div class="col-ms-6 col-md-2">
					<input name="distance" type="number" class="form-control"
						placeholder="Przebieg" required autofocus />
				</div>
				<div class="col-ms-6 col-md-2">
					<input name="date" type="date" class="form-control"
						placeholder="Data" required autofocus />
				</div>
				<div class="col-ms-6 col-md-2">
					<input name="lpgAmount" type="number" class="form-control"
						placeholder="Ile zatankowano LPG" required autofocus />
				</div>
				<div class="col-ms-6 col-md-2">
					<input name="lpgPrice" type="number" class="form-control"
						placeholder="Cena LPG" required autofocus />
				</div>
				<div class="col-ms-6 col-md-2">
					<input name="petrolAmount" type="number" class="form-control"
						placeholder="Ile zatankowano benzyny" required autofocus />
				</div>
				<div class="col-ms-6 col-md-2">
					<input name="petrolPrice" type="number" class="form-control"
						placeholder="Cena benzyny" required autofocus />
				</div>
				<div class="col-ms-6 col-md-2">
				
						 <input name="slider" type="range" min="40" max="120" value="80" id="myRange" class="slider" />
						 <p>Efektywność gazu:<span id="gasEffectivityValue"></span>%</p>	
					</div>

				</div>

				<input class="btn btn-lg btn-primary btn-block" type="submit"
					value="Dodaj!" />
		</form>
	</div>

	  <jsp:include page="fragment/footer.jspf" />
	  
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/slider.js"></script>
</body>
</html>