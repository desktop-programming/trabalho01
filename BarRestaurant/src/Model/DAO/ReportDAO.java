/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.util.List;
import Model.Interfaces.ImplementReport;
import Model.Menu;
import Model.Order;

public class ReportDAO implements ImplementReport{
   
    @Override
    public List<Order> getAllOrders() {
        return new OrderDAO().getAllOrder();
    }
    
    @Override
    public List<Order> getOrderItems(int order_id) {
        return new OrderDAO().getOrder(order_id);
    }
    
    @Override
    public Menu getMenu(int id){
        return new MenuDAO().getMenu(id);
    }
}

