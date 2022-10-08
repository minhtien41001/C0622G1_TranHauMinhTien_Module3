package service;

import dto.EmployeeDto;
import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> findAll();

    boolean create(Employee employee);

    Employee findById(int idFind);

    boolean edit(Employee employee);

    boolean delete(int idDelete);

    List<EmployeeDto> search(String nameSearch, String addressSearch, String phoneSearch);
}
