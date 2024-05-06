<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Cadastrar Projeto</title>

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

        <h1 class="p-3"> Cadastrar Projeto </h1>

        <form:form action="/projeto/salvarProjeto" method="post" modelAttribute="todo">
        
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
            		<label class="col-md-12" for="date">Data Inicio</label>
            		<div class="col-md-12">
            			<form:input type="date" path="dataInicio" id="dataInicio"
            				class="form-control input-sm" required="required" />
            		</div>
            	</div>
            
            	<div class="form-group col-md-4">
            		<label class="col-md-6" for="date">Data Previsao Fim</label>
            		<div class="col-md-12">
            			<form:input type="date" path="dataPrevisaoFim" id="dataPrevisaoFim"
            				class="form-control input-sm" required="required" />
            		</div>
            	</div>     
            	
            	<div class="form-group col-md-4">
            		<label class="col-md-12" for="date">Data Fim</label>
            		<div class="col-md-12">
            			<form:input type="date" path="dataFim" id="dataFim"
            				class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>
            
            <div class="row">    
	            <div class="form-group col-md-12">
	            		<label class="col-md-3" for="title">Descricao</label>
	            		<div class="col-md-12">
	            		    <form:input type="text" path="descricao" id="descricao"
	            		        class="form-control input-sm" required="required" />
	            		</div>
            	</div>
            </div>
            
			<div class="row">
            	<div class="form-group col-md-6">
            		<label class="col-md-3" for="title">Status</label>
            		<div class="col-md-12">	        
				         <form:select path="status" id="status" class="form-control ls-custom" required="required">  
					        <form:option value="em analise" label="Em análise"/>  
					        <form:option value="analise realizada" label="Análise realizada"/>  
					        <form:option value="analise aprovada" label="Análise aprovada"/>  
					        <form:option value="iniciado" label="Iniciado"/>
					        <form:option value="planejado" label="Planejado"/>  
					        <form:option value="em andamento" label="Em andamento"/>  
					        <form:option value="encerrado" label="Encerrado"/>
					        <form:option value="cancelado" label="Cancelado"/>        
					     </form:select>
            		</div>
            	</div>
            
            	<div class="form-group col-md-6">
            		<label class="col-md-3" for="title">Orçamento</label>
            		<div class="col-md-12">
            		    <form:input type="float" path="orcamento" id="orcamento"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>     
            
            <div class="row">
            	<div class="form-group col-md-6">
            		<label class="col-md-3" for="title">Risco</label>
            		<div class="col-md-12">
            		     <form:select path="risco" id="risco" class="form-control ls-custom" required="required">  
					        <form:option value="baixo" label="Baixo"/>  
					        <form:option value="medio" label="Médio"/>  
					        <form:option value="alto" label="Alto"/>
					     </form:select>
            		</div>
            	</div>
            	<div class="form-group col-md-6">
            		<label class="col-md-3" for="title">Gerente</label>            		
            		<div class="col-md-12">	  					
						<select name="gerente" id="gerente" class="form-control ls-custom">
	                    <option>
	                        <c:forEach items="${listaGerente}" var="gerente">
	                            <option value="${gerente.id}">${gerente.nome}</option> 
	                        </c:forEach>
	                    </option>
	                    </select>
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
                if (msg == "Falha ao salvar") {
    				Command: toastr["error"]("Falha ao salvar")
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