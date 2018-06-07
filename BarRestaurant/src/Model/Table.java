package Model;

public class Table {
   int id;
   double total;
   
   public Table(int number, double total){
       this.id = number;
       this.total = total;    
   }
   
   public Table(int number){
       this.id = number;
       this.total = 0;
   }
   
   public int getId(){
       return this.id;
   }
   
   public double getTotal(){
       return this.total;
   }
}
