package Pessoal;

import Conta.Conta;

public class Pessoa extends Conta {

	private String nome;
	private int cpf;
	private int senha;
	
	public Pessoa(String nome, int cpf, int senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		
	}
	
	public Pessoa() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
	
}
