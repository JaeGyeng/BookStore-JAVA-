<%-- 
    Document   : payment
    Created on : 2017. 12. 5, 오후 9:59:47
    Author     : JG
--%>

<%@page import="domain.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<Payment> payments = (ArrayList<Payment>) request.getAttribute("payments");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
    </head>
    <body>
        <h2>Hello, <%= user.getUsername()%></h2>
        <table border="2px">
            <tr>
                <th width="100">Payment ID</th>
                <th width="200">User Name</th>
                <th width="100">Product ID</th>
                <th width="100">Numbers</th>
                <th width="200">Address</th>
                <th width="200">Contact</th>
            </tr>
            <%
                for (int i = 0; i < payments.size(); i++) {
                    Payment payment = payments.get(i);
            %> 
            <tr>
                <td align="center"><%=payment.getPaymentid()%></td>
                <td align="center"><%=user.getUsername()%></td>
                <td align="center"><%=payment.getBookid()%></td>
                <td align="center"><%=payment.getNumbers()%></td>
                <td align="center"><%=payment.getAddress()%></td>
                <td align="center"><%=payment.getPhone()%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>

