/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.dao.jdbc;

import java.sql.*;
import java.util.*;
import sgi.dao.ClienteDAO;
import sgi.dto.ClienteDTO;
import sgi.jdbc.Conexion;

public class ClienteDaoJDBC implements ClienteDAO{
    
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO cliente (tipoDocumento, numeroDocumento, nombresCliente, ApellidosCliente) VALUES (?,?,?,?)";
    private final String SQL_INSERT_CREDIT_CARD = "INSERT INTO tarjetasclientes (idTarjeta, idCliente, Banco) VALUES (?,?,?)";
    private final String SQL_UPDATE = "UPDATE cliente SET tipoDocumento = ?, numeroDocumento = ?, nombresCliente = ?, apellidosCliente = ? WHERE idCliente = ?";
    private final String SQL_UPDATE_CREDIT_CARD = "UPDATE tarjetasclientes SET idTarjeta = ?, Banco = ? WHERE idCliente = ?";
    private final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    private final String SQL_SELECT = "SELECT idCliente, tipoDocumento, numeroDocumento, nombresCliente, apellidosCliente FROM cliente";
    private final String SQL_FIND_BY_ID = "SELECT * FROM cliente WHERE idCliente = ?";
    private final String SQL_FIND_TARJETA_BY_ID = "SELECT C.*, ifnull(T.idTarjeta,'0') as idTarjeta, ifnull(T.Banco,'') as Banco FROM cliente as C LEFT JOIN tarjetasclientes as T on T.idCliente = C.idCliente WHERE C.idCliente = ?";
    
    public ClienteDaoJDBC(){}
    
    public ClienteDaoJDBC(Connection conn){
        this.userConn = conn;
    }

    @Override
    public int insert(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, cliente.getTipoDocumento());
            ps.setString(2, cliente.getNumeroDocumento());
            ps.setString(3, cliente.getNombresCliente());
            ps.setString(4, cliente.getApellidosCliente());
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexion.close(ps);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return rows;
    }

    @Override
    public int update(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, cliente.getTipoDocumento());
            ps.setString(2, cliente.getNumeroDocumento());
            ps.setString(3, cliente.getNombresCliente());
            ps.setString(4, cliente.getApellidosCliente());
            ps.setInt(5, cliente.getIdCliente());
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexion.close(ps);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return rows;
    }

    @Override
    public int delete(ClienteDTO cliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO = null;
        List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();         
            
            while (rs.next()) {
                clienteDTO = new ClienteDTO();
                clienteDTO.setIdCliente(rs.getInt("idCliente"));
                clienteDTO.setTipoDocumento(rs.getString("tipoDocumento"));
                clienteDTO.setNumeroDocumento(rs.getString("numeroDocumento"));
                clienteDTO.setNombresCliente(rs.getString("nombresCliente"));
                clienteDTO.setApellidosCliente(rs.getString("apellidosCliente"));
                clientes.add(clienteDTO);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }
    
        return clientes;
    }

    @Override
    public ClienteDTO FindClienteById(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO = null;
        
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_FIND_BY_ID);
            ps.setInt(1, cliente.getIdCliente());
            rs = ps.executeQuery();
            
            while (rs.next()) {
                clienteDTO = new ClienteDTO();
                clienteDTO.setIdCliente(rs.getInt("idCliente"));
                clienteDTO.setTipoDocumento(rs.getString("tipoDocumento"));
                clienteDTO.setNumeroDocumento(rs.getString("numeroDocumento"));
                clienteDTO.setNombresCliente(rs.getString("nombresCliente"));
                clienteDTO.setApellidosCliente(rs.getString("apellidosCliente"));
                //clientes.add(clienteDTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return clienteDTO;
    }

    @Override
    public ClienteDTO FindTarjetaCreditoById(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO = null;
        
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_FIND_TARJETA_BY_ID);
            ps.setInt(1, cliente.getIdCliente());
            rs = ps.executeQuery();
            
            while (rs.next()) {
                clienteDTO = new ClienteDTO();
                clienteDTO.setIdCliente(rs.getInt("idCliente"));
                clienteDTO.setTipoDocumento(rs.getString("tipoDocumento"));
                clienteDTO.setNumeroDocumento(rs.getString("numeroDocumento"));
                clienteDTO.setNombresCliente(rs.getString("nombresCliente"));
                clienteDTO.setApellidosCliente(rs.getString("apellidosCliente"));
                clienteDTO.setIdTarjeta(rs.getInt("idTarjeta"));
                clienteDTO.setBanco(rs.getString("Banco"));
                //clientes.add(clienteDTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return clienteDTO;
    }

    @Override
    public int insertCreditCard(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT_CREDIT_CARD);
            ps.setInt(1, cliente.getIdTarjeta());
            ps.setInt(2, cliente.getIdCliente());
            ps.setString(3, cliente.getBanco());
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexion.close(ps);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return rows;
    }

    @Override
    public int updateCreditCard(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE_CREDIT_CARD);
            ps.setInt(1, cliente.getIdTarjeta());
            ps.setString(2, cliente.getBanco());
            ps.setInt(3, cliente.getIdCliente());
            
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexion.close(ps);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return rows;
    }
    
}
