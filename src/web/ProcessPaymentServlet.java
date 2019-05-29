package web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JG
 */
import domain.Basket;
import domain.BasketService;
import domain.PaymentService;
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

public class ProcessPaymentServlet extends HttpServlet {
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
        ArrayList<Basket> baskets = (ArrayList<Basket>) HttpSession.getAttribute("baskets");
        User user = (User) HttpSession.getAttribute("user");
        int userid = user.getUserid();
        String address = user.getAddress();
        String phone = user.getPhone();
        String creditcardnumber = request.getParameter("creditcardnumber");
        String creditcardpassword = request.getParameter("creditcardpassword");
        ArrayList<BookProduct> books = null;
        BookService BookService = new BookService();
        books = BookService.getAllBook();
        request.setAttribute("books", books);
        request.setAttribute("user", HttpSession.getAttribute("user"));
        PaymentService PaymentService = new PaymentService();
        for (int i = 0; i < baskets.size(); i++) {
            PaymentService.paymentAdd(userid, baskets.get(i).getBookid(), baskets.get(i).getNumbers(), address, phone, creditcardnumber, creditcardpassword);
        }
        BasketService BasketService = new BasketService();
        BasketService.cleanBasket(userid);
        
        view = request.getRequestDispatcher("myPay.jsp");
        view.forward(request, response);
    }
}


