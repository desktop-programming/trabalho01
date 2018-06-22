package Model.DAO;

import Model.Interfaces.ImplementOrder;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import DataBase.DataBaseGeneric;
import Model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAO extends DataBaseGeneric implements ImplementOrder{
    
    private List<Order> list;
    
    public OrderDAO(){
        super(new ConfigurationsMySQL(), "orders");
    }
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Order order) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("order_id", order.getOrderId());
        mapObj.put("order_isFinished", order.orderIsFinished());
        mapObj.put("table_id", order.getTableId());
        mapObj.put("product_quantity", order.getProductQuantity());
        mapObj.put("product_id", order.getItemId());
        this.genericInsert(mapObj);

        mapObj.clear();
        //this.db.execute("INSERT INTO orders (order_id, order_isFinished, table_id, product_quantity, product_id) VALUES (?,?,?,?,?)", 
        //            order.getOrderId(), order.orderIsFinished(), order.getTableId(), order.getProductQuantity(), order.getItemId());
        //this.db.execute("UPDATE tables SET order_id = ? WHERE table_id=?",order.getOrderId(), order.getTableId());
        
    }

    @Override
    public void update(Order order) {
       //this.db.execute("UPDATE orders SET id=? WHERE id=?", order.getName(), order.getId());
    }

    @Override
    public void delete(int id) {
      
    }
    

    @Override
    public List<Order> getOrder(int number) {
        list = new ArrayList<Order>();
        try {
            ResultSet rs = this.getOne(number);
            while (rs.next()) { 
                Order order = new Order(rs.getInt("order_id"), rs.getInt("table_id"), rs.getInt("product_id"), rs.getInt("order_isFinished"),rs.getInt("product_quantity"));
                list.add(order);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter uma mesa: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Order> getTableOrders(int number) {
        list = new ArrayList<Order>();
        ResultSet rs = this.db.query("SELECT * FROM orders WHERE table_id = '"+number+"' AND"
        +" order_isFinished = 0");
       try{
            while(rs.next()){
                Order order = new Order(rs.getInt("order_id"), rs.getInt("table_id"), rs.getInt("product_id"), rs.getInt("order_isFinished"), rs.getInt("product_quantity"));
                list.add(order);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar todos os pedidos: " + ex.getMessage());
        }

        return null;
    }
    
    @Override
    public List<Order> getAllOrder() {
        list = new ArrayList<Order>();
        ResultSet rs = this.db.query("SELECT * FROM orders");
        try {
            while(rs.next()){
                Order order = new Order(rs.getInt("order_id"), rs.getInt("table_id"), rs.getInt("product_id"), rs.getInt("order_isFinished"), rs.getInt("product_quantity"));
                list.add(order);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar todos os pedidos: " + ex.getMessage());
        }

        return null;
    }
}

