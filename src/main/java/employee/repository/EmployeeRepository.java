package employee.repository;

import org.springframework.stereotype.Component;

import employee.entity.Employee;

@Component
public interface EmployeeRepository
        extends org.springframework.data.jpa.repository.JpaRepository<Employee, Long> {

}
