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
import java.util.ArrayList;
public class BookService {
    
    private BookDAO bookDataAccess;
    
    public BookService() {
        bookDataAccess = new BookDAO();
    }
    
    public ArrayList<BookProduct> getAllBook() {
        ArrayList<BookProduct> books = null;
        try {
            books = bookDataAccess.allbookRetrieve();
        } catch (Exception e) {
            books = null;
        }
        return books;
    }
    
    public ArrayList<BookProduct> getBook(String bookname) {
        ArrayList<BookProduct> books = null;
        try {
            books = bookDataAccess.bookRetrieve(bookname);
        } catch (Exception e) {
            books = null;
        }
        return books;
    }
    
    public void insertBook(String booktype, String bookname, String publisher, String explanation, int price, int inventory, String BookImage) {
        bookDataAccess.bookInsert(booktype, bookname, publisher, explanation, price, inventory, BookImage);
    }
    
    public void updateBook(int bookid, String booktype, String bookname, String publisher, String explanation, int price, int inventory, String BookImage) {
        bookDataAccess.bookUpdate(bookid, booktype, bookname, publisher, explanation, price, inventory, BookImage);
    }
}
