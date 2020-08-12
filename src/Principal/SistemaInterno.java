package Principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Conta.Conta;
import Pessoal.Pessoa;
import criacaoDeDados.EjetarDados;

public class SistemaInterno {

	public static void main(String[] args) throws IOException {
		
		String path = "./src/criacaoDeDados/Dados.txt";
		
		List<Pessoa> listaPessoas = new ArrayList<>();
		List<Conta> listaConta = new ArrayList<>();
		
		EjetarDados.leitorPessoas(path, listaPessoas);
		EjetarDados.leitorContas(path, listaConta);
		
		Menus.menuGeral(listaPessoas, listaConta);
	}
}
