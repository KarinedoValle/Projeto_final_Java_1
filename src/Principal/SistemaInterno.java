package Principal;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import Conta.Conta;
import Pessoal.Cliente;
import Pessoal.Diretor;
import Pessoal.Funcionario;
import Pessoal.Gerente;
import Pessoal.Pessoa;
import Pessoal.PessoasEnum;
import Pessoal.Presidente;
import Relatorios.Leitura;

public class SistemaInterno  {

	public static void main(String[] args) throws IOException {
		
		Leitura Leitor = new Leitura();
		
		Scanner scan = new Scanner(System.in);
		String cpf;
		int senha = 0, senhaCorreta = 0, op = 0;
		String classe;

		Map<String, Pessoa> MapPessoa = null;
		MapPessoa = Leitor.leitorPessoa("./temp/cargaPessoas.txt");

		Map<String, Conta> MapConta = null;
		MapConta = Leitor.leitorConta("./temp/cargaContas.txt");
		Pessoa pessoa = null;
		Funcionario funcionario = null;
		Cliente cliente = null;
		Conta conta = null;

		do {
			if (senhaCorreta != senha) {
				System.out.println("Senha incorreta. Tente novamente.");
				System.out.println();
			}
			System.out.println("------------------------------------------------------");
			System.out.println("            Bem-vindo(a) ao Banco do Java!            ");
			System.out.println("------------------------------------------------------");
			System.out.print("Digite seu CPF usando somente números: ");
			cpf = scan.next();
			System.out.print("Digite sua senha: ");
			senha = scan.nextInt();

			pessoa = MapPessoa.get(cpf);
			senhaCorreta = pessoa.getSenha();

		} while (senhaCorreta != senha);

		classe = pessoa.getClass().toString();
		if (funcionario != null && cliente != null) {
			System.out.println("------------------------------------------------------");
			System.out.println("            Bem-vindo(a) ao Banco do Java!            ");
			System.out.println("------------------------------------------------------");
			System.out.println("Deseja logar como cliente ou como funcionário? ");
			System.out.println("1 - Cliente ");
			System.out.println("2 - Funcionário ");
			System.out.print(" Opção: ");
			op = scan.nextInt();
		}
		
		else if (pessoa.getTipo() == PessoasEnum.CLIENTE.name()) {
			pessoa = (Cliente) MapPessoa.get(cpf);

		} else if (pessoa.getTipo() == PessoasEnum.DIRETOR.name()){
			funcionario = (Diretor) MapPessoa.get(cpf);
		
		}  else if (pessoa.getTipo() == PessoasEnum.GERENTE.name()){
			funcionario = (Gerente) MapPessoa.get(cpf);
	
		} else if (pessoa.getTipo() == PessoasEnum.PRESIDENTE.name()){
			funcionario = (Presidente) MapPessoa.get(cpf);
		}
		conta = MapConta.get(cpf);

		// IDENTIFICAR SE O USUÁRIO É UM CLIENTE, GERENTE, DIRETOR OU PRESIDENTE
		if (funcionario != null && cliente != null) {
			

			if (op == 1) {
				((Cliente) pessoa).menu(conta, pessoa);
			} else if (op == 2) {

				if (funcionario.getCargo().equalsIgnoreCase(PessoasEnum.GERENTE.name())) {
					((Gerente) funcionario).menu(conta);

				} else if (funcionario.getCargo().equalsIgnoreCase(PessoasEnum.DIRETOR.name())) {
					((Diretor) funcionario).menu(conta);

				} else if (funcionario.getCargo().equalsIgnoreCase(PessoasEnum.PRESIDENTE.name())) {
					((Presidente) funcionario).menu(conta);

				}
			}
		} else {
			System.out.println("Usuário inválido! Tente novamente.");
		}
		
	}
}
