/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *  
 * @author oswal
 */
public class Noticias {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public Noticias(int _id, String Nombre, String Titular, int AutorId, String Contenido) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this._id = _id;
        this.Nombre = Nombre;
        this.Titular = Titular;
        this.AutorId = AutorId;
        this.Contenido = Contenido;
        setFechaCreado(timestamp);
        setFechaEditado(timestamp);
    }
    
    private int _id;
    private String Nombre;
    private String Titular;
    private Timestamp FechaCreado;
    private Timestamp FechaEditado;
    private int AutorId;
    private String Contenido;

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        setFechaEditado(timestamp);
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        setFechaEditado(timestamp);
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        setFechaEditado(timestamp);
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

    public int getAutorId() {
        return AutorId;
    }

    public String getContenido() {
        return Contenido;
    }

    public Timestamp getFechaCreado() {
        return FechaCreado;
    }

    private void setFechaCreado(Timestamp FechaCreado) {
        this.FechaCreado = FechaCreado;
    }

    public Timestamp getFechaEditado() {
        return FechaEditado;
    }

    private void setFechaEditado(Timestamp FechaEditado) {
        this.FechaEditado = FechaEditado;
    }

}
