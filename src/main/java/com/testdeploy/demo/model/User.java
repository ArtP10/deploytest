package com.testdeploy.demo.model;

import jakarta.persistence.*;

@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    private String cedula;
    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "registered_by")
    private Beneficiary beneficiary;

    public User(String nombre, String correo, Beneficiary beneficiary, String cedula) {
        this.name = nombre;
        this.email = correo;
        this.beneficiary = beneficiary;
        this.cedula = cedula;
    }

    public User(){

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return name;
    }

    public Long getId(){
        return id;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
}
