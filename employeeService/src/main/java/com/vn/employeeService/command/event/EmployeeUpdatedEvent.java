package com.vn.employeeService.command.event;

public class EmployeeUpdatedEvent {

    private String id;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisliplined;

    public EmployeeUpdatedEvent() {
    }

    public EmployeeUpdatedEvent(String id, String firstName, String lastName, String kin, Boolean isDisliplined) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kin = kin;
        this.isDisliplined = isDisliplined;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getKin() {
        return kin;
    }

    public void setKin(String kin) {
        this.kin = kin;
    }

    public Boolean getDisliplined() {
        return isDisliplined;
    }

    public void setDisliplined(Boolean disliplined) {
        isDisliplined = disliplined;
    }
}
