package it.uniroma3.siw.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String denominazione;
	
	@ManyToOne
	private Professore titolare;
	
	@ManyToMany
	private List<Professore> commissioneEsame;
	
	public Corso() {	
	}
	
	public Corso(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(denominazione, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(denominazione, other.denominazione) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Corso [id=" + id + ", denominazione=" + denominazione + "]";
	}
	
}
