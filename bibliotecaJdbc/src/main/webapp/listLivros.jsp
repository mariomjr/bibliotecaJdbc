<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">   		
        <script src="../js/bootstrap.min.js"></script>       
    </head>

    <body>          
        <div class="container">
            <h2>Livros</h2>
            <form action="/livros" method="get" id="searchLivrosForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="queryItem">
                <div class="form-group col-xs-5">
                    <input type="text" name="itemBusca" id="itemBusca" class="form-control" placeholder="Digite para buscar"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Buscar
                </button>
                <br></br>
                <br></br>
            </form>

            <form action="/livros" method="post" id="listLivrosForm" role="form" >              
                <input type="hidden" id="idLivro" name="idLivro">
                <input type="hidden" id="action" name="action">
                <c:choose>
                    <c:when test="${not empty livrosList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>ID</td>
                                    <td>Nome</td>
                                    <td>Descrição</td>
                                    <td>Valor</td>
                                    <td>Ano</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="livro" items="${livrosList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idLivro == livro.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="/livros?idLivro=${livro.id}&searchAction=searchById">${livro.id}</a>
                                    </td>                                    
                                    <td>${livro.nome}</td>
                                    <td>${livro.descricao}</td>
                                    <td>${employee.valor}</td>
                                    <td>${employee.ano}</td> 
                                    <td><a href="#" id="remove" 
                                           onclick="document.getElementById('action').value = 'remove';document.getElementById('idLivro').value = '${livro.id}';
                                                    document.getElementById('listLivrosForm').submit();"> 
                                            <span class="glyphicon glyphicon-trash"/>
                                        </a>
                                                   
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                           	Nenhum livro encontrado!
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="livro.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">Novo Livro</button> 
            </form>
        </div>
    </body>
</html>