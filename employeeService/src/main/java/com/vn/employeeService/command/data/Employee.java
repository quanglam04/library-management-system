package com.vn.employeeService.command.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String kin, Boolean isDiscipline) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kin = kin;
        this.isDisciplined = isDiscipline;
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

    public Boolean getIsDisciplined() {
        return isDisciplined;
    }

    public void setIsDisciplined(Boolean discipline) {
        isDisciplined = discipline;
    }
}
