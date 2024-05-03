package ra.web.service;

import ra.web.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeService {
    private static final List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee(1,"Nguyễn Văn Ánh", LocalDate.of(1991,1,1),"Hà Nam",true));
        employees.add(new Employee(2,"Nguyễn Văn Ánh", LocalDate.of(1991,1,1),"Hà Nam",true));
        employees.add(new Employee(3,"Nguyễn Văn Ánh", LocalDate.of(1991,1,1),"Hà Nam",true));
    }
    public List<Employee> findAll() {
        return employees;
    }

    ;

    public Employee findById(Integer id) {
        return employees.stream().filter(em -> Objects.equals(em.getId(), id)).findFirst().orElse(null);
    }

    public boolean save(Employee employee) {
        if (employee.getId() != null) {
            // cât nhật
            employees.set(employees.indexOf(findById(employee.getId())), employee);
        } else {
            employee.setId(getNewId());
            employees.add(employee);
        }
        return true;
    }

    public void deleteById(Integer id) {
        employees.remove(findById(id));
    }

    private Integer getNewId() {
        return employees.stream().map(Employee::getId).max(Integer::compareTo).orElse(0)+1;
    }

}
