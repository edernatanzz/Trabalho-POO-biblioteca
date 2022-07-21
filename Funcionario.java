package Model;


public class Funcionario extends Pessoa {
 private int id;
 

 int getId() {
	return id;
}
  public void setId(int id) {
	this.id = id;
}
 
	
public void getDate() {
	System.out.printf("Funcionário : %n ");
	System.out.print("Nome do Funcionário: " + getNome());
	System.out.printf("Identificação do Funcionario: %n "+ id);
}
}
