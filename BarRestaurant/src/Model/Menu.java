package Model;

public class Menu {
    String name, category;
    double price;
    int id;
    
    public Menu(String name, double price, int id, String category){
        this.name = name;
        this.price = price;
        this.id = id;
        this.category = category;
    }
    public Menu(){
        
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
