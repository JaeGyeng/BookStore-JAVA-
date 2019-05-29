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
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public final class SearchBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
       
        
        RequestDispatcher view = null;
        BookService BookService = null;
        String BookName = new String(request.getParameter("bookname").getBytes("8859_1"), "UTF-8");
        String Publisher = request.getParameter("publisher");
        HttpSession HttpSession = request.getSession();
        
        ArrayList<BookProduct> books = null;
        ArrayList<BookProduct> publishers = null;
        BookService = new BookService();
        books = BookService.getBook(BookName);
        publishers = BookService.getBook(Publisher);
        request.setAttribute("books", books);
        request.setAttribute("publishers", publishers);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        
   
           
        
       
    
        view = request.getRequestDispatcher("searchresult.jsp");
        view.forward(request, response);
    }
}
