package Model;

public class Employee {
    String name;
    String address;
    int id;
    String phone;
    String username;
    String password;
    
    public Employee(int id, String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        id++;
    }
    
    public Employee(String name, String street, String number, String neighborhood, String city, String UF, String phone, String username, String password){
        this.name = name;
        this.address = ""+street+", "+number+", "+neighborhood+", "+city+", "+UF;
        this.phone = phone;
        this.username = username;
        this.password = password;
        id++;
    }
    
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public int getID(){
        return id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
