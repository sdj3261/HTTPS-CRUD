<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>helloworld.jsp �ĸ����Ͱ� �Է� ������</title>
</head>
<body>

<h2>Get ���</h2>
    <!-- get ����� ����ؼ� ������ ���� (method="get") -->
    <form action="parameter01.jsp" method="get">
        �̸� : <input type="text" name="name" size="10"><br>
        �ּ� : <input type="text" name="address" size="30"><br>
        ��� :
            <input type="checkbox" name="hobby" value="game">����
            <input type="checkbox" name="hobby" value="travel">����
            <input type="checkbox" name="hobby" value="reading">����
            <br>
        <input type="submit" value="����">
    </form>
</body>
</html>
