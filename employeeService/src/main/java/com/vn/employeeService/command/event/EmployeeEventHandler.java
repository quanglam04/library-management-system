package com.vn.employeeService.command.event;


import com.vn.employeeService.command.data.Employee;
import com.vn.employeeService.command.data.EmployeeRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.DisallowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Slf4j
@Component
public class EmployeeEventHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    @DisallowReplay
    public void on(EmployeeCreatedEvent event) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    @DisallowReplay
    public void on(EmployeeUpdatedEvent event) throws Exception {
            Optional<Employee> employee = this.employeeRepository.findById(event.getId());
            Employee employee1 = employee.orElseThrow(() -> new Exception("Employee not found"));
            employee1.setFirstName(event.getFirstName());
            employee1.setLastName(event.getLastName());
            employee1.setKin(event.getKin());
            employee1.setIsDisciplined(employee1.getIsDisciplined());
            employeeRepository.save(employee1);

    }

    @EventHandler
    @DisallowReplay
    public void on(EmployeeDeleteEvent event) {
        try{
            Optional<Employee> employee = this.employeeRepository.findById(event.getId());
            Employee employee1 = employee.orElseThrow(() -> new Exception("Employee not found"));
            employeeRepository.delete(employee1);
        }
        catch (Exception error){
            log.error(error.getMessage());
        }

    }
}
