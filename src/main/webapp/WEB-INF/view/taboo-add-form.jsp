<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Taboo card</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Play Taboo</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Taboo card</h3>
	
		<form:form action="saveTabooCard" modelAttribute="tabooCard" method="POST">

			<!-- need to associate this data with taboo card id -->
			<form:hidden path="id" />
			<form:hidden path="username"/>
					
			<table>
				<tbody>
					<tr>
						<td><label>Keyword:</label></td>
						<td><form:input path="keyword" /></td>
					</tr>
				
					<tr>
						<td><label>Taboo word 1:</label></td>
						<td><form:input path="tabooWord1" /></td>
					</tr>
					
					<tr>
						<td><label>Taboo word 2:</label></td>
						<td><form:input path="tabooWord2" /></td>
					</tr>
					
					<tr>
						<td><label>Taboo word 3:</label></td>
						<td><form:input path="tabooWord3" /></td>
					</tr>
					
					<tr>
						<td><label>Taboo word 4:</label></td>
						<td><form:input path="tabooWord4" /></td>
					</tr>
					
					<tr>
						<td><label>Taboo word 5:</label></td>
						<td><form:input path="tabooWord5" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/taboocards/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










