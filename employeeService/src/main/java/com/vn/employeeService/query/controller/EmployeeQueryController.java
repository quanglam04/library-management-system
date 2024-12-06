package com.vn.employeeService.query.controller;


import com.vn.employeeService.command.data.Employee;
import com.vn.employeeService.query.model.EmployeeResponseModel;
import com.vn.employeeService.query.queries.GetAllEmployeeQuery;
import com.vn.employeeService.query.queries.GetDetailEmployeeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<EmployeeResponseModel> getAllEmployees(@RequestParam(required = false,defaultValue = "false") Boolean isDisciplined) {
        return  queryGateway.query(new GetAllEmployeeQuery(isDisciplined), ResponseTypes.multipleInstancesOf(EmployeeResponseModel.class)).join();

    }

    @GetMapping("/{id}")
    public EmployeeResponseModel getEmployee(@PathVariable String id) {
        return queryGateway.query(new GetDetailEmployeeQuery(id),ResponseTypes.instanceOf(EmployeeResponseModel.class)).join();
    }

}
