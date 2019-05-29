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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnectionPool;

public class BookDAO {
    private DBConnectionPool connPool;
    private static final String ALLRETRIEVE_STMT
            = "SELECT * FROM bookproduct";
    private static final String INSERT_STMT = "INSERT INTO bookproduct VALUES(?,?,?,?,?,?,?,?)";
    private static final String UPDATE_STMT = "UPDATE bookproduct SET BookType = ? BookName = ? Publisher = ? Explanation = ? Price = ? Inventory = ? BookImage = ?  WHERE BookID = ?";
    private static final String GETID_STMT = "SELECT COUNT(BookID) FROM bookproduct";
    ArrayList<BookProduct> allbookRetrieve() throws SQLException {
        ArrayList<BookProduct> books = new ArrayList<BookProduct>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(ALLRETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int BookID = rset.getInt(1);
                String BookType = rset.getString(2);
                String BookName = rset.getString(3);
                String Publisher = rset.getString(4);
                String Explanation = rset.getString(5);
                int Price = rset.getInt(6);
                int Inventory = rset.getInt(7);
                String BookImage = rset.getString(8);
                books.add(new BookProduct(BookID, BookType, BookName, Publisher, Explanation, Price, Inventory, BookImage));
            }
            return books;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    ArrayList<BookProduct> bookRetrieve(String bookname) throws SQLException {
        ArrayList<BookProduct> books = new ArrayList<BookProduct>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement("SELECT * FROM bookproduct WHERE BookName like '%" + bookname + "%'");
            rset = stmt.executeQuery();
            while (rset.next()) {
                int BookID = rset.getInt(1);
                String BookType = rset.getString(2);
                String BookName = rset.getString(3);
                String Publisher = rset.getString(4);
                String Explanation = rset.getString(5);
                int Price = rset.getInt(6);
                int Inventory = rset.getInt(7);
                String BookImage = rset.getString(8);
                books.add(new BookProduct(BookID, BookType, BookName, Publisher, Explanation, Price, Inventory, BookImage));
            }
            return books;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    void bookInsert(String booktype, String bookname, String publisher, String explanation, int price, int inventory, String BookImage) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(BookID)");
            ID++;
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, booktype);
            stmt.setString(3, bookname);
            stmt.setString(4, publisher);
            stmt.setString(5, explanation);
            stmt.setInt(6, price);
            stmt.setInt(7, inventory);
            stmt.setString(8, BookImage);
            stmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    void bookUpdate(int bookid, String booktype, String bookname, String publisher, String explanation, int price, int inventory, String BookImage) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, booktype);
            stmt.setString(2, bookname);
            stmt.setString(3, publisher);
            stmt.setString(4, explanation);
            stmt.setInt(5, price);
            stmt.setInt(6, inventory);
            stmt.setInt(7, bookid);
            stmt.setString(8,BookImage);
            stmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    void bookUpdate(int bookid, String booktype, String bookname, String publisher, String explanation, int price, int inventory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void bookInsert(String booktype, String bookname, String publisher, String explanation, int price, int inventory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
