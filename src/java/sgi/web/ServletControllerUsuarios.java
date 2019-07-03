/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sgi.dao.UsuarioDAO;
import sgi.dao.jdbc.UsuarioDaoJDBC;
import sgi.dto.UsuarioDTO;

/**
 *
 * @author Familia Jimenez
 */
@WebServlet(name = "ServletControllerUsuarios", urlPatterns = {"/ServletControllerUsuarios"})
public class ServletControllerUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Revisamos la accion indicada
        String accion = request.getParameter("accion");
        
        if("validarUsuario".equals(accion)){
            try {
                this.validarUsuario(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControllerUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("salir".equals(accion)){
            this.salir(request, response);
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
    
    //Metodo para validar si el usuario y password proporcinados son correctos
    private void validarUsuario(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {

        //Recuperamos los parametros del formulario
        String usuarioParam = request.getParameter("username");
        String passwordParam = request.getParameter("password");

        //Creamos el objeto DTO a enviar a la capa de servicio
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombreUsuario(usuarioParam);
        usuarioDTO.setPassUsuario(passwordParam);

        //Revisamos si existen el usuario y el password en la BD
        //Utilizamos el servicio de Usuarios
        //UsuarioService usuarioService = UsuarioServiceImpl.getInstance();
        //boolean usuarioValido = usuarioService.usuarioExistente(usuarioDto);
        UsuarioDAO usuarioDAO = new UsuarioDaoJDBC();
        boolean usuarioValido = usuarioDAO.validaExisteUsuario(usuarioDTO);
        
        //Si el usuario es válido, lo redireccionamos al caso de listarPersonas
        if (usuarioValido) {
          //Agregamos el usuario a la session
          HttpSession session = request.getSession();
          session.setAttribute("usuario", usuarioDTO.getNombreUsuario());
          response.sendRedirect("menuPrincipal.jsp");
          //this.listarPersonas(request, response);
        } else {
          //si el usuario no es valido, lo mandamos a la pagina de login nuevamente
          request.setAttribute("mensaje", "El usuario o password son incorrectos");
          request.getRequestDispatcher("index.jsp").forward(request, response);
    }

  }
    
  private void salir(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    //Eliminamos la session del servidor y redireccionamos a la pagina de inicio
    request.getSession().invalidate();
    request.getRequestDispatcher("index.jsp").forward(request, response);


  }

}
