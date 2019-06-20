package com.everykan.gestormultas.services;

import java.util.List;

import com.pgrsoft.gestionmultas.model.Agente;

public interface AgenteServices {

	/**
	 * 
	 * Se crea un Agente con un nuevo c�digo
	 * 
	 * @param agente
	 * @return
	 */
	public Agente create (Agente agente);
	
	public Agente read(Long codigo);
	public void delete(Long codigo);
	
	public List<Agente> getAll();
	
}
