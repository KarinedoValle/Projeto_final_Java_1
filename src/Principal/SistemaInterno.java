package Principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import conta.Conta;
import criacaoDeDados.EjetarDados;
import pessoal.Pessoa;

public class SistemaInterno {

	public static void main(String[] args) throws Exception {
		
		String path = "./src/criacaoDeDados/Dados.txt";
		
		List<Pessoa> listaPessoas = new ArrayList<>();
		List<Conta> listaConta = new ArrayList<>();
		
		EjetarDados.leitorPessoas(path, listaPessoas);
		EjetarDados.leitorContas(path, listaConta);
		
		Menus.menuGeral(listaPessoas, listaConta);
	}
}
