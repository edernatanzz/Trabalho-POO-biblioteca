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
	System.out.printf("Funcion�rio : %n ");
	System.out.print("Nome do Funcion�rio: " + getNome());
	System.out.printf("Identifica��o do Funcionario: %n "+ id);
}
}
