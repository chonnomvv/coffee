<%@ page import="kr.co.bit.coffee.vo.MemberVO" %><%--
  Created by IntelliJ IDEA.
  User: bit-user
  Date: 2018-04-13
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    MemberVO vo = (MemberVO) request.getAttribute("vo");
    if (vo == null) {
        vo = new MemberVO();
        vo.setId("");
        vo.setPw("");
        vo.setName("");
        vo.setZipcode(" - ");
        vo.setLang("");
        vo.setTool("0");
        vo.setBirth("");
    }
%>
<form action="./command?cmd=regist" method="post" enctype="application/x-www-form-urlencoded">
    <table>
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" name="id" id="userid" value="<%=vo.getId()%>" >
            </td>


        </tr>
        <tr>
            <td>패스워드</td>
            <td><input type="password" name="pw" id="pw" value="<%=vo.getPw()%>"></td>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" id="name" value="<%=vo.getName()%>"></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>우편번호</td>
            <td>
                <input type="text" name="zipcode" size="3" value="<%=vo.getZipcode()%>" id="zipcode">

                <span id="zipmsg"></span>
            </td>
        </tr>
        <tr>
            <td>생년월일</td>
            <td><input type="text" name ="birth" size="3" id="birth"></td></tr>
            <tr><td>사용언어</td>
            <td>
                <input type="checkbox" name="lang" class="langs"
                       value="0" >자바
                <input type="checkbox" name="lang" class="langs"
                       value="1" >파이썬
                <input type="checkbox" name="lang" class="langs"
                       value="2">C++
                <input type="checkbox" name="lang" class="langs"
                       value="3" >C
            </tr>
        <tr>
            <td>사용툴</td>
            <td>
                <input type="radio" name="tool" value="0" <%=vo.getTool().equals("0")?"checked":""%>>이클립스
                <input type="radio" name="tool" value="1" <%=vo.getTool().equals("1")?"checked":""%>>Visual Studio
                <input type="radio" name="tool" value="2" <%=vo.getTool().equals("2")?"checked":""%>>Xcode
                <input type="radio" name="tool" value="3" <%=vo.getTool().equals("3")?"checked":""%>>notepad
            </td>
            <td></td>
            <td></td>
        </tr>

        <tr>
            <td colspan="4"><input type="submit" value="가입"></td>

        </tr>
    </table>
</form>

</body>
</html>
