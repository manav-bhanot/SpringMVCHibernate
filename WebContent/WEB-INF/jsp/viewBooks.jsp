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
			<td colspan="2"> <label for="title"> ACTION </label> </td>
		</tr>
		
		<c:forEach items="${ listOfBooks }" var="book"> 
		
			<tr>
				<td> ${book.title} </td>
				<td> ${book.author} </td>
				<td> ${book.publishingYear} </td>
				<td> 
					<form:form id="${ book.id }" action="edit" method="POST">
						<input type="hidden" name="bookId" value="${ book.id }" />
						<input type="submit" value="Edit"/>
					</form:form>					
				 </td>
				 <td>
				 	<form:form id="${ book.id }" action="delete" method="POST">
				 		<input type="hidden" name="bookId" value="${ book.id }" />						
						<input type="submit" value="Delete"/>
					</form:form>
				 </td>
			</tr>
			
		</c:forEach>
		
	</table>
	
	<br />
	<br />
	
	<a href="addBook"> Add a new Book into the library </a>

</body>
</html>