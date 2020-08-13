package Principal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import conta.Tributos;
import enums.PessoasEnum;
import pessoal.Pessoa;
import relatorios.RelDeposito;
import relatorios.RelSaque;
import relatorios.RelTransferencia;
import relatorios.RelatorioDiretor;
import relatorios.RelatorioGerente;
import relatorios.RelatorioPresidente;
import relatorios.RendimentoPoupanca;
import relatorios.Saldo;
import relatorios.TributacaoCC;
import relatorios.TributoSeguroDeVida;
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
				System.out.println("\nCPF não cadastrado.");
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
		System.out.println("2 - Funcionário");
		System.out.print(" Opção: ");
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
					System.out.println("Opção inválida! Tente novamente.");
				}
				System.out.println("------------------------------------------------------------");
				System.out.println("                   O que deseja consultar?                   ");
				System.out.println("------------------------------------------------------------");
				System.out.println("1 - Movimentações da conta");
				System.out.println("2 - Relatórios");
				System.out.println("3 - Sair");
				System.out.print(" Opção: ");
				op1 = scan.nextInt();
				if (op1 == 3) {
					menuGeral(listaPessoas, listaConta);
				}
			} while (op1 != 1 && op1 != 2);

			// submenu
			if (op1 == 1) {
				do {
					Uteis.logo();
					if (op2 < 1 || op2 > 4) {
						System.out.println("Opcao inválida! Tente novamente.");
					}
					System.out.println("------------------------------------------------------------");
					System.out.println("                   Movimentações da conta                   ");
					System.out.println("------------------------------------------------------------");
					System.out.println("1 - Saque");
					System.out.println("2 - Depósito");
					System.out.println("3 - Transferência");
					System.out.println("4 - Contratar seguro de vida");
					System.out.println("5 - Voltar ao menu anterior");
					System.out.print(" Opção: ");
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
						System.out.println("Opcao inválida! Tente novamente.");
					}
					System.out.println("------------------------------------------------------------");
					System.out.println("                         Relatórios                         ");
					System.out.println("------------------------------------------------------------");
					System.out.println("1 - Saldo");
					System.out.println("2 - Relatório de tributação da conta corrente");
					System.out.println("3 - Relatório de rendimento da poupança");
					System.out.println("4 - Relatório de tributação referente ao seguro de vida");
					System.out.println("5 - Voltar ao menu anterior");
					System.out.print(" Opção: ");
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
							throw new Exception("Não é possível sacar valores negativos.");
						}
						continua = false;
					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						Thread.sleep(3 * 1000);
						scan.nextLine();
					}
				} while (continua);

				double saldoAnterior = conta.getSaldo();
				conta.sacar(valor);
				double novoSaldo = conta.getSaldo();
				
				//Resposta do submenu de saque
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                            Saque                            ");
				System.out.println("------------------------------------------------------------");
				System.out.format("\nSaldo anterior: %.2f", saldoAnterior); 
				System.out.format("\nValor sacado: %.2f", valor); 
				System.out.format("\nSaldo atual: %.2f", novoSaldo);
				RelSaque.pathSaque(conta, p, valor);

				System.out.println("\n\nDeseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.print(" Opção: ");
				r = scan.nextInt();

			} else if (op3 == 12) {
				boolean continua = true;
				do {
					try {
						Uteis.logo();
						System.out.println("------------------------------------------------------------");
						System.out.println("                          Depósito                          ");
						System.out.println("------------------------------------------------------------");
						System.out.println("0 - Cancelar");
						System.out.print("Digite o valor que deseja depositar: ");
						valor = scan.nextDouble();
						if (valor == 0) {
							menuGeral(listaPessoas, listaConta);
						}
						if (valor < 0) {
							throw new Exception("Não é possível depositar valores negativos.");
						}
						continua = false;
					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						Thread.sleep(3 * 1000);
						scan.nextLine();
					}
				} while (continua);
				double saldoAnterior = conta.getSaldo();
				conta.depositar(valor);
				double novoSaldo = conta.getSaldo();
				
				//Resposta do submenu de depósito
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                          Depósito                          ");
				System.out.println("------------------------------------------------------------");
				System.out.format("\nSaldo anterior: %.2f", saldoAnterior); 
				System.out.format("\nValor depositado: %.2f", valor); 
				System.out.format("\nSaldo atual: %.2f", novoSaldo);
				RelDeposito.pathDeposito(conta, valor, p);
				System.out.println("\n\nDeseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.print(" Opção: ");
				r = scan.nextInt();

			} else if (op3 == 13) {
				boolean continua = true;
				do {
					try {
						Uteis.logo();
						System.out.println("------------------------------------------------------------");
						System.out.println("                        Transferência                        ");
						System.out.println("------------------------------------------------------------");
						System.out.println("0 - Cancelar");
						System.out.print("Digite o valor que deseja transferir: ");
						valor = scan.nextDouble();
						if (valor == 0) {
							menuGeral(listaPessoas, listaConta);
						}
						if (valor < 0) {
							throw new Exception("Não é possível depositar valores negativos.");
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
				double saldoAnterior = conta.getSaldo();
				conta.transferir(valor, destinatario);
				double novoSaldo = conta.getSaldo();
				
				//Resposta do submenu de transferência
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                        Transferência                        ");
				System.out.println("------------------------------------------------------------");
				System.out.format("\nSaldo anterior: %.2f", saldoAnterior); 
				System.out.format("\nValor transferido: %.2f", valor); 
				System.out.format("\nSaldo atual: %.2f", novoSaldo);
				
				RelTransferencia.pathTransferencia(conta, valor, p, cpf);
				System.out.println("\n\nDeseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.print(" Opção: ");
				r = scan.nextInt();

			} else if (op3 == 14) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                  Contratar seguro de vida                  ");
				System.out.println("------------------------------------------------------------");
				System.out.println("0 - Cancelar");
				System.out.print("Digite o valor que será segurado: ");
				valor = scan.nextDouble();
				if (valor == 0) {
					menuGeral(listaPessoas, listaConta);
				}
				System.out.format("\nO valor segurado é: %.2f", conta.contratarSeguro(valor));
				System.out.println("\n\nDeseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.print(" Opção: ");
				r = scan.nextInt();

			} else if (op3 == 21) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("                            Saldo                           ");
				System.out.println("------------------------------------------------------------");
				System.out.format("\nSaldo atual de: R$ %.2f", conta.getSaldo());
				Saldo.pathsaldo(p, conta);

				System.out.println("\n\nDeseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.print(" Opção: ");
				r = scan.nextInt();

			} else if (op3 == 22) {
				try {
					Uteis.logo();
					System.out.println("------------------------------------------------------------");
					System.out.println("         Relatório de tributação da conta corrente          ");
					System.out.println("------------------------------------------------------------");
					System.out.println("\nTributacão por operação bancária");
					System.out.format("\n- Tributacão para saque: R$ %.2f", Tributos.saque);
					System.out.format("\n- Tributacão para depósito: R$ %.2f", Tributos.deposito);
					System.out.format("\n- Tributacão para transferência: R$ %.2f", Tributos.transferencia);
					System.out.format("\n- Tributacão para seguro de vida em porcentagem: %.2f", Tributos.transferencia);
					System.out.format("\n\nGasto total da tributação: %.2f", conta.getTotalTributos());
					TributacaoCC.pathTributacao(p, conta);
					System.out.println("\n\nDeseja fazer outra operação? ");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					System.out.print(" Opção: ");
					r = scan.nextInt();

				} catch (ClassCastException cce) {
					System.out.println("Voce não possui conta corrente para realizar esta operação!");
				}
			} else if (op3 == 23) {
				try {
					Uteis.logo();
					System.out.println("------------------------------------------------------------");
					System.out.println("             Relatório de rendimento da poupança             ");
					System.out.println("------------------------------------------------------------");
					System.out.println("\nSimulação");
					System.out.println("0 - Cancelar");
					System.out.print("\nDigite o valor que deseja simular: ");
					valor = scan.nextDouble();
					if (valor == 0) {
						menuGeral(listaPessoas, listaConta);
					}
					System.out.print("Digite a quantidade de dias desejada: ");
					dias = scan.nextInt();
					double valorFinal = ((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias);
					double rendimento = valorFinal - valor;
					
					//Resposta do submenu relatório de rendimento da poupança
					Uteis.logo();
					System.out.println("------------------------------------------------------------");
					System.out.println("             Relatório de rendimento da poupança             ");
					System.out.println("------------------------------------------------------------"); 
					System.out.format("\nO rendimento de R$ %.2f", valor);
					System.out.print(" durante " + dias + " dias é de ");
					System.out.format("R$ %.2f", rendimento);
					System.out.format("\nO valor total é R$ %.2f", valorFinal);
					RendimentoPoupanca.pathRendimento(conta, p, valor, dias);
					System.out.println("\n\nDeseja fazer outra operação? ");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					System.out.print(" Opção: ");
					r = scan.nextInt();

				} catch (ClassCastException cce) {
					System.out.println("Você não possui conta poupança para realizar esta operação!");
					Thread.sleep(2 * 1000);
				}
			} else if (op3 == 24) {
				Uteis.logo();
				System.out.println("------------------------------------------------------------");
				System.out.println("        Relatorio de tributação do seguro de vida           ");
				System.out.println("------------------------------------------------------------");
				System.out.format("\nTributação do seguro de vida em porcentagem: %.2f", Tributos.porcentagemSeguroDeVida);
				System.out.format("\n\nGasto com a tributação do seguro de vida: R$ %.2f", conta.getvSeguro());
				TributoSeguroDeVida.pathSeguro(conta, p);
				System.out.println("\n\nDeseja fazer outra operação? ");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.print(" Opção: ");
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
		System.out.println("      Relatório de número de contas de sua agência          ");
		System.out.println("------------------------------------------------------------");
		System.out
				.println("Total de contas de sua agência: " + RelatorioGerente.totalDeContasSupervisionadas(conta, p));

		System.out.println();
		System.out.println("\nGostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.print(" Opção: ");
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
		System.out.println("         Relatório: Informações de todos os clientes        ");
		System.out.println("------------------------------------------------------------");
		RelatorioDiretor.informacaoClientes(conta, p, listaPessoas, listaConta);

		System.out.println();
		System.out.println("\nGostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.print(" Opção: ");
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
		System.out.println("    Relatorio: Valor total do capital armazenado no Banco    ");
		System.out.println("------------------------------------------------------------");
		System.out
				.format("\nTotal de capital armazenado: R$ %.2f", RelatorioPresidente.totalDeCapital(conta, p, listaConta));

		System.out.println();
		System.out.println("\n\nGostaria de mudar para a interface cliente? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.print(" Opção: ");
		r = scan.nextInt();

		if (r == 1) {
			menuCliente(listaPessoas, p, conta, listaConta);
		} else {
			menuGeral(listaPessoas, listaConta);
		}

	}

}
