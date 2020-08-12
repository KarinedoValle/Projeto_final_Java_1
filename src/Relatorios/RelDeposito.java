package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Pessoal.Pessoa;
import conta.Conta;

public class RelDeposito {

	public static void pathDeposito(Conta conta, double valor, Pessoa pessoa) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + pessoa.getNome() + EXTENSAO;
		escritorDeposito(path, conta, pessoa, valor);
	}

	public static void escritorDeposito(String path, Conta conta, Pessoa p, double valor) throws IOException {
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
		linha = "--------------------Relat�rio de dep�sito--------------------";
		buffWrite.append("\n" + linha + "\n");
		linha = "Ol�, " + p.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Agencia: " + conta.getAgencia() + "\nValor depositado: " + valor + "\nSaldo: " + conta.getSaldo();
		buffWrite.append(linha + "\n");
		linha = "-----------------------Fim do relat�rio------------------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		linha = "________________Volte Sempre!________________";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
