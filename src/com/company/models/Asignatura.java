package com.company.models;

public class Asignatura {
    private String nombreAsignatura;
    private String gradoAsignatura;

    public void setGradoAsignatura(String gradoAsignatura) {
        this.gradoAsignatura = gradoAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getGradoAsignatura() {
        return gradoAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
}
