package Banco;
import java.sql.*;
import java.util.*;

public class DAO_Aluno {
	private Connection conexao;
	
	public DAO_Aluno(){
		conexao = new FabricaDeConexoes().solicitaConexao("localhost", "lyceum", "root", "" );
	}
	
	public void insere(Aluno p ){
		
		String sql = "insert into aluno " +
			"(nome, cpf, telefone) " +
			"values (?,?,?)";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setString(2,p.getCpf());
			stmt.setString(3,p.getTelefone());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Aluno busca(String n){

		Aluno p = new Aluno();

		try{
			String sql = "select * from Aluno where cpf like ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,  n );

			ResultSet rs = stmt.executeQuery();

			p.setNome("Nao Encontrado!");

			while(rs.next()){
				//if(rs.getString("nome").equals(n)){
				if(rs.getString("cpf").contains(n)){
					p.setNome(rs.getString("nome"));
					p.setCpf(rs.getString("cpf"));
					p.setTelefone(rs.getString("telefone"));
				}
			}

			rs.close();
			stmt.close();
			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Aluno p){

		String  sql = "update Aluno set " +
			"nome=?, cpf=?, telefone=? " +
			"where cpf=?";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setString(2,p.getCpf());
			stmt.setString(3,p.getTelefone());
			stmt.setString(4,p.getCpf());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void apaga(String n){
		
		String sql = "delete from Aluno " +
			"where nome=?";//apaga isso da primeiro ngc do banco
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,n);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Aluno> lista(){
		
		try{
			List<Aluno> pessoas = new ArrayList<Aluno>();
			PreparedStatement stmt = conexao.prepareStatement("select * from Aluno");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Aluno p = new Aluno();
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("Cpf"));
				p.setTelefone(rs.getString("telefone"));
				
				pessoas.add(p);
			}
			
			rs.close();
			stmt.close();
			return pessoas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
