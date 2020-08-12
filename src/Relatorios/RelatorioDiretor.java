package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Conta.Conta;
import Pessoal.Pessoa;

public class RelatorioDiretor {

	
	public static void informacaoClientes(Conta conta, List<Pessoa> listaPessoas, List<Conta> listaConta) throws IOException {
		
		for(int i = 0; i < listaPessoas.size(); i++) {
				System.out.println("Nome do cliente: " + listaPessoas.get(i).getNome() + 
						"\nCPF do cliente: " + listaPessoas.get(i).getCpf() +
						"\nNumero da agencia: " + listaConta.get(i).getAgencia());
			
		}
		
		pathInformacaoCliente(conta, listaPessoas, listaConta);
	}
	
	
	public static void pathInformacaoCliente(Conta conta, List<Pessoa> listaPessoas, List<Conta> listaConta) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + conta.getCpf() + EXTENSAO;
		escritorInformacaoCliente(path, conta, listaPessoas, listaConta);
	}
	
	public static void escritorInformacaoCliente(String path, Conta conta, List<Pessoa> listaPessoas, List<Conta> listaConta) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "*******Informacao dos Clientes********";
		buffWrite.append(linha + "\n");
	
		for(int i = 0; i < listaPessoas.size(); i++) {
				linha = "Nome do cliente: " + listaPessoas.get(i).getNome() + 
						"\nCPF do cliente: " + listaPessoas.get(i).getCpf() +
						"\nNumero da agencia: " + listaConta.get(i).getAgencia();
				buffWrite.append("\n" + linha + "\n");
			
		}

		buffWrite.close();
	}
}
