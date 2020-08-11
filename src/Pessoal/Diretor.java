package Pessoal;

import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class Diretor extends Funcionario {

	public Diretor() {
		super();}

	public Diretor(String nome, String cargo, String cpf, int senha) {
		super(nome, cargo, cpf, senha);}

	public static void menu(Conta conta) {
		Scanner scan = new Scanner(System.in);
		
		double valor;
		String cpf;
		int op1 = 1, op2 = 1, op3 = 1, dias;
		do {
			System.out.println(""); 
			System.out.println(""); 
			System.out.println("");
			if (op1 != 1 && op1 != 2) {
				System.out.println("Opção inválida. Tente novamente.");
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("                   O que deseja consultar?                   ");
			System.out.println("------------------------------------------------------------");
			System.out.println("1 - Movimentações da conta");
			System.out.println("2 - Relatórios");
			System.out.print(" Opção: ");
			op1 = scan.nextInt();
		} while (op1 != 1 && op1 != 2);

		
		 if (op1 == 1) {
	            do {
	            	System.out.println(""); 
	    			System.out.println(""); 
	    			System.out.println("");
	                if (op2 < 1 || op2 > 4) {
	                    System.out.println("Opção inválida. Tente novamente.");
	                }
	                System.out.println("------------------------------------------------------------");
	                System.out.println("                   Movimentações da conta                   ");
	                System.out.println("------------------------------------------------------------");
	                System.out.println("1 - Saque");
	                System.out.println("2 - Deposito");
	                System.out.println("3 - Transferência");
	                System.out.println("4 - Contratar seguro de vida");
	                System.out.print(" Opção: ");
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
	                if (op2 < 1 || op2 > 6) {
	                    System.out.println("Opção inválida. Tente novamente.");
	                }
	                System.out.println("------------------------------------------------------------");
	                System.out.println("                         Relatórios                         ");
	                System.out.println("------------------------------------------------------------");
	                System.out.println("1 - Saldo");
	                System.out.println("2 - Relatório de tributação da conta corrente");
	                System.out.println("3 - Relatório de rendimento da poupança");
	                System.out.println("4 - Tributação referente ao seguro de vida");
	                System.out.println("5 - Relatório Número de Contas de sua agência");
	                System.out.println("6 - Relatório Informações Nome/CPF/Agência de todos os clientes");
	                System.out.print(" Opção: ");
	                op2 = scan.nextInt();
	            } while (op2 < 1 || op2 > 6);
	            
	            if (op2 == 1) {
	                op3 = 21;
	            } else if (op2 == 2) {
	                op3 = 22;
	            } else if (op2 == 3) {
	                op3 = 23;
	            } else if (op2 == 4) {
	                op3 = 24;
	            } else if (op2 == 5) {
	                op3 = 25;
	            } else if (op2 == 6) {
	                op3 = 26;
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
	        } else if (op3 == 12) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("                          Depósito                          ");
	            System.out.println("------------------------------------------------------------");
	            System.out.print("Digite o valor que deseja depositar: ");
	            valor = scan.nextDouble();
	            System.out.println(conta.depositar(valor));
	        } else if (op3 == 13) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("                        Transferência                        ");
	            System.out.println("------------------------------------------------------------");
	            System.out.print("Digite o valor que deseja transferir: ");
	            valor = scan.nextDouble();
	            System.out.print("\nDigite o CPF do titular da conta de destino: ");
	            cpf = scan.next();
	            Conta destinatario = new ContaCorrente();//
	            System.out.println(conta.transferir(valor, destinatario));
	        } else if (op3 == 14) {
	            System.out.println("------------------------------------------------------------");
	            System.out.println("                  Contratar seguro de vida                  ");
	            System.out.println("------------------------------------------------------------");
	            System.out.print("Digite o valor que será assegurado: ");
	            valor = scan.nextDouble();
	            System.out.println(conta.contratarSeguro(valor));
	        } else if (op3 == 21) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");;
	            System.out.println("------------------------------------------------------------");
	            System.out.println("                            Saldo                           ");
	            System.out.println("------------------------------------------------------------");
	            System.out.print("Saldo atual de: R$" + conta.getSaldo());
	        } else if (op3 == 22) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            // Terminar de fazer o relatório com os gastos por operações
	            System.out.println("------------------------------------------------------------");
	            System.out.println("          Relatório de tributação da conta corrente          ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Tributação por operação bancária");
	            System.out.println("- Tributação para saque: R$ " + saque);
	            System.out.println("- Tributação para depósito: R$ " + deposito);
	            System.out.println("- Tributação para transferência: R$ " + transferencia);
	            System.out.println("- Tributação para seguro de vida em porcentagem: " + transferencia);
	        } else if (op3 == 23) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("             Relatório de rendimento da poupança             ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simulação");
	            System.out.print("Digite o valor que deseja simular: ");
	            valor = scan.nextDouble();
	            System.out.print("Digite a quantidade de dias desejada: ");
	            dias = scan.nextInt();
	            System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
	        }
	        //REVISAR CONTAS
	        else if (op3 == 24) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("             Relatório de Tributação do Seguro de Vida           ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simulação");
	            System.out.print("Digite o valor que deseja simular: ");
	            valor = scan.nextDouble();
	            System.out.print("Digite a quantidade de dias desejada: ");
	            dias = scan.nextInt();
	            System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
	        }
	        //REVISAR CONTAS
	        else if (op3 == 25) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("             Relatório de Número de Contas de Sua Agência             ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simulação");
	            System.out.print("Digite o valor que deseja simular: ");
	            valor = scan.nextDouble();
	            System.out.print("Digite a quantidade de dias desejada: ");
	            dias = scan.nextInt();
	            System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
	        }
	      //REVISAR CONTAS
	        else if (op3 == 26) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("             Relatório Informações Nome/CPF/Agência de todos os clientes              ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simulação");
	            System.out.print("Digite o valor que deseja simular: ");
	            valor = scan.nextDouble();
	            System.out.print("Digite a quantidade de dias desejada: ");
	            dias = scan.nextInt();
	            System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
	        }
	      }
				
	}

