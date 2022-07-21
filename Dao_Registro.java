package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao_Registro {
        private Connection conexao;

        public Dao_Registro(){
            conexao = new FabricaDeConexoes().solicitaConexao("localhost", "lyceum", "root", "" );
        }

        public void insere(Registro r ){

            String sql = "insert into registro " +
                    "(idRegistro, " +
                    "nomedoAluno, CpfdoAluno, telefonedoAluno, " +
                    " nomeDoFuncionario, cpfDoFuncionario,idDoFuncionario," +
                    "nomeDoLivro, autorDoLivro, paginasDoLivro) " +
                    "values (?,?,?,?,?,?,?,?,?,?)";

            try{
                PreparedStatement stmt = conexao.prepareStatement(sql);
                //parametros para registro geral
                stmt.setString(1,r.getIdRegistro());
                //comando sql para aluno
                stmt.setString(2,r.getNomeAluno());
                stmt.setString(3,r.getCpfAluno());
                stmt.setString(4,r.getTelefoneAluno());
                //parametros sql para funcionario
                stmt.setString(5,r.getNomeFuncionario());
                stmt.setString(6,r.getCpfFuncionario());
                stmt.setString(7,r.getIdFuncionario());
                //parametros qls para livro
                stmt.setString(8,r.getNomeLivro());
                stmt.setString(9,r.getAutorLivro());
                stmt.setString(10,r.getPaginasLivro());


                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public Registro busca (String n){

            Registro r = new Registro();

            try{
                String sql = "select * from Registro where IdRegistro like ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1,  n );

                ResultSet rs = stmt.executeQuery();

                r.setIdRegistro("Nao Encontrado!");

                while(rs.next()){
                    //if(rs.getString("nome").equals(n)){

                    if(rs.getString("nome").contains(n)){
                        //registro parametro set dar valor
                        r.setIdRegistro(rs.getString("IdRegistro"));
                        //registro aluno
                        r.setNomeAluno(rs.getString("nomeDoAluno"));
                        r.setCpfAluno(rs.getString("cpfDoAluno"));
                        r.setPaginasLivro(rs.getString("telefoneDoAluno"));
                        //regitro Funciorario set dar valor
                        r.setNomeFuncionario(rs.getString("nomeDoFuncionario"));
                        r.setCpfFuncionario(rs.getString("cpfDoFuncionario"));
                        r.setIdFuncionario(rs.getString("idDoFuncionario"));
                        //Set livro dar valor
                        r.setNomeLivro(rs.getString("nomeDoLivro"));
                        r.setAutorLivro(rs.getString("autorDoLivro"));
                        r.setPaginasLivro(rs.getString("paginasDoLivro"));

                    }
                }

                rs.close();
                stmt.close();
                return r;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void altera(Registro r){

            String  sql = "update Registro set " +
                    "IdRegistro=?,  " +
                    "nomeDoAluno=?, cpfDoAluno=?, telefoneDoAluno=? ,     " +
                    "nomeDoFuncionario=?, cpfDoFuncionario=?, idDoFuncionario=?," +
                    "nomeDoLivro=?, autorDoLivro=?, paginasDoLivro=? " +
                    "where IdRegistro=?";

            try{
                PreparedStatement stmt = conexao.prepareStatement(sql);
                //regitro
                stmt.setString(1,r.getIdRegistro());
                //aluno
                stmt.setString(2,r.getNomeAluno());
                stmt.setString(3,r.getCpfAluno());
                stmt.setString(4,r.getTelefoneAluno());
                //funcionario
                stmt.setString(5,r.getNomeFuncionario());
                stmt.setString(6,r.getCpfFuncionario());
                stmt.setString(7,r.getIdFuncionario());
                //livro
                stmt.setString(9,r.getNomeLivro());
                stmt.setString(9,r.getAutorLivro());
                stmt.setString(10,r.getPaginasLivro());

                //key primary
                stmt.setString(11,r.getIdRegistro());

                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void apaga(String n){

            String sql = "delete from Registro " +
                    "where IdRegistro=?";//mostra no banco

            try{
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1,n);

                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public List<Registro> lista(){

            try{
                List<Registro> registros = new ArrayList<Registro>();
                PreparedStatement stmt = conexao.prepareStatement("select * from Registro");
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    Registro r = new Registro();
                    r.setIdRegistro(rs.getString("IdRegistro"));
                    r.setNomeAluno(rs.getString("NomedoAluno"));
                    r.setCpfAluno(rs.getString("CpfdoAluno"));
                    r.setTelefoneAluno(rs.getString("TelefonedoAluno"));
                    //funcionario
                    r.setNomeFuncionario(rs.getString("NomedoFuncionario"));
                    r.setIdFuncionario(rs.getString("IddoFuncionario"));
                    r.setCpfFuncionario(rs.getString("CpfdoFuncionario"));
                 //livro
                    r.setNomeLivro(rs.getString("NomedoLivro"));
                    r.setAutorLivro(rs.getString("AutordoLivro"));
                    r.setPaginasLivro(rs.getString("PaginasdoLivro"));


                    registros.add(r);
                }

                rs.close();
                stmt.close();
                return registros;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
