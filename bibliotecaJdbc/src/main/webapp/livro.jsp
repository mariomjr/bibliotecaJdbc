<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <script src="resources/js/jquery-1.12.3.min.js"></script>
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/imc.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery-mask-min.js"></script>
        
        <script src="resources/js/imc.js"></script>  
    </head>
    <body>
        <div class="container">
            <form action="/bibliotecaJdbc/livros" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="adicionar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="idLivro" name="idLivro" value="${livro.id}">
                <h2>Livro</h2>
                <div class="form-group col-xs-4">
                    <label for="nome" class="control-label col-xs-4">Nome:</label>
                    <input type="text" name="nome" id="nome" class="form-control" value="${livro.nome}"/>                                   

                    <label for="descricao" class="control-label col-xs-4">Descrição:</label>                   
                    <input type="text" name="descricao" id="descricao" class="form-control" value="${livro.descricao}"/> 

                    <label for="ano" class="control-label col-xs-4">Ano:</label>                 
					<input type="text" name="ano" id="ano" class="form-control" value="${livro.ano}"/> 
					
                    <label for="valor" class="control-label col-xs-4">Valor:</label>                 
					<input type="text" name="valor" id="valor" class="form-control" value="${livro.valor}"/> 

                    <br></br>
                    <button type="submit" class="btn btn-primary  btn-md">Salvar</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>