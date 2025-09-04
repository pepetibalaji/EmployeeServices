package employee.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import employee.entity.Employee;
import employee.globalExceptions.DataNotFoundException;
import employee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id) throws DataNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new DataNotFoundException("Employee not found");
        }
    }

    @Transactional
    public Employee saveEmployee(Employee entity) {
        return employeeRepository.save(entity);
    }

}
