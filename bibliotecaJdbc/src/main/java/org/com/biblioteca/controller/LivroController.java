package org.com.biblioteca.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.biblioteca.entity.Livro;
import org.com.biblioteca.model.LivroModel;

@WebServlet(urlPatterns = {"/livros"})
public class LivroController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4108933822491176950L;
	
	private LivroModel livroModel;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("searchAction");
		if (action != null) {
			if(action.equals("buscaLivroById")){
				buscaLivroById(req, resp);
			}else if(action.equals("buscaByItem")){
				buscaLivroByQuery(req, resp);
			}
		} else {
			List<Livro> result = getLivroModel().buscaLivroByQuery(null);  
			forwardListLivros(req, resp, result);
		}

	}
	
    private void buscaLivroById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idLivro = Long.valueOf(req.getParameter("idLivro"));
        Livro livro = null;
        try {
        	livro = getLivroModel().buscaLivroById(idLivro);
        } catch (Exception ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("livro", livro);
        req.setAttribute("action", "edit");
        String nextJSP = "/livro.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
    
    private void buscaLivroByQuery(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String query = req.getParameter("queryItem");
        List<Livro> result = getLivroModel().buscaLivroByQuery(query);        
        forwardListLivros(req, resp, result);
    }
    
    private void forwardListLivros(HttpServletRequest req, HttpServletResponse resp, List<Livro> livroList)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listLivros.jsp");
        req.setAttribute("livrosList", livroList);
        dispatcher.forward(req, resp);
    }
    
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("adicionar")){
            adicionarLivro(req, resp);
        }else if(action.equals("editar")){
            editarLivro(req, resp);
        }else if(action.equals("remover")){
            removerLivro(req, resp);
        }
	}
	
    private void adicionarLivro(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String ano = req.getParameter("ano");
        String valor = req.getParameter("valor");
        
        Livro livro = new Livro(nome, descricao, Integer.valueOf(ano), Calendar.getInstance(), Double.valueOf(valor));
        
        getLivroModel().salvarAlterar(livro);
        List<Livro> result = getLivroModel().buscaLivroByQuery(null);  
        req.setAttribute("idLivro", livro.getId());
        req.setAttribute("message", "Livro salvo com sucesso!");
        forwardListLivros(req, resp, result);
    }

    private void editarLivro(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String ano = req.getParameter("ano");
        String valor = req.getParameter("valor");
        
        long idLivro = Integer.valueOf(req.getParameter("idLivro"));
        
        Livro livro = new Livro(idLivro,nome, descricao, Integer.valueOf(ano), Double.valueOf(valor));
        
        getLivroModel().salvarAlterar(livro);
        List<Livro> result = getLivroModel().buscaLivroByQuery(null);  
        req.setAttribute("idLivro", livro.getId());
        req.setAttribute("message", "Livro alterado com sucesso!");
        forwardListLivros(req, resp, result);
    }  

    private void removerLivro(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idLivro = Integer.valueOf(req.getParameter("idLivro"));
        getLivroModel().removerLivro(idLivro);
        req.setAttribute("message", "Livro removido com sucesso!");
        List<Livro> result = getLivroModel().buscaLivroByQuery(null);  
        forwardListLivros(req, resp, result);
    }
    
	public LivroModel getLivroModel() {
		if(livroModel == null){
			livroModel = new LivroModel();
		}
		return livroModel;
	}

	public void setLivroModel(LivroModel livroModel) {
		this.livroModel = livroModel;
	}   
	
}
