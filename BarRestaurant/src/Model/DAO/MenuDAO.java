/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DAO;

import Model.Interfaces.ImplementMenu;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO implements ImplementMenu{
    
    private List<Menu> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Menu menu) {
        this.db.execute("INSERT INTO java_menu (name) VALUES (?)", menu.getName());
    }

    @Override
    public void update(Menu menu) {
        this.db.execute("UPDATE java_menu SET name=? WHERE id=?", menu.getName(), menu.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM java_menu WHERE id=?", id);
    }

    @Override
    public List<Menu> getMenu(String name) {
        list = new ArrayList<Menu>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM java_menu WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Menu menu = new Menu();
                menu.setId(rs.getInt(1));
                menu.setName(rs.getString("name"));
                list.add(menu);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Menu> getAllMenu() {
        list = new ArrayList<Menu>();
        ResultSet rs = this.db.query("SELECT id, name FROM java_menu ORDER BY id");
        try {
            while(rs.next()){
                Menu menu = new Menu();
                menu.setId(rs.getInt(1));
                menu.setName(rs.getString("name"));
                list.add(menu);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
}
