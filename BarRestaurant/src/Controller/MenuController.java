
package Controller;

import Model.Menu;
import Model.DAO.MenuDAO;
import Model.Interfaces.ImplementMenu;
import View.FrameMenu;
import java.util.List;
import javax.swing.JOptionPane;

public class MenuController {
    private final FrameMenu panel;
    private final ImplementMenu implementMenu;
    private List<Menu> list;
    
    public MenuController(FrameMenu panel) {
        this.panel = panel;
        implementMenu = new MenuDAO();
        list = implementMenu.getAllMenu();
    }
    
    public void reset(){
        panel.setTextId("");
        panel.setTextPrice("");
        panel.setTextItem("");
        //panel.getTabelMenu().clearSelection();
    }
    
  /*  public void setTabel(){
        list = implementMenu.getAllMenu();
        panel.getTabelMenu().setModel(new TabelModelMenu(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelMenu().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }*/
    
    public void insert(){
        Menu menu = new Menu(panel.getTextItem(),
        Double.parseDouble(panel.getTextPrice()),
        Integer.parseInt(panel.getTextId()));
        
        implementMenu.insert(menu);
    }

    public void update(){
        Menu menu = new Menu(panel.getTextItem(),
        Double.parseDouble(panel.getTextPrice()),
        Integer.parseInt(panel.getTextId()));
        implementMenu.update(menu);
    }
    
    public void delete(){
        if (panel.getTextId().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTextId());
        implementMenu.delete(row);
    }
    
    public void getData(){
        if (panel.getTextItem().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de item para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTextItem();
        implementMenu.getMenu(name);
       // this.filterTable(name);
    }

    /*public void filterTable(String name){
        list = implementMenu.getMenu(name);
        panel.getTabelMenu().setModel(new TabelModelMenu(list));
    }*/
}