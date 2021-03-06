package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa extends Geral{

	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cpf;
	
	@Column(nullable=false)
	private String rg;
	
	@OneToMany (mappedBy = "pessoa")
	@Cascade(CascadeType.ALL)
	private List<Telefones> telefones;
	
	@Temporal(TemporalType.DATE)
	private Date dtnasc;

	public Pessoa() {
		super();
	}
	public Pessoa(String nome, String cpf, String rg, List<Telefones> telefones, Date dtnasc) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefones = telefones;
		this.dtnasc = dtnasc;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public List<Telefones> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefones> telefones) {
		this.telefones = telefones;
	}
	public Date getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}
	
}
