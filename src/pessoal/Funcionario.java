package pessoal;

public abstract class Funcionario extends Pessoa{
		
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cargo, String cpf, int senha) {
		super(nome, cpf, senha, cargo);

	}


	
}
