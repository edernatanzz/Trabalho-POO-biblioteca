package Model;


public class Livro {
	private int id;
	private String nome;
	private String Autor;
	private int Paginas;
	
	String getNome() {
		return nome;
	}
	void setNome(String nome) {
		this.nome = nome;
	}
	//id do Livro ;
	int getId() {
		return id;
	}
	void setId(int id) {
		 
		this.id = id;
	}
	String getAutor() {
		return Autor;
	}
	void setAutor(String autor) {
		Autor = autor;
	}
	
	void getDate() {
		System.out.printf("Livro : %n ");
		System.out.print("Nome do livro: " + nome);
		System.out.printf("Autor do Livro : %n "+ Autor + "%n" );
		System.out.println(id + "-" + id);
		System.out.println("Paginas " + Paginas  );
	}
	
	int getPaginas() {
		return Paginas;
	}
	void setPaginas(int paginas) {
		Paginas = paginas;
	}
	
}
	 



