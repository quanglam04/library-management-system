package com.vn.employeeService.query.queries;

public class GetDetailEmployeeQuery {
    private String id;

    public GetDetailEmployeeQuery(String id) {
        this.id = id;
    }
    public GetDetailEmployeeQuery() {}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
