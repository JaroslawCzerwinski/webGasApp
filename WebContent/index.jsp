<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Auto Gas Calculator - home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>

  <body>
    
    <nav class = "navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand">Auto Gaz Kalkulator</a>
        
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
          <span class="glyphicon glyphicon-list"></span>
        </button>
        
        <div class="collapse navbar-collapse navHeaderCollapse">
          <ul class="nav navbar-nav navbar-right">
            <c:choose>
            	<c:when test="${not empty sessionScope.user}">
            		<li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="${pageContext.request.contextPath}/login">Zaloguj się</a></li>
            	</c:otherwise>
            </c:choose>
          </ul>
        </div>
        
      </div>
    </nav>
    
    <c:if test="${not empty requestScope.refuelings}">
	    <c:forEach var="refuel" items="${requestScope.refuelings}">
	    	<div class="container">
		      <div class="row bs-callout bs-callout-primary">
		        <div class="col col-md-11 col-sm-10">
		         
		         <p><c:out value="${refuel.distance}" /></p>
		         <p><c:out value="${refuel.date}" /></p>
		         <p><c:out value="${refuel.lpgAmount}" /></p>
		         <p><c:out value="${refuel.lpgPrice}" /></p>
		         <p><c:out value="${refuel.petrolAmount}" /></p>
		         <p><c:out value="${refuel.petrolPrice}" /></p>
		         <p><c:out value="${refuel.paid}" /></p>
		         <p><c:out value="${refuel.saiving}" /></p>
		         <p><c:out value="${refuel.gasEfficiency}" /></p>
		         
		        </div>
		      </div>
		    </div>
	    </c:forEach>
    </c:if>
    
    <footer class="footer">
      <div class="container">
        <p class="navbar-text">Gaz Kalkulator - developed by <a href="http://linkedin.com/in/jarosław-czerwiński-6170b7121/">Jarosław Czerwiński</a></p>
      </div>
    </footer>
    
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>