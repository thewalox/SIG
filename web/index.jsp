
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login Sistema Web Control</title>

  </head>
  <body onload="sf();">
    <div id="wrap">
        <div id="header">
            <jsp:include page="/WEB-INF/Views/Commons/header.jsp"/>
        </div>
    </div>
        
    <div class = "container">
	<div class="wrapper">
            
            <form action="${pageContext.request.contextPath}/ServletControllerUsuarios" method="post" name="Login_Form" id="Login_Form" class="form-signin">       
                <input type="hidden" name="accion" value="validarUsuario" />
		<h3 class="form-signin-heading">Sistema de Gestion</h3>
                <hr class="colorgraph"><br>
			  
		<div class="input-group" id="user">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="text" class="form-control" name="username" id="username" value="" placeholder="Usuario" autofocus="">                                        
                </div>
		
                <div class="input-group" id="pass">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Contraseña">
                </div>  		  
			
                <div id="content"></div>
                <button class="btn btn-lg btn-primary btn-block" id="login" value="Login" type="submit">Login</button>
                
                <div id="msg">
                    <jsp:include page="/WEB-INF/Views/Commons/messages.jsp"/>
                </div>
            </form>
					
	</div>
    </div>
  </body>
</html>

<script>
  function sf(){

    document.form1.username.value = "";
    document.form1.password.value = "";
    document.form1.username.focus();
  }
</script>
