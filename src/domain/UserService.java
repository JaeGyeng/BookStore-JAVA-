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
import java.sql.Date;
public class UserService {
    private UserDAO userDataAccess;
    public UserService() {
        userDataAccess = new UserDAO();
    }
    public User getUser(String usertype, String username, String password) {
        User user = null;
        try {
            user = userDataAccess.userRetrieve(usertype, username, password);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }
    public void userCreate(String usertype, String username, String password, String sign, Date birthdate, String gender, String email, String phone, String address) {
        userDataAccess.userCreate(usertype, username, password, sign, birthdate, gender, email, phone, address);
    }
}
