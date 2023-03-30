package org.exercicio.banco.template.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.exercicio.banco.template.model.enumerator.TipoTransacao;

public class RegistroTransacao {

	private Integer id;
	private LocalDateTime dataTransacao;
	private double valor;
	private TipoTransacao tipo;
	
	private static int CONTADOR = 0;
	
	public RegistroTransacao(LocalDateTime data, double valor, TipoTransacao tipo) {
	
		CONTADOR++;
		this.id = CONTADOR;
		this.dataTransacao = data;
		this.tipo = tipo;
		
		if(tipo.getValor() == 1 || tipo.getValor() == 3) {
			this.valor = (valor*-1);
		}else
			this.valor = valor;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDateTime dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}

	public static int getCONTADOR() {
		return CONTADOR;
	}

	public static void setCONTADOR(int cONTADOR) {
		CONTADOR = cONTADOR;
	}

	@Override
	public String toString() {
		return "RegistroTransacao [id=" + id + ", dataTransacao=" + dataTransacao + ", valor=" + valor + ", tipo="
				+ tipo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroTransacao other = (RegistroTransacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
