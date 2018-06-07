package Model;

public class Menu {
    String name;
    double price;
    int id;
    
    public Menu(String name, double price, int id){
        this.name = name;
        this.price = price;
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    public int getID(){
        return id;
    }  
}
