package br.com.tools.timesheet.domain.sat;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SAT_VIEW_POA")
public class ViewTimeSheet {
	
	@Id
	private String matricula;
	
	private String nome;
	
	private String tarefa;
	
	private String descricao;
	
	@Column(name="cod_fase")
	private String codFase;
	
	@Column(name="des_fase")
	private String desFase;
	
	@Column(name="cod_atividade")
	private String codAtividade;

	@Column(name="des_atividade")
	private String desAtividade;
	
	@Column(name="dt_timesheet")
	private LocalDate data;
	
	private String observacao;
	
	private String horas;
	
	
	public ViewTimeSheet(){
		
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tarefa
	 */
	public String getTarefa() {
		return tarefa;
	}

	/**
	 * @param tarefa the tarefa to set
	 */
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the codFase
	 */
	public String getCodFase() {
		return codFase;
	}

	/**
	 * @param codFase the codFase to set
	 */
	public void setCodFase(String codFase) {
		this.codFase = codFase;
	}

	/**
	 * @return the desFase
	 */
	public String getDesFase() {
		return desFase;
	}

	/**
	 * @param desFase the desFase to set
	 */
	public void setDesFase(String desFase) {
		this.desFase = desFase;
	}

	/**
	 * @return the codAtividade
	 */
	public String getCodAtividade() {
		return codAtividade;
	}

	/**
	 * @param codAtividade the codAtividade to set
	 */
	public void setCodAtividade(String codAtividade) {
		this.codAtividade = codAtividade;
	}

	/**
	 * @return the desAtividade
	 */
	public String getDesAtividade() {
		return desAtividade;
	}

	/**
	 * @param desAtividade the desAtividade to set
	 */
	public void setDesAtividade(String desAtividade) {
		this.desAtividade = desAtividade;
	}

	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the horas
	 */
	public String getHoras() {
		return horas;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(String horas) {
		this.horas = horas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ViewTimeSheet [matricula=" + matricula + ", nome=" + nome + ", tarefa=" + tarefa + ", descricao="
				+ descricao + ", codFase=" + codFase + ", desFase=" + desFase + ", codAtividade=" + codAtividade
				+ ", desAtividade=" + desAtividade + ", data=" + data + ", observacao=" + observacao + ", horas="
				+ horas + "]";
	}
	
	

}
