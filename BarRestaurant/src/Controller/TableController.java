
package Controller;

import Model.Table;
import Model.DAO.TableDAO;
import Model.Interfaces.ImplementTable;
import View.FrameTable;
import java.util.List;
import javax.swing.JOptionPane;

public class TableController {
    private final FrameTable panel;
    private final ImplementTable implementTable;
    private List<Table> list;
    
    public TableController(FrameTable panel) {
        this.panel = panel;
        implementTable = new TableDAO();
        list = implementTable.getAllTable();
    }
    
    public void reset(){
        panel.setIdText("");

    }
    
    /*public void setTabel(){
        list = implementTable.getAllTable();
        panel.getTabelTable().setModel(new TabelModelTable(list));
    }*/
    
    /*public  void getDataField(){
        int row = panel.getTabelTable().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }*/
    
    public void insert(){
        Table table = new Table(Integer.parseInt(panel.getIdText()));
        implementTable.insert(table);
    }

  /*  public void update(){
        Table table = new Table(Integer.parseInt(panel.getIdText()));
        table.setId(Integer.parseInt(panel.getTxtId().getText()));
        table.setName(panel.getTxtName().getText());
        implementTable.update(table);
    }*/
    
    public void delete(){
        if (panel.getIdText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getIdText());
        implementTable.delete(row);
    }
    
    public void getData(){
        if (panel.getIdText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um número de mesa para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        implementTable.getTable(Integer.parseInt(panel.getIdText()));
        //this.filterTable(name);
    }

    /*public void filterTable(String name){
        list = implementTable.getTable(name);
        panel.getTabelTable().setModel(new TabelModelTable(list));
    }*/
}