<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guestbook posts</title>

</head>
<body>
	<h3><a href="./">Main page</a></h3>
	<div>
		<h1>Post list</h1>
	</div>
	<table border="1" style="table-layout: fixed;" width="1000">
		<tr>
			<td align="center">ID</td>
			<td width="800" align="center">Text</td>
			<td align="center">Edit</td>
			<td align="center">Delete</td>
		</tr>
		<c:forEach items="${requestScope.posts}" var="post">
			<tr>

				<td align="center">${post.id}</td>
				<td style="word-wrap: break-word;"><c:out value="${post.txt }" /></td>
				<td align="center"><a
					href="edit?id=${post.id }&txt=${post.txt}"><img src="edit.png"
						title="edit" alt="edit"></a></td>
				<td align="center"><a href="delete?id=${post.id }"> <img
						src="delete.png" alt="delete" title="delete">
				</a></td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${ requestScope.postId != null}">
		<form action="./edit" method="POST">
			<div>
				<h1>Edit post</h1>
			</div>
			<table>
				<tr>
					<td>Id:</td>
					<td colspan="2"><input type="text" name="id"
						disabled="disabled" value="${ requestScope.postId}"> <input
						type="hidden" name="id" value="${ requestScope.postId}"></td>
				</tr>
				<tr>
					<td>Text:</td>
					<td colspan="2"><input type="text" name="txt" maxlength="255" value="${requestScope.postTxt}"></td>

				</tr>
				<tr>
					<c:set value="" var="txtLen"></c:set>
					<td><input type="submit" value="Edit"></td>
				</tr>
			</table>
		</form>
	</c:if>
	<c:if test="${ requestScope.postId == null}">
		<form action="./add" method="POST">
			<div>
				<h1>Add post</h1>
			</div>
			<table>
				<tr>
					<td>Text:</td>
					<td colspan="2"><input type="text" name="txt" maxlength="255"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>