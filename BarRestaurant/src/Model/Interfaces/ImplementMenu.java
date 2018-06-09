/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

/**
 *
 * @author geovannemoro
 */

import Model.Menu;
import java.util.List;

public interface ImplementMenu{
    
    public void insert(Menu menu);
    
    public void update(Menu menu);
    
    public void delete(int id);
    
    public List<Menu> getMenu(String name);
    
    public List<Menu> getProductCategory(String category);
    
    public List<Menu> getProduct(String name);
    
    public List<Menu> getAllMenu();
}
