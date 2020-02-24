/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author oswal
 */
public class Noticias {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public Noticias() {

    }

    public Noticias(int id, String Nombre, String Titular, String Autor, String Contenido) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.id = id;
        this.Nombre = Nombre;
        this.Titular = Titular;
        this.Autor = Autor;
        this.Contenido = Contenido;
        setFechaCreado(timestamp);
        setFechaEditado(timestamp);
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    private int id;

    public void setId(int id) {
        this.id = id;
    }
    private String Nombre;
    private String Titular;
    private Timestamp FechaCreado;

    public static SimpleDateFormat getSdf() {
        return sdf;
    }
    private Timestamp FechaEditado;
    private String Autor;
    private String Contenido;

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        setFechaEditado(timestamp);
        setFechaCreado(timestamp);
        

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
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTitular() {
        return Titular;
    }

    public String getAutor() {
        return Autor;
    }

    public String getContenido() {
        return Contenido;
    }

    public Timestamp getFechaCreado() {
        return FechaCreado;
    }

    public void setFechaCreado(Timestamp FechaCreado) {
        this.FechaCreado = FechaCreado;
    }

    public Timestamp getFechaEditado() {
        return FechaEditado;
    }

    private void setFechaEditado(Timestamp FechaEditado) {
        this.FechaEditado = FechaEditado;
    }

}
