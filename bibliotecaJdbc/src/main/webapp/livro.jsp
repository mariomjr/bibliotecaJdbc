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
            <form action="/livros" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="add"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="idLivro" name="idLivro" value="${livro.id}">
                <h2>Livro</h2>
                <div class="form-group col-xs-4">
                    <label for="itNome" class="control-label col-xs-4">Nome:</label>
                    <input type="text" name="itNome" id="itNome" class="form-control" value="${livro.nome}"/>                                   

                    <label for="itDescricao" class="control-label col-xs-4">Descrição:</label>                   
                    <input type="text" name="itDescricao" id="itDescricao" class="form-control" value="${livro.descricao}"/> 

                    <label for="itAno" class="control-label col-xs-4">Ano:</label>                 
					<input type="text" name="itAno" id="itAno" class="form-control" value="${livro.ano}"/> 
					
                    <label for="itValor" class="control-label col-xs-4">Valor:</label>                 
					<input type="text" name="itValor" id="itValor" class="form-control" value="${livro.valor}"/> 

                    <br></br>
                    <button type="submit" class="btn btn-primary  btn-md">Salvar</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>