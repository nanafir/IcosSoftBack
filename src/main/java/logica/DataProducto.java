package logica;

import java.util.*;

public class DataProducto {

    private int id_producto;
    private String nombre_producto;
    private Double valor_venta;
    private int stock;
    private Date fecha_expiracion;

    public DataProducto() {
    }

    public DataProducto(int id_producto, String nombre_producto, Double valor_venta, int stock, Date fecha_expiracion) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.valor_venta = valor_venta;
        this.stock = stock;
        this.fecha_expiracion = fecha_expiracion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    @Override
    public String toString() {
        return "DataProducto{" + "id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", valor_venta=" + valor_venta + ", stock=" + stock + ", fecha_expiracion=" + fecha_expiracion + '}';
    }
}
