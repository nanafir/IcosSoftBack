/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Conexion;

/**
 *
 * @author nanaf
 */
public class DataUsuarios {

    private int id_Usuario;
    private String usuario;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo_electronico;
    private int rol;
    private int tipo_identificacion;
    private int catalogo;

    public DataUsuarios() {
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(int tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public int getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(int catalogo) {
        this.catalogo = catalogo;
    }

    public boolean guardarUsuario() {
        Conexion conexion = new Conexion();
        String sentencia = "INSERT INTO USUARIOS(id_Usuario, usuario, nombre, apellido, contraseña, correo_electronico, rol, tipo_identificacion, catalogo) VALUES ( ?,?,?,?,?,?,?,?,?)";
        return false;
      
    }

    @Override
    public String toString() {
        return "DataUsuarios{" + "id_Usuario=" + id_Usuario + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", contrase\u00f1a=" + contraseña + ", correo_electronico=" + correo_electronico + ", rol=" + rol + ", tipo_identificacion=" + tipo_identificacion + ", catalogo=" + catalogo + '}';
    }


    }
