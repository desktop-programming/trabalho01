/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Interfaces.ImplementTable;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
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
        this.db.execute("INSERT INTO java_table (name) VALUES (?)", table.getName());
    }

    @Override
    public void update(Table table) {
        this.db.execute("UPDATE java_table SET name=? WHERE id=?", table.getName(), table.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM java_table WHERE id=?", id);
    }

    @Override
    public List<Table> getTable(String name) {
        list = new ArrayList<Table>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM java_table WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Table table = new Table();
                table.setId(rs.getInt(1));
                table.setName(rs.getString("name"));
                list.add(table);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Table> getAllTable() {
        list = new ArrayList<Table>();
        ResultSet rs = this.db.query("SELECT id, name FROM java_table ORDER BY id");
        try {
            while(rs.next()){
                Table table = new Table();
                table.setId(rs.getInt(1));
                table.setName(rs.getString("name"));
                list.add(table);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
}

