<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Listar Pessoas Cadastrados</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- 007 apagar 
        <script src="https://cdn.es.gov.br/scripts/jquery/jquery-maskedinput/1.4.1/jquery.maskedinput-1.4.1.min.js"></script>
         -->
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

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

	<jsp:include page="../utils/Navbar.jsp" />


    <div class="container">

        <h1 class="p-3">Pessoas Cadastradas</h1>
        
        <form:form>

            <table class="table table-bordered table-sm">
	            <thead class="thead-dark">
	            	<tr>
	            		<th>NOME</th>
	            		<th>DATA NASCIMENTO</th>
	            		<th>CPF</th>
	            		<th>FUNCIONARIO</th>
	            		<th>GERENTE</th>	            		            		
	            		<th>EDITAR</th>
	            		<th>DELETAR</th>
	            	</tr>
	             </thead>	
            	 <c:forEach var="p" items="${list}">            	 
                    <tr>
                		<td>${p.nome}</td>
                		<td>${p.dataNascimento}</td>
                		<td>${p.cpf}</td>
                		<td>${p.funcionario}</td>
                		<td>${p.gerente}</td>
                		
                		<td><button type="button" class="btn btn-warning">
                		    <a href="/pessoa/editarPessoa/${p.id}">Editar</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger">
                			<a href="/pessoa/excluirPessoa/${p.id}">Deletar</a>
                		</button></td>
                	</tr>
            	 </c:forEach>

            </table>

        </form:form>


 		<button type="button" class="btn btn-primary">
        	<a href="/pessoa/novaPessoa">Adicionar Nova Pessoa</a>
        </button>

    </div>

    <script th:inline="javascript">
   
                window.onload = function() {
                	
                    var msg = "${message}";
                    
                    if (msg == "Salvo com sucesso!") {
        				Command: toastr["success"]("Pessoa adicionado com sucesso!!")
        			} else if (msg == "Excluido com sucesso!") {
        				Command: toastr["success"]("Pessoa excluido com sucesso!!")
        			} else if (msg == "Falha ao excluir!") {
        			    Command: toastr["error"]("N�o foi poss�vel excluir a Pessoa")
        			} else if (msg == "Editado com sucesso!") {
        				Command: toastr["success"]("Pessoa atualizado com sucesso!!")
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