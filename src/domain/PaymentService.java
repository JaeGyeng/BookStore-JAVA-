/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author DH
 */
public class PaymentService {

    private PaymentDAO paymentDataAccess;
    
    public PaymentService() {
        paymentDataAccess = new PaymentDAO();
    }
    
    public ArrayList<Payment> getAllPayment() {
        ArrayList<Payment> payments = null;
        try {
            payments = paymentDataAccess.allpaymentRetrieve();
        } catch (Exception e) {
            payments = null;
        }
        return payments;
        }
    
    public ArrayList<Payment> getAllPayment(int userid) {
        ArrayList<Payment> payments = null;
        try {
            payments = paymentDataAccess.paymentRetrieve(userid);
        } catch (Exception e) {
            payments = null;
        }
        return payments;
    }
    
    public void paymentAdd(int userid, int bookid, int numbers, String address, String phone, String creditcardnumber, String creditcardPassword) {
        paymentDataAccess.paymentAdd(userid, bookid, numbers, address, phone, creditcardnumber, creditcardPassword);
    }
}
