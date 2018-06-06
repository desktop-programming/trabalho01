/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DAO;

import Model.Interfaces.ImplementCard;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Card;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDAO implements ImplementCard{
    
    private List<Card> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Card card) {
        this.db.execute("INSERT INTO java_card (name) VALUES (?)", card.getName());
    }

    @Override
    public void update(Card card) {
        this.db.execute("UPDATE java_card SET name=? WHERE id=?", card.getName(), card.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM java_card WHERE id=?", id);
    }

    @Override
    public List<Card> getCard(String name) {
        list = new ArrayList<Card>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM java_card WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Card card = new Card();
                card.setId(rs.getInt(1));
                card.setName(rs.getString("name"));
                list.add(card);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Card> getAllCard() {
        list = new ArrayList<Card>();
        ResultSet rs = this.db.query("SELECT id, name FROM java_card ORDER BY id");
        try {
            while(rs.next()){
                Card card = new Card();
                card.setId(rs.getInt(1));
                card.setName(rs.getString("name"));
                list.add(card);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
}