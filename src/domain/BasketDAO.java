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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnectionPool;
public class BasketDAO {
    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT = "SELECT * FROM bookbasket where UserID=? and Validity = 1";
    private static final String GETID_STMT = "SELECT COUNT(BasketID) FROM bookbasket";
    private static final String ADD_STMT = "INSERT INTO bookbasket VALUES(?,?,?,?,1)";
    private static final String DELETE_STMT = "UPDATE bookbasket SET Validity = 2 WHERE UserID = ? AND BasketID = ?";
    private static final String CLEAN_STMT = "UPDATE bookbasket SET Validity = 2 WHERE UserID = ?";
    ArrayList<Basket> basketRetreve(int userid) throws SQLException {
        ArrayList<Basket> baskets = new ArrayList<Basket>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rest = null;
        
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setInt(1, userid);
            rest = stmt.executeQuery();
            while(rest.next()) {
                int BasketID = rest.getInt(1);
                int UserID = rest.getInt(2);
                int BookID = rest.getInt(3);
                int Numbers = rest.getInt(4);
                int Validity = rest.getInt(5);
                baskets.add(new Basket(BasketID, UserID, BookID, Numbers, Validity));
            }
            return baskets;
        } catch(SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } catch(Exception e) {
            throw new RuntimeException("Exception : " + e.getMessage());
        } finally {
            if(rest!=null) {
                try{
                    rest.close();
                }catch(SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(stmt!=null) {
                try{
                    stmt.close();
                }catch(SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(conn!=null) {
                try{
                    conn.close();
                }catch(Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    void basketAdd(int userid, int bookid, int numbers) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rest = null;
        
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rest = stmt.executeQuery();
            int ID = -1;
            rest.next();
            ID = rest.getInt("COUNT(BasketID)");
            ID++;
            stmt = conn.prepareStatement(ADD_STMT);
            stmt.setInt(1, ID);
            stmt.setInt(2, userid);
            stmt.setInt(3, bookid);
            stmt.setInt(4, numbers);
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } finally {
            if(stmt!=null) {
                try{
                    stmt.close();
                }catch(SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(conn!=null) {
                try{
                    conn.close();
                }catch(Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    
    void basketDelete(int userid, int basketid) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rest = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(DELETE_STMT);
            stmt.setInt(1, userid);
            stmt.setInt(2, basketid);
            stmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } finally {
            if(stmt!=null) {
                try{
                    stmt.close();
                } catch(SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch(Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    
    void basketClean(int userid) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rest = null;
         try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(CLEAN_STMT);
            stmt.setInt(1, userid);
            stmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } finally {
            if(stmt!=null) {
                try{
                    stmt.close();
                } catch(SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch(Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    
    }
}
