package org.exercicio.banco.template.model;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente cli1 = new Cliente("Gustavo", "000");
		
		ContaBancaria c1 = new ContaBancaria(1, 0);
		
		ContaBancaria c2 = new ContaBancaria(2, 0);
		
		c1.depositar(100);
		c1.sacar(25);
		c1.realizarTransferencia(10, c2);
		
		System.out.println(c1);
		c1.imprimirExtrato(3, 2023);
		System.out.println(c2);
		c2.imprimirExtrato(3, 2023);
	}

}
