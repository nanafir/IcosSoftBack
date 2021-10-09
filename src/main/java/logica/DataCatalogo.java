package logica;

public class DataCatalogo {

    private int id_catalogo;
    private String nombre_parametros;
    private String valor_parametro;

    public DataCatalogo() {
    }

    public DataCatalogo(int id_catalogo, String nombre_parametros, String valor_parametro) {
        this.id_catalogo = id_catalogo;
        this.nombre_parametros = nombre_parametros;
        this.valor_parametro = valor_parametro;
    }

    public int getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(int id_catalogo) {
        this.id_catalogo = id_catalogo;
    }

    public String getNombre_parametros() {
        return nombre_parametros;
    }

    public void setNombre_parametros(String nombre_parametros) {
        this.nombre_parametros = nombre_parametros;
    }

    public String getValor_parametro() {
        return valor_parametro;
    }

    public void setValor_parametro(String valor_parametro) {
        this.valor_parametro = valor_parametro;
    }
     @Override
    public String toString() {
        return "DataCatalogo{" + "id_catalogo=" + id_catalogo + ", nombre_parametros=" + nombre_parametros + ", Valor_parametro=" + valor_parametro + '}';
    }
}
