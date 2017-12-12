<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="deco" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="home.jsp">홈</a>
<a href="bestItem.jsp">인기상품</a>
<a href="newItem.jsp">신상품</a>
<a href="exclude.jsp">제외</a> <!-- 무조건 탑부분에 이게 나와라 -->
<hr>
	<deco:body></deco:body>
<hr>
중앙정보처리학원 <br>
날씨 춥고 배고파
</body>
</html>