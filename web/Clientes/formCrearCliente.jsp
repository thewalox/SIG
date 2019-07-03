
<html>
  <head>
    <meta charset="UTF-8">
    <title>Crear Cliente</title>
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
                                <li class="active">Crear Cliente</li>
                        </ol>
                    </div>
				
                    <form action="${pageContext.request.contextPath}/ServletControllerClientes" method="post" name="Create_Cliente_Form" id="Create_Cliente_Form">
                        <input type="hidden" name="accion" value="crearCliente" />
                            <div class="form-group" id="content"></div>
                            <div class="form-group">
                                    <label for="tipodoc">Tipo Documento</label>
                                    <select class="form-control" name="tipodoc" id="tipodoc">
                                            <option value="0">...</option>
                                            <option value="CC">Cedula de Ciudadania</option>
                                            <option value="CE">Cedula de Extranjeria</option>
                                            <option value="TI">Tarjeta de Identidad</option>
                                    </select>
                            </div>
                            <div class="form-group">
                                    <label for="numerodoc">Numero Documento</label>
                                    <input type="text" placeholder="Numero Documento" id="numerodoc" name="numerodoc" class="form-control">
                            </div>
                            <div class="form-group">
                                    <label for="nombrecliente">Nombres Cliente</label>
                                    <input type="text" placeholder="Nombres Clientes" id="nombrecliente" name="nombrecliente" class="form-control">
                            </div>
                            <div class="form-group">
                                    <label for="apellidocliente">Apellidos Cliente</label>
                                    <input type="text" placeholder="Apellidos Cliente" id="apellidocliente" name="apellidocliente" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <button class="btn btn-lg btn-primary btn-block" id="aceptar" value="aceptar" type="button" onclick="ValidaFormularioCrearCliente()">Aceptar</button>
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
