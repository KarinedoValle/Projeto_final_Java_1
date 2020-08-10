package Principal;

import java.util.Scanner;

import Pessoal.Cliente;
import Pessoal.Presidente;

public class SistemaInterno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cpf;
		int senha;
		Scanner scan = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
		System.out.println("Digite seu CPF: ");
		cpf=scan.next();
		System.out.println("Digite sua Senha: ");
		senha=scan.nextInt();
		
		Presidente diretor = new Presidente();
		
		diretor.menu();
		
		
	}
}
