package Model;


public class Registro {
		private Livro livro;
		private Funcionario funcionario;
		private Aluno aluno;
		
		 void setFuncionario (Funcionario x) {
			 funcionario = x;
		}
		 void setAluno (Aluno x) {
			aluno = x;
		}
		
		 void setLivro (Livro x) {
			livro = x;
		}
		void Info () {
			System.out.println("Informa��es do Registro: "
					+ "\n\n Livro: " + "\n1 - Nome: " + livro.getNome() + "\n2- Autor do Livro: " + livro.getAutor() + "\n3- N�mero de Paginas: " + livro.getPaginas()  + "\n4- Id: " + livro.getId() +"\n" +
					"\n Funcion�rio(a): " + "\n1 - Nome: " + funcionario.getNome() + "\n2- Id do Funcion�rio: " + funcionario.getId() + "\n" +
					"\n Aluno(a): " + "\n1-Nome: "+ aluno.getNome() + "\n2- N� de telefone: (77)" + aluno.getTelefone());
		}
}