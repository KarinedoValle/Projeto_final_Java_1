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
				System.out.println("Op��o inv�lida. Tente novamente.");
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("                   O que deseja consultar?                   ");
			System.out.println("------------------------------------------------------------");
			System.out.println("1 - Movimenta��es da conta");
			System.out.println("2 - Relat�rios");
			System.out.print(" Op��o: ");
			op1 = scan.nextInt();
		} while (op1 != 1 && op1 != 2);

		
		 if (op1 == 1) {
	            do {
	            	System.out.println(""); 
	    			System.out.println(""); 
	    			System.out.println("");
	                if (op2 < 1 || op2 > 4) {
	                    System.out.println("Op��o inv�lida. Tente novamente.");
	                }
	                System.out.println("------------------------------------------------------------");
	                System.out.println("                   Movimenta��es da conta                   ");
	                System.out.println("------------------------------------------------------------");
	                System.out.println("1 - Saque");
	                System.out.println("2 - Deposito");
	                System.out.println("3 - Transfer�ncia");
	                System.out.println("4 - Contratar seguro de vida");
	                System.out.print(" Op��o: ");
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
	                    System.out.println("Op��o inv�lida. Tente novamente.");
	                }
	                System.out.println("------------------------------------------------------------");
	                System.out.println("                         Relat�rios                         ");
	                System.out.println("------------------------------------------------------------");
	                System.out.println("1 - Saldo");
	                System.out.println("2 - Relat�rio de tributa��o da conta corrente");
	                System.out.println("3 - Relat�rio de rendimento da poupan�a");
	                System.out.println("4 - Tributa��o referente ao seguro de vida");
	                System.out.println("5 - Relat�rio N�mero de Contas de sua ag�ncia");
	                System.out.println("6 - Relat�rio Informa��es Nome/CPF/Ag�ncia de todos os clientes");
	                System.out.print(" Op��o: ");
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
	            System.out.println("                          Dep�sito                          ");
	            System.out.println("------------------------------------------------------------");
	            System.out.print("Digite o valor que deseja depositar: ");
	            valor = scan.nextDouble();
	            System.out.println(conta.depositar(valor));
	        } else if (op3 == 13) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("                        Transfer�ncia                        ");
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
	            System.out.print("Digite o valor que ser� assegurado: ");
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
	            // Terminar de fazer o relat�rio com os gastos por opera��es
	            System.out.println("------------------------------------------------------------");
	            System.out.println("          Relat�rio de tributa��o da conta corrente          ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Tributa��o por opera��o banc�ria");
	            System.out.println("- Tributa��o para saque: R$ " + saque);
	            System.out.println("- Tributa��o para dep�sito: R$ " + deposito);
	            System.out.println("- Tributa��o para transfer�ncia: R$ " + transferencia);
	            System.out.println("- Tributa��o para seguro de vida em porcentagem: " + transferencia);
	        } else if (op3 == 23) {
	        	System.out.println(""); 
				System.out.println(""); 
				System.out.println("");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("             Relat�rio de rendimento da poupan�a             ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simula��o");
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
	            System.out.println("             Relat�rio de Tributa��o do Seguro de Vida           ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simula��o");
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
	            System.out.println("             Relat�rio de N�mero de Contas de Sua Ag�ncia             ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simula��o");
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
	            System.out.println("             Relat�rio Informa��es Nome/CPF/Ag�ncia de todos os clientes              ");
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Simula��o");
	            System.out.print("Digite o valor que deseja simular: ");
	            valor = scan.nextDouble();
	            System.out.print("Digite a quantidade de dias desejada: ");
	            dias = scan.nextInt();
	            System.out.println(((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias));
	        }
	      }
				
	}

