package com.vn.employeeService.command.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateEmployeeModel {

    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @NotBlank(message = "kin is mandatory")
    private String kin;
    @NotNull(message = "isDisciplined is mandatory")
    private Boolean isDisciplined;

    public UpdateEmployeeModel() {
    }

    public UpdateEmployeeModel(String firstName, String lastName, String kin, Boolean isDisciplined) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.kin = kin;
        this.isDisciplined = isDisciplined;
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

    public Boolean getIsDisciplined() {
        return isDisciplined;
    }

    public void setIsDisciplined(Boolean isDisciplined) {
        isDisciplined = isDisciplined;
    }
}
