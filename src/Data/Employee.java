package Data;
// Employee class is a subclass of Person class
public class Employee extends Person{
    private int empNo; // Employee number

    public Employee(String firstname, String lastname, String email, String address, int empNo) {
        super(firstname, lastname, email, address);
        this.empNo = empNo; // Set the employee number
    }
}
