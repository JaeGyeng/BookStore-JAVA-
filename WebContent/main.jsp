<%-- 
    Document   : main
    Created on : 2017. 11. 24, 오후 4:57:13
    Author     : JG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.User"%>
<%@page import="domain.BookProduct"%>
<!DOCTYPE html>
<html>
    <head>
        <title> 5 Book Store</title>
        <link rel ="stylesheet" href ="mainCss.css" type = "text/css">

    </head>
    <h2>로그인 해주세요</h2>
    <body leftmargin="0" topmargin="0">
        

      
       <div class = "searchbook">     
        <form action="search2" method="post">
            <input type="text" name="bookname" size="15" id = "searchbar" placeholder="도서명 입력">
            <input type="submit" value="검색" id = "searchbtn">
        </form>
       </div>       
        
        
        <div class = "pageback">
        <table width="1280" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td colspan="5" height="141" background="./images/BookStoreMain__01-1.jpg"></td>
            </tr>
            
           
            <tr>

                <td  wideth = "306" height="56"> <input type ="image" src="./images/BookStoreMain__02.jpg" border ="0" onclick="location.href= 'main.jsp'"></td>
                <td  wideth = "276" height="56"> <input type ="image" src="./images/BookStoreMain__03.jpg" border ="0" onclick="location.href= 'login.jsp'"></td>
                <td  wideth = "162" height="56"> <img src="./images/BookStoreMain__04.jpg" border ="0" ></td>
                <td  wideth = "180" height="56"> <img src="./images/BookStoreMain__05.jpg" border ="0"></td>
                <td  wideth = "356" height="56"> <img src="./images/BookStoreMain__06.jpg" border ="0"></td>

                
            </tr>
            
           
            <tr>
                <td colspan="5" wideth = "1280" height="200"> <img src="./images/BookStoreMain__07-2.jpg"></td>
            </tr>

          <%--  
            <tr>
                <td colspan="5" wideth = "440" height="712"> <img src="./images/BookStoreMain__08.jpg"></td>            
            </tr>
            
            <tr>
                <td colspan="5" wideth = "1208" height="114"> <img src="./images/BookStoreMain__09.jpg"></td>
            </tr>
           --%>

        </table>

        </div>
        
    </body>
</html>

