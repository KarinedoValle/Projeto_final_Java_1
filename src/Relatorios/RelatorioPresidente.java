package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import Conta.Conta;

public class RelatorioPresidente {

	public static Double totalDeCapital(Conta conta,  List<Conta> listaConta) throws IOException {
		double capitalTotal = 0;
		for(int i = 0; i <listaConta.size(); i++) {
			capitalTotal += listaConta.get(i).getSaldo();
		}
		pathCapital(conta, capitalTotal);
		return capitalTotal;
	}
	
	
	public static void pathCapital(Conta conta, double capital) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + conta.getCpf() + EXTENSAO;
		escritorCapital(path, conta, capital);	
	}
	
	public static void escritorCapital(String path, Conta conta, double capital) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "*******Total de Capital no Banco********";
		buffWrite.append(linha + "\n");
		linha = "Identificacao do Presidente: " + conta.getCpf() + "\nCapital total presente no banco é de: " + capital ;
			buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
