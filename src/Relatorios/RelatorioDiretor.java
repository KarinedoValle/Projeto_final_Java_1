package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Pessoal.Pessoa;
import conta.Conta;

public class RelatorioDiretor {

	public static void informacaoClientes(Conta conta, Pessoa p, List<Pessoa> listaPessoas, List<Conta> listaConta)
			throws IOException {
		Collections.sort(listaPessoas);
		for (int i = 0; i < listaPessoas.size(); i++) {
			System.out.println("-------------------------- \nNome do cliente: " + listaPessoas.get(i).getNome() + "\nCPF do cliente: "
					+ listaPessoas.get(i).getCpf() + "\nNumero da agencia: " + listaConta.get(i).getAgencia() + "\n--------------------------");
			System.out.println();
		}

		pathInformacaoCliente(conta, p, listaPessoas, listaConta);
	}

	public static void pathInformacaoCliente(Conta conta, Pessoa p, List<Pessoa> listaPessoas, List<Conta> listaConta)
			throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + p.getNome() + EXTENSAO;
		escritorInformacaoCliente(path, conta, p, listaPessoas, listaConta);
	}

	public static void escritorInformacaoCliente(String path, Conta conta, Pessoa p, List<Pessoa> listaPessoas,
			List<Conta> listaConta) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "************************************************************";
		buffWrite.append(linha + "\n");
		linha = "                                    _______                          ";
		buffWrite.append(linha + "\n");
		linha = "                             � Hero | | | | Bank �                             ";
		buffWrite.append(linha + "\n");
		linha = "";
		buffWrite.append(linha + "\n");
		linha = "************************************************************";
		buffWrite.append(linha + "\n");
		linha = "-------------Relat�rio: Informa��es dos clientes-------------";
		buffWrite.append("\n" + linha + "\n");
		linha = "Ol�, " + p.getNome() + "!";
		buffWrite.append(linha + "\n");

		Collections.sort(listaPessoas);
		for (int i = 0; i < listaPessoas.size(); i++) {
			linha = "Nome do cliente: " + listaPessoas.get(i).getNome() + "\nCPF do cliente: "
					+ listaPessoas.get(i).getCpf() + "\nNumero da agencia: " + listaConta.get(i).getAgencia();
			buffWrite.append("\n" + linha + "\n");
			linha = "-----------------------Fim do relat�rio------------------------";
			buffWrite.append(linha + "\n");
			linha = "Data: " + formatar.format(date);
			buffWrite.append(linha + "\n");
			linha = "________________Volte Sempre!________________";
			buffWrite.append(linha + "\n");

		}

		buffWrite.close();
	}
}
