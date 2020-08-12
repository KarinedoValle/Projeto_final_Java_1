package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import Conta.Conta;

public class RelatorioGerente {

	public static int totalDeContasSupervisionadas(Conta conta) throws IOException {
		int total = 0;
		if(conta.getAgencia() == 001) {
			total = Conta.getTotalAgencia1();
		} else if(conta.getAgencia() == 002) {
			total = Conta.getTotalAgencia2();
		}
		
		pathGerente(conta, total);
		return total;
	}
	
	
	public static void pathGerente(Conta conta, int total) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + conta.getCpf() + EXTENSAO;
		escritorGerente(path, conta, total);	
	}
	
	public static void escritorGerente(String path, Conta conta, int total) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "*******Total de Contas********";
		buffWrite.append(linha + "\n");
		linha = "Gerente: " + conta.getCpf() + "\nTotal de contas supervisionadas: " + total;
			buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
