package Conta;

public abstract class Conta implements Tributos{

	private int cpf;
	private double saldo;
	private int agencia;

	public Conta(int cpf, double saldo, int agencia) {
		super();
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
	}

	public Conta() {
		super();
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	// operacoes
	public String sacar(double valor) {
		double saldoAnterior;
		double novoSaldo;
		if (this.saldo > valor) {
			saldoAnterior = this.getSaldo();
			novoSaldo = getSaldo() - valor;
			this.setSaldo(novoSaldo);
			return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + novoSaldo;
		} else {
			return "Saldo insuficiente para saque.";
		}
	}

	public String depositar(double valor) {
		double novoSaldo;
		double saldoAnterior = this.getSaldo();
		novoSaldo = this.getSaldo() + valor;
		this.setSaldo(novoSaldo);
		return "Saldo anterior: " + saldoAnterior + "\nValor depositado: " + valor + "\nSaldo atual: " + novoSaldo;
	}

	public String transferir(double valor, Conta conta) {
		double saldoAnterior;
		double novoSaldo;
		if (this.saldo > valor) {
			saldoAnterior = this.getSaldo();
			novoSaldo = getSaldo() - valor;
			sacar(valor);
			conta.setSaldo(conta.getSaldo() + valor);
			return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + novoSaldo;
		} else {
			return "Saldo insuficiente para transferência.";
		}
	}

	public String contratarSeguro(double valor) {
        double valorSegurado = valor - calculoTributoSeguroDeVida(valor);
        return "O valor segurado é: " + valorSegurado;
    }
	
	 public double calculoTributoSeguroDeVida(double valor) {
	        return valor * porcentagemSeguroDeVida;
	    }
}
