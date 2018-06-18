/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Report;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Interfaces.ImplementReport;
import Model.Menu;
import Model.Order;

public class ReportDAO implements ImplementReport{
    
    private List<Report> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Report storage) {
        this.db.execute("INSERT INTO storage (storage_item, storage_id, storage_quantity) VALUES (?,?,?)",
                storage.getName(), storage.getId(), storage.getQuantity());
    }

    @Override
    public void update(Report storage) {
        this.db.execute("UPDATE storage SET storage_quantity=? WHERE storage_id=?", storage.getQuantity(), storage.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM storage WHERE storage_id=?", id);
    }

    @Override
    public List<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<Order>();
        ResultSet rs = this.db.query("SELECT * FROM orders");
        try {
            while(rs.next()){
                Order order = new Order(rs.getInt("order_id"), rs.getInt("table_id"), rs.getInt("product_id"), rs.getInt("order_isFinished"), rs.getInt("product_quantity"));
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar todas as mesas: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public Menu getMenu(int id){
        try {
            ResultSet rs = this.db.query("SELECT * FROM product WHERE product_id '" + id + "'");
                Menu product = new Menu(rs.getString("product_item"), rs.getDouble("product_price"),
                        rs.getInt("product_id"), rs.getString("product_category"));
                    
            return product;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um item do menu: " + ex.getMessage());
        }
        return null;
    }
}

