
package Controller;

import Model.Employee;
import Model.DAO.EmployeeDAO;
import Model.Interfaces.ImplementEmployee;
import Model.Table.TabelModelEmployee;
import View.EmployeePanelForm;
import java.util.List;
import javax.swing.JOptionPane;

public class EmployeeController {
    private final EmployeePanelForm panel;
    private final ImplementEmployee implementEmployee;
    private List<Employee> list;
    
    public EmployeeController(EmployeePanelForm panel) {
        this.panel = panel;
        implementEmployee = new EmployeeDAO();
        list = implementEmployee.getAllEmployee();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelEmployee().clearSelection();
    }
    
    public void setTabel(){
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
    
    public void insert(){
        Employee employee = new Employee();
        employee.setName(panel.getTxtName().getText());
        implementEmployee.insert(employee);
    }

    public void update(){
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(panel.getTxtId().getText()));
        employee.setName(panel.getTxtName().getText());
        implementEmployee.update(employee);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementEmployee.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementEmployee.getEmployee(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementEmployee.getEmployee(name);
        panel.getTabelEmployee().setModel(new TabelModelEmployee(list));
    }
}