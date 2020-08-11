package Pessoal;

public abstract class Funcionario extends Pessoa{


	private String cargo;
		
	public Funcionario() {
		super();
	}

	public Funcionario(String cpf, String nome, int senha, String tipo, String cargo) {
		super(cpf, nome, senha, tipo);
		this.cargo = cargo;

	}

	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}
