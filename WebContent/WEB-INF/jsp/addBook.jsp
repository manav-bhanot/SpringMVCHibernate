<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a New Book</title>
</head>

<body>

	<h2>Add a New Book in the library</h2>

	<form:form method="POST" modelAttribute="book" action="saveBook">
	
		<form:input type="hidden" path="id" id="id" />

		<table>
			<tr>
				<td><label for="title"> Title:</label></td>
				<td><form:input path="title" id="title" /></td>
			</tr>
			<tr>
				<td><label for="author"> Author:</label></td>
				<td><form:input path="author" id="author" /></td>
			</tr>
			<tr>
				<td><label for="publishingYear"> Published Year:</label></td>
				<td><form:input path="publishingYear" id="publishingYear" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" name="action" value="Update">
						</c:when>
						<c:otherwise>
							<input type="submit" name="action" value="Add">
						</c:otherwise>
					</c:choose></td>
			</tr>

		</table>

	</form:form>
	
	<br />
	<br />
	
	<a href="viewBooks"> Display All Books </a>
	
</body>
</html>