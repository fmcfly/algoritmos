<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ROT13</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
	<h1>ROT13</h1>
	
	<div class="container">
		<div class="form-group">
		   <label for="textonormal">Texto</label>
		   <textarea class="form-control" id="textonormal" rows="3"
		    onchange="update" onkeyup="update()"></textarea>
		 </div>
		 
		 <div class="form-group">
		   <label for="textoRot">Texto con ROT 13</label>
		   <textarea class="form-control" id="textoRot" rows="3"></textarea>
		 </div>
		 
		 <div>
		 	<img src="img/ROT13.png" class="img-fluid" alt="Responsive image">
		 </div>
		 
	</div>
<script type="text/javascript">
	function update(){
		document.getElementById('textoRot').value = rot(document.getElementById('textonormal').value);
	}
	
	function rot(s){
		return s.replace( /[A-Za-z]/g , function(c) {  
		    return String.fromCharCode( c.charCodeAt(0) + ( c.toUpperCase() <= "M" ? 13 : -13 ) ); //Cuando sumas el unicode del caracter mas o menos 13 te da el caracter correspondiente a ROT13
		} );
	}
</script>
</body>
</html>