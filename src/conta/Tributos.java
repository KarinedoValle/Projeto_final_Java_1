package conta;

public interface Tributos {
	
		 
	    static final double saque = 0.10;
	    static final double deposito = 0.10;
	    static final double transferencia = 0.20;
	    static final double rendimentoPoupancaDia = 0.0011/30;
	    static final double porcentagemSeguroDeVida = 0.2;
	 
	    public double calculoTributoSeguroDeVida(double valor);
	
	
}
