<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>helloworld.jsp 파리미터값 입력 페이지</title>
</head>
<body>

<h2>Get 방식</h2>
    <!-- get 방식을 사용해서 데이터 전송 (method="get") -->
    <form action="parameter01.jsp" method="get">
        이름 : <input type="text" name="name" size="10"><br>
        주소 : <input type="text" name="address" size="30"><br>
        취미 :
            <input type="checkbox" name="hobby" value="game">게임
            <input type="checkbox" name="hobby" value="travel">여행
            <input type="checkbox" name="hobby" value="reading">독서
            <br>
        <input type="submit" value="전송">
    </form>
</body>
</html>
