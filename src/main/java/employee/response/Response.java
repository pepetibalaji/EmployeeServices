package employee.response;

import org.springframework.stereotype.Component;

import employee.employeeDto.DepartmentForm;
import employee.employeeDto.EmployeeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Response {
    private DepartmentForm departmentForm;
    private EmployeeForm employeeForm;
}
