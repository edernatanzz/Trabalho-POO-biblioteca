package Banco;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class JanelaCadastro extends JFrame implements ActionListener{

	DAO_Aluno da = new DAO_Aluno();
	Aluno a = new Aluno();

	MaskFormatter mascara;

	JLabel jlNome = new JLabel("Nome");
	JTextField jtfNome = new JTextField(100);

	JLabel jlTelefone = new JLabel("Telefone");
	JTextField jtfTelefone = new JTextField(200);

	JLabel jlCpf = new JLabel("CPF");

	JFormattedTextField jtfCpf;

	JButton gravar = new JButton("Gravar");
	JButton buscar = new JButton("Buscar");
	JButton alterar = new JButton("Alterar");
	JButton apagar = new JButton("Apagar");
	JButton listar = new JButton("Listar");

	JanelaCadastro(){

		setTitle("Cadastro Geral ");
		setSize(375,220);
		setLocationRelativeTo(null);
		setLayout(null);

		jlNome.setBounds(20,20,100,20);
		add(jlNome);

		jtfNome.setBounds(20,40,200,20);
		add(jtfNome);

		jlTelefone.setBounds(20,60,100,20);
		add(jlTelefone);

		jtfTelefone.setBounds(20,80,200,20);
		add(jtfTelefone);

		jlCpf.setBounds(20,100,100,20);
		add(jlCpf);

		jtfCpf.setBounds(20,120,200,20);
		add(jtfCpf);

		gravar.setBounds(240,20,100,20);
		gravar.addActionListener(this);
		add(gravar);

		buscar.setBounds(240,50,100,20);
		buscar.addActionListener(this);
		add(buscar);

		alterar.setBounds(240,80,100,20);
		alterar.addActionListener(this);
		add(alterar);

		apagar.setBounds(240,110,100,20);
		apagar.addActionListener(this);
		add(apagar);

		listar.setBounds(240,140,100,20);
		listar.addActionListener(this);
		add(listar);

	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == gravar){

			a.setNome(jtfNome.getText());
			a.setTelefone(jtfTelefone.getText());
			a.setCpf(jtfCpf.getText());

			jtfNome.setText("");
			jtfTelefone.setText("");
			jtfCpf.setText("");

			da.insere(a);
		}

		if(e.getSource() == alterar){

			a.setNome(jtfNome.getText());
			a.setTelefone(jtfTelefone.getText());
			a.setCpf(jtfCpf.getText());

			jtfNome.setText("");
			jtfTelefone.setText("");
			jtfCpf.setText("");

			da.altera(a);
		}

		if(e.getSource() == buscar){
			a = da.busca(jtfCpf.getText());
			jtfNome.setText(a.getNome());
			jtfTelefone.setText(a.getTelefone());
			jtfCpf.setText(a.getCpf());
		}

		if(e.getSource() == apagar){
			da.apaga(jtfCpf.getText());

			jtfNome.setText("");
			jtfTelefone.setText("");
			jtfCpf.setText("");
		}

		if(e.getSource() == listar){
			List<Aluno> lista = new ArrayList<Aluno>();

			lista = da.lista();

			for(int i = 0; i < lista.size(); i++){
				System.out.println("- - - - - - -- - - - ");
				System.out.println("Nome :" + lista.get(i).getNome());
				System.out.println("Telefone  :" + lista.get(i).getTelefone());
				System.out.println("Cpf :" + lista.get(i).getCpf());
			}
		}

	}
}
