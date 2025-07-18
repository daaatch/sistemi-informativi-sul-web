package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Collezione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	@ManyToOne
	private Curatore curatore;
	
	@Column
	@OneToMany(mappedBy = "collezione", fetch = FetchType.EAGER)
	private List<Opera> opere;

}
