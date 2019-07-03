function ValidaFormularioCrearCliente(){

    var forma = document.getElementById("Create_Cliente_Form");
    var tipoDoc = document.getElementById("tipodoc").value;
    var numeroDoc = document.getElementById("numerodoc").value;
    var nomCliente = document.getElementById("nombrecliente").value;
    var apeCliente = document.getElementById("apellidocliente").value;
    
    if (tipoDoc == 0){
        alert("El tipo de documento es obligatorio");
        tipoDoc.focus();
        exit();
    }
    
    if (numeroDoc.length == 0){
        alert("El campo numero de documento del cliente es obligatorio");
        document.getElementById("numerodoc").focus();
        exit();
    }
    
    if (nomCliente.length == 0){
        alert("El campo Nombres Cliente es obligatorio");
        document.getElementById("nombrecliente").focus();
        exit();
    }
    
    if (apeCliente.length == 0){
        alert("El campo Apellidos Cliente es obligatorio");
        document.getElementById("apellidocliente").focus();
        exit();
    }

    //Enviamos el formulario
    forma.submit();
}

function ValidaFormularioEditarCliente(){
    //alert(renglonSeleccionado);
    //Recuperamos la formay la accion para modificarla
    var forma = document.getElementById("Edit_Cliente_Form");
    var tipoDoc = document.getElementById("tipodoc").value;
    var numeroDoc = document.getElementById("numerodoc").value;
    var nomCliente = document.getElementById("nombrecliente").value;
    var apeCliente = document.getElementById("apellidocliente").value;
    
    if (tipoDoc == 0){
        alert("El tipo de documento es obligatorio");
        tipoDoc.focus();
        exit();
    }
    
    if (numeroDoc.length == 0){
        alert("El campo numero de documento del cliente es obligatorio");
        document.getElementById("numerodoc").focus();
        exit();
    }
    
    if (nomCliente.length == 0){
        alert("El campo Nombres Cliente es obligatorio");
        document.getElementById("nombrecliente").focus();
        exit();
    }
    
    if (apeCliente.length == 0){
        alert("El campo Apellidos Cliente es obligatorio");
        document.getElementById("apellidocliente").focus();
        exit();
    }

    //Enviamos el formulario
    forma.submit();
}

function ValidaFormularioAddCreditCardCliente(){
    //alert(renglonSeleccionado);
    //Recuperamos la formay la accion para modificarla
    var forma = document.getElementById("Add_Card_Cliente_Form");
    var numeroTarjeta = document.getElementById("numerotarjeta").value;
    var banco = document.getElementById("banco").value;
    
    if (numeroTarjeta.length < 5){
        alert("El numero de la tarjeta debe contener por lo menos de 5 caracteres");
        document.getElementById("numerotarjeta").focus();
        exit();
    }
    
    if (banco.length == 0){
        alert("El campo banco es obligatorio");
        document.getElementById("banco").focus();
        exit();
    }
    
    //Enviamos el formulario
    forma.submit();
}

function Regresar(){
    window.location.replace("http://localhost:8084/SGI/ServletControllerClientes?accion=listarCliente");
}
