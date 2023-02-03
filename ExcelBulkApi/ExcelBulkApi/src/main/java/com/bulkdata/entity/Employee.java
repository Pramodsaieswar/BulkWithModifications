package com.bulkdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private  int employeid;
    private  String employeeName;
    private  String employeeCabin;
    private  String designation;
    private  long phoneNumber;
    private  String branch;

    public Employee(int employeid, String employeeName, String employeeCabin, String designation, long phoneNumber, String branch) {
        this.employeid = employeid;
        this.employeeName = employeeName;
        this.employeeCabin = employeeCabin;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
        this.branch = branch;
    }

    public Employee() {
    }

    public int getEmployeid() {
        return employeid;
    }

    public void setEmployeid(int employeid) {
        this.employeid = employeid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCabin() {
        return employeeCabin;
    }

    public void setEmployeeCabin(String employeeCabin) {
        this.employeeCabin = employeeCabin;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


}
