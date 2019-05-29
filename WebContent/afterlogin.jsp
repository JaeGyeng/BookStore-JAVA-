<%-- 
    Document   : login
    Created on : 2017. 11. 15, 오후 6:13:00
    Author     : DH
--%>


<%@page import="domain.BookProduct"%>
<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.BookProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Book List</title>
        <link rel ="stylesheet" href ="afterloginCss.css" type = "text/css">
        <% ArrayList<BookProduct> books = (ArrayList<BookProduct>) request.getAttribute("books");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>


        <% String IsLoginUser = null;
           
            if(user != null){
                
                IsLoginUser = user.getUsername();  
            }
            
        %>
        
    </head>
 
        <h2><%=IsLoginUser%>님 접속 중</h2>

    <body leftmargin="0" topmargin="0">
       
 
      <div class = "searchbook2">     
        <form action="search" method="post">
               <input type="text" name="bookname" size="15" id = "searchbar2" placeholder="도서명 입력">
                <input type="submit" value="검색" id = "searchbtn2">
        </form>
      </div>
        
        
      
        <div class = "pagebcakground">    
        <table width="1280" border="0" cellspacing="0" cellpadding="0">
            

            
            <tr>
                <td colspan="5" height="141" background="./images/BookStoreMain__01-1.jpg"></td>
            </tr>
            
            
            
 

 
            <tr>

                <td  wideth = "306" height="56"> <input type ="image" src="./images/BookStoreMain__02.jpg" border ="0" onclick="location.href= 'afterlogin.jsp'"></td>
                <td  wideth = "276" height="56"> <input type ="image" src="./images/BookStoreMain__03.jpg" border ="0" onclick="location.href= 'login.jsp'"></td>
                <td  wideth = "162" height="56"> <img src="./images/BookStoreMain__04.jpg" border ="0"></td>
                <td  wideth = "180" height="56"> <img src="./images/BookStoreMain__05.jpg" border ="0" onclick="location.href= 'myPay.jsp'"></td>
                <td  wideth = "356" height="56"> <img src="./images/BookStoreMain__06.jpg" border ="0"></td>


                
            </tr>
            
            
            <tr>
                <td colspan="5" wideth = "1280" height="200"> <img src="./images/BookStoreMain__07-2.jpg"></td>

            </tr>
            
            <tr>
                <td colspan="5" wideth = "440" height="712"> <img src="./images/BookStoreMain__08.jpg"></td>


            
            
            </tr>
            
            <tr>
                <td colspan="5" wideth = "1208" height="114"> <img src="./images/BookStoreMain__09.jpg"></td>
            </tr>


            </table>

        </div>
        


    </body>
</html>