package Pessoal;

import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class Presidente extends Funcionario{
	
	public Presidente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Presidente(String nome, String cpf, String cargo, int senha) {
		super(nome, cargo, cpf, senha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\nPresidente \n[getNome()=" + getNome() + ",\ngetCpf()=" + getCpf() + ",\ngetSenha()=" + getSenha()
				+ ",\ngetSaldo()=" + getSaldo() + ",\ngetAgencia()=" + getAgencia() + "]";
	}

	
	
}
