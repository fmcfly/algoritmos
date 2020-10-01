<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
HttpSession sesion = request.getSession();
String cifradaAES = "";
String descifradaAES = "";
if(sesion.getAttribute("cifradaAES")!=null){
	cifradaAES = (String) sesion.getAttribute("cifradaAES");
	descifradaAES = "";
}
if(sesion.getAttribute("descifradaAES")!=null){
	descifradaAES = (String) sesion.getAttribute("descifradaAES");
	cifradaAES = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Virologia</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style>
	.oculto{
		visibility: hidden;
		width:2px;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">Virología y Criptografía</a>
	  <a class="navbar-brand" href="#">Equipo 2</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="AES.jsp">AES</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="DES.jsp">DES</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="ROT13.jsp">ROT13</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<br>
	<h1>AES</h1>
    <div class="container">
        <form class="row mb-2"  action="AESServlet" method = "POST"
        autocomplete="off">
            <div class="col-sm-4">
                <label class="sr-only">Texto</label>
                <input type="text" class="form-control" placeholder="Texto"
                name="texto" value=<%= descifradaAES %>>
            </div>
			<input value=1 class="oculto" name="opcion">
            <div class="col-sm-4">
                <button type="submit" class="btn btn-outline-success mb-2">Cifrar</button>
            </div>
        </form>

        <form class="row mb-2" action="AESServlet" method = "POST"
        autocomplete="off">
            <div class="col-sm-4">
                <label class="sr-only">Texto</label>
                <input type="text" class="form-control" placeholder="Texto"
                name="texto" value=<%=cifradaAES %>>
            </div>
			<input value=2 class="oculto" name="opcion">
            <div class="col-sm-4">
                <button type="submit" class="btn btn-outline-danger mb-2">Descifrar</button>
            </div>
        </form>
    </div>
</body>
</html>