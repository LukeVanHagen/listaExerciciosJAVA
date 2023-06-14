package org.exercicio.banco.template.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

import org.exercicio.banco.template.model.enumerator.TipoTransacao;

public class RegistroTransacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private BigDecimal valor;
	private TipoTransacao tipo;
	private LocalDateTime dataTransacao;

	
	public RegistroTransacao(BigDecimal valor, TipoTransacao tipo, LocalDateTime data) {
		this.id = new Random().nextInt(999999999);
		this.valor = valor;
		this.tipo = tipo;
		this.dataTransacao= dataTransacao;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getData() {
		return dataTransacao;
	}

	public void setData(LocalDateTime data) {
		this.dataTransacao = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataTransacao, id, tipo, valor);
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
		return Objects.equals(dataTransacao, other.dataTransacao) && Objects.equals(id, other.id) && tipo == other.tipo
				&& Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "RegistroTransacao [id=" + id + ", valor=" + valor + ", tipo=" + tipo + ", data=" + dataTransacao + "]";
	}

	public LocalDateTime getDataTransacao() {
		
		return dataTransacao;
	}

	public String getDescricao() {
		
        String descricao;

        switch (tipo) {
            case CREDITO:
                descricao = "Crédito";
                break;
            case DEBITO:
                descricao = "Débito";
                break;
            case TRANSACAO_CREDITO:
                descricao = "Transferência Recebida";
                break;
            case TRANSACAO_DEBITO:
                descricao = "Transferência Enviada";
                break;
            default:
                descricao = "Desconhecido";
        }

        return descricao;
    }
	
	}
	
	
	
	
	

