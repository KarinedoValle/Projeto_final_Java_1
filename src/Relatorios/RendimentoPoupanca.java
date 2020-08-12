package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Conta.ContaPoupanca;

public class RendimentoPoupanca {
	public static void pathRendimento(Conta conta, double valor, int dias) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + conta.getCpf() + EXTENSAO;
		escritorRendimento(path, conta, valor, dias);	
	}
	
	public static void escritorRendimento(String path, Conta conta, double valor, int dias) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "*******Simulacao de Rendimento********";
		buffWrite.append(linha + "\n");
		linha = "Agencia: " + conta.getAgencia() + "\nValor de aplicacao: " + valor + "\nQuantidade de dias" + dias +
				"\nRendimento previsto: " + ((ContaPoupanca)conta).getValorRendimento();
			buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	
}
