/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.dto;

/**
 *
 * @author Familia Jimenez
 */
public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String passUsuario;
    
    public UsuarioDTO(){}
    
    public UsuarioDTO(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public int getIdUsuario(){
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getPassUsuario(){
        return this.passUsuario;
    }
    
    public void setPassUsuario(String passUsuario){
        this.passUsuario = passUsuario;
    }
    
    @Override
    public String toString(){
        return "Usuario{idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario +
                ", passUsuario =" + passUsuario + "}";
    }
}
