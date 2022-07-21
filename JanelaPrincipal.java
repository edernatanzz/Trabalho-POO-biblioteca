package Banco;

import javax.swing.*;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame implements ActionListener {

	JanelaPessoa jp = new JanelaPessoa();
	JanelaLivro jlv = new JanelaLivro();
	JanelaRegistro jr = new JanelaRegistro();
	JanelaFuncionario jf = new JanelaFuncionario();
	JanelaListagem jl = new JanelaListagem();
JanelaListarRegistros jlr = new JanelaListarRegistros();
	JMenuBar jmbMenus = new JMenuBar();
	JMenu jmCadastro = new JMenu("Cadastro");
	JMenuItem jmiCadastroPessoa = new JMenuItem("Aluno");
    JMenuItem jmRegistro = new JMenuItem( "Registro ");
	JMenuItem jmJanelaFuncionario = new JMenuItem("Funcionario ");

	JMenuItem jmiLivro = new JMenuItem("Livro");
	JMenu jmListagem = new JMenu("Listagem");
	JMenuItem jmiListagemPessoa = new JMenuItem("Aluno");
	JMenuItem getJmJanelaFuncionario = new JMenuItem("Funcionario");
	JMenuItem JmiLivro = new JMenuItem("Livro");



	public JanelaPrincipal() {

		setTitle("Exemplo de BanCo de Dados");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(null);

		setJMenuBar(jmbMenus);

		jmbMenus.add(jmCadastro);
		jmCadastro.add(jmiCadastroPessoa);
		jmiCadastroPessoa.addActionListener(this);




		jmbMenus.add(jmiLivro);
		jmCadastro.add(jmiLivro);
		jmiLivro.addActionListener(this);

		jmbMenus.add(jmJanelaFuncionario);
		jmCadastro.add(jmJanelaFuncionario);
		jmJanelaFuncionario.addActionListener(this);

		jmbMenus.add(jmListagem);
		jmListagem.add(jmiListagemPessoa);
		jmiListagemPessoa.addActionListener(this);

     jmbMenus.add(jmRegistro);
		jmCadastro.add(jmRegistro);
		jmRegistro.addActionListener(this);


		setVisible(true);
	}

	public void actionPerformed(ActionEvent evento) {//isso faz o evento do botao (faz o clique)

		if (evento.getSource() == jmiCadastroPessoa) {
			jp.setVisible(true);
		}

		if (evento.getSource() == jmiListagemPessoa) {
			jl.listagem();
			jl.setVisible(true);
		}
		if (evento.getSource() == jmiLivro) {
			jlv.setVisible(true);
		}
		if (evento.getSource() == jmJanelaFuncionario) {
			jf.setVisible(true);

		}if(evento.getSource()==jmRegistro){
			jr.setVisible(true);
		}
	}
}