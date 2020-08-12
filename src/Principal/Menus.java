package Principal;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Conta.Tributos;
import Pessoal.Pessoa;
import Relatorios.RelDeposito;
import Relatorios.RelSaque;
import Relatorios.RelTransferencia;
import Relatorios.RelatorioDiretor;
import Relatorios.RelatorioGerente;
import Relatorios.RelatorioPresidente;
import Relatorios.RendimentoPoupanca;
import Relatorios.Saldo;
import Relatorios.TributacaoCC;
import Relatorios.TributoSeguroDeVida;

public class Menus {

	static Scanner scan = new Scanner(System.in);
	static String cpf;

	public static void menuGeral(List<Pessoa> listaPessoas, List<Conta> listaConta) throws IOException{
		System.out.println("------------------------------------------------------------");
		System.out.println("                           Login                            ");
		System.out.println("------------------------------------------------------------");
		System.out.println("CPF: ");
		cpf = scan.next();
		System.out.println("Senha: ");
		int senha = scan.nextInt();

		Pessoa pl = null, p = null;
		Conta cl = null, c = null;
		
		for(int i = 0; i < listaPessoas.size(); i++) {
			pl = listaPessoas.get(i);
			if(pl.getCpf().equalsIgnoreCase(cpf)) {
				p = listaPessoas.get(i);
			}
			
		}
		
		for(int i = 0; i < listaConta.size(); i++) {
			cl = listaConta.get(i);
			if(cl.getCpf().equalsIgnoreCase(cpf)) {
				c = listaConta.get(i);
			}
		}
		
		

		if(p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha && p.getTipo().equalsIgnoreCase("Cliente")) {
			menuCliente(p, c);
		}else if(p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha && p.getTipo().equalsIgnoreCase("Gerente")) {
			menuFuncionario(p, c, listaPessoas, listaConta);
		}else if(p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha && p.getTipo().equalsIgnoreCase("Diretor")) {
			menuFuncionario(p, c, listaPessoas, listaConta);
		}else if(p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha && p.getTipo().equalsIgnoreCase("Presidente")) {
			menuFuncionario(p, c, listaPessoas, listaConta);
		}else {
			System.out.println("Usuario nao cadastrado!");
		}

	}

	public static void menuFuncionario(Pessoa p, Conta c, List<Pessoa> listaPessoas, List<Conta> listaConta) throws IOException{

		int op;

		System.out.println("------------------------------------------------------------");
		System.out.println("                           Login                            ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Gostaria de logar com:");
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcionario");
		op = scan.nextInt();

		if(op == 1) {
			menuCliente(p, c);
		}else if(op == 2 && p.getTipo().equalsIgnoreCase("Gerente")) {
			menuGerente(p, c);
		}else if(op == 2 && p.getTipo().equalsIgnoreCase("Diretor")) {
			menuDiretor(p, c, listaPessoas, listaConta);
		}else if(op == 2 && p.getTipo().equalsIgnoreCase("Presidente")) {
			menuPresidente(p, c, listaConta);
		}
	}

