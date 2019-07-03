
package sgi.dao;

import java.sql.*;
import java.util.*;
import sgi.dto.ClienteDTO;

public interface ClienteDAO {
    public int insert(ClienteDTO cliente) throws SQLException;
    public int insertCreditCard(ClienteDTO cliente) throws SQLException;
    public int update(ClienteDTO cliente) throws SQLException;
    public int updateCreditCard(ClienteDTO cliente) throws SQLException;
    public int delete(ClienteDTO cliente) throws SQLException;
    public List<ClienteDTO> select() throws SQLException;
    public ClienteDTO FindClienteById(ClienteDTO cliente) throws SQLException;
    public ClienteDTO FindTarjetaCreditoById(ClienteDTO cliente) throws SQLException;
}
