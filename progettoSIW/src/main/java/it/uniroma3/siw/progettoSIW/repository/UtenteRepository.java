package it.uniroma3.siw.progettoSIW.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progettoSIW.model.Utente;


public interface UtenteRepository extends CrudRepository<Utente, Long>{
	
	
	public List<Utente> findByNome(String nome);
	public List<Utente> findByNomeAndCognome(String nome, String cognome);
}

