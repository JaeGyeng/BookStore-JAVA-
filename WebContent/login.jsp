<%-- 
    Document   : main
    Created on : 2017. 11. 15, 오후 5:45:42
    Author     : DH
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" 
        pageEncoding="UTF-8" session="false" import="java.util.Iterator"%>
<!DOCTYPE html>
<jsp:useBean id="status" scope="request" class="util.Status"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn</title></head>
        <link rel ="stylesheet" href ="loginCss.css" type = "text/css">
    
    
    <body>
       
        <h2>5조 서점 방문을 환영합니다!</h2>
        
        <div class = "loinWarning">  
            <%if ((status != null) && !status.isSuccessful()) {%>   <!--미입력칸 발견시 메세지 출력-->
            <font color="red">아이디, 비밀번호를 확인하세요!
            <ul><%Iterator errors = status.getExceptions();
                while (errors.hasNext()) {
                    Exception ex = (Exception) errors.next();%>
                <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        </div>  
        <form action="login" method="post">
           <div  class ="logtab">
            <table border ="0" width="300" height="150">
                <tr bgcolor="pink">
                    <td align="center"> 
                        <font size ="5" color="white" weight="bold">사용자 구분</font></td>
                    <td>
                        <select name ="usertype" id = "slct" >
                            <option name="usertype" value="C">고객
                            <option name="usertype" value="A">관리자
                        </select></td>
                </tr>
                <tr bgcolor="pink">
                    <td align="center"> 
                         <font size ="5" color="white" weight="bold">아이디</font></td>
                    <td> <input id ="idinput" type ="text" name="username" size="10" placeholder="영문,숫자"></td>
                </tr>
                <tr bgcolor="pink">
                    <td align="center">
                         <font size ="5" color="white" weight="bold">비밀번호</font></td>
                    <td><input id = "pssinput" type="password" name="password"size="10" placeholder="영문,숫자"></td>
                </tr>
                </table>
           </div>
            
            <div> <input id ="loginbtn" type="submit" value="로그인" size="20" weight="bold" ></div> 
            
        </form>
      
        <form action="join.jsp" method="post">
            <div> <input type="submit" value="회원가입" id = "btnjoin"> </div>
        
        </form> 
        
        
 
        
    </body>
</html>