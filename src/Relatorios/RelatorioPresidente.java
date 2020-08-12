package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import Pessoal.Pessoa;
import conta.Conta;

public class RelatorioPresidente {

	public static Double totalDeCapital(Conta conta, Pessoa pessoa, List<Conta> listaConta) throws IOException {
		double capitalTotal = 0;
		for (int i = 0; i < listaConta.size(); i++) {
			capitalTotal += listaConta.get(i).getSaldo();
		}
		capitalTotal += Conta.getTotalTributosBanco(); 
		pathCapital(conta, pessoa, capitalTotal);
		return capitalTotal;
	}

	public static void pathCapital(Conta conta, Pessoa pessoa, double capital) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + pessoa.getNome() + EXTENSAO;
		escritorCapital(path, conta, pessoa, capital);
	}

	public static void escritorCapital(String path, Conta conta, Pessoa p, double capital) throws IOException {
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
		linha = "------------Relatório: Total de capital no banco------------";
		buffWrite.append("\n" + linha + "\n");
		linha = "Olá, " + p.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Identificacao do Presidente: " + p.getNome() + "\nCapital total presente no banco é de: " + capital;
		buffWrite.append(linha + "\n");
		linha = "-----------------------Fim do relatório------------------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		linha = "________________Volte Sempre!________________";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
