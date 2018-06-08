/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Interfaces.ImplementTable;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Menu;
import Model.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDAO implements ImplementTable{
    
    private List<Table> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Table table) {
        this.db.execute("INSERT INTO tables (table_id) VALUES (?)", table.getId());
    }

    @Override
    public void update(Table table) {
       // this.db.execute("UPDATE tables SET id=? WHERE id=?", table.getName(), table.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM tables WHERE table_id=?", id);
    }
    

    @Override
    public List<Table> getTable(int number) {
        list = new ArrayList<Table>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM tables WHERE table_id = '" + number + "'");
            while (rs.next()) { 
                Table table = new Table(rs.getInt("table_id"), rs.getInt("order_id"));
                list.add(table);
            }
            
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter uma mesa: " + ex.getMessage());
        }
        return null;
    }


   /* @Override
    public List<Table> getAllTable() {
        list = new ArrayList<Table>();
        ResultSet rs = this.db.query("SELECT * FROM order");
        try {
            while(rs.next()){
                Table table = new Table(rs.getInt("table_id"), rs.getInt ("order_id"));
                list.add(table);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar todas as mesas: " + ex.getMessage());
        }
        return null;
    }*/
    
    public Menu getMenu(int id){
        try {
            ResultSet rs = this.db.query("SELECT * FROM product WHERE product_id '" + id + "'");
                Menu product = new Menu(rs.getString("product_item"), rs.getDouble("product_price"),
                        rs.getInt("product_id"));
                    
            return product;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um item do menu: " + ex.getMessage());
        }
        return null;
    }
}

