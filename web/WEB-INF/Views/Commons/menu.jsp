<ul class="nav navbar-nav">
    <li class="active"><a href="${pageContext.request.contextPath}/menuPrincipal.jsp">Inicio</a></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Clientes <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/ServletControllerClientes?accion=listarCliente">Gestion Cliente</a></li>
        </ul>				
    </li>

</ul>

<ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bienvenid@ <%= session.getAttribute("usuario") %><span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/ServletControllerUsuarios?accion=salir"><strong>Cerrar Sesion </strong><span class="glyphicon glyphicon-off"></span></a></li>
        </ul>				
    </li>
</ul>