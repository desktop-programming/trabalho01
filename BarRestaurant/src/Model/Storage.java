package Model;


public class Storage {
    String name;
    int quantity;
    int id;
    
    public Storage(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
        id++;
    }
    
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }

    public int getID(){
        return id;
    }
}
