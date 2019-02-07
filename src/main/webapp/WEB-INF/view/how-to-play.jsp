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

	<title>Jak grać?</title>
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
  <div class="jumbotron">
  <h1 class="display-3">Jak grać?</h1>
  <hr class="my-4">
  <h3>Taboo / Tabu – zasady gry</h2>
  <p class="lead">Zasady gry są proste. Uczestnicy dzielą się na drużyny (minimum dwuosobowe). Wybrany gracz z drużyny losuje kartę z hasłem i próbuje naprowadzić pozostałych graczy z drużyny na odgadnięcie hasła. W tym czasie drużyna przeciwna pilnuje, czy zawodnik opisujący hasło przestrzega zasad kilku zasad:</p>
  <ul class="lead">
  	<li>Nie wolno używać żadnej części hasła (ani synonimów), które należy odgadnąć.</li>
  	<li>Nie można używać liczby mnogiej ani skrótów dla hasła znajdującego się na karcie.</li>
  	<li>Nie można gestykulować, ale można śpiewać.</li>
  	<li>Najważniejsze: Nie można używać zakazanych słów, które znajdują się na karcie pod hasłem.</li>
  </ul>
  <p class="lead">Te kilka prostych zasad sprawiają, że opisanie hasła z karty staje się bardzo trudne. Taboo (Tabu) to gra, która zmusza do myślenia.</p>
  
  <hr class="my-4">
  
  <h3>Head's Up! / Czółko – zasady gry</h3>
  <p class="lead">By zagrać, przyłóż telefon do czoła, ekranem do reszty zebranych. Publiczność zobaczy na wyświetlaczu hasło, które my będziemy musieli zgadnąć wysłuchując lub obserwując ich wskazówki. Jeśli uda nam się w ustalonym czasie trafić, dotykamy ekranu i zyskujemy punkt. W sytuacji, gdy hasło jest zbyt trudne i któraś ze stron zrezygnuje z gry, wtedy stukamy palcem w ekran dwa razy i przechodzimy do kolejnego tytułu. Po 10 hasłach runda się kończy; podobnie dzieje się, gdy minie czas wyznaczony na odgadnięcie hasła.</p>
  
</div>
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