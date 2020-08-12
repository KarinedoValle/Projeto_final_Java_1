package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Conta.Tributos;
import Pessoal.Pessoa;

public class TributacaoCC {
	

	public static void pathTributacao(Pessoa p, Conta conta) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		final String OPERACAO = "Tributacao da CC";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) +"_"+ OPERACAO + "_" + conta.getCpf() + EXTENSAO;
		escritorTributacao(path, conta, p);	
	}
	
	public static void escritorTributacao(String path, Conta conta, Pessoa p) throws IOException {
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "*******Tributa��o da Conta Corrente********";
		buffWrite.append("\n" + linha + "\n");
		linha = "Ola, " + p.getNome();
		buffWrite.append(linha + "\n");
		linha = "No dia " + formatar.format(date) + "\n";
		buffWrite.append(linha + "\n");
		linha = "Voc� gastou um total de R$" + conta.getTotalTributos();
		buffWrite.append(linha + "\n");
		linha = "************Final da Tributa��o************";
		buffWrite.append(linha + "\n");
		linha = "No nosso banco, a tributa��o para cada opera��o �:\n" + "Para o saque: " + Tributos.saque + 
				"\nPara o dep�sito:" + Tributos.deposito +
				"\nPara as transfer�ncias: " + Tributos.transferencia;
			buffWrite.append(linha + "\n");
		linha = "______________Volte Sempre!______________";

		buffWrite.close();
	}
	
}
