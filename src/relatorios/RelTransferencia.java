package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import conta.Conta;
import pessoal.Pessoa;

public class RelTransferencia {

	public static void pathTransferencia(Conta conta, double valor, Pessoa pessoa, String cpfDestinatario)
			throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_transferencia_" + pessoa.getNome() + EXTENSAO;
		escritorTransferencia(path, conta, pessoa, valor, cpfDestinatario);
	}

	public static void escritorTransferencia(String path, Conta conta, Pessoa p, double valor, String cpfDestinatario)
			throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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
		linha = "-------------------Relatório de Transferência------------------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + p.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor transferido: R$ " + valor + "\nCPF do destinatário: "
				+ cpfDestinatario + "\nSaldo atual: R$ " + conta.getSaldo();
		buffWrite.append(linha + "\n\n");
		linha = "-------------------------Fim do relatório--------------------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		linha = "_________________Volte Sempre!________________";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
