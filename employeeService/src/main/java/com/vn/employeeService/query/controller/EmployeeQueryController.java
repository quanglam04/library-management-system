package com.vn.employeeService.query.controller;


import com.vn.employeeService.command.data.Employee;
import com.vn.employeeService.query.model.EmployeeResponseModel;
import com.vn.employeeService.query.queries.GetAllEmployeeQuery;
import com.vn.employeeService.query.queries.GetDetailEmployeeQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@Tag(name = "Employee Query")
public class EmployeeQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @Operation(
            summary = "Get List Employee",
            description = "Get endpoint for employee with filter",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized / Invalid Token"
                    )
            }
    )
    @GetMapping
    public List<EmployeeResponseModel> getAllEmployees(@RequestParam(required = false,defaultValue = "false") Boolean isDisciplined) {
        return  queryGateway.query(new GetAllEmployeeQuery(isDisciplined), ResponseTypes.multipleInstancesOf(EmployeeResponseModel.class)).join();

    }


    @Operation(
            summary = "Get Employee by ID",
            description = "Get endpoint for specific employee ",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized / Invalid Token"
                    )
            }
    )
    @GetMapping("/{id}")
    public EmployeeResponseModel getEmployee(@PathVariable String id) {
        return queryGateway.query(new GetDetailEmployeeQuery(id),ResponseTypes.instanceOf(EmployeeResponseModel.class)).join();
    }

}
