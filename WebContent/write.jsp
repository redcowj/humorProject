<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result >0 }">
	<script type="text/javascript">
		alert("작성 성공 메인으로 돌아갑니다. 파일업르드는?");
		location.href="main.jsp";
	</script>
</c:if>
<c:if test="${result <=0 }">
	<script type="text/javascript">
		alert("실패했어요 ㅠ");
		history.go(-1);
	</script>
</c:if>
</body>
</html>