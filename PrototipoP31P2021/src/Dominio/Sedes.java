/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author OtakuGT
 */
public class Sedes {
    String codigo_sede;
    String nombre_sede;
    String estatus_sede;

    public Sedes() {
    }

    public String getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public String getEstatus_sede() {
        return estatus_sede;
    }

    public void setEstatus_sede(String estatus_sede) {
        this.estatus_sede = estatus_sede;
    }

    public Sedes(String codigo_sede, String nombre_sede, String estatus_sede) {
        this.codigo_sede = codigo_sede;
        this.nombre_sede = nombre_sede;
        this.estatus_sede = estatus_sede;
    }

    @Override
    public String toString() {
        return "Sedes{" + "codigo_sede=" + codigo_sede + ", nombre_sede=" + nombre_sede + ", estatus_sede=" + estatus_sede + '}';
    }
}
