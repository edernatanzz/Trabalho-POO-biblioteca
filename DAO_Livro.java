package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Livro {
	private Connection conexao;

	public DAO_Livro(){
		conexao = new FabricaDeConexoes().solicitaConexao("localhost", "lyceum", "root", "" );
	}
	
	public void insere(Livro l ){
		
		String sql = "insert into livro " +
			"(nome, autor, paginas) " +
			"values (?,?,?)";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,l.getNome());
			stmt.setString(2,l.getAutor());
			stmt.setString(3,l.getPaginas());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Livro busca(String n){

		Livro l = new Livro();

		try{
			String sql = "select * from Livro where nome like ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,  n );

			ResultSet rs = stmt.executeQuery();

			l.setNome("Nao Encontrado!");

			while(rs.next()){
				//if(rs.getString("nome").equals(n)){
				if(rs.getString("nome").contains(n)){
					l.setNome(rs.getString("nome"));
					l.setAutor(rs.getString("autor"));
					l.setPaginas(rs.getString("Paginas"));
				}
			}

			rs.close();
			stmt.close();
			return l;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Livro l){

		String  sql = "update Livro set " +
			"nome=?, autor=?, paginas=? " +
			"where nome=?";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,l.getNome());
			stmt.setString(2,l.getAutor());
			stmt.setString(3,l.getPaginas());
			stmt.setString(4,l.getNome());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void apaga(String n){
		
		String sql = "delete from Livro " +
			"where nome=?";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,n);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Livro> lista(){
		
		try{
			List<Livro> livros = new ArrayList<Livro>();
			PreparedStatement stmt = conexao.prepareStatement("select * from Livro");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Livro l = new Livro();
				l.setNome(rs.getString("nome"));
				l.setAutor(rs.getString("Autor"));
				l.setPaginas(rs.getString("Paginas"));
				
				livros.add(l);
			}
			
			rs.close();
			stmt.close();
			return livros;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
