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
    <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<title>Przeglądaj swoje karty Head's Up!</title>

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
			
				<input type="button" value="Dodaj kartę"
					   onclick="window.location.href='showAddForm'; return false;"
					   class="btn btn-primary"
				/>

		<br>
		<br>

		<table class="table table-hover">
		<thead>
				<tr class="table-light">
					<th scope="col">Autor</th>
					<th scope="col">Tytuł</th>
					<th scope="col">Akcja</th>
				</tr>
		</thead>		
				<c:forEach var="tempHeadsUpCard" items="${headsUpCards}">
				
					<c:url var="updateLink" value="/headsupcards/showUpdateForm">
						<c:param name="headsUpCardId" value="${tempHeadsUpCard.id}" />
					</c:url>					

					<c:url var="deleteLink" value="/headsupcards/delete">
						<c:param name="headsUpCardId" value="${tempHeadsUpCard.id}" />
					</c:url>					
					
					<tr class="table-light">
						<td> ${tempHeadsUpCard.author} </td>
						<td> ${tempHeadsUpCard.title} </td>
						<td>
							<a class="btn btn-info" href="${updateLink}">Edytuj</a>

							<a class="btn btn-danger" href="${deleteLink}" 
							   onclick="if (!(confirm('Czy na pewno chcesz usunąć tę kartę?'))) return false">Usuń</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>


	
<div class="footer navbar-fixed-bottom">
<div class="container">
	<footer id="footer">
        <div class="row">
          <div class="col-lg-12">

            <ul class="list-unstyled">
              <li class="float-lg-right"><a href="#top">Do góry</a></li>
            </ul>
            <p>© 2018 Copyright Dawid Głowienkowski</p>
          </div>
        </div>

      </footer>
</div>
</div>
</body>

</html>









