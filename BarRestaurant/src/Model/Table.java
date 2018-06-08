package Model;

public class Table {
   int id;
   int order_id;
   
   public Table(int number, int order_id){
       this.id = number;
       this.order_id = order_id;    
   }
   
   public Table(int number){
       this.id = number;
       this.order_id = 0;
   }
   
   public int getId(){
       return this.id;
   }
   
   public double getOrderId(){
       return this.order_id;
   }
}
