package com.everykan.gestormultas.services;

import java.util.List;

import com.everykan.gestormultas.model.Agente;

public interface AgenteServices {

	/**
	 * Se crea un Agente con un nuevo código
	 * 
	 * @param agente
	 * @return
	 */

	public Agente create (Agente agente);
	
	public Agente read(Long codigo);
	public void delete(Long codigo);
	
	public List<Agente> getAll();
	
}
