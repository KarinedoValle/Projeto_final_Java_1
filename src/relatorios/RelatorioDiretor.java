package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import conta.Conta;
import pessoal.Pessoa;

public class RelatorioDiretor {

	public static void informacaoClientes(Conta conta, Pessoa p, List<Pessoa> listaPessoas, List<Conta> listaConta)
			throws IOException {
		Collections.sort(listaPessoas);
		for (int i = 0; i < listaPessoas.size(); i++) {
			System.out.println("----------------------------------- \nNome do cliente: " + listaPessoas.get(i).getNome() + "\nCPF do cliente: "
					+ listaPessoas.get(i).getCpf() + "\nNumero da agência: " + listaConta.get(i).getAgencia() + "\n-----------------------------------");
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
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_diretor_" + p.getNome() + EXTENSAO;
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
		linha = "                             ° Hero | | | | Bank °                             ";
		buffWrite.append(linha + "\n");
		linha = "";
		buffWrite.append(linha + "\n");
		linha = "************************************************************";
		buffWrite.append(linha + "\n");
		linha = "-------------Relatório: Informações dos clientes-------------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + p.getNome() + "!";
		buffWrite.append(linha + "\n");

		Collections.sort(listaPessoas);
		for (int i = 0; i < listaPessoas.size(); i++) {
			linha = "-------------------------------------------- \nNome do cliente: " + listaPessoas.get(i).getNome() + "\nCPF do cliente: "
					+ listaPessoas.get(i).getCpf() + "\nNúmero da agência: " + listaConta.get(i).getAgencia() + "\n--------------------------------------------";
			buffWrite.append("\n" + linha + "\n");
		}
			linha = "\n--------------------------Fim do relatório--------------------------";
			buffWrite.append(linha + "\n");
			linha = "Data: " + formatar.format(date);
			buffWrite.append(linha + "\n");
			linha = "_________________Volte Sempre!________________";
			buffWrite.append(linha + "\n");


		buffWrite.close();
	}
}
