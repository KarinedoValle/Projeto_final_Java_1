package Conta;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Pessoal.Pessoa;
import Relatorios.Leitura;

public class ContaCorrente extends Conta {
	Leitura leitor = new Leitura();

	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String cpf, double saldo, int agencia, String tipoConta) {
		super(cpf, saldo, agencia, tipoConta);
	}


	@Override
	public String sacar(double valor, Conta conta, Pessoa pessoa) throws IOException {
		double saldoAnterior;
		double novoSaldo;
		String operacao = "Saque";
		if (this.getSaldo() > valor + saque) {
			saldoAnterior = this.getSaldo();
			novoSaldo = getSaldo() - valor - saque;
			this.setSaldo(novoSaldo);
			leitor.escritorPath (pessoa, conta, saldoAnterior, novoSaldo, valor, operacao);
			return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + novoSaldo;
		} else {
			return "Saldo insuficiente para saque.";
		}
	}

	@Override
	public String depositar(double valor, Conta conta, Pessoa pessoa) throws IOException {
		double novoSaldo;
		double saldoAnterior = this.getSaldo();
		String operacao = "Depósito";
		novoSaldo = this.getSaldo() + valor - deposito;
		this.setSaldo(novoSaldo);
		leitor.escritorPath (pessoa, conta, saldoAnterior, novoSaldo, valor, operacao);
		return "Saldo anterior: " + saldoAnterior + "\nValor depositado: " + valor + "\nSaldo atual: " + novoSaldo;
	}

	@Override
	public String transferir(double valor, Conta conta, Conta destinatario, Pessoa pessoa) throws IOException {
		double saldoAnterior;
		double novoSaldo;
		String operacao = "Transferir";
		if (this.getSaldo() > valor + transferencia) {
			saldoAnterior = this.getSaldo();
			novoSaldo = getSaldo() - valor - transferencia;
			sacar(valor, conta, pessoa);
			this.setSaldo(novoSaldo);
			destinatario.setSaldo(conta.getSaldo() + valor);
			leitor.escritorPath (pessoa, conta, saldoAnterior, novoSaldo, valor, operacao);
			return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + novoSaldo;
		} else {
			return "Saldo insuficiente para transferencia.";
		}
	}

}
