<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    // ���ڵ�
    request.setCharacterEncoding("euc-kr");
%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>parameter02.jsp �ĸ����Ͱ� ��� ������</title>
</head>
<body>
<h2>Post ���� ���</h2>
    �̸� : <%= request.getParameter("name") %><br>
    �ּ� : <%= request.getParameter("address") %><br>
    ��� : 
    <%
        // üũ�ڽ��� �迭�� ó���ؾ� �Ѵ�.
        String[] values = request.getParameterValues("hobby");
        if(values != null){
            for(int i=0; i<values.length; i++){        
    %>
        <%=values[i] %>
    <%                        
            }
        }
    %>
</body>
</html>
