package Model.DAO;

import Model.Interfaces.ImplementOrder;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Order;
import Model.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements ImplementOrder{
    
    private List<Order> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Order order) {
        this.db.execute("INSERT INTO orders (order_id) VALUES (?)", order.getOrderId());
    }

    @Override
    public void update(Order order) {
       //this.db.execute("UPDATE orders SET id=? WHERE id=?", order.getName(), order.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM orders WHERE order_id=?", id);
    }
    

    @Override
    public List<Order> getOrder(int number) {
        list = new ArrayList<Order>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM orders WHERE order_id = '" + number + "'");
            while (rs.next()) { 
                Order order = new Order(rs.getInt("order_id"), rs.getInt("table_id"), rs.getInt("item_id"), rs.getInt("order_isFinished"),rs.getInt("product_quantity"));
                list.add(order);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter uma mesa: " + ex.getMessage());
        }
        return null;
    }
    
    public List<Order> getTableOrders(int number) {
        list = new ArrayList<Order>();
        ResultSet rs = this.db.query("SELECT * FROM orders WHERE table_id = '"+number+"'");
       try{
            while(rs.next()){
                Order order = new Order(rs.getInt("order_id"), rs.getInt("table_id"), rs.getInt("product_id"), rs.getInt("order_isFinished"), rs.getInt("product_quantity"));
                list.add(order);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar todas os pedidos: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Order> getAllOrder() {
        list = new ArrayList<Order>();
        ResultSet rs = this.db.query("SELECT * FROM orders");
        try {
            while(rs.next()){
                Order order = new Order(rs.getInt("order_id"), rs.getInt("table_id"), rs.getInt("item_id"), rs.getInt("order_isFinished"), rs.getInt("product_quantity"));
                list.add(order);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar todas as mesas: " + ex.getMessage());
        }
        return null;
    }
}

