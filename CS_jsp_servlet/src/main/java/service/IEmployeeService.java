package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    List<Employee> search(String name, String address, String phone);
}
