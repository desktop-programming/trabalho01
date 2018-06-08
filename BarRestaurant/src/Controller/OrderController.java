/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Order;
import Model.DAO.OrderDAO;
import Model.Interfaces.ImplementOrder;
import View.FrameOrder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OrderController {
    private final FrameOrder panel;
    private final ImplementOrder implementOrder;
    private List<Order> list;
    
    public OrderController(FrameOrder panel) {
        this.panel = panel;
        implementOrder = new OrderDAO();
        list = implementOrder.getAllOrder();
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
    
    public void insert(){
        Order order = new Order(Integer.parseInt(panel.getTextOrder()),
        Integer.parseInt(panel.getTextTable()),
        panel.getTextCategory(), panel.getTextDescription(),
        Integer.parseInt(panel.getTextQuantity()),
        Double.parseDouble(panel.getTextValue()));
        
        implementOrder.insert(order);
    }

    public void update(){
        Order order = new Order(Integer.parseInt(panel.getTextOrder()),
        Integer.parseInt(panel.getTextTable()),
        panel.getTextCategory(), panel.getTextDescription(),
        Integer.parseInt(panel.getTextQuantity()),
        Double.parseDouble(panel.getTextValue()));
        
        implementOrder.update(order);
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