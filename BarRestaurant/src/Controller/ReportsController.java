
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
    private List<Report> list;
    
    public ReportsController(FrameReports panel) {
        this.panel = panel;
        implementReport = new ReportDAO();
        list = implementReport.getAllStorage();
    }
    
    public void reset(){
    }
    
    /*public void setTabel(){
        list = implementStorage.getAllStorage();
        panel.getTabelStorage().setModel(new TabelModelStorage(list));
    }*/
    
    /*public  void getDataField(){
        int row = panel.getTabelStorage().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }*/
    
    public void insert(){
        Report storage = new Report(panel.getTextItem(),Integer.parseInt(panel.getTextQuantity()),Integer.parseInt(panel.getTextId()));
        implementStorage.insert(storage);
    }

    public void update(){
        Report storage = new Report(panel.getTextItem(),Integer.parseInt(panel.getTextQuantity()),Integer.parseInt(panel.getTextId()));
        implementStorage.update(storage);
    }
    
    public void delete(){
        if (panel.getTextId().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTextId());
        implementStorage.delete(row);
    }
    
    public void getData(){
        if (panel.getTextItem().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um item para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTextItem();
        implementStorage.getStorage(name);
       // this.filterTable(name);
    }
    public List<Order> getAllOrders(){
        return implementReport.getAllOrders();
    }
    
    public double getProductPrice(int id){
        return implementReport.getMenu(id).getPrice();
    }

   /* public void filterTable(String name){
        list = implementStorage.getStorage(name);
        panel.getTabelStorage().setModel(new TabelModelStorage(list));
    }*/
}