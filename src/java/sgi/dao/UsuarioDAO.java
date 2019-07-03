
package sgi.dao;
import java.sql.*;
import java.util.*;
import sgi.dto.UsuarioDTO;

public interface UsuarioDAO {
    public boolean validaExisteUsuario(UsuarioDTO usuario) throws SQLException;
}
