package conta;

public class ContaPoupanca extends Conta{
	
	private String TipoConta;
	private double valorRendimento;

	public ContaPoupanca(String cpf, double saldo, int agencia, String tipoConta) {
		super(cpf, saldo, agencia);
		TipoConta = tipoConta;
	}

	public ContaPoupanca() {
		super();
	}
	
	public String getTipoConta() {
		return TipoConta;
	}

	public void setTipoConta(String tipoConta) {
		TipoConta = tipoConta;
	}
	
	
	
	public double getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	public double calcularRendimentoPoupanca(double valor, int dias) {
        double valorFinal = valor * rendimentoPoupancaDia * dias;
            this.valorRendimento = valorFinal;
        return valorFinal;
    }

	@Override
	public String toString() {
		return "\n---------------------------- \n Conta Poupança instanciada \n---------------------------- \nCPF do titular: " + getCpf()
		+ "\nAgência: " + getAgencia() + "\nSaldo: " + getSaldo() + "\n----------------------------";
	}
	
	
}
