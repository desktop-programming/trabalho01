
package Controller;

import Model.Employee;
import Model.DAO.EmployeeDAO;
import Model.Interfaces.ImplementEmployee;
//import Model.Table.TabelModelEmployee;
import View.FrameEmployee;
import java.util.List;

public class EmployeeController {
    private final FrameEmployee panel;
    private final ImplementEmployee implementEmployee;
    private List<Employee> list;
    
    public EmployeeController(FrameEmployee panel) {
        this.panel = panel;
        implementEmployee = new EmployeeDAO();
        list = implementEmployee.getAllEmployee();
    }
    public EmployeeController(){
        this.panel = null;
        implementEmployee = new EmployeeDAO();
    }
    
    public void reset(){
        panel.setTextNumber("");
        panel.setTextName("");
        panel.setTextCity("");
        panel.setTextId("");
        panel.setTextNeighborhood("");
        panel.setTextPhone("");
        panel.setTextZipcode("");
        panel.setTextUF("");
        panel.setTextStreet("");
        panel.setTextUsername("");
        panel.setTextPassword("");

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
    
    public void delete(int id){
        implementEmployee.delete(id);
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
    
    public List<Employee> getAllEmployee(){
        return implementEmployee.getAllEmployee();
    }

    public String getLogin(String user, String pass){
        return implementEmployee.getLogin(user,pass);
    }

}