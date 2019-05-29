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
public class BasketService {
    private BasketDAO basketDataAccess;
    public BasketService() {
        basketDataAccess = new BasketDAO();
    }
    
    public ArrayList<Basket> getBasket(int userid) {
        ArrayList<Basket> baskets = null;
        try {
            baskets = basketDataAccess.basketRetreve(userid);
        } catch (Exception e) {
            baskets =null;
        }
        return baskets;
    }
    
    public void addBasket(int userid, int bookid, int numbers) {
        basketDataAccess.basketAdd(userid, bookid, numbers);
    }
    
    public void deleteBasket(int userid, int bookid) {
        basketDataAccess.basketDelete(userid, bookid);
    }
    
    public void cleanBasket(int userid) {
        basketDataAccess.basketClean(userid);
    }
}
