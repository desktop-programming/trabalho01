/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DAO;

import Model.Interfaces.ImplementEmployee;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import DataBase.DataBaseGeneric;
import Model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAO extends DataBaseGeneric implements ImplementEmployee{
    
    public EmployeeDAO(){
        super(new ConfigurationsMySQL(), "employees");
    }
    
    private List<Employee> list;
            
    @Override
    public void insert(Employee employee) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("employee_id", employee.getID());
        mapObj.put("employee_name", employee.getName());
        mapObj.put("employee_address", employee.getAddress());
        mapObj.put("employee_phone", employee.getPhone());
        mapObj.put("employee_username", employee.getUsername());
        mapObj.put("employee_password", employee.getPassword());
        this.genericInsert(mapObj);     
//this.db.execute("INSERT INTO java_employee (name) VALUES (?)", employee.getName());
    }

    @Override
    public void update(Employee employee) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapCondition = new HashMap<>();
        mapCondition.put("employee_id", employee.getID());
        mapObj.put("employee_name", employee.getName());
        mapObj.put("employee_address", employee.getAddress());
        mapObj.put("employee_phone", employee.getPhone());
        mapObj.put("employee_username", employee.getUsername());
        mapObj.put("employee_password", employee.getPassword());
        this.genericUpdate(mapObj, mapCondition);
        //this.db.execute("UPDATE java_employee SET name=? WHERE id=?", employee.getName(), employee.getID());
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("employee_id", id);
        this.genericDelete(mapObj);        
    //this.db.execute("DELETE FROM java_employee WHERE id=?", id);
    }

    @Override
    public List<Employee> getEmployee(String name) {
    /*    list = new ArrayList<Employee>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM employees WHERE employee_name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Employee employee = new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("employee_address"), rs.getString("employee_phone"));
                list.add(employee);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um funcionario: " + ex.getMessage());
        }
        */
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        list = new ArrayList<Employee>();
        ResultSet rs = this.getAll();
        try {
            while (rs.next()) { 
                Employee employee = new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("employee_address"), rs.getString("employee_phone"));
                list.add(employee);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um funcionario pelo nome: " + ex.getMessage());
        }
        return null;
    }
    public String getLogin(String user, String pass){
        ResultSet rs = this.getLoginGeneric(user,pass);
        try {
            if (rs.next()) { 
                return rs.getString("employee_name");
            }
        } catch (SQLException ex) {
            System.out.println("Usuario nao encontrado " + ex.getMessage());
        }
        return null;
    }
}

