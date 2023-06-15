package org.exercicio.banco.template.models;

public enum TipoConta {

	CONTA_CORRENTE(1), CONTA_POUPANCA(2);

	private final int valor;

	private TipoConta(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static TipoConta transacaoFromValor(int valor) {
		for (TipoConta t : values()) {
			if (t.getValor() == valor)
				return t;
		}
		return null;
	}
}
