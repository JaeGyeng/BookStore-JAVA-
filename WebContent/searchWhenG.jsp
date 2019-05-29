<%-- 
    Document   : serchresult
    Created on : 2017. 11. 25, 오전 1:18:53
    Author     : JG
--%>

<%@page import="domain.BookProduct"%>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.BookProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Book List</title>
        <link rel ="stylesheet" href ="searchrsCss.css" type = "text/css">
        <style>

            .table2_1{
                position: absolute;
                left: 140px;
                width: 1000px;
      
                word-break:break-all;
            }
            .table2_1 th {
                background-color:#FF7A85;
                color:#FFFFFF
            }
            .table2_1,.table2_1 th,.table2_1 td
            {
                text-align:center;
                padding:5px;
                border:1px solid #feb3b9;
                border-collapse:collapse;
                font-size: 25px;
            }
            .table2_1 tr:nth-child(odd){
                background-color:#fed2d6;

             }
            .table2_1 tr:nth-child(even){
                background-color:#fdfdfd;
            }
            

            #namewidth{
                width: 200px;
            }
            #expwidth{
                width: 300px;
            }
            #cashwidth{
                width: 100px;
                
            }
            #bimg{
                width: 100%;
                
            }


            

        </style>
        
        <% ArrayList<BookProduct> books = (ArrayList<BookProduct>) request.getAttribute("books");%>


    </head>
    <body>
        <h2>로그인 하세요</h2>


      <div class = "searchbook3">     
        <form action="search2" method="post">
               <input type="text" name="bookname" size="15" id = "searchbar3" placeholder="도서명 입력">
                <input type="submit" value="검색" id = "searchbtn3">
        </form>
      </div>




    <div class = "bg">
    <table width="1280" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td colspan="5" height="141" background="./images/BookStoreMain__01-1.jpg"></td>
            </tr>
            
 
 
            <tr>
                <td  wideth = "306" height="56"> <input type ="image" src="./images/BookStoreMain__02.jpg" border ="0" onclick="location.href= 'main.jsp'"></td>
                <td  wideth = "276" height="56"> <input type ="image" src="./images/BookStoreMain__03.jpg" border ="0" onclick="location.href= 'login.jsp'"></td>
                <td  wideth = "162" height="56"> <img src="./images/BookStoreMain__04.jpg" border ="0"></td>
                <td  wideth = "180" height="56"> <img src="./images/BookStoreMain__05.jpg" border ="0"></td>
                <td  wideth = "356" height="56"> <img src="./images/BookStoreMain__06.jpg" border ="0"></td>             
            </tr>
                      
     </table>

      </div>









    <div class ="booklist">
        <table class = "table2_1" >

            <tr>
                <th>도서ID</th>
                <th>종류</th>
                <th>표지</th>
                <th>도서명</th>
                <th>설명</th>
                <th>가격</th>
                <th>재고</th>


            </tr>

   
    
            <%
                for(int i=0; i<books.size(); i++) {
                    BookProduct book = books.get(i);
            %>
        
            <tr>
                <td align="center"><%=book.getBookid()%></td>
                <td align="center"><%=book.getBooktype()%></td>
                <td align="center"><img src ="./BookImg/<%=book.getBookImage()%>" id ="bimg"></td>
                <td align="center" id = "namewidth" style="word-break:break-all;"><%=book.getBookname()%></td>
                <td align="center" id = "expwidth" ><%=book.getExplanation()%></td>
                <td align="center" id ="cashwidth"><%=book.getPrice()%>원</td>
                <td align="center"><%=book.getInventory()%></td>


            </tr>
   
            <% }%>
        </table>
    </div>
    </body>
</html>
