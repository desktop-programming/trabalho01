package Model;

public class Table {
   int table;
   int card;
   double totalIndividual;
   double value;
   
   public Table(int table, int card, double totalIndividual){
       this.table = table;
       this.card = card;
       this.totalIndividual= totalIndividual;    
   }
   
   public int getTable(){
       return table;
   }
   
   public int getCard(){
       return card;
   } 
   
   public double getTotalIndividual(){
       return totalIndividual;
   }
   
   public double getValue(){
       return value;
   }

}
