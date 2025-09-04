package employee.utility;

import org.springframework.stereotype.Component;

import employee.employeeDto.EmployeeForm;
import employee.entity.Employee;

@Component
public class EmployeeObjectConverter {

    public Employee employee(EmployeeForm entity) {
        return Employee.builder()
                .name(entity.getName())
                .address(entity.getAddress())
                .salary(entity.getSalary())
                .departmentId(entity.getDepartmentId())
                .build();
    }

    public EmployeeForm employeeForm(Employee entity) {
        return EmployeeForm.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .salary(entity.getSalary())
                .departmentId(entity.getDepartmentId())
                .build();
    }
}
