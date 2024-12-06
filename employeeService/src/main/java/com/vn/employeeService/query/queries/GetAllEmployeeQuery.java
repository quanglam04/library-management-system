package com.vn.employeeService.query.queries;

public class GetAllEmployeeQuery {

    private Boolean isDisciplined;

    public GetAllEmployeeQuery(Boolean isDisciplined) {
        this.isDisciplined = isDisciplined;
    }
    public GetAllEmployeeQuery() {}
    public Boolean getIsDisciplined() {
        return isDisciplined;
    }
    public void setIsDisciplined(Boolean isDisciplined) {
        this.isDisciplined = isDisciplined;
    }
}
