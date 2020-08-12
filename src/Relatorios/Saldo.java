package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Pessoal.Pessoa;

public class Saldo {

	public static void pathsaldo(Pessoa p, Conta conta) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		final String OPERACAO = "saldo";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + OPERACAO +"_" + p.getNome() + EXTENSAO;
		escritorSaldo(path, conta, p);	
	}
	
	public static void escritorSaldo(String path, Conta conta, Pessoa p) throws IOException {
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "**************Saldo**************";
		buffWrite.append("\n" + linha + "\n");
		linha = "Ola, " + p.getNome();
		buffWrite.append(linha + "\n");
		linha = "Saldo atual: " + conta.getSaldo();
		buffWrite.append(linha + "\n");
		linha = "**********Fim do Saldo**********"; 
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		linha = "__________Volte Sempre!_________";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	
}
