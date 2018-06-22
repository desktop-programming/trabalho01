
package Controller;

import Model.Employee;
import Model.DAO.EmployeeDAO;
import Model.Interfaces.ImplementEmployee;
//import Model.Table.TabelModelEmployee;
import View.FrameEmployee;
import java.util.List;
import javax.swing.JOptionPane;

public class EmployeeController {
    private final FrameEmployee panel;
    private final ImplementEmployee implementEmployee;
    private List<Employee> list;
    
    public EmployeeController(FrameEmployee panel) {
        this.panel = panel;
        implementEmployee = new EmployeeDAO();
        list = implementEmployee.getAllEmployee();
    }
    
    public void reset(){
        panel.setTextName("");
        panel.setTextCity("");
        panel.setTextId("");
        panel.setTextNeighborhood("");
        panel.setTextPhone("");
        panel.setTextZipcode("");
        panel.setTextUF("");
        panel.setTextStreet("");

        //panel.getTabelEmployee().clearSelection();
    }
    
    /*public void setTabel(){
        list = implementEmployee.getAllEmployee();
        panel.getTabelEmployee().setModel(new TabelModelEmployee(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelEmployee().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
*/
    
    public void insert(Employee employee){
        implementEmployee.insert(employee);
    }

    public void update(Employee employee){
        implementEmployee.update(employee);
    }
    
    public void delete(){
       /* if (panel.getTxtID().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementEmployee.delete(row); */
    }
    
    public List<Employee> getEmployee(String name){
        return implementEmployee.getEmployee(name);
    }

    public void filterTable(String name){
        /*list = implementEmployee.getEmployee(name);
        panel.getTabelEmployee().setModel(new TabelModelEmployee(list));
        */    
        }

}