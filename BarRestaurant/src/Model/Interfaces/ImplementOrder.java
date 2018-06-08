package Model.Interfaces;

import Model.Order;
import java.util.List;

public interface ImplementOrder{
    
    public void insert(Order order);
    
    public void update(Order order);
    
    public void delete(int id);
    
    public List<Order> getTableOrders(int number);
    
    public List<Order> getOrder(int number);
    
    public List<Order> getAllOrder();
}