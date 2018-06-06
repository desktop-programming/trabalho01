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

import Model.Card;
import java.util.List;

public interface ImplementCard{
    
    public void insert(Card card);
    
    public void update(Card card);
    
    public void delete(int id);
    
    public List<Card> getCard(String name);
    
    public List<Card> getAllCard();
}