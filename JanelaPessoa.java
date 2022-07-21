package Banco;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.text.*;

class JanelaPessoa extends JFrame implements ActionListener{

	DAO_Aluno dp = new DAO_Aluno();
	Aluno p = new Aluno();
	
	MaskFormatter mascaraFone;
	
	JLabel jlNome = new JLabel("Nome");//aparecer na janelinha aberta
	JTextField jtfNome = new JTextField(100);

	JLabel jlCpf = new JLabel("cpf");
	JTextField jtfCpf = new JTextField(200);

	JLabel jlTelefone = new JLabel("Telefone");
	//JTextField jtfFone = new JTextField();
	JFormattedTextField jtftelefone;
	
	JButton gravar = new JButton("Gravar");
	JButton buscar = new JButton("Buscar");
	JButton alterar = new JButton("Alterar");
	JButton apagar = new JButton("Apagar");
	JButton listar = new JButton("Listar");
	
	JanelaPessoa(){
		
		try{
			// mascaraFone = new MaskFormatter("(##)####-####");			
			jtftelefone = new JFormattedTextField(new MaskFormatter("(##)########"));
		} catch(Exception e){
		}
		
		setTitle("Cadastro de Aluno");
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

		jlTelefone.setBounds(20,100,100,20);
		add(jlTelefone);
		
		jtftelefone.setBounds(20,120,200,20);
		add(jtftelefone);
		
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
			
			p.setNome(jtfNome.getText());
			p.setCpf(jtfCpf.getText());
			p.setTelefone(jtftelefone.getText());

			jtfNome.setText("");
			jtfCpf.setText("");
			jtftelefone.setText("");
			
			dp.insere(p);
		}

		if(e.getSource() == alterar){
			
			p.setNome(jtfNome.getText());
			p.setCpf(jtfCpf.getText());
			p.setTelefone(jtftelefone.getText());

			jtfNome.setText("");
			jtfCpf.setText("");
			jtftelefone.setText("");
			
			dp.altera(p);
		}

		if(e.getSource() == buscar){
			p = dp.busca(jtfCpf.getText());
			jtfNome.setText(p.getNome());
			jtfCpf.setText(p.getCpf());
			jtftelefone.setText(p.getTelefone());
		}

		if(e.getSource() == apagar){
			dp.apaga(jtfNome.getText());

			jtfNome.setText("");
			jtfCpf.setText("");
			jtftelefone.setText("");
		}
		
		if(e.getSource() == listar){
			List<Aluno> lista = new ArrayList<Aluno>();
			
			lista = dp.lista();
			
			for(int i = 0; i < lista.size(); i++){
				System.out.println("- - - - - - -- - - - ");
				System.out.println(" Nome :" + lista.get(i).getNome());
				System.out.println("Cpf :" + lista.get(i).getCpf());
				System.out.println("Telefone :" + lista.get(i).getTelefone());
			}
		}

	}
}
