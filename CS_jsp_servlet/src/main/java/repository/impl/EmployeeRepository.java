package repository.impl;

import model.Employee;
import repository.IEmployeeRepository;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FIND_ALL = "select * from employee";
    private static final String INSERT = "insert into employee(name, date_of_birth,id_card, salary, phone_number,email," +
            "address, position_id, education_degree_id, division_id)\n" +
            "values(?,?,?,?,?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select * from employee where id=? ";
    private static final String UPDATE = "update employee set name=?,date_of_birth=?,id_card=?,salary=?,phone_number=?" +
            "email=?,address=?,position_id=?,education_degree_id=?,division_id=? where id= ?;";
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public boolean create(Employee employee) {
        return false;
    }

    @Override
    public boolean edit(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(int idDelete) {
        return false;
    }

    @Override
    public Employee findById(int idFind) {
        return null;
    }

    @Override
    public List<Employee> search(String nameSearch, String addressSearch, String phoneSearch) {
        return null;
    }
}
