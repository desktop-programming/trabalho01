package Model;


public class Report {
    String item;
    int quantity;
    int id;
    
    public Report(String name, int quantity, int id){
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
