/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;


/**
 *  
 * @author oswal
 */
public class Noticias {
    private int _id;
    private String Nombre;
    private String Titular;

    public void setId(int _id) {
        this._id = _id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public void setAutorId(int AutorId) {
        this.AutorId = AutorId;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public int getId() {
        return _id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTitular() {
        return Titular;
    }

    public Date getFecha() {
        return Fecha;
    }

    public int getAutorId() {
        return AutorId;
    }

    public String getContenido() {
        return Contenido;
    }
    private Date Fecha;
    private int AutorId;
    private String Contenido;
}
