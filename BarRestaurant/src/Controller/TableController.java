
package Controller;

import Model.Table;
import Model.DAO.TableDAO;
import Model.Interfaces.ImplementTable;
import Model.Table.TabelModelTable;
import View.TablePanelForm;
import java.util.List;
import javax.swing.JOptionPane;

public class TableController {
    private final TablePanelForm panel;
    private final ImplementTable implementTable;
    private List<Table> list;
    
    public TableController(TablePanelForm panel) {
        this.panel = panel;
        implementTable = new TableDAO();
        list = implementTable.getAllTable();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelTable().clearSelection();
    }
    
    public void setTabel(){
        list = implementTable.getAllTable();
        panel.getTabelTable().setModel(new TabelModelTable(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelTable().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Table table = new Table();
        table.setName(panel.getTxtName().getText());
        implementTable.insert(table);
    }

    public void update(){
        Table table = new Table();
        table.setId(Integer.parseInt(panel.getTxtId().getText()));
        table.setName(panel.getTxtName().getText());
        implementTable.update(table);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementTable.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementTable.getTable(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementTable.getTable(name);
        panel.getTabelTable().setModel(new TabelModelTable(list));
    }
}