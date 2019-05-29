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
import domain.User;
import domain.UserService;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Status;

public class JoinServlet extends HttpServlet {
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
        Status status = new Status();
        request.setAttribute("status", status);
        
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
           
            
            String sign = request.getParameter("sign");
            if(sign != null) sign = new String(sign.getBytes("8859_1"), "UTF-8"); //한글 깨짐 방지
            
            Date birthdate = java.sql.Date.valueOf(request.getParameter("birthdate"));
            

            String gender = request.getParameter("gender");     
            if(gender != null) gender = new String(gender.getBytes("8859_1"), "UTF-8"); //한글 깨짐 방지
            
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            
            String address = request.getParameter("address");
            if(address != null) address = new String(address.getBytes("8859_1"), "UTF-8"); //한글 깨짐 방지
            
            if ((username == null) || (username.length() == 0)) {
                status.addException(new Exception(
                        "아이디를 입력하세요"));
            }
            if ((password == null) || (password.length() == 0)) {
                status.addException(new Exception(
                        "비밀번호를 입력하세요"));
            }
            if ((sign == null) || (sign.length() == 0)) {
                status.addException(new Exception(
                        "이름을 입력하세요"));
            }
            if ((birthdate == null) || (password.length() == 0)) {
                status.addException(new Exception(
                        "생년월일(xxxx-xx-xx)를 입력하세요"));
            }
            if ((gender == null) || (gender.length() == 0) || !(gender.equals("남성") || gender.equals("여성"))) {
                status.addException(new Exception(
                        "성별을 선택하세요"));
            }
            if ((email == null) || (email.length() == 0)) {
                status.addException(new Exception(
                        "이메일을 입력하세요"));
            }
            if ((phone == null) || (phone.length() == 0)) {
                status.addException(new Exception(
                        "전화번호를 입력하세요"));
            }
            if ((address == null) || (address.length() == 0)) {
                status.addException(new Exception(
                        "주소를 입력하세요"));
            }
            try {
                UserService = new UserService();
                UserService.userCreate("C", username, password, sign, birthdate, gender, email, phone, address);
                if (!status.isSuccessful()) {
                    view = request.getRequestDispatcher("join.jsp");
                    view.forward(request, response);
                    return;
                }
                view = request.getRequestDispatcher("joinconfirm.jsp");
                view.forward(request, response);
            } catch (Exception e) {
                status.addException(e);
                view = request.getRequestDispatcher("join.jsp");
                view.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            status.addException(e);
            view = request.getRequestDispatcher("join.jsp");
            view.forward(request, response);
        }
    }
}
