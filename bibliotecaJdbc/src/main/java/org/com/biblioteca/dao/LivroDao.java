package org.com.biblioteca.dao;

import java.sql.Connection;
import java.util.List;

import org.com.biblioteca.entity.Livro;
import org.com.biblioteca.utils.ConnectionFactory;

public class LivroDao {

	public Livro buscaLivroById(Long id){
		
		Connection conn = ConnectionFactory.createConnection();
		
		if(conn!= null){
			
		}
		return null;
	}

	public List<Livro> buscaLivroByQuery(String query) {
		return null;
	}
}