	public static void menuCliente(Pessoa p, Conta conta) throws IOException{
		int op1 = 1, op2 = 1, op3 = 0, r = 0;
		double valor;
		int dias;
		String cpf;

do {
		do {
			System.out.println(""); 
			System.out.println(""); 
			System.out.println("");
			if (op1 != 1 && op1 != 2) {
				System.out.println("Opcao invalida. Tente novamente.");
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("                   O que deseja consultar?                   ");
			System.out.println("------------------------------------------------------------");
			System.out.println("1 - Movimentacoes da conta");
			System.out.println("2 - Relatorios");
			System.out.print(" Opcao: ");
			op1 = scan.nextInt();
		} while (op1 != 1 && op1 != 2);

		//submenu
		if (op1 == 1) {
			do {
				System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
				if (op2 < 1 || op2 > 4) {
					System.out.println("Opcao invalida. Tente novamente.");
				}
				System.out.println("------------------------------------------------------------");
				System.out.println("                   Movimentacoes da conta                   ");
				System.out.println("------------------------------------------------------------");
				System.out.println("1 - Saque");
				System.out.println("2 - Deposito");
				System.out.println("3 - Transferencia");
				System.out.println("4 - Contratar seguro de vida");
				System.out.print(" Opcao: ");
				op2 = scan.nextInt();
			} while (op2 < 1 || op2 > 4);
			if (op2 == 1) {
				op3 = 11;
			} else if (op2 == 2) {
				op3 = 12;
			} else if (op2 == 3) {
				op3 = 13;
			} else if (op2 == 4) {
				op3 = 14;
			}

		} else if (op1 == 2) {
			do {
				System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
				if (op2 < 1 || op2 > 4) {
					System.out.println("Opcao invalida. Tente novamente.");
				}
				System.out.println("------------------------------------------------------------");
				System.out.println("                         Relatorios                         ");
				System.out.println("------------------------------------------------------------");
				System.out.println("1 - Saldo");
				System.out.println("2 - Relatorio de tributacao da conta corrente");
				System.out.println("3 - Relatorio de rendimento da poupanca");
				System.out.println("4 - Tributacao referente ao seguro de vida");
				System.out.print(" Opcao: ");
				op2 = scan.nextInt();
			} while (op2 < 1 || op2 > 4);

			if (op2 == 1) {
				op3 = 21;
			} else if (op2 == 2) {
				op3 = 22;
			} else if (op2 == 3) {
				op3 = 23;
			} else if (op2 == 4) {
				op3 = 24;
			}
		}

		if (op3 == 11) {

			System.out.println(""); 
			System.out.println(""); 
			System.out.println("");
			System.out.println("------------------------------------------------------------");
			System.out.println("                            Saque                            ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Digite o valor que deseja sacar: ");
			valor = scan.nextDouble();
			System.out.println(conta.sacar(valor));
			RelSaque.pathSaque(conta, valor);

			System.out.println("\nGostaria de continuar logado? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			r = scan.nextInt();
				
			
		} else if (op3 == 12) {
			System.out.println(""); 
			System.out.println(""); 
			System.out.println("");
			System.out.println("------------------------------------------------------------");
			System.out.println("                          Deposito                          ");
			System.out.println("------------------------------------------------------------");
			System.out.print("\nDigite o valor que deseja depositar: ");
			valor = scan.nextDouble();
			System.out.println(conta.depositar(valor));
			RelDeposito.pathDeposito(conta, valor);
			
			System.out.println("Gostaria de continuar logado? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			r = scan.nextInt();
			
		} else if (op3 == 13) {
			System.out.println(""); 
			System.out.println(""); 
			System.out.println("");
			System.out.println("------------------------------------------------------------");
			System.out.println("                        Transferencia                        ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Digite o valor que deseja transferir: ");
			valor = scan.nextDouble();
			System.out.print("\nDigite o CPF do titular da conta de destino: ");
			cpf = scan.next();
			Conta destinatario = new ContaCorrente();//
			destinatario.setCpf(cpf);//Caso queira verificar se entrou na conta
			System.out.println(conta.transferir(valor, destinatario));
			RelTransferencia.pathTransferencia(conta, valor, cpf);
			
			System.out.println("\nGostaria de continuar logado? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			r = scan.nextInt();
			
		} else if (op3 == 14) {
			System.out.println("------------------------------------------------------------");
			System.out.println("                  Contratar seguro de vida                  ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Digite o valor que sera assegurado: ");
			valor = scan.nextDouble();
			System.out.println(conta.contratarSeguro(valor));
			
			System.out.println("\nGostaria de continuar logado? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			r = scan.nextInt();
			
		} else if (op3 == 21) {
			System.out.println(""); 
			System.out.println(""); 
			System.out.println("");;
			System.out.println("------------------------------------------------------------");
			System.out.println("                            Saldo                           ");
			System.out.println("------------------------------------------------------------");
			System.out.print("Saldo atual de: R$" + conta.getSaldo());
			Saldo.pathsaldo(p, conta);;
			
			System.out.println("\nGostaria de continuar logado? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			r = scan.nextInt();
			
		} else if (op3 == 22) {
			try {
				System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
				// Terminar de fazer o relatorio com os gastos por operacoes
				System.out.println("------------------------------------------------------------");
				System.out.println("          Relatorio de tributacao da conta corrente          ");
				System.out.println("------------------------------------------------------------");
				System.out.println("Tributacao por operacao bancaria");
				System.out.println("Gasto total da tributacao: " + conta.getTotalTributos());
				System.out.println("- Tributacao para saque: R$ " + Tributos.saque);
				System.out.println("- Tributacao para deposito: R$ " + Tributos.deposito);
				System.out.println("- Tributacao para transferencia: R$ " + Tributos.transferencia);
				System.out.println("- Tributacao para seguro de vida em porcentagem: " + Tributos.transferencia);
				TributacaoCC.pathTributacao(p, conta);
				
				System.out.println("\nGostaria de continuar logado? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				r = scan.nextInt();
				
			}catch(ClassCastException cce) {
				System.out.println("Voce nao possui conta corrente para realizar esta operacao!");
			}
		} else if (op3 == 23) {
			try {
				System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
				System.out.println("------------------------------------------------------------");
				System.out.println("             Relatorio de rendimento da poupanca             ");
				System.out.println("------------------------------------------------------------");
				System.out.println("Simulacao");
				System.out.print("Digite o valor que deseja simular: ");
				valor = scan.nextDouble();
				System.out.print("Digite a quantidade de dias desejada: ");
				dias = scan.nextInt();
				System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
				RendimentoPoupanca.pathRendimento(conta, valor, dias);
				
				System.out.println("\nGostaria de continuar logado? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				r = scan.nextInt();
				
			}catch(ClassCastException cce) {
				System.out.println("Voce nao possue conta poupanca para poder realizar esta operacao!");
			}
		}  else if (op3 == 24) {
			System.out.println(""); 
			System.out.println(""); 
			System.out.println("");
			System.out.println("------------------------------------------------------------");
			System.out.println("        Relatorio de tributacao do Seguro de Vida           ");
			System.out.println("------------------------------------------------------------");
			System.out.println("Gasto na tributacao do seguro de vida: " + conta.getvSeguro());
			System.out.println("Tributacao do seguro de vida: " + Tributos.porcentagemSeguroDeVida);
			TributoSeguroDeVida.pathSeguro(conta);
			
			System.out.println("\nGostaria de continuar logado? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			r = scan.nextInt();
			
		}
	}while(r != 2);
}

	public static void menuGerente(Pessoa p, Conta conta) throws IOException {

		int r = 0;

		System.out.println(""); 
		System.out.println(""); 
		System.out.println("");
		System.out.println("------------------------------------------------------------");
		System.out.println("      Relatorio de Numero de Contas de Sua Agencia          ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Total de agencias em sua supervisao: " + RelatorioGerente.totalDeContasSupervisionadas(conta));
		
		System.out.println();
		System.out.println("Gostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		r = scan.nextInt();
		
		if(r == 1) {
			menuCliente(p, conta);
		}else {
			System.exit(0);
		}

	}

	public static void menuDiretor(Pessoa p, Conta conta, List<Pessoa> listaPessoas, List<Conta> listaConta) throws IOException {

		int r = 0;
		
		System.out.println(""); 
		System.out.println(""); 
		System.out.println("");
		System.out.println("------------------------------------------------------------");
		System.out.println("         Relatorio: Informacoes de todos os clientes        ");
		System.out.println("------------------------------------------------------------");
		RelatorioDiretor.informacaoClientes(conta, listaPessoas, listaConta);
		
		System.out.println();
		System.out.println("Gostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		r = scan.nextInt();
		
		if(r == 1) {
			menuCliente(p, conta);
		}else {
			System.exit(0);
		}
		
	}

	public static void menuPresidente(Pessoa p, Conta conta, List<Conta> listaConta) throws IOException {

		int r = 0;
		
		System.out.println(""); 
		System.out.println(""); 
		System.out.println("");
		System.out.println("------------------------------------------------------------");
		System.out.println("     Relatorio Valor Total Capital Armazenado no Banco      ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Total de capital armazenado: R$ " + RelatorioPresidente.totalDeCapital(conta, listaConta));
		
		System.out.println();
		System.out.println("Gostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		r = scan.nextInt();
		
		if(r == 1) {
			menuCliente(p, conta);
		}else {
			System.exit(0);
		}

	}


}