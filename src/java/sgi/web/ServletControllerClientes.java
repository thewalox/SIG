/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sgi.dao.ClienteDAO;
import sgi.dao.jdbc.ClienteDaoJDBC;
import sgi.dto.ClienteDTO;


/**
 *
 * @author Familia Jimenez
 */
@WebServlet(name = "ServletControllerClientes", urlPatterns = {"/ServletControllerClientes"})
public class ServletControllerClientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Revisamos la accion indicada
        String accion = request.getParameter("accion");
        
        if ("crearCliente".equals(accion)) {
            try {
                this.addCliente(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControllerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("listarCliente".equals(accion)){
            try {
                this.listarClientes(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControllerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("buscarClienteById".equals(accion)){
            try {
                int idCliente = Integer.parseInt(request.getParameter("idcliente"));
                this.buscarClienteById(request, response, idCliente);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControllerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("buscarTarjetaCreditoById".equals(accion)){
            try {
                int idCliente = Integer.parseInt(request.getParameter("idcliente"));
                this.buscarTarjetaCreditoById(request, response, idCliente);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControllerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("editarCliente".equals(accion)){
            try {
                this.editCliente(request, response);
                System.out.println("here");
            } catch (SQLException ex) {
                Logger.getLogger(ServletControllerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("asignarTarjetaCliente".equals(accion)){
            try {
                this.addCreditCardCliente(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControllerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.accionPorDefault(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void accionPorDefault(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {


    //Redireccionamos a la pagina de inicio
    String mensaje = "Acci&oacute;n no proporcionada o desconocida";
    request.setAttribute("mensaje", mensaje);
    request.getRequestDispatcher("index.jsp").forward(request, response);

  }
    
    private void addCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String mensaje = null;
        
        String tipoDoc = request.getParameter("tipodoc");
        String numeroDoc = request.getParameter("numerodoc");
        String nombreCliente = request.getParameter("nombrecliente");
        String apellidoCliente = request.getParameter("apellidocliente");
        
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setTipoDocumento(tipoDoc);
        clienteDTO.setNumeroDocumento(numeroDoc);
        clienteDTO.setNombresCliente(nombreCliente);
        clienteDTO.setApellidosCliente(apellidoCliente);
        
        ClienteDAO clienteDAO = new ClienteDaoJDBC();
        int exitoso = clienteDAO.insert(clienteDTO);
        
        if (exitoso > 0) {
            //mensaje = "Se guard&oacute; el elemento correctamente";
            //request.setAttribute("mensaje", mensaje);
            this.listarClientes(request, response);

        } else {
            mensaje = "No se guardo correctamente el elemento";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("Clientes/formCrearCliente.jsp").forward(request, response);
        }
    }
    
    private void editCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String mensaje = null;
        
        String tipoDoc = request.getParameter("tipodoc");
        String numeroDoc = request.getParameter("numerodoc");
        String nombreCliente = request.getParameter("nombrecliente");
        String apellidoCliente = request.getParameter("apellidocliente");
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setTipoDocumento(tipoDoc);
        clienteDTO.setNumeroDocumento(numeroDoc);
        clienteDTO.setNombresCliente(nombreCliente);
        clienteDTO.setApellidosCliente(apellidoCliente);
        clienteDTO.setIdCliente(idCliente);
        
        ClienteDAO clienteDAO = new ClienteDaoJDBC();
        int exitoso = clienteDAO.update(clienteDTO);
        
        if (exitoso > 0) {
            //mensaje = "Se guard&oacute; el elemento correctamente";
            //request.setAttribute("mensaje", mensaje);
            this.listarClientes(request, response);

        } else {
            mensaje = "No se pudo actualizar correctamente el cliente";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("Clientes/formEditarCliente.jsp").forward(request, response);
        }
    }
    
    private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ClienteDAO clienteDAO = new ClienteDaoJDBC();
        
        List<ClienteDTO> clientes = clienteDAO.select();
        request.setAttribute("clientes", clientes);
        
        request.getRequestDispatcher("/Clientes/formConsultarCliente.jsp").forward(request, response);
    }
    
    private void buscarClienteById(HttpServletRequest request, HttpServletResponse response, int idCliente) throws ServletException, IOException, SQLException {    
        int ID = idCliente;
        
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(ID);
        
        ClienteDAO clienteDAO = new ClienteDaoJDBC();
        ClienteDTO registro = clienteDAO.FindClienteById(clienteDTO);
        request.setAttribute("cliente", registro);
        
        request.getRequestDispatcher("/Clientes/formEditarCliente.jsp").forward(request, response);
    }
    
    private void buscarTarjetaCreditoById(HttpServletRequest request, HttpServletResponse response, int idCliente) throws ServletException, IOException, SQLException {    
        int ID = idCliente;
        
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(ID);
        
        ClienteDAO clienteDAO = new ClienteDaoJDBC();
        ClienteDTO registro = clienteDAO.FindTarjetaCreditoById(clienteDTO);
        request.setAttribute("cliente", registro);
        
        request.getRequestDispatcher("/Clientes/formAsignarTarjetaCliente.jsp").forward(request, response);
    }
    
    private void addCreditCardCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String mensaje = null;
        
        String validaTarjeta = request.getParameter("validaTarjeta");
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        int numeroTarjeta = Integer.parseInt(request.getParameter("numerotarjeta"));
        String banco = request.getParameter("banco");
        
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(idCliente);
        clienteDTO.setIdTarjeta(numeroTarjeta);
        clienteDTO.setBanco(banco);
        
        ClienteDAO clienteDAO = new ClienteDaoJDBC();
        
        int exitoso = 0;
        
        if("0".equals(validaTarjeta)){
            exitoso = clienteDAO.insertCreditCard(clienteDTO);
        }else{
            exitoso = clienteDAO.updateCreditCard(clienteDTO);
        }
        
        
        if (exitoso > 0) {
            //mensaje = "Se guard&oacute; el elemento correctamente";
            //request.setAttribute("mensaje", mensaje);
            this.listarClientes(request, response);

        } else {
            mensaje = "No se guardo correctamente el elemento";
            request.setAttribute("mensaje", mensaje);
            //request.getRequestDispatcher("Clientes/formAsignarTarjetaCliente.jsp").forward(request, response);
            this.buscarTarjetaCreditoById(request, response, idCliente);
        }
    }

}
