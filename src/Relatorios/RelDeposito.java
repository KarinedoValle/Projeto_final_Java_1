package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;

public class RelDeposito {
	
	public static void pathDeposito(Conta conta, double valor) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + conta.getCpf() + EXTENSAO;
		escritorDeposito(path, conta, valor);	
	}
	
	public static void escritorDeposito(String path, Conta conta, double valor) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "*******Deposito********";
		buffWrite.append(linha + "\n");
		linha = "Agencia: " + conta.getAgencia() + "\nValor depositado: " + valor + "\nSaldo: " + conta.getSaldo();
			buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
