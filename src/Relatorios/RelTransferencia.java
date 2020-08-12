package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;

public class RelTransferencia {
	
	public static void pathTransferencia(Conta conta, double valor, String cpfDestinatario) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + conta.getCpf() + EXTENSAO;
		escritorTransferencia(path, conta, valor, cpfDestinatario);	
	}
	
	public static void escritorTransferencia(String path, Conta conta, double valor, String cpfDestinatario) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "*******Transferencia********";
		buffWrite.append(linha + "\n");
		linha = "Agencia: " + conta.getAgencia() + "\nValor transferido: " + valor + "\nCPF do estinatario: " + cpfDestinatario +
				"\nSaldo: " + conta.getSaldo();
			buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
