package it.uniroma3.siw.progettoSIW.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.progettoSIW.model.Foto;
import it.uniroma3.siw.progettoSIW.repository.FotoRepository;

@Service
public class FotoService {

	@Autowired 
	private FotoRepository fotoRepository;

	@Transactional 
	public Foto inserisci(Foto foto) {
		return fotoRepository.save(foto);
	}

	@Transactional
	public List<Foto> tutti(){
		return (List<Foto>) fotoRepository.findAll();
	}
	
	
	

	public Foto fotoPerId(Long id) {
		return this.fotoRepository.findById(id).get();
	}
	
	@Transactional 
	public void elimina(Long id) {
		fotoRepository.deleteById(id);
	}
}