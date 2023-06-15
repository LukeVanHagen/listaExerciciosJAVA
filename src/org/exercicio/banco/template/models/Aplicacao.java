package org.exercicio.banco.template.models;

import java.math.BigDecimal;

public class Aplicacao {

	public static void main(String[] args) {
		
		ContaCorrente conta = new ContaCorrente();
		conta.imprimirExtratoConta(2022,12);
		
		System.out.println(conta.toString());
		
		ContaPoupanca conta1 = new ContaPoupanca();
		ContaPoupanca conta2 = new ContaPoupanca();
		ContaCorrente corrente = new ContaCorrente();
		BigDecimal quantia = new BigDecimal("100");
		BigDecimal quantia1 = new BigDecimal("50");
	
		conta1.desativarConta();
		
		conta2.depositar(quantia);
		conta2.imprimirExtratoConta(2023,6);
		conta2.transferir(corrente, quantia1);
		conta2.imprimirExtratoConta(2023,6);
	}
}
