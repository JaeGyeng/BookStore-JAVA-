<%-- 
    Document   : basket
    Created on : 2017. 11. 20, 오후 6:49:45
    Author     : DH
--%>

<%@page import="domain.Basket" %>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel ="stylesheet" href ="mainCss.css" type = "text/css">
         <style>
             

            .table2_1{
                position: absolute;
                top: 300px;
                left: 80px;
                width: 1150px;
      
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
            
            #del{
                width: 100px;
            }
            #delButton{
        font-family: 'Nanum Pen Script', cursive;
        font-size: 20px;         
        -moz-box-shadow:inset 0px 1px 0px 0px #fce2c1;
        -webkit-box-shadow:inset 0px 1px 0px 0px #fce2c1;
	box-shadow:inset 0px 1px 0px 0px #fce2c1;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffc477), color-stop(1, #fb9e25));
	background:-moz-linear-gradient(top, #ffc477 5%, #fb9e25 100%);
	background:-webkit-linear-gradient(top, #ffc477 5%, #fb9e25 100%);
	background:-o-linear-gradient(top, #ffc477 5%, #fb9e25 100%);
	background:-ms-linear-gradient(top, #ffc477 5%, #fb9e25 100%);
	background:linear-gradient(to bottom, #ffc477 5%, #fb9e25 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffc477', endColorstr='#fb9e25',GradientType=0);
	background-color:#ffc477;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #eeb44f;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-weight:bold;
	text-decoration:none;
	text-shadow:0px 1px 0px #cc9f52;                            
            }


            

        </style>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book List</title>
        <%ArrayList<Basket> baskets = (ArrayList<Basket>)request.getAttribute("baskets");%>
        <%User user = (User)request.getAttribute("user");%>
        <%session.setAttribute("user", user);%>
    </head>
    <body>
        <h2><%=user.getUsername()%>님 장바구니</h2>
        
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

                <td  wideth = "306" height="56"> <input type ="image" src="./images/BookStoreMain__02.jpg" border ="0" onclick="location.href= 'afterlogin.jsp'"></td>
                <td  wideth = "276" height="56"> <input type ="image" src="./images/BookStoreMain__03.jpg" border ="0" onclick="location.href= 'login.jsp'"></td>
                <td  wideth = "162" height="56"> <img src="./images/BookStoreMain__04.jpg" border ="0"></td>
                <td  wideth = "180" height="56"> <input type ="image" src="./images/BookStoreMain__05.jpg" border ="0" onclick="location.href= 'myPay.jsp'"></td>
                <td  wideth = "356" height="56"> <img src="./images/BookStoreMain__06.jpg" border ="0"></td>

                
            </tr>
            
        

            
        </table>

        </div>
        
        
        
        <table border="2px" class = "table2_1">
            <tr>
                <th width ="200">장바구니 번호</th>
                <th width ="200">사용자</th>
                <th width ="200">도서번호</th>
                <th width ="200">수량</th>
                <th id = "del">삭제</th>
            </tr>
            <%
                for(int i = 0 ;i<baskets.size();i++) {
                    Basket basket = baskets.get(i);
            %>
            <tr>
                <td align="center"><%=basket.getBasketid()%></td>
                <td align="center"><%=user.getUsername()%></td>
                <td align="center"><%=basket.getBookid()%></td>
                <td align="center"><%=basket.getNumbers()%></td>
                <td align="center">
                    <form action="delete" method="post">
                        <input type="hidden" name="basketid" value="<%=basket.getBasketid()%>">
                        <input type="hidden" name="userid" value="<%=user.getUserid()%>">
                        <input type="submit" value="Delete" id = "delButton">
                    </form></td>
            </tr>
            <%}%>
        </table>
        
         <form action="payment" method="post">
            <input type="submit" value="Payment">
        </form>


 
        
        
    </body>
</html>
