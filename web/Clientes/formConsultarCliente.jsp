
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Consultar Cliente</title>
  </head>
  <body>
    <div id="wrap">
        <div id="header">
            <jsp:include page="/WEB-INF/Views/Commons/header.jsp"/>
        </div>
    </div>
    
    <header>
        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
            <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">
                <span class="sr-only">Desplegar / Ocultar Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
					
            </div>
                <div class="collapse navbar-collapse" id="menu">
                     <jsp:include page="/WEB-INF/Views/Commons/menu.jsp"/>
                </div>
            </div>
            </nav>
	</header>
                
        <section class="main container">
            <div class="row">
                <section class="posts col-md-12">
                    <div class="miga-de-pan">
                        <ol class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/menuPrincipal.jsp">Inicio</a></li>
                            <li><a href="#">Clientes</a></li>
                            <li class="active">Gestion Cliente</li>
                        </ol>
                    </div>
                            
                    <div class="form-group" id="content">
                        <a href="${pageContext.request.contextPath}/Clientes/formCrearCliente.jsp">Agregar Cliente <span class="glyphicon glyphicon-plus"></span></a>
                        <form name="form">
                                <table class="table table-striped table-condensed table-hover">
                                        <thead>
                                                <tr>
                                                        <th>ID</th>
                                                        <th>TIPO DOCUMENTO</th>
                                                        <th>NUMERO DOCUMENTO</th>
                                                        <th>NOMBRES</th>
                                                        <th>APELLIDOS</th>
                                                        <th></th>
                                                        <th></th>
                                                </tr>
                                                <c:forEach var="clientes" items="${clientes}">
                                                <tr>
                                                    <td>${clientes.idCliente}</td>
                                                    <td>${clientes.tipoDocumento}</td>
                                                    <td>${clientes.numeroDocumento}</td>
                                                    <td>${clientes.nombresCliente}</td>
                                                    <td>${clientes.apellidosCliente}</td>
                                                    <td><a title="Editar Clientes" href="${pageContext.request.contextPath}/ServletControllerClientes?accion=buscarClienteById&idcliente=${clientes.idCliente}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                                    <td><a title="Asignar Tarjeta de Credito" href="${pageContext.request.contextPath}/ServletControllerClientes?accion=buscarTarjetaCreditoById&idcliente=${clientes.idCliente}"><span class="glyphicon glyphicon-credit-card"></span></a></td>
                                                </tr>
                                                </c:forEach>
                                        </thead>
                                </table>
                        </form>
                    </div>
                </section>
            </div>
        </section>
    
  </body>
</html>
