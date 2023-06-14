package org.exercicio.banco.template.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.exercicio.banco.template.model.enumerator.TipoTransacao;

public class ContaPoupanca implements Serializable , IConta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer numeroConta;
	private BigDecimal saldo;
	private LocalDateTime dataAbertura;
	private boolean status;
	private List<RegistroTransacao> transacoes;

	public ContaPoupanca() {
		this.numeroConta = new Random().nextInt(999999999);
		this.saldo = BigDecimal.ZERO;
		saldo.setScale(4, RoundingMode.HALF_UP);
		this.dataAbertura = LocalDateTime.now();
		this.status = true;
		transacoes = new ArrayList<>();
	}
	
	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	private void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	private void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<RegistroTransacao> getTransacoes() {
		return transacoes;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(numeroConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPoupanca other = (ContaPoupanca) obj;
		return Objects.equals(numeroConta, other.numeroConta);
	}

	@Override
	public String toString() {
		return "ContaPoupanca [numeroConta=" + numeroConta + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura
				+ ", status=" + status + ", transacoes=" + transacoes + "]";
	}

	@Override
	public void depositar(BigDecimal quantia) {
		
		if (status) {
			if (quantia.compareTo(BigDecimal.ZERO) > 0) {
				this.saldo = this.saldo.add(quantia);
				transacoes.add(new RegistroTransacao(quantia, TipoTransacao.CREDITO, LocalDateTime.now()));
				System.out.println("Deposito realizado com sucesso.");
			} else {
				System.err.println("Valor invalido para deposito.");

			}
		} else {
			System.err.println("Operação não permitida. Conta desativada.");

		}
		
	}

	@Override
	public void sacar(BigDecimal quantia) {
		
		if (status) {
			if (quantia.compareTo(BigDecimal.ZERO) > 0) {
				if (this.saldo.compareTo(quantia) > 0) {
					this.saldo = this.saldo.subtract(quantia);
					transacoes.add(new RegistroTransacao(quantia, TipoTransacao.DEBITO, LocalDateTime.now()));
					System.out.println("Saque realizado com sucesso!");
				} else {
					System.err.println("Saldo insuficiente.");
				}
			} else {
				System.err.println("Valor invalido para saque.");
			}
		} else {
			System.err.println("Operação não permitida. Conta desativada.");
		}
		
	}

	@Override
	public void transferir(ContaBancaria c, BigDecimal quantia) {
		
		if (status && c.isStatus()) {
			if (quantia.compareTo(BigDecimal.ZERO) < 0) {
				System.err.println("Valor invalido para transferencia.");
			} else if (quantia.compareTo(saldo) <= 0) {
				setSaldo(saldo.subtract(quantia));
				c.setSaldo(c.getSaldo().add(quantia));
				c.transacoes.add(new RegistroTransacao(quantia, TipoTransacao.TRANSACAO_CREDITO, LocalDateTime.now()));
				transacoes.add(new RegistroTransacao(quantia, TipoTransacao.TRANSACAO_DEBITO, LocalDateTime.now()));
			} else
				System.err.println("Saldo insuficiente para realizar a transferencia.");
		} else {
			System.err.println("Operacao nao pode ser realizada entre contas desativadas.");
		}
		
	}

	@Override
	public void imprimirExtratoConta(int mes, int year) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	    System.out.println("Extrato da Conta: " + numeroConta);
	    System.out.println("Mês/Ano: " + mes + "/" + year);
	    System.out.println("--------------------------------------");

	    for (RegistroTransacao transacao : transacoes) {
	        LocalDateTime dataTransacao = transacao.getDataTransacao();
	        if (dataTransacao.getMonthValue() == mes && dataTransacao.getYear() == year) {
	            System.out.println("Data: " + dataTransacao.format(formatter));
	            System.out.println("Descrição: " + transacao.getDescricao());
	            System.out.println("Valor: " + transacao.getValor());
	            System.out.println("--------------------------------------");
	        }
	    }
	}
		
	}

