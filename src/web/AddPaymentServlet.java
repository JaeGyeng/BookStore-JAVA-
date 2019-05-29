/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Basket;
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

public class AddPaymentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        HttpSession HttpSession = request.getSession();
        ArrayList <Basket> baskets = (ArrayList <Basket>) HttpSession.getAttribute("baskets");
        User user = (User) HttpSession.getAttribute("user");
        BookService BookService;
        BookService = new BookService();
        ArrayList<BookProduct> books = null;
        books = BookService.getAllBook();
        int totalprice = 0;
        ArrayList<BookProduct> myproducts = new ArrayList<>();
        for (int i = 0; i < baskets.size(); i++) {
            for (int j = 0; j < books.size(); j++) {
                if (baskets.get(i).getBookid() == books.get(j).getBookid()) {
                    totalprice += books.get(j).getPrice() * baskets.get(i).getNumbers();
                    myproducts.add(books.get(j));
                }
            }
        }
        
        request.setAttribute("baskets", baskets);
        request.setAttribute("user", user);
        request.setAttribute("myproducts", myproducts);
        request.setAttribute("totalprice", totalprice);
        view = request.getRequestDispatcher("addpayment.jsp");
        view.forward(request, response);
    }
}


