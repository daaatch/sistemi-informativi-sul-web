package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Curatore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, length = 10)
	private String matricola;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Collezione> collezioni;

}
