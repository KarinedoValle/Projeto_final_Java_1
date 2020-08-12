package Pessoal;

import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class Cliente extends Pessoa{

	
		
	public Cliente() {
		super();}

	public Cliente(String nome, String cpf, String tipo, int senha) {
		super(nome, cpf, senha, tipo);
	}

	@Override
	public String toString() {
		return "\nCliente \n[getNome()=" + getNome() + ",\ngetCpf()=" + getCpf() + ",\ngetSenha()=" + getSenha()
				+ ",\ngetSaldo()=" + getSaldo() + ",\ngetAgencia()=" + getAgencia() + "]";
	}
	

	
}

