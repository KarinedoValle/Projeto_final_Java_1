package Conta;

public class ContaCorrente extends Conta {
	
	private String TipoConta;

	public ContaCorrente(String cpf, double saldo, int agencia, String tipoConta) {
		super(cpf, saldo, agencia);
		TipoConta = tipoConta;
	}

	public ContaCorrente() {
		super();
	}
	
	public String getTipoConta() {
		return TipoConta;
	}

	public void setTipoConta(String tipoConta) {
		TipoConta = tipoConta;
	}

	@Override
    public String sacar(double valor) {
        double saldoAnterior;
        double novoSaldo;
        if (this.getSaldo() > valor + saque) {
            saldoAnterior = this.getSaldo();
            novoSaldo = getSaldo() - valor - saque;
            this.setSaldo(novoSaldo);
            return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + novoSaldo;
        } else {
            return "Saldo insuficiente para saque.";
        }
    }
 
    @Override
    public String depositar(double valor) {
        double novoSaldo;
        double saldoAnterior = this.getSaldo();
        novoSaldo = this.getSaldo() + valor - deposito;
        this.setSaldo(novoSaldo);
        return "Saldo anterior: " + saldoAnterior + "\nValor depositado: " + valor + "\nSaldo atual: " + novoSaldo;
    }
 
    @Override
    public String transferir(double valor, Conta conta) {
        double saldoAnterior;
        double novoSaldo;
        if (this.getSaldo() > valor + transferencia) {
            saldoAnterior = this.getSaldo();
            novoSaldo = getSaldo() - valor - transferencia;
            sacar(valor);
            this.setSaldo(novoSaldo);
            conta.setSaldo(conta.getSaldo() + valor);
            return "Saldo anterior: " + saldoAnterior + "\nValor sacado: " + valor + "\nSaldo atual: " + novoSaldo;
        } else {
            return "Saldo insuficiente para transferencia.";
        }
    }
    
  }
