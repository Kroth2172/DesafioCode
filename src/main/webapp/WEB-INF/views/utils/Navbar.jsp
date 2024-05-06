<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>        

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
        .container {
        	max-width: 1440px;
        }
    </style>

</head>
<body>
    
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">	
		  <a class="navbar-brand" href="/">#</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="/">Home</a>
		      </li>
		      <li class="nav-item active">
		         <a class="nav-link" href="/projeto/listarProjetos">Projeto</a>
		      </li>
		      <li class="nav-item active">
		         <a class="nav-link" href="/pessoa/listarPessoas">Pessoa</a>
		      </li>
		    </ul>		    
		  </div>
		</nav>
    
</body>

</html>