package logica;

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

    public DataUsuarios(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public DataUsuarios(int id_Usuario, String usuario, String nombre, String apellido, String contraseña, String correo_electronico, int rol, int tipo_identificacion, int catalogo) {
        this.id_Usuario = id_Usuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.correo_electronico = correo_electronico;
        this.rol = rol;
        this.tipo_identificacion = tipo_identificacion;
        this.catalogo = catalogo;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    @Override
    public String toString() {
        return "DataUsuarios{" + "id_Usuario=" + id_Usuario + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", contrase\u00f1a=" + contraseña + ", correo_electronico=" + correo_electronico + ", rol=" + rol + ", tipo_identificacion=" + tipo_identificacion + ", catalogo=" + catalogo + '}';
    }

}
