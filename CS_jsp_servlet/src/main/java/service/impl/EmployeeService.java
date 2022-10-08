package service.impl;

import dto.EmployeeDto;
import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    @Override
    public List<EmployeeDto> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public boolean create(Employee employee) {
        return iEmployeeRepository.create(employee);
    }

    @Override
    public Employee findById(int idFind) {
        return iEmployeeRepository.findById(idFind);
    }

    @Override
    public boolean edit(Employee employee) {
        return iEmployeeRepository.edit(employee);
    }

    @Override
    public boolean delete(int idDelete) {
        return iEmployeeRepository.delete(idDelete);
    }

    @Override
    public List<EmployeeDto> search(String nameSearch, String addressSearch, String phoneSearch) {
        return iEmployeeRepository.search(nameSearch, addressSearch, phoneSearch);
    }
}
