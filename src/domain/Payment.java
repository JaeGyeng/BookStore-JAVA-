/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author DH
 */
public class Payment {

    int paymentid;
    int userid;
    int bookid;
    int numbers;
    String address;
    String phone;
    String creditcardnumber;
    String creditcardpassword;
    
    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public String getCreditcardpassword() {
        return creditcardpassword;
    }

    public void setCreditcardpassword(String creditcardpassword) {
        this.creditcardpassword = creditcardpassword;
    }

    public Payment(int paymentid, int userid, int bookid, int numbers, String address, String phone, String creditcardnumber, String creditcardpassword) {
        this.paymentid = paymentid;
        this.userid = userid;
        this.bookid = bookid;
        this.numbers = numbers;
        this.address = address;
        this.phone = phone;
        this.creditcardnumber = creditcardnumber;
        this.creditcardpassword = creditcardpassword;
    }

}
