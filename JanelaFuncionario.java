package Banco;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class JanelaFuncionario extends JFrame implements ActionListener{

	DAO_Funcionario df = new DAO_Funcionario();
	Funcionario f = new Funcionario();



	JLabel jlNome = new JLabel("Nome");//aparecer na janelinha aberta
	JTextField jtfNome = new JTextField(100);

	JLabel jlCpf = new JLabel("Cpf");
	JTextField jtfCpf = new JTextField(200);

	JLabel jlId = new JLabel("Id ");
	JTextField jtfId = new JTextField(300);


	JButton gravar = new JButton("Gravar");
	JButton buscar = new JButton("Buscar");
	JButton alterar = new JButton("Alterar");
	JButton apagar = new JButton("Apagar");
	JButton listar = new JButton("Listar");

	JanelaFuncionario(){
		
		setTitle("Cadastro de Funcionario ");
		setSize(375,220);
		setLocationRelativeTo(null);
		setLayout(null);

		jlNome.setBounds(20,20,100,20);
		add(jlNome);
		
		jtfNome.setBounds(20,40,200,20);
		add(jtfNome);

		jlCpf.setBounds(20,60,100,20);
		add(jlCpf);
		
		jtfCpf.setBounds(20,80,200,20);
		add(jtfCpf);

		jlId.setBounds(20,100,100,20);
		add(jlId);
		
		jtfId.setBounds(20,120,200,20);
		add(jtfId);
		
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
			
			f.setNome(jtfNome.getText());
			f.setCpf(jtfCpf.getText());
			f.setId(jtfId.getText());

			jtfNome.setText("");
			jtfCpf.setText("");
			jtfId.setText("");
			
			df.insere(f);
		}

		if(e.getSource() == alterar){
			
			f.setNome(jtfNome.getText());
			f.setCpf(jtfCpf.getText());
			f.setId(jtfId.getText());

			jtfNome.setText("");
			jtfCpf.setText("");
			jtfId.setText("");
			
			df.altera(f);
		}

		if(e.getSource() == buscar){
			f = df.busca(jtfCpf.getText());
			jtfNome.setText(f.getNome());
			jtfCpf.setText(f.getCpf());
			jtfId.setText(f.getId());
		}

		if(e.getSource() == apagar){
			df.apaga(jtfNome.getText());

			jtfNome.setText("");
			jtfCpf.setText("");
			jtfId.setText("");
		}
		
		if(e.getSource() == listar){
			List<Funcionario> lista = new ArrayList<Funcionario>();
			
			lista = df.lista();
			
			for(int i = 0; i < lista.size(); i++){
				System.out.println("- - - - - - -- - - - ");
				System.out.println(" Nome :" + lista.get(i).getNome());
				System.out.println("Cpf :" + lista.get(i).getCpf());
				System.out.println("Id :" + lista.get(i).getId());
			}
		}

	}
}
