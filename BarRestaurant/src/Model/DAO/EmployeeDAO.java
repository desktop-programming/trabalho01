/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DAO;

import Model.Interfaces.ImplementEmployee;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements ImplementEmployee{
    
    private List<Employee> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Employee employee) {
        this.db.execute("INSERT INTO java_employee (name) VALUES (?)", employee.getName());
    }

    @Override
    public void update(Employee employee) {
        this.db.execute("UPDATE java_employee SET name=? WHERE id=?", employee.getName(), employee.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM java_employee WHERE id=?", id);
    }

    @Override
    public List<Employee> getEmployee(String name) {
        list = new ArrayList<Employee>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM employee WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString("name"));
                list.add(employee);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        list = new ArrayList<Employee>();
        ResultSet rs = this.db.query("SELECT id, name FROM java_employee ORDER BY id");
        try {
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString("name"));
                list.add(employee);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
}

