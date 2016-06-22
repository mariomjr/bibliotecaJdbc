package org.com.biblioteca.model;

import java.util.List;

import org.com.biblioteca.dao.LivroDao;
import org.com.biblioteca.entity.Livro;

public class LivroModel {
	
	private LivroDao livroDao;
	
	public Livro buscaLivroById(Long id){
		return getLivroDao().buscaLivroById(id);
	}

	public List<Livro> buscaLivroByQuery(String query) {
		return getLivroDao().buscaLivroByQuery(query);
	}
	
	public void salvarAlterar(Livro livro){
		getLivroDao().salvarAlterarLivro(livro);
	}
	
	public void removerLivro(Long id){
		getLivroDao().removerLivro(id);
	}

	public LivroDao getLivroDao() {
		if(livroDao == null){
			livroDao = new LivroDao();
		}
		return livroDao;
	}

	public void setLivroDao(LivroDao livroDao) {
		this.livroDao = livroDao;
	}
	
}
