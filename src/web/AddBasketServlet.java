/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.BasketService;
import domain.BookProduct;
import domain.BookService;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Status;

/**
 *
 * @author DH
 */
public class AddBasketServlet extends HttpServlet{
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        BasketService BasketService = new BasketService();
        BookService BookService = new BookService();
        Status status = new Status();
        request.setAttribute("status", status);
        HttpSession HttpSession = request.getSession();
        int userid = Integer.parseInt(request.getParameter("userid"));
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        int numbers = Integer.parseInt(request.getParameter("numbers"));
        if((request.getParameter("numbers") == null)) {
            status.addException(new Exception("Please enter book numbers"));
        }
        if((numbers == 0)) {
            status.addException(new Exception("Please enter book numbers"));
        }
        
        ArrayList<BookProduct> books = null;
        BookService = new BookService();
        books = BookService.getAllBook();
        request.setAttribute("books", books);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        try {
            BasketService = new BasketService();
            BasketService.addBasket(userid, bookid, numbers);
            if(!status.isSuccessful()) {
                view = request.getRequestDispatcher("searchresult.jsp");
                view.forward(request, response);
                return;
            }
            view = request.getRequestDispatcher("searchresult.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("searchresult.jsp");
            view.forward(request, response);
        }
    }
}
