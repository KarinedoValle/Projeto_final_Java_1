package Pessoal;

import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class Diretor extends Funcionario {

	public Diretor() {
		super();}

	public Diretor(String nome, String cpf, String cargo, int senha) {
		super(nome, cargo, cpf, senha);}

	@Override
	public String toString() {
		return "\nDiretor \n[getNome()=" + getNome() + ",\ngetCpf()=" + getCpf() + ",\ngetSenha()=" + getSenha()
				+ ",\ngetSaldo()=" + getSaldo() + ",\ngetAgencia()=" + getAgencia() + "]";
	}


				
	}

