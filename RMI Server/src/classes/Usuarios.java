/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author oswal
 */
public class Usuarios {
    private int UsuarioId;
    private int Role;
    private String Nombre;
    public Usuarios(){}
    public Usuarios(int Role, String Nombre) {
        this.Role = Role;
        this.Nombre = Nombre;
    }

    public int getUsuarioId() {
        return UsuarioId;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
