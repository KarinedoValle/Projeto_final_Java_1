package pessoal;

import conta.Conta;

public class Pessoa extends Conta implements Comparable<Pessoa>{
	
	private String tipo;
	private String nome;
	private String cpf;
	private int senha;
	
	public Pessoa(String nome, String cpf, int senha, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public Pessoa() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
    public int compareTo(Pessoa pessoa) {
		return this.getNome().compareToIgnoreCase(pessoa.getNome());
    }
	
}
