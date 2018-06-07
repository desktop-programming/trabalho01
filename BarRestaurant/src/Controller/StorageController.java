
package Controller;

import Model.Storage;
import Model.DAO.StorageDAO;
import Model.Interfaces.ImplementStorage;
import View.FrameStorage;
import java.util.List;
import javax.swing.JOptionPane;

public class StorageController {
    private final FrameStorage panel;
    private final ImplementStorage implementStorage;
    private List<Storage> list;
    
    public StorageController(FrameStorage panel) {
        this.panel = panel;
        implementStorage = new StorageDAO();
        list = implementStorage.getAllStorage();
    }
    
    public void reset(){
        panel.setTextId("");
        panel.setTextItem("");
        panel.setTextQuantity("");
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
        Storage storage = new Storage(panel.getTextItem(),Integer.parseInt(panel.getTextQuantity()),Integer.parseInt(panel.getTextId()));
        implementStorage.insert(storage);
    }

    public void update(){
        Storage storage = new Storage(panel.getTextItem(),Integer.parseInt(panel.getTextQuantity()),Integer.parseInt(panel.getTextId()));
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

   /* public void filterTable(String name){
        list = implementStorage.getStorage(name);
        panel.getTabelStorage().setModel(new TabelModelStorage(list));
    }*/
}