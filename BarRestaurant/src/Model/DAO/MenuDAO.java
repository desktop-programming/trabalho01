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
        this.db.execute("INSERT INTO products (product_id, product_name, product_price, product_category) VALUES (?,?,?,?)", 
                menu.getID() ,menu.getName(), menu.getPrice(),menu.getCategory());
    }

    @Override
    public void update(Menu menu) {
        this.db.execute("UPDATE products SET product_name=?, product_price=?, product_category=? WHERE product_id=?", 
                menu.getName(), menu.getPrice(), menu.getCategory() ,menu.getID());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM products WHERE product_id=?", id);
    }

    @Override
    public List<Menu> getMenu(String name) {
     
        return null;
    }
    
    @Override
    public List<Menu> getProduct(String name){
        list = new ArrayList<Menu>();
        ResultSet rs = this.db.query("SELECT * FROM products WHERE product_name LIKE '"+name+"'");
        try {
            while(rs.next()){
                Menu menu = new Menu(rs.getString("product_name"), rs.getDouble("product_price"),
                        rs.getInt("product_id"),rs.getString("product_category"));
                list.add(menu);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar os items do menu: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Menu> getProductCategory(String category){
        list = new ArrayList<Menu>();
        ResultSet rs = this.db.query("SELECT * FROM products WHERE product_category LIKE '"+category+"'");
        try {
            while(rs.next()){
                Menu menu = new Menu(rs.getString("product_name"), rs.getDouble("product_price"),
                        rs.getInt("product_id"),rs.getString("product_category"));
                list.add(menu);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar os items do menu: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Menu> getAllMenu() {
        list = new ArrayList<Menu>();
        ResultSet rs = this.db.query("SELECT * FROM products ORDER BY product_id");
        try {
            while(rs.next()){
                Menu menu = new Menu(rs.getString("product_name"), rs.getDouble("product_price"),
                        rs.getInt("product_id"),rs.getString("product_category"));
                list.add(menu);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar os items do menu: " + ex.getMessage());
        }
        return null;
    }
    
    public Menu getMenu(int id){
        try {
            ResultSet rs = this.db.query("SELECT * FROM products WHERE product_id ='" + id + "'");
            rs.next();
                Menu product = new Menu(rs.getString("product_name"), rs.getDouble("product_price"),
                rs.getInt("product_id"), rs.getString("product_category"));
            return product;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um item do menu: " + ex.getMessage());
        }
        return null;
    }
}
