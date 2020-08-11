package Pessoal;

import Conta.Conta;

public class Pessoa extends Conta {

	private String nome;
	private String cpf;
	private int senha;
	private String tipo;
	
	public Pessoa() {}
	
	public Pessoa(String cpf, String nome, int senha, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		
	}
	

	
	//Getters and Setters
	
	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
	
}
