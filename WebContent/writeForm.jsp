<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ include file="sessionChk.jsp" %> 

<!DOCTYPE html >
<%-- <jsp:include page="sessionChk.jsp" flush="false"></jsp:include> --%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="common.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function upload(){
	var url = "fileUpload.jsp";
	window.open(url,"","width =450 height=300"); //새로운창(idChk.jsp)을 띄움 
}
</script>
</head>
<body>
	<form action="write.do" >
	<input type="hidden" name="id" value="${member.id }">
		<table>
			<caption>글 작성</caption>
			<tr>
				<td>제목</td>
				<td><input type="text" required="required" name="subject"></td>
			</tr>
			<tr>
				<td>글쓴이아이디</td>
				<td>${member.id }</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><input type="text" value="humor" name="category"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="50" name="content"></textarea></td>
			</tr>
			 <tr>
				<!--  <td colspan="2"><input type="file" name="originFile" ></td> -->
			 	<td colspan="2"><input type="button" onclick="upload()" value="파일 업로드"></td> 
			 </tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>