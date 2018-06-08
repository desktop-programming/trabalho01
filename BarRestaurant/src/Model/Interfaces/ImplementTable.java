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

import Model.Table;
import java.util.List;

public interface ImplementTable{
    
    public void insert(Table table);
    
    public void update(Table table);
    
    public void delete(int id);
    
    public List<Table> getTable(int number);
 
}
