
<html>
  <head>
    <meta charset="UTF-8">
    <title>Sistema Web Control</title>
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
    
  </body>
</html>
