<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Editar Pessoa</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</head>
<body>

	<jsp:include page="../utils/Navbar.jsp" />

    <div class="container">

        <h1 class="p-3"> Editar Pessoa </h1>

        <form:form action="/pessoa/salvarEditarPessoa" method="post" modelAttribute="todo">
			<form:input path="id" type="hidden"/>
           
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="title">Nome</label>
            		<div class="col-md-12">
            		    <form:input type="text" path="nome" id="nome"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>    
            </div>   
            
            <div class="row">       
            	<div class="form-group col-md-4">
            		<label class="col-md-12" for="date">Data de Nascimento</label>
            		<div class="col-md-12">
            			<form:input type="date" path="dataNascimento" id="dataNascimento"
            				class="form-control input-sm" required="required" />
            		</div>
            	</div>
            	<div class="form-group col-md-4">
	            		<label class="col-md-3" for="title">CPF</label>
	            		<div class="col-md-12">
	            		    <form:input type="text" path="cpf" id="cpf"
	            		        class="form-control input-sm" required="required" />
	            		</div>
            	</div>	
            </div>
            
            <div class="row">   
            
           		<div class="form-group col-md-4">
            		<label class="col-md-12" for="date">Funcionario</label>
            		<div class="col-md-12">
            			<form:checkbox path="funcionario" id="funcionario"
            				class="form-control input-sm" required="required" />
            		</div>
            	</div> 
            	<div class="form-group col-md-4">
            		<label class="col-md-12" for="date">Gerente</label>
            		<div class="col-md-12">
            			<form:checkbox path="gerente" id="gerente"
            				class="form-control input-sm" required="required" />
            		</div>
            	</div>
	            
            </div>
           
            <div class="row p-2">
            	<div class="col-md-2">
            		<button type="submit" value="Register" class="btn btn-success">Salvar</button>
            	</div>
            </div>

        </form:form>

    </div>

    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Edit Failure") {
        				Command: toastr["error"]("Something went wrong with the edit.")
        			}

        			toastr.options = {
                          "closeButton": true,
                          "debug": false,
                          "newestOnTop": false,
                          "progressBar": true,
                          "positionClass": "toast-top-right",
                          "preventDuplicates": false,
                          "showDuration": "300",
                          "hideDuration": "1000",
                          "timeOut": "5000",
                          "extendedTimeOut": "1000",
                          "showEasing": "swing",
                          "hideEasing": "linear",
                          "showMethod": "fadeIn",
                          "hideMethod": "fadeOut"
                        }
        	    }
            </script>

</body>

</html>