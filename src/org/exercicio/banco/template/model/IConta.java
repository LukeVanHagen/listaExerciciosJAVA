package org.exercicio.banco.template.model;

import java.math.BigDecimal;

public interface IConta {

	
	public void depositar(BigDecimal quantia);
	public void sacar(BigDecimal quantia);
	public void transferir(ContaBancaria c, BigDecimal quantia);
	public void imprimirExtratoConta(int mes, int year);
}
