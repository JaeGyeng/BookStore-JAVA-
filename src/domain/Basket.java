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
public class Basket {
    int basketid;
    int userid;
    int bookid;
    int numbers;
    int validity;

    public Basket(int basketid, int userid, int bookid, int numbers, int validity) {
        this.basketid = basketid;
        this.userid = userid;
        this.bookid = bookid;
        this.numbers = numbers;
        this.validity = validity;
    }
    
    public int getBasketid() {
        return basketid;
    }

    public void setBasketid(int basketid) {
        this.basketid = basketid;
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

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }
}