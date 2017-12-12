<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="sessionChk.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
<table><caption>회원정보</caption>
	<tr><th>아이디</th><td>${member.id }</td></tr>
	<tr><th>이름</th><td>${member.name }</td></tr>
	<tr><th>주소</th><td>${member.address }</td></tr>
	<tr><th>전화</th><td>${member.tel }</td></tr>
	<tr><th>등록일</th><td>${member.reg_date }</td></tr>
</table>
<a href="main.do">메인</a>
<a href="updateForm.do">회원정보 수정</a>

</body>
</html>