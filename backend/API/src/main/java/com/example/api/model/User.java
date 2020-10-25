package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Boolean procesado;

    public User() {
    }

    public User(String nombre, String apellido, Boolean procesado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.procesado = procesado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public Boolean getProcesado() {

        return procesado;
    }

    public void setProcesado(Boolean procesado) {

        this.procesado = procesado;
    }

    @Override
    public String toString() {
        return "{ id: " + id + ", nombre: " + nombre + ", apellido"
                + apellido + ", procesado: " + procesado + "}";
    }
}
