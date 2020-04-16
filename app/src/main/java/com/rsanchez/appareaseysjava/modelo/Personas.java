package com.rsanchez.appareaseysjava.modelo;

public class Personas {

    private int id;
    private String nombre;
    private String apellido;
    private String avatar;
    private String email;


    public Personas(int id, String nombre, String apellido, String email, String avatar) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.avatar = avatar;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
