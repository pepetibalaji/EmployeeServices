package employee.employeeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeForm {
    private Long id;
    private String name;
    private String address;
    private Double salary;
    private Long departmentId;

}
