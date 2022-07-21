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
			System.out.println("Informações do Registro: "
					+ "\n\n Livro: " + "\n1 - Nome: " + livro.getNome() + "\n2- Autor do Livro: " + livro.getAutor() + "\n3- Número de Paginas: " + livro.getPaginas()  + "\n4- Id: " + livro.getId() +"\n" +
					"\n Funcionário(a): " + "\n1 - Nome: " + funcionario.getNome() + "\n2- Id do Funcionário: " + funcionario.getId() + "\n" +
					"\n Aluno(a): " + "\n1-Nome: "+ aluno.getNome() + "\n2- Nº de telefone: (77)" + aluno.getTelefone());
		}
}