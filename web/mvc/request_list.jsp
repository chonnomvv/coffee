<%@ page import="kr.co.bit.coffee.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bit-user
  Date: 2018-04-13
  Time: 오후 6:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>전체 조회하기</title>
</head>
<body>

<%
    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");

%>

<%=list.toString()%>

</body>
</html>
//