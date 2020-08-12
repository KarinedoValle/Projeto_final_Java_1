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

	public String calcularRendimentoPoupanca(double valor, int dias) {
        double valorInicial = valor;
        double valorFinal = valor;
            valorFinal = valor * rendimentoPoupancaDia * dias;
            valorRendimento = valorFinal;
        return "O rendimento do valor R$" + valorInicial + " durante " + dias + " dias é de R$" + (valorFinal - valorInicial) + "\nO valor total é R$" + valorFinal;
    }

	@Override
	public String toString() {
		return "\n---------------------------- \n Conta Poupança instanciada \n---------------------------- \nCPF do titular: " + getCpf()
		+ "\nAgência: " + getAgencia() + "\nSaldo: " + getSaldo() + "\n----------------------------";
	}
	
	
}
