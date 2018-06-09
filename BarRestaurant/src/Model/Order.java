package Model;

public class Order{
    int order_id;
    int table_id;
    int item_id;
    int order_isFinished;
    int product_quantity;
   
    public Order(int order_id, int table_id, int item_id, int order_isFinished, int product_quantity){
        this.order_id = order_id;
        this.table_id = table_id;
        this.item_id = item_id;
        this.order_isFinished = order_isFinished;
        this.product_quantity = product_quantity;
}
public Order(int order_id, int table_id, int item_id){
        this.order_id = order_id;
        this.table_id = table_id;
        this.item_id = item_id;
        this.order_isFinished = 0;
}

    public Order() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getOrderId(){
        return order_id;
    }
    public int getTableId(){
        return table_id;
    }
    public int getItemId(){
        return item_id;
    }  
    public int getProductQuantity(){
        return product_quantity;
    }  
    
    public boolean orderIsFinished(){
        return order_isFinished==1;
    }
    

}
