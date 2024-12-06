package com.vn.employeeService.command.event;


import com.vn.employeeService.command.data.Employee;
import com.vn.employeeService.command.data.EmployeeRepository;
import jakarta.ws.rs.NotFoundException;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeEventHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void on(EmployeeCreatedEvent event) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(EmployeeUpdatedEvent event) {
            Optional<Employee> employee = this.employeeRepository.findById(event.getId());
            Employee employee1 = employee.orElseThrow(() -> new NotFoundException("Employee not found"));
            employee1.setFirstName(event.getFirstName());
            employee1.setLastName(event.getLastName());
            employee1.setKin(event.getKin());
            employee1.setDiscipline(employee1.getDiscipline());
            employeeRepository.save(employee1);

    }
}
