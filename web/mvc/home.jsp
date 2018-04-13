<%--
  Created by IntelliJ IDEA.
  User: bit-user
  Date: 2018-04-13
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>홈화면</title>
</head>
<body>

<form action="./command?cmd=regist_form" method="post">
    <input type = "submit" value = "회원등록">

</form>


<form action="./command?cmd=request_list" method="post">
    <input type = "submit" value = "멤버조회">

</form>

</body>
</html>
