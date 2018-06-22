
package Controller;

import Model.DAO.ReportDAO;
import View.FrameReports;
import java.util.List;
import Model.Interfaces.ImplementReport;
import Model.Menu;
import Model.Order;

public class ReportsController {
    private final FrameReports panel;
    private final ImplementReport implementReport;

    
    public ReportsController(FrameReports panel) {
        this.panel = panel;
        implementReport = new ReportDAO();
    }

    public List<Order> getAllOrders(){
        return implementReport.getAllOrders();
    }
    
    public Menu getProduct(int id){
        return implementReport.getMenu(id);
    }
    
    public List<Order> getOrderItems(int id){
        return implementReport.getOrderItems(id);
    }
    
    public void disconnect(){
   
    }

   /* public void filterTable(String name){
        list = implementStorage.getStorage(name);
        panel.getTabelStorage().setModel(new TabelModelStorage(list));
    }*/
}