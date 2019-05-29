<%-- 
    Document   : joinconfirm
    Created on : 2017. 11. 15, 오후 6:13:50
    Author     : DH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel ="stylesheet" href ="loginCss.css" type = "text/css">
        <title>회원가입 완료</title>
                    <style>
                #message{
                    
                    margin-top: 250px;
                    margin-left: 500px;
                    font-size: 50px;
                    color: green;
                }

                
            </style>
    </head>
    <body>
        <div id = "message">             
            회원가입 되었습니다!
        </div> 
        
        <div> <input id ="homebtn" type="button" value="Home" size="20" weight="bold" onclick="location.href= 'main.jsp'"></div>
        <div> <input id ="loginbtn" type="button" value="로그인" size="20" weight="bold" onclick="location.href= 'login.jsp'"></div>
        
        
    </body>
</html>
