/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.MenuDAO;
import Model.Order;
import Model.DAO.OrderDAO;
import Model.Interfaces.ImplementMenu;
import Model.Interfaces.ImplementOrder;
import Model.Menu;
import View.FrameOrder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OrderController {
    private final FrameOrder panel;
    private final ImplementOrder implementOrder;
    private final ImplementMenu implementMenu;
    private List<Order> list;
    
    public OrderController(FrameOrder panel) {
        this.panel = panel;
        implementOrder = new OrderDAO();
        list = implementOrder.getAllOrder();
        implementMenu = new MenuDAO();
    }
    
    public void reset(){
      /*  panel.setTextId("");
        panel.setTextPrice("");
        panel.setTextItem("");
        //panel.getTabelOrder().clearSelection();
    */}
    
  /*  public void setTabel(){
        list = implementOrder.getAllOrder();
        panel.getTabelOrder().setModel(new TabelModelOrder(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelOrder().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }*/
    
    public void insert( Order order){     
        implementOrder.insert(order);
    }

    public void update(){
  
    }
    
    public List<Menu> getProductCategory(String category){
        return implementMenu.getProductCategory(category);
    }
    
    public List<Menu> getProduct(String name){
        return implementMenu.getProduct(name);
    }
    
    public void delete(){
    /*    if (panel.getTextId().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTextId());
        implementOrder.delete(row);*/
    }
     
     
    public void getData(){
        /*if (panel.getTextItem().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de item para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTextItem();
        implementOrder.getOrder(name);
       // this.filterTable(name);
        */
    }

    /*public void filterTable(String name){
        list = implementOrder.getOrder(name);
        panel.getTabelOrder().setModel(new TabelModelOrder(list));
    }*/
}