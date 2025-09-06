package employee.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import employee.employeeDto.DepartmentForm;
import employee.employeeDto.EmployeeForm;
import employee.entity.Employee;
import employee.globalExceptions.DataNotFoundException;
import employee.repository.EmployeeRepository;
import employee.response.Response;
import employee.utility.EmployeeObjectConverter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final EmployeeObjectConverter employeeObjectConverter;
    private final Response response;

    public Response getEmployeeById(Long id) throws DataNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeForm eform = employeeObjectConverter.employeeForm(optionalEmployee.get());
            response.setEmployeeForm(eform);
            DepartmentForm dform = restTemplate
                    .getForObject("http://department-services/department/getDepartment?dept_id="
                            + eform.getDepartmentId(), DepartmentForm.class);
            response.setDepartmentForm(dform);
            return response;
        } else {
            throw new DataNotFoundException("Employee not found");
        }
    }

    @Transactional
    public Employee saveEmployee(Employee entity) {
        return employeeRepository.save(entity);
    }

}
