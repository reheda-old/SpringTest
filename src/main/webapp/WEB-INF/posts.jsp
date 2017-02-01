<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guestbook posts</title>
</head>
<body>

	<table border="1">

		<c:forEach items="${requestScope.posts}" var="post">
			<tr>

				<td>${post.id}</td>
				<td><c:out value="${post.txt }" /></td>
				<td><a href="delete?id=${post.id }"> <img src="delete.png">
				</a></td>
			</tr>


		</c:forEach>
		<form action="./add" method="POST">
		
		<tr>
		<td colspan="2">
			<input type="text" name="txt">
		</td>
		<td>
			<input type="submit">
			
		</td>
		
		</tr>
		</form>

	</table>
</body>
</html>