
package Controller;

import Model.Card;
import Model.DAO.CardDAO;
import Model.Interfaces.ImplementCard;
import Model.Table.TabelModelCard;
import View.CardPanelForm;
import java.util.List;
import javax.swing.JOptionPane;

public class CardController {
    private final CardPanelForm panel;
    private final ImplementCard implementCard;
    private List<Card> list;
    
    public CardController(CardPanelForm panel) {
        this.panel = panel;
        implementCard = new CardDAO();
        list = implementCard.getAllCard();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelCard().clearSelection();
    }
    
    public void setTabel(){
        list = implementCard.getAllCard();
        panel.getTabelCard().setModel(new TabelModelCard(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelCard().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Card card = new Card();
        card.setName(panel.getTxtName().getText());
        implementCard.insert(card);
    }

    public void update(){
        Card card = new Card();
        card.setId(Integer.parseInt(panel.getTxtId().getText()));
        card.setName(panel.getTxtName().getText());
        implementCard.update(card);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementCard.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementCard.getCard(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementCard.getCard(name);
        panel.getTabelCard().setModel(new TabelModelCard(list));
    }
}