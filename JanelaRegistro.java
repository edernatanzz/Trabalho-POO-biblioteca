package Banco;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class JanelaRegistro extends JFrame implements ActionListener{

	Dao_Registro dr = new Dao_Registro();
	Registro r = new Registro();


   //idregidtro
	JLabel jlIdRegistro = new JLabel("Id Registro");
	JTextField jtfIdRegistro = new JTextField(100);
	//para o ALUNO
	JLabel jlnomeDoAluno = new JLabel("Nome do aluno ");
	JTextField jtfNomeDoAluno = new JTextField(100);
	JLabel jlTelefone = new JLabel("Telefone");
	JTextField jtfTelefone = new JTextField(200);
	JLabel jlCpfDoAluno = new JLabel("CPF");
	JTextField jtfCpfDoAluno = new JTextField(200);


// camp destinado ao funcionario
    JLabel jlNomeDoFuncionario = new JLabel("Nome do Funcionario ");//aparecer na janelinha aberta
	JTextField jtfNomeDoFuncionario = new JTextField(100);

	JLabel jlCpfDoFuncionario = new JLabel("Cpf Do Funcionario ");
	JTextField jtfCpfDoFuncionario = new JTextField(200);

	JLabel jlIdFuncionario = new JLabel("Id Funcionario");
	JTextField jtfIdFuncionario = new JTextField(300);



	//campo destinado para o livro
	JLabel jlNomeDoLivro = new JLabel("Nome Do Livro");//aparecer na janelinha aberta
	JTextField jtfNomeDoLivro = new JTextField(100);

	JLabel jlAutorDoLivro = new JLabel("Autor Do Livro ");
	JTextField jtfAutorDoLivro = new JTextField(200);

	JLabel jlPaginasDoLivro = new JLabel("Paginas Do Livro");
	JTextField jtfPaginasDoLivro = new JTextField(200);



	JButton gravar = new JButton("Gravar");
	JButton apagar = new JButton("Apagar");
	JButton listar = new JButton("Listar");

	JanelaRegistro(){

		setTitle("Cadastro Geral "); //heidht = altura e width = largura
		setSize(800,600);
		setLocationRelativeTo(null);
		setLayout(null);

		jlIdRegistro.setBounds(20,20,100,20);
		add(jlIdRegistro);
		jtfIdRegistro.setBounds(20,40,50,20);
		add(jtfIdRegistro);

      //para aluno
		jlnomeDoAluno.setBounds(50,60,200,20);//String nome do aluno
		add(jlnomeDoAluno);
		jtfNomeDoAluno.setBounds(50,80,200,20);//campo para digitar
		add(jtfNomeDoAluno);

		jlTelefone.setBounds(50,100,100,20);
		add(jlTelefone);
		jtfTelefone.setBounds(50,120,100,20);
		add(jtfTelefone);

		jlCpfDoAluno.setBounds(50,140,100,20);
		add(jlCpfDoAluno);

		jtfCpfDoAluno.setBounds(50,160,200,20);
		add(jtfCpfDoAluno);
		//funcionario

		jlNomeDoFuncionario.setBounds(50,180,100,20);
		add(jlNomeDoFuncionario);

		jtfNomeDoFuncionario.setBounds(50,200,200,20);
		add(jtfNomeDoFuncionario);

		jlIdFuncionario.setBounds(50,220,200,20);
		add(jlIdFuncionario);

		jtfIdFuncionario.setBounds(50,240,200,20);
		add(jtfIdFuncionario);

		jlCpfDoFuncionario.setBounds(50,260,100,20);
		add(jlCpfDoFuncionario);

		jtfCpfDoFuncionario.setBounds(50,280,200,20);
		add(jtfCpfDoFuncionario);


		//livro
		jlNomeDoLivro.setBounds(50,300,100,20);
		add(jlNomeDoLivro);

		jtfNomeDoLivro.setBounds(50,320,100,20);
		add(jtfNomeDoLivro);

		jlAutorDoLivro.setBounds(50,340,100,20);
		add(jlAutorDoLivro);

		jtfAutorDoLivro.setBounds(50,360,200,20);
		add(jtfAutorDoLivro);

		jlPaginasDoLivro.setBounds(50,380,100,20);
		add(jlPaginasDoLivro);

		jtfPaginasDoLivro.setBounds(50,400,200,20);
		add(jtfPaginasDoLivro);


//...

		gravar.setBounds(600,20,100,20);
		gravar.addActionListener(this);
		add(gravar);




		apagar.setBounds(600,110,100,20);
		apagar.addActionListener(this);
		add(apagar);

		listar.setBounds(600,140,100,20);
		listar.addActionListener(this);
		add(listar);

	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == gravar){
			//id da opecaçao
			r.setIdRegistro(jtfIdRegistro.getText());
			jtfIdRegistro.setText("");

			  //aluno
			r.setNomeAluno(jtfNomeDoAluno.getText());
			r.setTelefoneAluno(jtfTelefone.getText());
			r.setCpfAluno(jtfCpfDoAluno.getText());

			jtfNomeDoAluno.setText("");
			jtfTelefone.setText("");
			jtfCpfDoAluno.setText("");


			//funcionario
			r.setNomeFuncionario(jtfNomeDoFuncionario.getText());
			r.setCpfFuncionario(jtfCpfDoFuncionario.getText());
			r.setIdFuncionario(jtfIdFuncionario.getText());

			jtfNomeDoFuncionario.setText("");
			jtfCpfDoFuncionario.setText("");
			jtfIdFuncionario.setText("");



			//livro
			r.setNomeLivro(jtfNomeDoLivro.getText());
			r.setAutorLivro(jtfAutorDoLivro.getText());
			r.setPaginasLivro(jtfPaginasDoLivro.getText());

			jtfNomeDoLivro.setText("");
			jtfAutorDoLivro.setText("");
			jtfPaginasDoLivro.setText("");

			dr.insere(r);
		}



		if(e.getSource() == apagar){

			dr.apaga(jtfIdRegistro.getText());
			//registro
			jtfIdRegistro.setText("");
			//aluno

			jtfNomeDoAluno.setText("");
			jtfTelefone.setText("");
			jtfCpfDoAluno.setText("");
			//funcionario
			jtfNomeDoFuncionario.setText("");
			jtfCpfDoFuncionario.setText("");
			jtfIdFuncionario.setText("");

			//livro
			jtfNomeDoLivro.setText("");
			jtfAutorDoLivro.setText("");
			jtfPaginasDoLivro.setText("");

		}

		if(e.getSource() == listar){
			List<Registro> lista = new ArrayList<Registro>();

			lista = dr.lista();

			for(int i = 0; i < lista.size(); i++){
				System.out.println("- - - - - - -- - - - ");
				System.out.println("Id do Registro :" + lista.get(i).getIdRegistro());
				System.out.println(" Informações do aluno : ");
				//aluno
				System.out.println("Nome do aluno :" + lista.get(i).getNomeAluno());
				System.out.println("Telefone do aluno :" + lista.get(i).getTelefoneAluno());
				System.out.println("Cpf :" + lista.get(i).getCpfAluno());

				System.out.println("---Funcionario que fez o registro do livro : ");
				//funcionario
				System.out.println("Nome do Funcionario :" + lista.get(i).getNomeFuncionario());
				System.out.println("Cpf Do Funcionario  :" + lista.get(i).getCpfFuncionario());
				System.out.println("Id   :" + lista.get(i).getIdFuncionario());
              //livro
				System.out.println("- - - - - Livro - -- - - - ");
				System.out.println(" Nome Da Obra :" + lista.get(i).getNomeAluno());
				System.out.println("Autor Da Obra :" + lista.get(i).getAutorLivro());
				System.out.println("Nº Paginas :" + lista.get(i).getPaginasLivro());


			}
		}

	}
}
