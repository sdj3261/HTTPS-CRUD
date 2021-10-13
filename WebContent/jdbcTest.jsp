<%@ page contentType="text/html; charset=euc-kr"
    import="java.sql.*"
%>

<%
Connection con = null;
PreparedStatement stmt = null;

try{
	String jdbcURL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String dbID="root";
	String dbPW="0000"; //비밀번호 입력

	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(jdbcURL,dbID,dbPW);
    stmt = con.prepareStatement("create table keona(success varchar(10))");
	stmt.executeUpdate();
	stmt.close();
	con.close();
}catch(Exception e){
    out.println(e);
}
%>

<html>
<body>
Successfully ok table created check your DB.
</body>
</html>
