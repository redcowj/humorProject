<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="common.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="600" height="300">
		<tr height="10%">
			<td>제목</td>
			<td>글쓴이</td>
			<td>조회 </td>
			<td>추천 </td>
		</tr>
		<tr height="10%">
			<td width="50%">${board.subject }</td>
			<td>${board.id }</td>
			<td>${board.readcount }</td>
			<td>${board.best}</td>
		</tr>
		<tr align="left" valign="top">
			<td colspan="5">
				<c:forEach var="file" items="${fileList }">
					<img alt="없어요!" src="upload/${file.fileName }" width="550">
				</c:forEach>
				<pre>${board.content }</pre>
			</td>
		</tr>
	</table>
<a href="boardList.do?pageNum=${pageNum }">목록</a>
</body>
</html>