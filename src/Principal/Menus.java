package Principal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import conta.Tributos;
import enums.PessoasEnum;
import uteis.Uteis;

public class Menus {

	static Scanner scan = new Scanner(System.in);
	static String cpf;

	public static void menuGeral(List<Pessoa> listaPessoas, List<Conta> listaConta) throws Exception {
		Pessoa pl = null, p = null;
		Conta cl = null, c = null;
		boolean continua = true;
		do {
			try {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                 Bem-vindo(a) ao Hero Bank!                  ");
				System.out.println("------------------------------------------------------------");
				System.out.print("Digite seu CPF: ");
				cpf = scan.next();
				System.out.print("Digite sua senha: ");
				int senha = scan.nextInt();

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

				if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha
						&& p.getTipo().equalsIgnoreCase(PessoasEnum.CLIENTE.name())) {
					menuCliente(listaPessoas, p, c, listaConta);
				} else if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha
						&& p.getTipo().equalsIgnoreCase(PessoasEnum.GERENTE.name())) {
					menuFuncionario(p, c, listaPessoas, listaConta);
				} else if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha
						&& p.getTipo().equalsIgnoreCase(PessoasEnum.DIRETOR.name())) {
					menuFuncionario(p, c, listaPessoas, listaConta);
				} else if (p.getCpf().equalsIgnoreCase(cpf) && p.getSenha() == senha
						&& p.getTipo().equalsIgnoreCase(PessoasEnum.PRESIDENTE.name())) {
					menuFuncionario(p, c, listaPessoas, listaConta);
				}
				continua = false;
			} catch (NullPointerException ex) {
				System.out.println("\nCPF n�o cadastrado.");
				Thread.sleep(2 * 1000);
			}
		} while (continua);
	}

	public static void menuFuncionario(Pessoa p, Conta c, List<Pessoa> listaPessoas, List<Conta> listaConta)
			throws Exception {

		int op;
		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("                 Bem-vindo(a) ao Hero Bank!                  ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Gostaria de logar com:");
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcion�rio");
		System.out.print(" Op��o: ");
		op = scan.nextInt();

		if (op == 1) {
			menuCliente(listaPessoas, p, c, listaConta);
		} else if (op == 2 && p.getTipo().equalsIgnoreCase(PessoasEnum.GERENTE.name())) {
			menuGerente(listaPessoas, p, c, listaConta);
		} else if (op == 2 && p.getTipo().equalsIgnoreCase(PessoasEnum.DIRETOR.name())) {
			menuDiretor(p, c, listaPessoas, listaConta);
		} else if (op == 2 && p.getTipo().equalsIgnoreCase(PessoasEnum.PRESIDENTE.name())) {
			menuPresidente(p, c, listaConta, listaPessoas);
		}
	}

	public static void menuCliente(List<Pessoa> listaPessoas, Pessoa p, Conta conta, List<Conta> listaConta)
			throws Exception {
		int op1 = 1, op2 = 1, op3 = 0, r = 0;
		double valor = 0.0;
		int dias;
		String cpf;

		do {
			do {
				Uteis.logo();
				if (op1 != 1 && op1 != 2) {
					System.out.println("Op��o inv�lida! Tente novamente.");
				}
				System.out.println("------------------------------------------------------------");
				System.out.println("                   O que deseja consultar?                   ");
				System.out.println("------------------------------------------------------------");
				System.out.println("1 - Movimenta��es da conta");
				System.out.println("2 - Relat�rios");
				System.out.print(" Op��o: ");
				op1 = scan.nextInt();
			} while (op1 != 1 && op1 != 2);

			// submenu
			if (op1 == 1) {
				do {
					Uteis.logo();
					if (op2 < 1 || op2 > 4) {
						System.out.println("Opcao inv�lida! Tente novamente.");
					}
					System.out.println("------------------------------------------------------------");
					System.out.println("                   Movimenta��es da conta                   ");
					System.out.println("------------------------------------------------------------");
					System.out.println("1 - Saque");
					System.out.println("2 - Dep�sito");
					System.out.println("3 - Transfer�ncia");
					System.out.println("4 - Contratar seguro de vida");
					System.out.println("5 - Voltar ao menu anterior");
					System.out.print(" Op��o: ");
					op2 = scan.nextInt();
				} while (op2 < 1 || op2 > 5);
				if (op2 == 1) {
					op3 = 11;
				} else if (op2 == 2) {
					op3 = 12;
				} else if (op2 == 3) {
					op3 = 13;
				} else if (op2 == 4) {
					op3 = 14;
				} else if (op2 == 5) {
					menuCliente(listaPessoas, p, conta, listaConta);
				}

			} else if (op1 == 2) {
				do {
					Uteis.logo();
					if (op2 < 1 || op2 > 4) {
						System.out.println("Opcao inv�lida! Tente novamente.");
					}
					System.out.println("------------------------------------------------------------");
					System.out.println("                         Relat�rios                         ");
					System.out.println("------------------------------------------------------------");
					System.out.println("1 - Saldo");
					System.out.println("2 - Relat�rio de tributa��o da conta corrente");
					System.out.println("3 - Relat�rio de rendimento da poupan�a");
					System.out.println("4 - Tributa��o referente ao seguro de vida");
					System.out.println("5 - Voltar ao menu anterior");
					System.out.print(" Op��o: ");
					op2 = scan.nextInt();
				} while (op2 < 1 || op2 > 5);

				if (op2 == 1) {
					op3 = 21;
				} else if (op2 == 2) {
					op3 = 22;
				} else if (op2 == 3) {
					op3 = 23;
				} else if (op2 == 4) {
					op3 = 24;
				} else if (op2 == 5) {
					menuCliente(listaPessoas, p, conta, listaConta);
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
						System.out.println("0 - Cancelar");
						System.out.print("Digite o valor que deseja sacar: ");
						valor = scan.nextDouble();
						if (valor == 0) {
							menuGeral(listaPessoas, listaConta);
						}
						if (valor < 0) {
							throw new Exception("N�o � poss�vel sacar valores negativos.");
						}
						continua = false;
					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						Thread.sleep(3 * 1000);
						scan.nextLine();
					}
				} while (continua);

				System.out.println(conta.sacar(valor));
				RelSaque.pathSaque(conta, p, valor);

				System.out.println("\nDeseja fazer outra opera��o? ");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
				System.out.print(" Op��o: ");
				r = scan.nextInt();

			} else if (op3 == 12) {
				boolean continua = true;
				do {
					try {
						Uteis.logo();
						System.out.println("------------------------------------------------------------");
						System.out.println("                          Dep�sito                          ");
						System.out.println("------------------------------------------------------------");
						System.out.println("0 - Cancelar");
						System.out.print("Digite o valor que deseja depositar: ");
						valor = scan.nextDouble();
						if (valor == 0) {
							menuGeral(listaPessoas, listaConta);
						}
						if (valor < 0) {
							throw new Exception("N�o � poss�vel depositar valores negativos.");
						}
						continua = false;
					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						Thread.sleep(3 * 1000);
						scan.nextLine();
					}
				} while (continua);
				System.out.println(conta.depositar(valor));
				RelDeposito.pathDeposito(conta, valor, p);
				System.out.println();
				System.out.println("Deseja fazer outra opera��o? ");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
				System.out.print(" Op��o: ");
				r = scan.nextInt();

			} else if (op3 == 13) {
				boolean continua = true;
				do {
					try {
						Uteis.logo();
						System.out.println("------------------------------------------------------------");
						System.out.println("                        Transfer�ncia                        ");
						System.out.println("------------------------------------------------------------");
						System.out.println("0 - Cancelar");
						System.out.print("Digite o valor que deseja transferir: ");
						valor = scan.nextDouble();
						if (valor == 0) {
							menuGeral(listaPessoas, listaConta);
						}
						if (valor < 0) {
							throw new Exception("N�o � poss�vel depositar valores negativos.");
						}
						continua = false;
					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						Thread.sleep(3 * 1000);
						scan.nextLine();
					}
				} while (continua);
				System.out.print("\nDigite o CPF do titular da conta de destino: ");
				cpf = scan.next();
				Conta cl = null;
				Conta destinatario = null;
				for (int i = 0; i < listaConta.size(); i++) {
					cl = listaConta.get(i);
					if (cl.getCpf().equalsIgnoreCase(cpf)) {
						destinatario = listaConta.get(i);
					}
				}
				System.out.println(conta.transferir(valor, destinatario));
				RelTransferencia.pathTransferencia(conta, valor, p, cpf);
				System.out.println();
				System.out.println("Deseja fazer outra opera��o? ");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
				System.out.print(" Op��o: ");
				r = scan.nextInt();

			} else if (op3 == 14) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                  Contratar seguro de vida                  ");
				System.out.println("------------------------------------------------------------");
				System.out.println("0 - Cancelar");
				System.out.print("Digite o valor que ser� assegurado: ");
				valor = scan.nextDouble();
				if (valor == 0) {
					menuGeral(listaPessoas, listaConta);
				}
				System.out.println(conta.contratarSeguro(valor));
				System.out.println();
				System.out.println("Deseja fazer outra opera��o? ");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
				System.out.print(" Op��o: ");
				r = scan.nextInt();

			} else if (op3 == 21) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                            Saldo                           ");
				System.out.println("------------------------------------------------------------");
				System.out.print("Saldo atual de: R$" + conta.getSaldo());
				Saldo.pathsaldo(p, conta);

				System.out.println();
				System.out.println("Deseja fazer outra opera��o? ");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
				System.out.print(" Op��o: ");
				r = scan.nextInt();

			} else if (op3 == 22) {
				try {
					Uteis.logo();
					System.out.println("------------------------------------------------------------");
					System.out.println("         Relat�rio de tributa��o da conta corrente          ");
					System.out.println("------------------------------------------------------------");
					System.out.println("\nTributac�o por opera��o banc�ria");
					System.out.println("- Tributac�o para saque: R$ " + Tributos.saque);
					System.out.println("- Tributac�o para dep�sito: R$ " + Tributos.deposito);
					System.out.println("- Tributac�o para transfer�ncia: R$ " + Tributos.transferencia);
					System.out.println("- Tributac�o para seguro de vida em porcentagem: " + Tributos.transferencia);
					System.out.println("Gasto total da tributa��o: " + conta.getTotalTributos());
					TributacaoCC.pathTributacao(p, conta);
					System.out.println();
					System.out.println("Deseja fazer outra opera��o? ");
					System.out.println("1 - Sim");
					System.out.println("2 - N�o");
					System.out.print(" Op��o: ");
					r = scan.nextInt();

				} catch (ClassCastException cce) {
					System.out.println("Voce n�o possui conta corrente para realizar esta opera��o!");
				}
			} else if (op3 == 23) {
				try {
					Uteis.logo();
					System.out.println("------------------------------------------------------------");
					System.out.println("             Relat�rio de rendimento da poupan�a             ");
					System.out.println("------------------------------------------------------------");
					System.out.println("\nSimula��o");
					System.out.println("0 - Cancelar");
					System.out.print("Digite o valor que deseja simular: ");
					valor = scan.nextDouble();
					if (valor == 0) {
						menuGeral(listaPessoas, listaConta);
					}
					System.out.print("Digite a quantidade de dias desejada: ");
					dias = scan.nextInt();
					System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
					RendimentoPoupanca.pathRendimento(conta, p, valor, dias);
					System.out.println();
					System.out.println("Deseja fazer outra opera��o? ");
					System.out.println("1 - Sim");
					System.out.println("2 - N�o");
					System.out.print(" Op��o: ");
					r = scan.nextInt();

				} catch (ClassCastException cce) {
					System.out.println("Voc� n�o possui conta poupan�a para realizar esta opera��o!");
				}
			} else if (op3 == 24) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("        Relatorio de tributa��o do seguro de vida           ");
				System.out.println("------------------------------------------------------------");
				System.out.println("Tributa��o do seguro de vida em porcentagem: " + Tributos.porcentagemSeguroDeVida);
				System.out.println("Gasto na tributa��o do seguro de vida: " + conta.getvSeguro());
				TributoSeguroDeVida.pathSeguro(conta, p);
				System.out.println();
				System.out.println("Deseja fazer outra opera��o? ");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
				System.out.print(" Op��o: ");
				r = scan.nextInt();

			}
		} while (r != 2);

		if (r == 2) {
			menuGeral(listaPessoas, listaConta);
		}

	}

	public static void menuGerente(List<Pessoa> listaPessoas, Pessoa p, Conta conta, List<Conta> listaConta)
			throws Exception {

		int r = 0;

		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("      Relat�rio de n�mero de contas de sua ag�ncia          ");
		System.out.println("------------------------------------------------------------");
		System.out
				.println("Total de contas de sua ag�ncia: " + RelatorioGerente.totalDeContasSupervisionadas(conta, p));

		System.out.println();
		System.out.println("Deseja fazer outra opera��o? ");
		System.out.println("1 - Sim");
		System.out.println("2 - N�o");
		System.out.print(" Op��o: ");
		r = scan.nextInt();

		if (r == 1) {
			menuCliente(listaPessoas, p, conta, listaConta);
		} else {
			menuGeral(listaPessoas, listaConta);
		}

	}

	public static void menuDiretor(Pessoa p, Conta conta, List<Pessoa> listaPessoas, List<Conta> listaConta)
			throws Exception {

		int r = 0;

		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("         Relat�rio: Informa��es de todos os clientes        ");
		System.out.println("------------------------------------------------------------");
		RelatorioDiretor.informacaoClientes(conta, p, listaPessoas, listaConta);

		System.out.println();
		System.out.println("Gostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - N�o");
		System.out.print(" Op��o: ");
		r = scan.nextInt();

		if (r == 1) {
			menuCliente(listaPessoas, p, conta, listaConta);
		} else {
			menuGeral(listaPessoas, listaConta);
		}

	}

	public static void menuPresidente(Pessoa p, Conta conta, List<Conta> listaConta, List<Pessoa> listaPessoas)
			throws Exception {

		int r = 0;

		Uteis.logo();
		System.out.println("------------------------------------------------------------");
		System.out.println("     Relatorio: Valor total capital armazenado no Banco      ");
		System.out.println("------------------------------------------------------------");
		System.out
				.println("Total de capital armazenado: R$ " + RelatorioPresidente.totalDeCapital(conta, p, listaConta));

		System.out.println();
		System.out.println("Gostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - N�o");
		System.out.print(" Op��o: ");
		r = scan.nextInt();

		if (r == 1) {
			menuCliente(listaPessoas, p, conta, listaConta);
		} else {
			menuGeral(listaPessoas, listaConta);
		}

	}

}
