package com.testdeploy.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="beneficiaries")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cedula;

    @Column(nullable=false)
    private String name;

    @Column(nullable = false)
    private int age;

    private String condition;

    public Beneficiary(String name, int age, String condition, String cedula) {
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.cedula = cedula;
    }

    public Beneficiary(){

    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
