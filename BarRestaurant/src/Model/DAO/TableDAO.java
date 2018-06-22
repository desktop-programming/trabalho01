/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Interfaces.ImplementTable;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import DataBase.DataBaseGeneric;
import Model.Menu;
import Model.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableDAO extends DataBaseGeneric implements ImplementTable{
    
    public TableDAO(){
        super(new ConfigurationsMySQL(), "tables");
    }
    
    private List<Table> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void delete(int id) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapCondition = new HashMap<>();
        mapCondition.put("table_id", id);
        mapObj.put("order_id", 0);
        this.genericUpdate(mapObj, mapCondition);
        mapObj.clear();
        mapObj.put("order_isFinished", 1);
        this.genericUpdate(mapObj, mapCondition, "orders");
    }
    
    @Override
    public List<Table> getTable(int number) {
        list = new ArrayList<Table>();
        try {
            ResultSet rs = this.getOne(number);
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
  @Override
    public List<Table> getAllTable() {
        list = new ArrayList<Table>();
        try {
            ResultSet rs = this.getAll();
            while (rs.next()) { 
                Table table = new Table(rs.getInt("table_id"), rs.getInt("order_id"));
                list.add(table);
            }
            
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter todas as mesas: " + ex.getMessage());
        }
        return null;
    }
    
    public Menu getMenu(int id){
        return new MenuDAO().getMenu(id);
    }
}

