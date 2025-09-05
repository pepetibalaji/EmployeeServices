package employee.conntroller;

import org.springframework.web.bind.annotation.RestController;

import employee.employeeDto.EmployeeForm;
import employee.entity.Employee;
import employee.globalExceptions.DataNotFoundException;
import employee.response.Response;
import employee.service.EmployeeServices;
import employee.utility.EmployeeObjectConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServices employeeServices;
    private final EmployeeObjectConverter employeeObjectConverter;

    @PostMapping("saveEmployee")
    public EmployeeForm saveEmployee(@RequestBody EmployeeForm entity) throws DataNotFoundException {
        Employee emp = employeeObjectConverter.employee(entity);
        employeeServices.saveEmployee(emp);
        return employeeObjectConverter.employeeForm(emp);
    }

    @GetMapping("getEmployee")
    public Response getEmployee(@RequestParam Long id) throws DataNotFoundException {
        return employeeServices.getEmployeeById(id);
    }

}
