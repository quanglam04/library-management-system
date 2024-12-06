package com.vn.employeeService.command.event;

public class EmployeeDeleteEvent {
    private String id;
    public EmployeeDeleteEvent(String id) {
        this.id = id;
    }
    public EmployeeDeleteEvent() {}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
