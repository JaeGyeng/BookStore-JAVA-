<%-- 
    Document   : join
    Created on : 2017. 11. 15, 오후 6:01:18
    Author     : DH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false" import="java.util.Iterator"%>





<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head>
        <title>회원가입</title>
        <link rel ="stylesheet" href ="joinCss.css" type = "text/css">    
    </head>
    <body>
        <h2>회원가입은 빠르고 정확하게</h2>
     <div class = "joinWarning">       
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red"> 오류 발생! 다시 한 번 확인하세요.
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
     </div>
        <form action="join" method="post">
            <div class = 'jointab'>
            <table>
                <tr bgcolor="pink">
                    <td align="center">
                        <font size ="5" color="white" weight="bold">아이디</font>
                    </td> 
                    <td><input type="text" name="username" size="20" placeholder="영문,숫자 최대10자" id ="inputid" >
                    </td>
                </tr>
                <tr></tr>
                <tr></tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">비밀번호</font>
                    </td>
                    <td><input type="password" name="password" size="20" placeholder="영문,숫자 최대10자" id = "inputpss"></td>
                </tr>
                <tr></tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">이름</font>
                    </td>
                    <td><input type="text" name="sign" size="20" placeholder="이름" id ="inputname"></td>
                </tr>
                <tr></tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">생년월일</td>
                    <td><input type="text" name="birthdate" size="20" placeholder="YYYY-MM-DD" id = "inputbt"></td>
                </tr>
                <tr></tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">성별</td>
                           <td> <input type="radio" name="gender" value="남성" id = "inputM">남성
                               <input type="radio" name="gender" value="여성" id = "inputF">여성 </td>
                 
                </tr>
                <tr></tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">E-Mail</td>
                    <td><input type="text" name="email" size="20" id =inputem></td>
                </tr>
                <tr></tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">휴대폰 번호</td>
                    <td><input type="text" name="phone" size="20" placeholder="010-xxxx-xxxx" id ="inputph"></td>
                </tr>
                <tr></tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">주소</td>
                    <td><input type="text" name="address" size="20" id = "inputaddss"></td>
                </tr>
            </table>
            </div>
            
            <input type="submit" value="가입하기" size="20" id = "joinbtn">
        </form>         
    </body>
</html>
