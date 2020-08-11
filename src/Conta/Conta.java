package Conta;

import java.io.IOException;

import Pessoal.Pessoa;
import Relatorios.Leitura;

public abstract class Conta implements Tributos{
	Leitura leitor = new Leitura();

	private String cpf;
	private double saldo;
	private int agencia;
	private String TipoConta;

	public Conta(String cpf, double saldo, int agencia, String tipo) {
		super();
		this.TipoConta = tipo;
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
	}

	public Conta() {
		super();
	}

	
	//Getters and Setters
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
	}

	// operacoes
	public String sacar(double valor, Conta conta, Pessoa pessoa) throws IOException {
		double saldoAnterior;
		double novoSaldo;
		String operacao = "Saque";
		if (this.saldo > valor) {
			saldoAnterior = this.getSaldo();
			novoSaldo = getSaldo() - valor;
			this.setSaldo(novoSaldo);
			leitor.escritorPath (pessoa, conta, saldoAnterior, novoSaldo, valor, operacao);
			return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + novoSaldo;
		} else {
			return "Saldo insuficiente para saque.";
		}
	}

	public String depositar(double valor, Conta conta, Pessoa pessoa) throws IOException {
		double novoSaldo;
		double saldoAnterior = this.getSaldo();
		String operacao = "Depósito";
		novoSaldo = this.getSaldo() + valor;
		this.setSaldo(novoSaldo);
		leitor.escritorPath (pessoa, conta, saldoAnterior, novoSaldo, valor, operacao);
		return "Saldo anterior: " + saldoAnterior + "\nValor depositado: " + valor + "\nSaldo atual: " + novoSaldo;
	}

	public String transferir(double valor, Conta conta, Conta destinatario, Pessoa pessoa) throws IOException {
		double saldoAnterior;
		double novoSaldo;
		String operacao = "Transferência";
		if (this.saldo > valor) {
			saldoAnterior = this.getSaldo();
			novoSaldo = getSaldo() - valor;
			sacar(valor, conta, pessoa);
			destinatario.setSaldo(conta.getSaldo() + valor);
			leitor.escritorPath (pessoa, conta, saldoAnterior, novoSaldo, valor, operacao);
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

	
