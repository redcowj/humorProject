<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="sessionChk.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="common.css">
<script type="text/javascript">
	function chk() {
		if(frm.password.value != frm.password2.value){
			alert("암호가 암호확인과 다릅니다.");
			frm.password.focus();
			return false;
		}
	}
</script>
</head>
<body>
<form action="update.do" name="frm" onsubmit="return chk()">
	<input type="hidden" name="id" value="${member.id }">
	<table><caption>회원정보 수정</caption>
		<tr><th>아이디</th><td>${member.id }</td></tr>
		<tr><th>새로운 암호</th><td><input type="password" name="password" required="required" ></td></tr>
		<tr><th>새로운 암호확인</th><td><input type="password" name="password2" required="required"></td></tr>
		<tr><th>이름</th><td><input type="text" name="name" value="${member.name }" required="required"></td></tr>
		<tr><th>주소</th><td><input type="text" name="address" value="${member.address }" required="required"></td></tr>
		<tr><th>전화번호</th><td><input type="tel" name="tel" value="${member.tel }" required="required"
								 pattern="\d{3}-\d{3,4}-\d{4}" placeholder="xxx-xxxx-xxxx"></td></tr>
		<tr><th colspan="2"><input type="submit"  value="확인" ></th></tr>
	</table>
<a href="main.do">메인</a>


</form>
</body>
</html>