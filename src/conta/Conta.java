package conta;

import java.text.DecimalFormat;

public abstract class Conta implements Tributos {

	private String cpf;
	private double saldo;
	private int agencia;
	private String tipo;
	private double totalTributos = 0.0;
	private double vSeguro = 0;
	static int totalAgencia1 = 0;
	static int totalAgencia2 = 0;

	// Construtores
	public Conta() {
		super();
	}

	public Conta(String cpf, double saldo, int agencia, String tipo) {
		super();
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
		if (agencia == 001) {
			totalAgencia1++;
		} else if (agencia == 002) {
			totalAgencia2++;
		}
	}

	// Getters and Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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
		if (agencia == 001) {
			totalAgencia1++;
		} else if (agencia == 002) {
			totalAgencia2++;
		}
	}

	public double getTotalTributos() {
		return totalTributos;
	}

	public void setTotalTributos(double totalTributos) {
		this.totalTributos = totalTributos;
	}

	public double getvSeguro() {
		return vSeguro;
	}

	public void setvSeguro(double vSeguro) {
		this.vSeguro = vSeguro;
	}

	public static int getTotalAgencia1() {
		return totalAgencia1;
	}

	public static int getTotalAgencia2() {
		return totalAgencia2;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// Operações
	public String sacar(double valor) {
		if (this.saldo > valor) {
			double novoSaldo = this.getSaldo() - valor;
			this.setSaldo(novoSaldo);
			return "Saque realizado com sucesso!";
		} else {
			return "Saldo insuficiente para saque.";
		}
	}

	public String depositar(double valor) {
		double novoSaldo = this.getSaldo() + valor;
		this.setSaldo(novoSaldo);
		return "Depósito realizado com sucesso!";
	}

	public String transferir(double valor, Conta conta) {
		if (this.saldo > valor) {
			sacar(valor);
			conta.setSaldo(conta.getSaldo() + valor);
			return "Transferência realizada com sucesso!";
		} else {
			return "Saldo insuficiente para transferência.";
		}
	}

	public double contratarSeguro(double valor) {
		this.setSaldo(this.getSaldo() - this.calculoTributoSeguroDeVida(valor));
		this.vSeguro += this.calculoTributoSeguroDeVida(valor);
		double total = this.getTotalTributos() + this.calculoTributoSeguroDeVida(valor);
		this.setTotalTributos(total);
		return valor;
	}

	public double calculoTributoSeguroDeVida(double valor) {
		return valor * porcentagemSeguroDeVida;
	}
}
