package com.everykan.gestormultas.services;

import java.util.List;

import com.everykan.gestormultas.model.Agente;
import com.everykan.gestormultas.model.Multa;

public interface MultaServices {

	/**
	 * 
	 * Se crea una multa con un nuevo c�digo
	 * 
	 * @param multa
	 * @return
	 */
	public Multa create(Multa multa);
	
	public Multa read(Long codigo);
	
	public void delete(Long codigo);
	
	public List<Multa> getAll();
	public List<Multa> getByAgente(Agente agente);
	
	
}
