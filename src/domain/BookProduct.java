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
public class BookProduct {
 int bookid;
    String booktype;
    String bookname;
    String publisher;
    String explanation;
    int price;
    int inventory;
    String BookImage;
    

    public BookProduct(int bookid, String booktype, String bookname, String publisher, String explanation, int price, int inventory, String BookImage) {
        this.bookid = bookid;
        this.booktype = booktype;
        this.bookname = bookname;
        this.publisher = publisher;
        this.explanation = explanation;
        this.price = price;
        this.inventory = inventory;
        this.BookImage = BookImage;
    }
    
    public int getBookid() {
        return bookid;
    }
   
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getBooktype() {
        return booktype;
    }
    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getExplanation() {
        return explanation;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    
    public String getBookImage() {
        return BookImage;
    }
    public void setBookImage(String BookImage) {
        this.BookImage = BookImage;
    }
}