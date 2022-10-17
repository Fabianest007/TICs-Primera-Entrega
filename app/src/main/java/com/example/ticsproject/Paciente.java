package com.example.ticsproject;

import java.io.Serializable;

public class Paciente implements Serializable {
    private String nombres, apellido_materno, apellido_paterno, rut;

    public Paciente(String rut, String nombres, String apellido_paterno, String apellido_materno) {
        this.nombres = nombres;
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
