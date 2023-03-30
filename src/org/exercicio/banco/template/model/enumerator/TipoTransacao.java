package org.exercicio.banco.template.model.enumerator;

public enum TipoTransacao {

	SAQUE(1),
	DEPOSITO(2),
	TRANSFERENCIA_DEBITADO(3),
	TRANSFERENCIA_CREDITADO(4);
	
	private final int valor;
	
	private TipoTransacao(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static TipoTransacao getTipoFromNumero(int valor) {
		for(TipoTransacao t : values()) {
			if(t.getValor() == valor)
				return t;
		}
		return null;
	}
	
}
