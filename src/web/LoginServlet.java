/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

/**
 *
 * @author DH
 */
import domain.BookProduct;
import domain.BookService;
import domain.UserService;
import domain.User;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.pool.OracleDataSource;
import util.Status;
public final class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        UserService UserService = null;
        BookService BookService = null;
        Status status = new Status();
        request.setAttribute("status", status);
        String usertype = request.getParameter("usertype");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if ((username == null) || (username.length() == 0)) {
            status.addException(new Exception(
                    "아이디를 입력해주세요."));
        }
        if ((password == null) || (password.length() == 0)) {
            status.addException(new Exception(
                    "비밀번호를 입력해주세요."));
        }
        User user = null;
        ArrayList<BookProduct> books = null;
        try {
            UserService = new UserService();
            user = UserService.getUser(usertype, username, password);
            BookService = new BookService();
            books = BookService.getAllBook();
            if (user == null) {
                status.addException(new Exception(
                        "아이디 또는 비밀번호가 틀립니다!"));
            }
            if (books == null) {
                status.addException(new Exception(
                        "데이터베이스 오류"));
            }
            
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
                return;
            }
            request.setAttribute("user", user);
            request.setAttribute("books", books);
        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }
        if (usertype.equals("A")) {
            view = request.getRequestDispatcher("admin/login.jsp");
            view.forward(request, response);
        }
        if (usertype.equals("C")) {
            view = request.getRequestDispatcher("afterlogin.jsp");
            view.forward(request, response);
        }
    }
}