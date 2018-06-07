package Model;


public class Storage {
    String item;
    int quantity;
    int id;
    
    public Storage(String name, int quantity, int id){
        this.item = name;
        this.quantity = quantity;
        this.id = id;
    }

   
    public String getName(){
        return item;
    }
    public int getQuantity(){
        return quantity;
    }

    public int getId(){
        return id;
    }
}
