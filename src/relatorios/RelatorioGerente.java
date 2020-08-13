package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import conta.Conta;
import pessoal.Pessoa;

public class RelatorioGerente {

	public static int totalDeContasSupervisionadas(Conta conta, Pessoa pessoa) throws IOException {
		int total = 0;
		if (conta.getAgencia() == 001) {
			total = Conta.getTotalAgencia1();
		} else if (conta.getAgencia() == 002) {
			total = Conta.getTotalAgencia2();
		}

		pathGerente(conta, pessoa, total);
		return total;
	}

	public static void pathGerente(Conta conta, Pessoa pessoa, int total) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_gerente_" + pessoa.getNome() + EXTENSAO;
		escritorGerente(path, conta, pessoa, total);
	}

	public static void escritorGerente(String path, Conta conta, Pessoa p, int total) throws IOException {
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
		linha = "--------------------Relatório: Total de contas-------------------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + p.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Gerente: " + conta.getCpf() + "\nTotal de contas supervisionadas: " + total;
		buffWrite.append(linha + "\n\n");
		linha = "--------------------------Fim do relatório--------------------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		linha = "_________________Volte Sempre!________________";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
