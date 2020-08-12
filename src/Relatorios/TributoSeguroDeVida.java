package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Conta.ContaPoupanca;

public class TributoSeguroDeVida {
	
		public static void pathSeguro(Conta conta) throws IOException {
			final String PATH_BASICO = "./temp/";
			final String EXTENSAO = ".txt";
			Date date = new Date();
			SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String path = PATH_BASICO + formatar.format(date) + "_" + conta.getCpf() + EXTENSAO;
			escritorRendimento(path, conta);	
		}
		
		public static void escritorRendimento(String path, Conta conta) throws IOException {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			String linha = "";
			linha = "*******Tributacao Seguro de Vida********";
			buffWrite.append(linha + "\n");
			linha = "Agencia: " + conta.getAgencia() + "\nValor do tributo: " + conta.getvSeguro();
				buffWrite.append(linha + "\n");

			buffWrite.close();
		}
}
