package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import conta.Conta;
import pessoal.Pessoa;
import uteis.Uteis;

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
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
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
		linha = "---------------------------------Saldo-------------------------------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + p.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Saldo atual: R$ " + conta.getSaldo();
		buffWrite.append(linha + "\n\n");
		linha = "---------------------------Fim do saldo---------------------------"; 
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		linha = "_________________Volte Sempre!________________";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	
}
