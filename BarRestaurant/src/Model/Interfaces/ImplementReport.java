/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

/**
 *
 * @author geovannemoro
 */

import Model.Menu;
import Model.Order;
import Model.Report;
import java.util.List;

public interface ImplementReport{
    
    public void insert(Report storage);
    
    public void update(Report storage);
    
    public void delete(int id);
    
    public List<Order> getAllOrders();
    
    public Menu getMenu(int id);
}
