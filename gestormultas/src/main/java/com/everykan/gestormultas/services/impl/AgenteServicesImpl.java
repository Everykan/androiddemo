package com.everykan.gestormultas.services.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.pgrsoft.gestionmultas.model.Agente;
import com.pgrsoft.gestionmultas.services.AgenteServices;

public class AgenteServicesImpl implements AgenteServices{

	private static final AgenteServicesImpl INSTANCE = new AgenteServicesImpl();
	private static final Map<Long,Agente> AGENTES;
	
	static {
		
		AGENTES = new TreeMap<Long,Agente>();
		
		Agente agente1 = new Agente(100L,"Pepin","Galvez","Ridruejo");
		Agente agente2 = new Agente(101L,"Honorio","Martin","Salvador");
		Agente agente3 = new Agente(102L,"Carlota","Cifuentes","Arderiu");
		
		AGENTES.put(agente1.getCodigo(), agente1);
		AGENTES.put(agente2.getCodigo(), agente2);
		AGENTES.put(agente3.getCodigo(), agente3);
		
	}
	
	private AgenteServicesImpl() {
		
	}
	
	public static AgenteServices getInstance() {
		return INSTANCE;
	}
	
	
	@Override
	public Agente create(Agente agente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agente read(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Agente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
