package criacaoDeDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.ContasEnum;
import enums.PessoasEnum;
import pessoal.Cliente;
import pessoal.Diretor;
import pessoal.Gerente;
import pessoal.Pessoa;
import pessoal.Presidente;

public class EjetarDados {

	public static void leitorPessoas(String path, List<Pessoa> listaPessoas) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		

		String linha = "";

		while (true) {

			linha = buffRead.readLine();

			if (linha != null) {
				String [] split = linha.split(",");

				if(split[2].equalsIgnoreCase(PessoasEnum.DIRETOR.name())) {
					Diretor d = new Diretor(split[0], split[1], split[2], Integer.parseInt(split[3]));
					listaPessoas.add(d);
//					System.out.println(d);
				}
				else if(split[2].equalsIgnoreCase(PessoasEnum.GERENTE.name())) {
					Gerente g = new Gerente(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]));
					listaPessoas.add(g);
//					System.out.println(g);
				}
				else if(split[2].equalsIgnoreCase(PessoasEnum.PRESIDENTE.name())) {
					Presidente p = new Presidente(split[0], split[1], split[2], Integer.parseInt(split[3]));
					listaPessoas.add(p);
//					System.out.println(p);
				}
				else if(split[2].equalsIgnoreCase(PessoasEnum.CLIENTE.name())) {
					Cliente c = new Cliente(split[0], split[1], split[2], Integer.parseInt(split[3]));
					listaPessoas.add(c);
//					System.out.println(c);

			}
		} else {
			break;
		}
		
		}
		buffRead.close();
	}
	
	public static void leitorContas(String path, List<Conta> listaConta) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		

		String linha = "";

		while (true) {

			linha = buffRead.readLine();

			if (linha != null) {
				String [] split = linha.split(",");

				if(split[3].equalsIgnoreCase(ContasEnum.CONTACORRENTE.name())) {
					ContaCorrente cc = new ContaCorrente(split[0], Double.parseDouble(split[1]), Integer.parseInt(split[2]), split[3]);
					listaConta.add(cc);
//					System.out.println(cc);
				}
				else if(split[3].equalsIgnoreCase(ContasEnum.CONTAPOUPANCA.name())) {
					ContaPoupanca cp = new ContaPoupanca(split[0], Double.parseDouble(split[1]), Integer.parseInt(split[2]), split[3]);
					listaConta.add(cp);
//					System.out.println(cp);
				}
			
		} else {
			break;
		}
		
		}
		buffRead.close();
	}
}		
