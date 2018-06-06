
package Controller;

import Model.Menu;
import Model.DAO.MenuDAO;
import Model.Interfaces.ImplementMenu;
import Model.Table.TabelModelMenu;
import View.MenuPanelForm;
import java.util.List;
import javax.swing.JOptionPane;

public class MenuController {
    private final MenuPanelForm panel;
    private final ImplementMenu implementMenu;
    private List<Menu> list;
    
    public MenuController(MenuPanelForm panel) {
        this.panel = panel;
        implementMenu = new MenuDAO();
        list = implementMenu.getAllMenu();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelMenu().clearSelection();
    }
    
    public void setTabel(){
        list = implementMenu.getAllMenu();
        panel.getTabelMenu().setModel(new TabelModelMenu(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelMenu().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Menu menu = new Menu();
        menu.setName(panel.getTxtName().getText());
        implementMenu.insert(menu);
    }

    public void update(){
        Menu menu = new Menu();
        menu.setId(Integer.parseInt(panel.getTxtId().getText()));
        menu.setName(panel.getTxtName().getText());
        implementMenu.update(menu);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementMenu.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementMenu.getMenu(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementMenu.getMenu(name);
        panel.getTabelMenu().setModel(new TabelModelMenu(list));
    }
}