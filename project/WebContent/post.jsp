<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>helloworld.jsp �ĸ����Ͱ� �Է� ������</title>
</head>
<body>

<h2>Post ���</h2>
    <!-- get ����� ����ؼ� ������ ���� (method="post") -->
    <form action="parameter02.jsp" method="post">
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
