package Banco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class JanelaListarRegistros extends JFrame implements ActionListener{

	Dao_Registro dp = new Dao_Registro();

	JTextArea jtaTexto = new JTextArea();
	JScrollPane jspRolagem = new JScrollPane(jtaTexto);

	JanelaListarRegistros(){
		//janela que aparece lista de alunos
		setTitle("Registro dos Livros ");
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);

		jspRolagem.setBounds(10,10,465,240);
		add(jspRolagem);
	}

	public void actionPerformed(ActionEvent e){

	}
	
	public void listagem(){
		//aparecer lista de todos os registros efetuados ,,, arraylist
		List<Registro> lista = new ArrayList<Registro>();

		lista = dp.lista();
		
		jtaTexto.setText("");
		
		for(int i = 0; i < lista.size(); i++){
			//registro id
			jtaTexto.append("\n Id Do Registro :" + lista.get(i).getIdRegistro());

			//ALUNOS
			jtaTexto.append("\n Nome do aluno :" + lista.get(i).getNomeAluno());
			jtaTexto.append("\n Cpf. :" + lista.get(i).getCpfAluno());
			jtaTexto.append("\n Telefone :" + lista.get(i).getTelefoneAluno());
            //funcionarios
			jtaTexto.append("\n Nome :" + lista.get(i).getNomeFuncionario());
			jtaTexto.append("\n Cpf. :" + lista.get(i).getCpfFuncionario());
			jtaTexto.append("\n Telefone :" + lista.get(i).getIdFuncionario());
			//livros
			jtaTexto.append("\n Nome :" + lista.get(i).getNomeLivro());
			jtaTexto.append("\n Cpf. :" + lista.get(i).getAutorLivro());
			jtaTexto.append("\n Telefone :" + lista.get(i).getPaginasLivro());
			jtaTexto.append("\n\n");
		}

	}
}
