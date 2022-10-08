package repository;

import dto.EmployeeDto;
import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeDto> findAll();

    boolean create(Employee employee);

    boolean edit(Employee employee);

    boolean delete(int idDelete);

    Employee findById(int idFind);

    List<EmployeeDto> search(String nameSearch,String addressSearch,String phoneSearch);


}
