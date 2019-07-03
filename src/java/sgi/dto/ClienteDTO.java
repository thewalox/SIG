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
public class ClienteDTO {
    private int idCliente;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombresCliente;
    private String apellidosCliente;
    private int idTarjeta;
    private String Banco;
    
    public ClienteDTO(){}
    
    public ClienteDTO(int idCliente){
        this.idCliente = idCliente;
    }
    
    public int getIdCliente(){
        return this.idCliente;
    }
    
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    
    public String getTipoDocumento(){
        return this.tipoDocumento;
    }
    
    public void setTipoDocumento(String tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }
    
    public String getNumeroDocumento(){
        return this.numeroDocumento;
    }
    
    public void setNumeroDocumento(String numeroDocumento){
        this.numeroDocumento = numeroDocumento;
    }
    
    public String getNombresCliente(){
        return this.nombresCliente;
    }
    
    public void setNombresCliente(String nombresCliente){
        this.nombresCliente = nombresCliente;
    }
    
    public String getApellidosCliente(){
        return this.apellidosCliente;
    }
    
    public void setApellidosCliente(String apellidosCliente){
        this.apellidosCliente = apellidosCliente;
    }
    
    public int getIdTarjeta(){
        return this.idTarjeta;
    }
    
    public void setIdTarjeta(int idTarjeta){
        this.idTarjeta = idTarjeta;
    }
    
    public String getBanco(){
        return this.Banco;
    }
    
    public void setBanco(String Banco){
        this.Banco = Banco;
    }
}
