<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="common.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
<table>
<caption>파일 업로드</caption>
	<tr>
	<td>파일</td>
		<td><input type="file" name="originFile" required="required"></td>
	</tr>
	<tr align="center"><td colspan="2"><input type="submit" value="파일 업로드"></td></tr>
</table>
</form>
</body>
</html>