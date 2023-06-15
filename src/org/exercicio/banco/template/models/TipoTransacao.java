package org.exercicio.banco.template.models;

public enum TipoTransacao {
	DEPOSITO(1), SAQUE(2), TRANSFERENCIA_CREDITO(3), TRASNFERENCIA_DEBITO(4);

	private final int valor;

	private TipoTransacao(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static TipoTransacao transacaoFromValor(int valor) {
		for (TipoTransacao t : values()) {
			if (t.getValor() == valor)
				return t;
		}
		return null;
	}

}
