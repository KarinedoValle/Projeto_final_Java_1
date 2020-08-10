package Conta;

public class ContaPoupanca extends Conta{
	
	private String TipoConta;

	public ContaPoupanca(int cpf, double saldo, int agencia, String tipoConta) {
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
	
	public String calcularRendimentoPoupanca(double valor, int dias) {
        double valorInicial = valor;
        double valorFinal = valor;
            valorFinal = valor * rendimentoPoupancaDia * dias;
        return "O rendimento do valor R$" + valorInicial + " durante " + dias + " dias é de R$" + (valorFinal - valorInicial) + "\nO valor total é R$" + valorFinal;
    }
}
