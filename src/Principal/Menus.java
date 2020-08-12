package Principal;

import java.io.IOException;
import java.util.InputMismatchException;
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
import enums.PessoasEnum;
import uteis.Uteis;

public class Menus {

	static Scanner scan = new Scanner(System.in);
	static String cpf;

	public static void menuGeral(List<Pessoa> listaPessoas, List<Conta> listaConta) throws Exception {
		System.out.println("************************************************************");     
		System.out.println("                          _______                          ");
		System.out.println("                   ° Hero | | | | Bank °                   ");
		System.out.println();
		System.out.println("************************************************************");
		
		System.out.println("------------------------------------------------------------");
		System.out.println("                           Login                            ");
		System.out.println("------------------------------------------------------------");
		System.out.print("CPF: ");
		cpf = scan.next();
		System.out.print("Senha: ");
		int senha = scan.nextInt();

		Pessoa pl = null, p = null;
		Conta cl = null, c = null;

		for (int i = 0; i < listaPessoas.size(); i++) {
			pl = listaPessoas.get(i);
			if (pl.getCpf().equalsIgnoreCase(cpf)) {
				p = listaPessoas.get(i);
			}

		}

		for (int i = 0; i < listaConta.size(); i++) {
			cl = listaConta.get(i);
			if (cl.getCpf().equalsIgnoreCase(cpf)) {
				c = listaConta.get(i);
			}
		}

		if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha && p.getTipo().equalsIgnoreCase("Cliente")) {
			menuCliente(p, c);
		} else if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha
				&& p.getTipo().equalsIgnoreCase("Gerente")) {
			menuFuncionario(p, c, listaPessoas, listaConta);
		} else if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha
				&& p.getTipo().equalsIgnoreCase("Diretor")) {
			menuFuncionario(p, c, listaPessoas, listaConta);
		} else if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha
				&& p.getTipo().equalsIgnoreCase("Presidente")) {
			menuFuncionario(p, c, listaPessoas, listaConta);
		} else {
			System.out.println("Usuario nao cadastrado!");
		}

	}

	public static void menuFuncionario(Pessoa p, Conta c, List<Pessoa> listaPessoas, List<Conta> listaConta)
			throws Exception {

		int op;
		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("                           Login                            ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Gostaria de logar com:");
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcionario");
		System.out.print(" Opcao: ");
		op = scan.nextInt();

		if (op == 1) {
			menuCliente(p, c);
		} else if (op == 2 && p.getTipo().equalsIgnoreCase(PessoasEnum.GERENTE.name())) {
			menuGerente(p, c);
		} else if (op == 2 && p.getTipo().equalsIgnoreCase(PessoasEnum.DIRETOR.name())) {
			menuDiretor(p, c, listaPessoas, listaConta);
		} else if (op == 2 && p.getTipo().equalsIgnoreCase(PessoasEnum.PRESIDENTE.name())) {
			menuPresidente(p, c, listaConta);
		}
	}

	public static void menuCliente(Pessoa p, Conta conta) throws Exception {
		int op1 = 1, op2 = 1, op3 = 0, r = 0;
		double valor = 0.0;
		int dias;
		String cpf;

		do {
			do {
				Uteis.logo();
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

			// submenu
			if (op1 == 1) {
				do {
					Uteis.logo();
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
					Uteis.logo();
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
				boolean continua = true;

				do {
					try {
						Uteis.logo();
						System.out.println("------------------------------------------------------------");
						System.out.println("                            Saque                            ");
						System.out.println("------------------------------------------------------------");
						System.out.print("Digite o valor que deseja sacar: ");
						valor = scan.nextDouble();
						if (valor < 0) {
							throw new Exception("Não é possível sacar valores negativos.");
						}
						continua = false;
					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						scan.nextLine();
					}
				} while (continua);

				System.out.println(conta.sacar(valor));
				RelSaque.pathSaque(conta, valor);

				System.out.println("\nDeseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				System.out.print(" Opcao: ");
				r = scan.nextInt();

			} else if (op3 == 12) {
				boolean continua = true;
				do {
					try {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                          Deposito                          ");
				System.out.println("------------------------------------------------------------");
				System.out.print("\nDigite o valor que deseja depositar: ");
				valor = scan.nextDouble();
				if (valor < 0) {
					throw new Exception("Não é possível depositar valores negativos.");
				}
				continua = false;
			} catch (Exception erro1) {
				System.err.println(erro1.getMessage());
				scan.nextLine();
			}
		} while (continua);
				System.out.println(conta.depositar(valor));
				RelDeposito.pathDeposito(conta, valor);

				System.out.println("Deseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				System.out.print(" Opcao: ");
				r = scan.nextInt();

			} else if (op3 == 13) {
				boolean continua = true;
				do {
					try {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                        Transferencia                        ");
				System.out.println("------------------------------------------------------------");
				System.out.print("Digite o valor que deseja transferir: ");
				valor = scan.nextDouble();
				if (valor < 0) {
					throw new Exception("Não é possível depositar valores negativos.");
				}
				continua = false;
			} catch (Exception erro1) {
				System.err.println(erro1.getMessage());
				scan.nextLine();
			}
		} while (continua);
				System.out.print("\nDigite o CPF do titular da conta de destino: ");
				cpf = scan.next();
				Conta destinatario = new ContaCorrente();
				destinatario.setCpf(cpf);
				System.out.println(conta.transferir(valor, destinatario));
				RelTransferencia.pathTransferencia(conta, valor, cpf);

				System.out.println("Deseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				System.out.print(" Opcao: ");
				r = scan.nextInt();

			} else if (op3 == 14) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                  Contratar seguro de vida                  ");
				System.out.println("------------------------------------------------------------");
				System.out.print("Digite o valor que sera assegurado: ");
				valor = scan.nextDouble();
				System.out.println(conta.contratarSeguro(valor));

				System.out.println("Deseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				System.out.print(" Opcao: ");
				r = scan.nextInt();

			} else if (op3 == 21) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                            Saldo                           ");
				System.out.println("------------------------------------------------------------");
				System.out.print("Saldo atual de: R$" + conta.getSaldo());
				Saldo.pathsaldo(p, conta);
				;

				System.out.println("Deseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				System.out.print(" Opcao: ");
				r = scan.nextInt();

			} else if (op3 == 22) {
				try {
					Uteis.logo();
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

					System.out.println("Deseja fazer outra operação? ");
					System.out.println("1 - Sim");
					System.out.println("2 - Nao");
					System.out.print(" Opcao: ");
					r = scan.nextInt();

				} catch (ClassCastException cce) {
					System.out.println("Voce não possui conta corrente para realizar esta operacão!");
				}
			} else if (op3 == 23) {
				try {
					Uteis.logo();
					System.out.println("------------------------------------------------------------");
					System.out.println("             Relatorio de rendimento da poupanca             ");
					System.out.println("------------------------------------------------------------");
					System.out.println("Simulação");
					System.out.print("Digite o valor que deseja simular: ");
					valor = scan.nextDouble();
					System.out.print("Digite a quantidade de dias desejada: ");
					dias = scan.nextInt();
					System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
					RendimentoPoupanca.pathRendimento(conta, valor, dias);

					System.out.println("Deseja fazer outra operação? ");
					System.out.println("1 - Sim");
					System.out.println("2 - Nao");
					System.out.print(" Opcao: ");
					r = scan.nextInt();

				} catch (ClassCastException cce) {
					System.out.println("Voce nao possue conta poupanca para poder realizar esta operacao!");
				}
			} else if (op3 == 24) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("        Relatorio de tributacao do Seguro de Vida           ");
				System.out.println("------------------------------------------------------------");
				System.out.println("Gasto na tributacao do seguro de vida: " + conta.getvSeguro());
				System.out.println("Tributacao do seguro de vida: " + Tributos.porcentagemSeguroDeVida);
				TributoSeguroDeVida.pathSeguro(conta);

				System.out.println("Deseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				System.out.print(" Opcao: ");
				r = scan.nextInt();

			}
		} while (r != 2);
	}

	public static void menuGerente(Pessoa p, Conta conta) throws Exception {

		int r = 0;

		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("      Relatorio de numero de Contas de Sua Agencia          ");
		System.out.println("------------------------------------------------------------");
		System.out.println(
				"Total de agencias em sua supervisao: " + RelatorioGerente.totalDeContasSupervisionadas(conta));

		System.out.println();
		System.out.println("Deseja fazer outra operação? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		System.out.print(" Opcao: ");
		r = scan.nextInt();

		if (r == 1) {
			menuCliente(p, conta);
		} else {
			System.exit(0);
		}

	}

	public static void menuDiretor(Pessoa p, Conta conta, List<Pessoa> listaPessoas, List<Conta> listaConta)
			throws Exception {

		int r = 0;

		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("         Relatorio: Informacoes de todos os clientes        ");
		System.out.println("------------------------------------------------------------");
		RelatorioDiretor.informacaoClientes(conta, listaPessoas, listaConta);

		System.out.println();
		System.out.println("Gostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		System.out.print(" Opcao: ");
		r = scan.nextInt();

		if (r == 1) {
			menuCliente(p, conta);
		} else {
			System.exit(0);
		}

	}

	public static void menuPresidente(Pessoa p, Conta conta, List<Conta> listaConta) throws Exception {

		int r = 0;

		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("     Relatorio Valor Total Capital Armazenado no Banco      ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Total de capital armazenado: R$ " + RelatorioPresidente.totalDeCapital(conta, listaConta));

		System.out.println();
		System.out.println("Gostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		System.out.print(" Opcao: ");
		r = scan.nextInt();

		if (r == 1) {
			menuCliente(p, conta);
		} else {
			System.exit(0);
		}

	}

}
