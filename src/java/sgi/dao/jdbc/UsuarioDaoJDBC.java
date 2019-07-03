
package sgi.dao.jdbc;
import java.sql.*;
import java.util.*;
import sgi.dao.UsuarioDAO;
import sgi.dto.UsuarioDTO;
import sgi.jdbc.Conexion;

public class UsuarioDaoJDBC implements UsuarioDAO{
    private Connection userConn;
    private final String SQL_VALIDA_EXISTE_USUARIO = "SELECT * FROM usuario WHERE username = ? AND password = ?";
    
    public UsuarioDaoJDBC(){}
    
    public UsuarioDaoJDBC(Connection conn){
        this.userConn = conn;
    }

    @Override
    public boolean validaExisteUsuario(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean existeUsuario = false;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_VALIDA_EXISTE_USUARIO);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPassUsuario());
            rs = ps.executeQuery();
            
            if(rs.absolute(1)){
                existeUsuario = true;
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
        
        return existeUsuario;
    }
}
