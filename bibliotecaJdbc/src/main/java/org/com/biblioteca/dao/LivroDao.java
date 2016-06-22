package org.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.com.biblioteca.entity.Livro;
import org.com.biblioteca.utils.ConnectionFactory;

public class LivroDao {

	public Livro buscaLivroById(Long id){
		
		Connection conn = ConnectionFactory.createConnection();
		
		if(conn!= null){
			try {
				StringBuilder sql = new StringBuilder();
				sql.append(" select id, nome, descricao, ano, dataInclusao, valor from livro  where id = ?");
				PreparedStatement ps = conn.prepareStatement(sql.toString());
				ps.setLong(1, id);
				ResultSet rs = ps.executeQuery();
				Livro livro = new Livro();
				if(rs.next()){
					livro.setId(id);
					livro.setNome(rs.getString("nome"));
					livro.setDescricao(rs.getString("descricao"));
					livro.setAno(rs.getInt("ano"));
					Date date = rs.getDate("dataInsercao");
					Calendar data = Calendar.getInstance();
					data.setTimeInMillis(date.getTime());
					livro.setDataInclusao(data);
					livro.setValor(rs.getDouble("valor"));
					return livro;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<Livro> buscaLivroByQuery(String query) {
		Connection conn = ConnectionFactory.createConnection();
		
		if(conn!= null){
			try {
				StringBuilder sql = new StringBuilder();
				sql.append(" select id, nome, descricao, ano, dataInclusao, valor from livro");
				PreparedStatement ps = conn.prepareStatement(sql.toString());
//				ps.setLong(1, id);
				ResultSet rs = ps.executeQuery();
				Livro livro;
				List<Livro> listLivro = new ArrayList<Livro>();
				while(rs.next()){
					livro = new Livro();
					livro.setId(rs.getLong("id"));
					livro.setNome(rs.getString("nome"));
					livro.setDescricao(rs.getString("descricao"));
					livro.setAno(rs.getInt("ano"));
					Date date = rs.getDate("dataInsercao");
					Calendar data = Calendar.getInstance();
					data.setTimeInMillis(date.getTime());
					livro.setDataInclusao(data);
					livro.setValor(rs.getDouble("valor"));
					listLivro.add(livro);
				}
				return listLivro;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public Long buscaNextIdLivro() {
		Connection conn = ConnectionFactory.createConnection();
		if(conn!= null){
			try {
				StringBuilder sql = new StringBuilder();
				sql.append(" select max(id) as max from livro ");
				PreparedStatement ps = conn.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					return (rs.getLong(1)+1);
				}else{
					return 1l;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public void salvarAlterarLivro(Livro livro) {
		// TODO Auto-generated method stub
	}
	
	public void removerLivro(Long id) {
		// TODO Auto-generated method stub
	}
}
