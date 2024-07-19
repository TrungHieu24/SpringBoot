package com.example.testmvc.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Birthday")
    private String birthday;

    @Column(name="Phone")
    private String phone;

    @Column(name="email")
    private String email;

    public Employee() {

    }
    public Employee(int id, String name, String birthday, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    public Employee(String name, String birthday, String phone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getBirthday() {return birthday;}
    public void setBirthday(String birthday) {this.birthday = birthday;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", birthday=" + birthday + ", phone="+ phone +" ,email=" + email + "]";
    }
}
