package Relatorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Conta.ContasEnum;
import Pessoal.Cliente;
import Pessoal.Diretor;
import Pessoal.Funcionario;
import Pessoal.Gerente;
import Pessoal.Pessoa;
import Pessoal.PessoasEnum;
import Pessoal.Presidente;

public class Leitura {

	public static Map<String, Pessoa> leitorPessoa(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		Map<String, Pessoa> MapPessoa = new HashMap<>();
		String linha = "", cpf = "";
		while (true) {
			linha = buffRead.readLine();

			Funcionario funcionario = null;
			Pessoa pessoa = null;
			Conta conta = null;
			if (linha != null) {
				String[] split = linha.split(";");
				if (split[3].equalsIgnoreCase(PessoasEnum.CLIENTE.name())) {
					cpf = split[0];
					pessoa = new Cliente(split[0], split[1], Integer.parseInt(split[2]), split[3]);
					MapPessoa.put(cpf, pessoa);
					System.out.println();
					System.out.println(pessoa);

				} else if (split[4].equalsIgnoreCase(PessoasEnum.GERENTE.name())) {
					cpf = split[0];
					funcionario = new Gerente(split[0].toString(), split[1], Integer.parseInt(split[2]), split[3],
							split[4], Integer.parseInt(split[5]));
					MapPessoa.put(cpf, funcionario);
					System.out.println();
					System.out.println(funcionario);

				} else if (split[4].equalsIgnoreCase(PessoasEnum.DIRETOR.name())) {
					cpf = split[0];
					funcionario = new Diretor(split[0], split[1], Integer.parseInt(split[2]), split[3], split[4],
							Integer.parseInt(split[5]));
					MapPessoa.put(cpf, funcionario);
					System.out.println();
					System.out.println(funcionario);

				} else if (split[4].equalsIgnoreCase(PessoasEnum.PRESIDENTE.name())) {
					cpf = split[0];
					funcionario = new Presidente(split[0], split[1], Integer.parseInt(split[2]), split[3], split[4]);
					MapPessoa.put(cpf, funcionario);
					System.out.println();
					System.out.println(funcionario);
				}
			} else
				break;
		}
		buffRead.close();
		return MapPessoa;
	}

	public static Map<String, Conta> leitorConta(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		Map<String, Conta> MapConta = new HashMap<>();
		String linha = "", cpf;
		while (true) {
			linha = buffRead.readLine();

			Funcionario funcionario = null;
			Pessoa pessoa = null;
			Conta conta = null;
			if (linha != null) {
				String[] split = linha.split(";");

				// LEITURA DE CONTAS
				if (split[3].equalsIgnoreCase(ContasEnum.CONTACORRENTE.name())) {
					cpf = split[0];
					conta = new ContaCorrente(split[0], Double.parseDouble(split[1]), Integer.parseInt(split[2]),
							split[3]);
					MapConta.put(cpf, conta);
					System.out.println();
					System.out.println(conta);
				} else if (split[3].equalsIgnoreCase(ContasEnum.CONTAPOUPANCA.name())) {
					cpf = split[0];
					conta = new ContaPoupanca(split[0], Double.parseDouble(split[1]), Integer.parseInt(split[2]),
							split[3]);
					MapConta.put(cpf, conta);
					System.out.println();
					System.out.println(conta);
				}
			} else
				break;
		}
		buffRead.close();
		return MapConta;
	}
	public static void escritor(String path, Pessoa pessoa, Conta conta, double saldoAnterior, double novoSaldo, double valor, String operacao) throws IOException {
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

		String linha = "-------------------------Relatório de movimentação-------------------------";
		buffWrite.append(linha + "\n");

		if (pessoa.getTipo().equals(PessoasEnum.CLIENTE.name())) {
			linha = "" + ((Cliente) pessoa).getAgencia() + "\n" + ((Cliente) pessoa).getSaldo()
					+ "\nData da movimentação: " + formatar.format(data);
			buffWrite.append(linha + "\n");
			linha = "Saldo anterior: " + saldoAnterior + "\nTipo de operação: " + operacao + "\nValor: R$" + valor + "\nSaldo atual: R$" + novoSaldo;
			buffWrite.append(linha + "\n");
			linha = "--------------------------------------------------------------------------";
			buffWrite.append(linha + "\n");
		}
		if (pessoa.getTipo().equals(PessoasEnum.GERENTE.name())) {
			linha = "" + ((Gerente) pessoa).getAgencia() + "\n" + ((Gerente) pessoa).getSaldo()
					+ "\nData da movimentação: " + formatar.format(data);
			buffWrite.append(linha + "\n");
			linha = "Saldo anterior: " + saldoAnterior + "\nTipo de operação: " + operacao + "\nValor: R$" + valor + "\nSaldo atual: R$" + novoSaldo;
			buffWrite.append(linha + "\n");
			linha = "--------------------------------------------------------------------------";
			buffWrite.append(linha + "\n");
		}
		if (pessoa.getTipo().equals(PessoasEnum.DIRETOR.name())) {
			linha = "" + ((Diretor) pessoa).getAgencia() + "\n" + ((Diretor) pessoa).getSaldo()
					+ "\nData da movimentação: " + formatar.format(data);
			buffWrite.append(linha + "\n");
			linha = "Saldo anterior: " + saldoAnterior + "\nTipo de operação: " + operacao + "\nValor: R$" + valor + "\nSaldo atual: R$" + novoSaldo;
			buffWrite.append(linha + "\n");
			linha = "--------------------------------------------------------------------------";
			buffWrite.append(linha + "\n");
		}
		if (pessoa.getTipo().equals(PessoasEnum.DIRETOR.name())) {
			linha = "" + ((Presidente) pessoa).getSaldo()
					+ "\nData da movimentação: " + formatar.format(data);
			buffWrite.append(linha + "\n");
			linha = "Saldo anterior: " + saldoAnterior + "\nTipo de operação: " + operacao + "\nValor: R$" + valor + "\nSaldo atual: R$" + novoSaldo;
			buffWrite.append(linha + "\n");
			linha = "--------------------------------------------------------------------------";
			buffWrite.append(linha + "\n");
		}

		buffWrite.close();
	}

	public static void escritorPath(Pessoa pessoa, Conta conta, double saldoAnterior, double novoSaldo, double valor, String operacao) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + pessoa.getNome() + EXTENSAO;
		escritor(path, pessoa, conta, saldoAnterior, novoSaldo, valor, operacao);
	}

}
