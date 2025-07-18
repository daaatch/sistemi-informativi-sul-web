package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private LocalDate nascita;
	
	@Column(nullable = true)
	private LocalDate morte;
	
	@Column(length = 3)
	private String nazionalita;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Opera> opere;
	
}
