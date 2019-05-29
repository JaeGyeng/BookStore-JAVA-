/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnectionPool;

/**
 *
 * @author DH
 */
public class PaymentDAO {
    private DBConnectionPool connPool;
    private static final String ALLRETRIEVE_STMT = "SELECT * FROM bookpayment";
    private static final String RETRIEVE_STMT = "SELECT * FROM bookpayment WHERE UserID = ?";
    private static final String GETID_STMT = "SELECT COUNT(PaymentID) FROM bookpayment";
    private static final String ADD_STMT = "INSERT INTO bookpayment VALUES(?,?,?,?,?,?,?,?)";
    
    ArrayList<Payment> allpaymentRetrieve() throws SQLException {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rest = null;
        
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(ALLRETRIEVE_STMT);
            rest = stmt.executeQuery();
            while(rest.next()) {
                int PaymentID = rest.getInt(1);
                int UserID = rest.getInt(2);
                int BookID = rest.getInt(3);
                int Numbers = rest.getInt(4);
                String Address = rest.getString(5);
                String Phone = rest.getString(6);
                String CreditCardNumber = rest.getString(7);
                String CreditCardPassword = rest.getString(8);
                payments.add(new Payment(PaymentID, UserID, BookID, Numbers, Address, Phone, CreditCardNumber, CreditCardPassword));
            }
            return payments;
        } catch(SQLException se) {
            throw new RuntimeException(
            "A database error occurred." + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception : " + e.getMessage());
        } finally {
            if(rest!=null) {
                try {
                    rest.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
                }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    ArrayList<Payment> paymentRetrieve(int userid) throws SQLException {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rest = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setInt(1, userid);
            rest = stmt.executeQuery();
            while(rest.next()) {
                int PaymentID = rest.getInt(1);
                int UserID = rest.getInt(2);
                int BookID = rest.getInt(3);
                int Numbers = rest.getInt(4);
                String Address = rest.getString(5);
                String Phone = rest.getString(6);
                String CreditCardNumber = rest.getString(7);
                String CreditCardPassword = rest.getString(8);
                payments.add(new Payment(PaymentID, UserID, BookID, Numbers, Address, Phone, CreditCardNumber, CreditCardPassword));
            }
            return payments;
        } catch(SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception : " + e.getMessage());
        } finally {
            if(rest!=null) {
                try {
                    rest.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
                }
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }    
    }
    void paymentAdd(int userid, int bookid, int numbers, String address, String phone, String creditcardnumber, String creditcardpassword) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rest = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rest = stmt.executeQuery();
            int ID = -1;
            rest.next();
            ID = rest.getInt("COUNT(PaymentID)");
            ID++;
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, ID);
            stmt.setInt(2, userid);
            stmt.setInt(3, bookid);
            stmt.setInt(4, numbers);
            stmt.setString(5, address);
            stmt.setString(6, phone);
            stmt.setString(7, creditcardnumber);
            stmt.setString(8, creditcardpassword);
            stmt.executeQuery();
        } catch(SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } finally {
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }  
    }
}


