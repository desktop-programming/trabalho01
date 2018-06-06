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

import Model.Storage;
import java.util.List;

public interface ImplementStorage{
    
    public void insert(Storage storage);
    
    public void update(Storage storage);
    
    public void delete(int id);
    
    public List<Storage> getStorage(String name);
    
    public List<Storage> getAllStorage();
}
