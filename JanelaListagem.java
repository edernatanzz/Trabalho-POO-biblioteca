package Banco;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class JanelaListagem extends JFrame implements ActionListener{

	DAO_Aluno dp = new DAO_Aluno();

	JTextArea jtaTexto = new JTextArea();
	JScrollPane jspRolagem = new JScrollPane(jtaTexto);
	
	JanelaListagem(){
		//janela que aparece lista de alunos
		setTitle("Listagem de Aluno");
		setSize(500,300);
		setLocationRelativeTo(null);
		setLayout(null);

		jspRolagem.setBounds(10,10,465,240);
		add(jspRolagem);
	}

	public void actionPerformed(ActionEvent e){

	}
	
	public void listagem(){
		//aparecer lista de alunos em array
		List<Aluno> lista = new ArrayList<Aluno>();

		lista = dp.lista();
		
		jtaTexto.setText("");
		
		for(int i = 0; i < lista.size(); i++){
			jtaTexto.append("\n Nome :" + lista.get(i).getNome());
			jtaTexto.append("\n Cpf. :" + lista.get(i).getCpf());
			jtaTexto.append("\n Telefone :" + lista.get(i).getTelefone());
			jtaTexto.append("\n\n");
		}

	}
}
