package pessoal;

public class Presidente extends Funcionario{
	
	public Presidente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Presidente(String nome, String cpf, String cargo, int senha) {
		super(nome, cargo, cpf, senha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\n-------------------------- \n   Presidente instanciado    \n-------------------------- \nNome: "
				+ getNome() + "\nCPF: " + getCpf() + "\nSenha: " + getSenha() + "\nCargo: " + getTipo() + "\nSaldo: "
				+ getSaldo() + "\nAgência: " + getAgencia() + "\n--------------------------";
	}

	
	
}
