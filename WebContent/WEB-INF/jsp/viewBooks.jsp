<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Books</title>
</head>
<body>

	<h2> List Of All Books</h2>
	
	<table>
		<tr>
			<td> <label for="title"> TITLE </label> </td>
			<td> <label for="title"> AUTHOR </label> </td>
			<td> <label for="title"> PUBLISHING YEAR </label> </td>
		</tr>
		
		<c:forEach items="${ listOfBooks }" var="books"> 
		
			<tr>
				<td> ${books.title} </td>
				<td> ${books.author} </td>
				<td> ${books.publishingYear} </td>
			</tr>
			
		</c:forEach>
		
	</table>
	
	<br />
	<br />
	
	<a href="addBook"> Add a new Book into the library </a>

</body>
</html>