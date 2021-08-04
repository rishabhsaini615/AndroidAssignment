package com.example.assignmentsql;

public class StudentDataModel {

    private String name;
    private String dob;
    private String contact;

    public String getName() {
        return "Name: "+ name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return "Date of Birth :" + dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContact() {
        return "Contact Number: " + contact;
    }


    public void setAddress(String address) {
        this.contact = address;
    }
}
