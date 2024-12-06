package com.vn.employeeService.query.projection;

import com.vn.employeeService.command.data.Employee;
import com.vn.employeeService.command.data.EmployeeRepository;
import com.vn.employeeService.query.model.EmployeeResponseModel;
import com.vn.employeeService.query.queries.GetAllEmployeeQuery;
import com.vn.employeeService.query.queries.GetDetailEmployeeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {

    @Autowired
    private EmployeeRepository employeeRepository;

    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeeQuery getAllEmployeeQuery) {
        List<Employee> list = employeeRepository.findAllByIsDisciplined(getAllEmployeeQuery.getIsDisciplined());
        System.out.println(list.toString());
        return list.stream().map(employee -> {
            EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
            BeanUtils.copyProperties(employee, employeeResponseModel);
            return employeeResponseModel;
        }).toList();

    }

    @QueryHandler
    public EmployeeResponseModel handle(GetDetailEmployeeQuery getDetailEmployeeQuery) throws Exception {
        Employee e =  employeeRepository.findById(getDetailEmployeeQuery.getId()).orElseThrow(() -> new Exception("Employee not found"));
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        BeanUtils.copyProperties(e, employeeResponseModel);
        return employeeResponseModel;

    }
}
