package Banco;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class JanelaLivro extends JFrame implements ActionListener{

	DAO_Livro dl = new DAO_Livro();
	Livro l = new Livro();



	JLabel jlNome = new JLabel("Nome");//aparecer na janelinha aberta
	JTextField jtfNome = new JTextField(100);

	JLabel jlAutor = new JLabel("Autor");
	JTextField jtfAutor = new JTextField(200);

	JLabel jlPaginas = new JLabel("Paginas");
	JTextField jtfPaginas = new JTextField(200);


	JButton gravar = new JButton("Gravar");
	JButton buscar = new JButton("Buscar");
	JButton alterar = new JButton("Alterar");
	JButton apagar = new JButton("Apagar");
	JButton listar = new JButton("Listar");

	JanelaLivro(){

		setTitle("Cadastro de Livros");
		setSize(375,220);
		setLocationRelativeTo(null);
		setLayout(null);

		jlNome.setBounds(20,20,100,20);
		add(jlNome);
		
		jtfNome.setBounds(20,40,200,20);
		add(jtfNome);

		jlAutor.setBounds(20,60,100,20);
		add(jlAutor);
		
		jtfAutor.setBounds(20,80,200,20);
		add(jtfAutor);

		jlPaginas.setBounds(20,100,100,20);
		add(jlPaginas);
		
		jtfPaginas.setBounds(22,120,200,20);
		add(jtfPaginas);
		
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
			
			l.setNome(jtfNome.getText());
			l.setAutor(jtfAutor.getText());
			l.setPaginas(jtfPaginas.getText());

			jtfNome.setText("");
			jtfAutor.setText("");
			jtfPaginas.setText("");
			
			dl.insere(l);
		}

		if(e.getSource() == alterar){
			
			l.setNome(jtfNome.getText());
			l.setAutor(jtfAutor.getText());
			l.setPaginas(jtfPaginas.getText());

			jtfNome.setText("");
			jtfAutor.setText("");
			jtfPaginas.setText("");
			
			dl.altera(l);
		}

		if(e.getSource() == buscar){
			l = dl.busca(jtfNome.getText());
			jtfNome.setText(l.getNome());
			jtfAutor.setText(l.getAutor());
			jtfPaginas.setText(l.getPaginas());
		}

		if(e.getSource() == apagar){
			dl.apaga(jtfNome.getText());

			jtfNome.setText("");
			jtfAutor.setText("");
			jtfPaginas.setText("");
		}
		
		if(e.getSource() == listar){
			List<Livro> lista = new ArrayList<Livro>();
			
			lista = dl.lista();
			
			for(int i = 0; i < lista.size(); i++){
				System.out.println("- - - - - - -- - - - ");
				System.out.println(" Nome :" + lista.get(i).getNome());
				System.out.println("Autor :" + lista.get(i).getAutor());
				System.out.println("Paginas :" + lista.get(i).getPaginas());
			}
		}

	}
}
