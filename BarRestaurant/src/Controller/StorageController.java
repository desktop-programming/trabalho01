
package Controller;

import Model.Storage;
import Model.DAO.StorageDAO;
import Model.Interfaces.ImplementStorage;
import Model.Table.TabelModelStorage;
import View.StoragePanelForm;
import java.util.List;
import javax.swing.JOptionPane;

public class StorageController {
    private final StoragePanelForm panel;
    private final ImplementStorage implementStorage;
    private List<Storage> list;
    
    public StorageController(StoragePanelForm panel) {
        this.panel = panel;
        implementStorage = new StorageDAO();
        list = implementStorage.getAllStorage();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelStorage().clearSelection();
    }
    
    public void setTabel(){
        list = implementStorage.getAllStorage();
        panel.getTabelStorage().setModel(new TabelModelStorage(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelStorage().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Storage storage = new Storage();
        storage.setName(panel.getTxtName().getText());
        implementStorage.insert(storage);
    }

    public void update(){
        Storage storage = new Storage();
        storage.setId(Integer.parseInt(panel.getTxtId().getText()));
        storage.setName(panel.getTxtName().getText());
        implementStorage.update(storage);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementStorage.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementStorage.getStorage(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementStorage.getStorage(name);
        panel.getTabelStorage().setModel(new TabelModelStorage(list));
    }
}