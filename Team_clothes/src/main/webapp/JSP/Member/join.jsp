<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/join" method="post" onsubmit="return submitFormWithAxios();">
        PWD : <input name="pwd" type="password"><br/>
        RE_PWD : <input name="re_pwd" type="password"><br/>
        NAME :<input name="name" type="text"><br/>
        PHONE :<input name="phone" type="text" placeholder="[-]을 포함해서 입력해주세요"><br/>
        ADDR :<input type="text" id="sample6_postcode" placeholder="우편번호">
		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample6_address" placeholder="주소"><br>
		<input type="text" id="sample6_detailAddress" placeholder="상세주소">
		<input type="text" id="sample6_extraAddress" placeholder="참고항목">
		<input type="hidden" name="addr" id="merged_addr">
        EMAIL : <input name="email" type="email">
        <input type="button" onclick="submitFormWithAxios()" value="email인증"><br>
        
        <input type="submit" value="전송">
    </form>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="/JS/address.js"></script>
    <script src="/JS/member.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>