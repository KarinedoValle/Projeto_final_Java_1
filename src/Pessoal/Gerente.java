package Pessoal;

import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class Gerente extends Funcionario{
	
	private int agencia;

	
	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, String cpf, String cargo, int senha, int agencia) {
		super(nome, cargo, cpf, senha);
		this.agencia = agencia;
		// TODO Auto-generated constructor stub
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "\nGerente \n[agencia=" + agencia + ",\ngetNome()=" + getNome() + ",\ngetCpf()=" + getCpf()
				+ ",\ngetSenha()=" + getSenha() + ",\ngetSaldo()=" + getSaldo() + "]";
	}


				
	}
	
