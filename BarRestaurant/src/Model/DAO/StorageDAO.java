/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


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
        this.db.execute("INSERT INTO java_storage (name) VALUES (?)", storage.getName());
    }

    @Override
    public void update(Storage storage) {
        this.db.execute("UPDATE java_storage SET name=? WHERE id=?", storage.getName(), storage.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM java_storage WHERE id=?", id);
    }

    @Override
    public List<Storage> getStorage(String name) {
        list = new ArrayList<Storage>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM java_storage WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Storage storage = new Storage();
                storage.setId(rs.getInt(1));
                storage.setName(rs.getString("name"));
                list.add(storage);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Storage> getAllStorage() {
        list = new ArrayList<Storage>();
        ResultSet rs = this.db.query("SELECT id, name FROM java_storage ORDER BY id");
        try {
            while(rs.next()){
                Storage storage = new Storage();
                storage.setId(rs.getInt(1));
                storage.setName(rs.getString("name"));
                list.add(storage);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
}

