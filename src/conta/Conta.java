package conta;

import java.text.DecimalFormat;

public abstract class Conta implements Tributos{

	private String cpf;
	private double saldo;
	private int agencia;
	private double totalTributos = 0.0;
	static double totalTributosBanco = 0.0;
	private double vSeguro = 0;
	static int totalAgencia1 =0;
	static int totalAgencia2 = 0;

	public Conta(String cpf, double saldo, int agencia) {
		super();
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
		if(agencia == 001) {
			totalAgencia1++;
		} else if(agencia == 002) {
			totalAgencia2++;
		}
	}



	public Conta() {
		super();
	}

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
		if(agencia == 001) {
			totalAgencia1++;
		} else if(agencia == 002) {
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
	
	public static double getTotalTributosBanco() {
		return totalTributosBanco;
	}
	
	public static void setTotalTributosBanco(double totalTributosBanco) {
		Conta.totalTributosBanco = totalTributosBanco;
	}

	

	// operacoes
	public String sacar(double valor) {
		double saldoAnterior;
		double novoSaldo;
		if (this.saldo > valor) {
			saldoAnterior = this.getSaldo();
			novoSaldo = getSaldo() - valor;
			this.setSaldo(novoSaldo);
			return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + "%.2f, novoSaldo";
		} else {
			return "Saldo insuficiente para saque.";
		}
	}

	public String depositar(double valor) {
		double novoSaldo;
		double saldoAnterior = this.getSaldo();
		novoSaldo = this.getSaldo() + valor;
		this.setSaldo(novoSaldo);
		return "Saldo anterior: " + saldoAnterior + "\nValor depositado: " + valor + "\nSaldo atual: " +"%.2f, novoSaldo";
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
        vSeguro += calculoTributoSeguroDeVida(valor);
        double totalTributosGeral =  getTotalTributos() + calculoTributoSeguroDeVida(valor);
        setTotalTributosBanco(totalTributosGeral);
        return "O valor segurado é: " + valorSegurado;
    }
	
	 public double calculoTributoSeguroDeVida(double valor) {
	        return valor * porcentagemSeguroDeVida;
	    }
}
