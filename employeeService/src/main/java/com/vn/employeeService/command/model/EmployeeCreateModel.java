package com.vn.employeeService.command.model;

import jakarta.validation.constraints.NotBlank;

public class EmployeeCreateModel {

    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @NotBlank(message = "kin is mandatory")
    private String kin;

    public EmployeeCreateModel(String firstName, String lastName, String kin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.kin = kin;
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
}
