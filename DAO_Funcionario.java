package Banco;

import java.sql.*;
import java.util.*;

public class DAO_Funcionario {
	private Connection conexao;

	public DAO_Funcionario(){
		conexao = new FabricaDeConexoes().solicitaConexao("localhost", "lyceum", "root", "");
	}
	
	public void insere(Funcionario p){
		
		String sql = "insert into Funcionario " +
			"(nome, id, cpf) " +
			"values (?,?,?)";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setString(2,p.getId());
			stmt.setString(3,p.getCpf());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Funcionario busca(String n) {

		Funcionario p = new Funcionario();

		try{
			//if(rs.getString("nome").equals(n)){
			String sql = "select * from Funcionario where cpf like ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, n);

			ResultSet rs = stmt.executeQuery();

			p.setNome("Nao Encontrado!");
			
			while(rs.next()){
				//if(rs.getString("nome").equals(n)){
				if(rs.getString("cpf").contains(n)){
					p.setNome(rs.getString("nome"));
					p.setId(rs.getString("Id"));
					p.setCpf(rs.getString("Cpf"));
				}
			}
			
			rs.close();
			stmt.close();
			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Funcionario p){

		String sql = "update funcionario set " +
			"nome=?, Id =? , Cpf=?" +
			"where cpf=?";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setString(2,p.getId());
			stmt.setString(3,p.getCpf());
			stmt.setString(4,p.getCpf());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void apaga(String n){
		
		String sql = "delete from funcionario " +
			"where cpf=?";//procura no banco
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,n);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> lista(){
		
		try{
			List<Funcionario> funcionario = new ArrayList<Funcionario>();
			PreparedStatement stmt = conexao.prepareStatement("select * from funcionario");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Funcionario f = new Funcionario();
				f.setNome(rs.getString("nome"));
				f.setId(rs.getString("Id"));
				f.setCpf(rs.getString("cpf"));
				
				funcionario.add(f);
			}
			
			rs.close();
			stmt.close();
			return funcionario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
