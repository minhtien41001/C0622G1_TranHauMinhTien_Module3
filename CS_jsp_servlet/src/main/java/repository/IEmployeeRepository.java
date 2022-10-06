package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    boolean create(Employee employee);

    boolean edit(Employee employee);

    boolean delete(int idDelete);

    Employee findById(int idFind);

    List<Employee> search(String nameSearch,String addressSearch,String phoneSearch);


}
