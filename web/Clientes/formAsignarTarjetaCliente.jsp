
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Asignar Tarjeta Credito Cliente</title>
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
                                <li class="active">Asignar Tarjeta Credito Cliente</li>
                        </ol>
                    </div>
				
                    <form action="${pageContext.request.contextPath}/ServletControllerClientes" method="post" name="Add_Card_Cliente_Form" id="Add_Card_Cliente_Form">
                        <input type="hidden" name="accion" value="asignarTarjetaCliente" />
                        <input type="hidden" name="idcliente" value="${cliente.idCliente}" />
                        <input type="hidden" name="validaTarjeta" value="${cliente.idTarjeta}" />
                            <div class="form-group" id="content"></div>
                            <div class="form-group">
                                <div class="form-group col-md-4">
                                    <label for="idcliente">Id Cliente</label>
                                    <input type="text" placeholder="ID Cliente" id="id" name="id" class="form-control" value="${cliente.idCliente}" disabled="disabled">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-group col-md-4">
                                    <label for="tipodoc">Tipo Documento</label>
                                    <select class="form-control" name="tipodoc" id="tipodoc" disabled>
                                            <option value="0">...</option>
                                            <c:set var = "tipo" scope = "session" value = "${cliente.tipoDocumento}"/>
                                            <c:set var = "select" scope = "session" value = "selected"/>
                                            <option value="CC" <c:if test="${tipo == 'CC'}"><c:out value = "${select}" /></c:if>>Cedula de Ciudadania</option>
                                            <option value="CE" <c:if test="${tipo == 'CE'}"><c:out value = "${select}" /></c:if>>Cedula de Extranjeria</option>
                                            <option value="TI" <c:if test="${tipo == 'TI'}"><c:out value = "${select}" /></c:if>>Tarjeta de Identidad</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-group col-md-4">
                                    <label for="numerodoc">Numero Documento</label>
                                    <input type="text" placeholder="Numero Documento" id="numerodoc" name="numerodoc" class="form-control" value="${cliente.numeroDocumento}" disabled>
                            </div>
                            </div>
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <label for="nombrecliente">Nombres Cliente</label>
                                    <input type="text" placeholder="Nombres Clientes" id="nombrecliente" name="nombrecliente" class="form-control" value="${cliente.nombresCliente}" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <label for="apellidocliente">Apellidos Cliente</label>
                                    <input type="text" placeholder="Apellidos Cliente" id="apellidocliente" name="apellidocliente" class="form-control" value="${cliente.apellidosCliente}" disabled>
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <label for="numerotarjeta">Numero Tarjeta</label>
                                    <input type="text" placeholder="Numero Tarjeta" id="numerotarjeta" name="numerotarjeta" class="form-control" value="${cliente.idTarjeta}">
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <label for="numerotarjeta">Banco</label>
                                    <input type="text" placeholder="Banco" id="banco" name="banco" class="form-control" value="${cliente.banco}">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <button class="btn btn-lg btn-primary btn-block" id="aceptar" value="aceptar" type="button" onclick="ValidaFormularioAddCreditCardCliente()">Aceptar</button>
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <button class="btn btn-lg btn-danger btn-block" id="cancelar" value="cancelar" type="button" onclick="Regresar()">Cancelar</button>
                                </div>
                            </div>
                                
                            <div id="msg">
                                <jsp:include page="/WEB-INF/Views/Commons/messages.jsp"/>
                            </div>
                    </form>
				
				
                </section>

            </div>
	</section>
                            
  </body>
</html>
