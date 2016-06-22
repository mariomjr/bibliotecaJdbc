package org.com.biblioteca.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.biblioteca.dao.LivroDao;
import org.com.biblioteca.entity.Livro;

@WebServlet(urlPatterns = {"/livros"})
public class LivroController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4108933822491176950L;
	
	LivroDao livroDao = new LivroDao();
	
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
			List<Livro> result = livroDao.buscaLivroByQuery(null);  
			forwardListLivros(req, resp, result);
		}

	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
		
	}
	
    private void buscaLivroById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idLivro = Long.valueOf(req.getParameter("idLivro"));
        Livro livro = null;
        try {
        	livro = livroDao.buscaLivroById(idLivro);
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
        List<Livro> result = livroDao.buscaLivroByQuery(query);        
        forwardListLivros(req, resp, result);
    }
    
    private void forwardListLivros(HttpServletRequest req, HttpServletResponse resp, List livroList)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listLivros.jsp");
        req.setAttribute("livrosList", livroList);
        dispatcher.forward(req, resp);
    }   
	
}
