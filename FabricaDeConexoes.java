package Banco;
import java.sql.*;
import javax.swing.*;

public class FabricaDeConexoes {
	
    public Connection solicitaConexao(String host, String banco, String usuario, String senha) {

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e){
			JOptionPane.showMessageDialog(null,"Driver nao encontrato. "+e.toString());
			System.exit(1);
		}
		
        try {
            return DriverManager.getConnection("jdbc:mysql://" + host + "/" + banco, usuario, senha);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro com o banco de dados. \n"+e.toString());
			System.exit(2);
			return null;//erro colocado quando nao conecta
        }
	}    
}
