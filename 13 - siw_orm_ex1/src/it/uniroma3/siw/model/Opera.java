package it.uniroma3.siw.model;

import java.time.Year;
import java.util.List;

import javax.persistence.*;

@Entity
public class Opera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private Year anno;
	
	@Column(length = 255)
	private String descrizione;
	
	@OneToMany(mappedBy = "opere", fetch = FetchType.EAGER)
	private List<Artista> artisti;
	
	@ManyToOne
	private Collezione collezione;
	
}
