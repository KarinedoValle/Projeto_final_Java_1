package Pessoal;

public abstract class Funcionario extends Pessoa{


	private String cargo;
		
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cargo, int cpf, int senha) {
		super(nome, cpf, senha);
		this.cargo = cargo;

	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}
