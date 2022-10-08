package repository.impl;

import dto.EmployeeDto;
import model.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FIND_ALL = "select * from employee;";
    private static final String INSERT = "insert into employee(name, date_of_birth,id_card, salary, phone_number,email," +
            "address, position_id, education_degree_id, division_id)\n" +
            "values(?,?,?,?,?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select * from employee where id=? and is_delete=0; ";
    private static final String UPDATE = "update employee set name=?,date_of_birth=?,id_card=?,salary=?,phone_number=?" +
            "email=?,address=?,position_id=?,education_degree_id=?,division_id=? where id=?and is_delete=0;";
    private static final String DELETE = "update employee set is_delete=1 where id=? and is_delete=0; ";
    private static final String SEARCH = "select * from employee where is_delete=0 and name like ? and address like ? and" +
            "phone_number like ?; ";
    @Override
    public List<EmployeeDto> findAll() {
        List<EmployeeDto> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int employeeId = resultSet.getInt("id");
                String employeeName = resultSet.getString("name");
                String employeeBirthday = resultSet.getString("date_of_birth");
                String employeeIdCard = resultSet.getString("id_card");
                double employeeSalary = resultSet.getDouble("salary");
                String employeeNumberPhone = resultSet.getString("phone_number");
                String employeeEmail = resultSet.getString("email");
                String employeeAddress = resultSet.getString("address");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_name");
                String divisionName = resultSet.getString("division_name");

                EmployeeDto employee = new EmployeeDto(employeeId,employeeName,employeeBirthday,employeeIdCard,
                        employeeSalary,employeeNumberPhone,employeeEmail,employeeAddress,positionName,divisionName,educationDegreeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean create(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeeNumberPhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());

            int num = preparedStatement.executeUpdate();
            return (num == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Employee employee) {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeeNumberPhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setInt(11, employee.getEmployeeId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    @Override
    public boolean delete(int idDelete) {
        boolean rowDelete = false;
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, idDelete);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDelete;
    }

    @Override
    public Employee findById(int idFind) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, idFind);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String employeeName = resultSet.getString("name");
                String employeeBirthday = resultSet.getString("date_of_birth");
                String employeeIdCard = resultSet.getString("id_card");
                double employeeSalary = resultSet.getInt("salary");
                String employeePhone = resultSet.getString("phone_number");
                String employeeEmail = resultSet.getString("email");
                String employeeAddress = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");

                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<EmployeeDto> search(String nameSearch, String addressSearch, String phoneSearch) {
        List<EmployeeDto> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + nameSearch + "%");
            preparedStatement.setString(2, "%" + addressSearch + "%");
            preparedStatement.setString(3, "%" + phoneSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String employeeName = resultSet.getString("name");
                String employeeBirthday = resultSet.getString("date_of_birth");
                String employeeIdCard = resultSet.getString("id_card");
                double employeeSalary = resultSet.getInt("salary");
                String employeePhone = resultSet.getString("phone_number");
                String employeeEmail = resultSet.getString("email");
                String employeeAddress = resultSet.getString("address");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");

                EmployeeDto employee = new EmployeeDto(employeeId, employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress, positionName, educationDegreeName,
                        divisionName);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}
