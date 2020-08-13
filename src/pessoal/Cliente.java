package pessoal;

public class Cliente extends Pessoa {

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String tipo, int senha) {
		super(nome, cpf, senha, tipo);
	}

	@Override
	public String toString() {
		return "\n-------------------------- \n   Cliente instanciado   \n-------------------------- \nNome: "
				+ getNome() + "\nCPF: " + getCpf() + "\nSenha: " + getSenha() + "\nSaldo: " + getSaldo() + "\nAgência: "
				+ getAgencia() + "\n--------------------------";

	}

}
