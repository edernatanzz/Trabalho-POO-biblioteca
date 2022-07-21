package Model;




public class Aluno extends Pessoa{
	private int telefone;

	int getTelefone() {
		return telefone;
	}

public	void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
public void  getDate() {
		System.out.printf("Aluno : %n ");
		System.out.print("Nome do Aluno: " + getNome());
		System.out.printf("Telefone do Aluno: %n "+ telefone);
	}
}
