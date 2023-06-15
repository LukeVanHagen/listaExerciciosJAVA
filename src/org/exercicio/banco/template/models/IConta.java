package org.exercicio.banco.template.models;

import java.math.BigDecimal;
import java.util.List;

public interface IConta { 

	public abstract void depositar(BigDecimal quantia);

	public abstract void transferir(IConta contaDestino, BigDecimal quantia);

	public abstract void imprimirExtratoConta(int ano, int mes);

	public abstract void desativarConta();

	public abstract void ativarConta();

	public abstract void sacar(BigDecimal quantia);

	public abstract List<RegistroTransacao> getTransacoes();

	


}
