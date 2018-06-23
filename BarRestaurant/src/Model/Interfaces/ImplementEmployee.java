/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

/**
 *
 * @author geovannemoro
 */

import Model.Employee;
import java.util.List;

public interface ImplementEmployee{
    
    public void insert(Employee employee);
    
    public void update(Employee employee);
    
    public void delete(int id);
    
    public List<Employee> getEmployee(String name);
    
    public List<Employee> getAllEmployee();
    
    public String getLogin(String user, String pass);
}