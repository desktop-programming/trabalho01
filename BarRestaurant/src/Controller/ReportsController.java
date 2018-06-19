
package Controller;

import Model.Report;
import Model.DAO.ReportDAO;
import View.FrameReports;
import java.util.List;
import javax.swing.JOptionPane;
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
    
    public double getProductPrice(int id){
        return implementReport.getMenu(id).getPrice();
    }
    
    public Menu getProduct(int id){
        return implementReport.getMenu(id);
    }
    
    public List<Order> getOrderItems(int id){
        return implementReport.getOrderItems(id);
    }

   /* public void filterTable(String name){
        list = implementStorage.getStorage(name);
        panel.getTabelStorage().setModel(new TabelModelStorage(list));
    }*/
}