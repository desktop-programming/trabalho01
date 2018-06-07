/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Interfaces.ImplementStorage;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Storage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageDAO implements ImplementStorage{
    
    private List<Storage> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Storage storage) {
        this.db.execute("INSERT INTO storage (storage_item, storage_id, storage_quantity) VALUES (?,?,?)",
                storage.getName(), storage.getId(), storage.getQuantity());
    }

    @Override
    public void update(Storage storage) {
        this.db.execute("UPDATE storage SET storage_quantity=? WHERE storage_id=?", storage.getQuantity(), storage.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM storage WHERE storage_id=?", id);
    }

    @Override
    public List<Storage> getStorage(String name) {
        list = new ArrayList<Storage>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM storage WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Storage storage = new Storage(rs.getString("storage_name"), 
                        rs.getInt("storage_quantity"), rs.getInt("storage_id"));
                list.add(storage);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um item do estoque: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Storage> getAllStorage() {
        list = new ArrayList<Storage>();
        ResultSet rs = this.db.query("SELECT * FROM storage ORDER BY id");
        try {
            while(rs.next()){
                Storage storage = new Storage(rs.getString("storage_name"), 
                        rs.getInt("storage_quantity"), rs.getInt("storage_id"));
                list.add(storage);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar lista de itens: " + ex.getMessage());
        }
        return null;
    }
}

