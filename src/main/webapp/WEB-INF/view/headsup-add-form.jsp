<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <!-- Bootstrap -->
    <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<title>Dodaj kartę</title>

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome">Strona główna</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/howToPlay">Jak grać?</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/taboocards/list">Przeglądaj karty Taboo</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/headsupcards/list">Przeglądaj karty Head's Up</a>
      </li>
    </ul>
	<security:authorize access="hasAnyRole('USER', 'ADMIN')">
		<form:form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/logout" method="POST">
		<input class="btn btn-secondary my-2 my-sm-0" type="submit" value="Wyloguj"/>
		</form:form>
	</security:authorize>
	<security:authorize access="isAnonymous()">
		<form:form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/showLoginPage" method="GET">
		<input class="btn btn-secondary my-2 my-sm-0" type="submit" value="Zaloguj"/>
		</form:form>
	</security:authorize>
  </div>
</nav>
	<br>
	<br>
	<div class="container">
		<form:form action="saveHeadsUpCard" modelAttribute="headsUpCard" method="POST">

			<!-- need to associate this data with taboo card id -->
			<form:hidden path="id" />
			<form:hidden path="username"/>
					
			<table class="table table-hover">
				<tbody>
					<tr>
						<td><label>Autor:</label></td>
						<td><form:input class="form-control" path="author" /></td>
					</tr>
				
					<tr>
						<td><label>Tytuł utworu:</label></td>
						<td><form:input class="form-control" path="title" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input class="btn btn-primary" type="submit" value="Zapisz" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<p>
			<a href="${pageContext.request.contextPath}/headsupcards/list">Wróć do listy</a>
		</p>
	</div>
</body>

</html>










