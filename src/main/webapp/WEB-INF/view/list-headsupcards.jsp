<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>

<html>

<head>
	<title>List Heads Up Cards</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Play Head's Up!</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<p>
				User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
			</p>
		

			<security:authorize access="hasAnyRole('USER', 'ADMIN')">
			
				<!-- put new button: Add Heads Up card -->
			
				<input type="button" value="Add Card"
					   onclick="window.location.href='showAddForm'; return false;"
					   class="add-button"
				/>
			
			</security:authorize>
	
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Author</th>
					<th>Title</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print heads up cards -->
				<c:forEach var="tempHeadsUpCard" items="${headsUpCards}">
				
					<!-- construct an "update" link with card id -->
					<c:url var="updateLink" value="/headsupcards/showUpdateForm">
						<c:param name="headsUpCardId" value="${tempHeadsUpCard.id}" />
					</c:url>					

					<!-- construct an "delete" link with card id -->
					<c:url var="deleteLink" value="/headsupcards/delete">
						<c:param name="headsUpCardId" value="${tempHeadsUpCard.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempHeadsUpCard.author} </td>
						<td> ${tempHeadsUpCard.title} </td>
						<td>
							<a href="${updateLink}">Update</a>

							<a href="${deleteLink}" 
							   onclick="if (!(confirm('Are you sure you want to delete this card?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
	<p></p>
		
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" class="add-button" />
	
	</form:form>

</body>

</html>









