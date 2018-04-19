package Model;

import java.util.ArrayList;

public class Card {
    ArrayList<Menu> items = new ArrayList<Menu>();
    
    int id;
    double value;
    
    public Card(int id, double value){
        this.id = id;
        this.value = value;
    }
    
    public int getID(){
        return id;
    }
    public double getValue(){
        return value;
    }
    
    public ArrayList getItems(){
        return items;
    }
}
