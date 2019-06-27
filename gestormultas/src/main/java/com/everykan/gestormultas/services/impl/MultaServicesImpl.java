package com.everykan.gestormultas.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.everykan.gestormultas.model.Agente;
import com.everykan.gestormultas.model.Multa;
import com.everykan.gestormultas.model.Tipo;
import com.everykan.gestormultas.services.MultaServices;


public class MultaServicesImpl implements MultaServices {

	private static final MultaServices INSTANCE = new MultaServicesImpl();
	private static final Map<Long,Multa> MULTAS;
	
	static {
		
		MULTAS = new TreeMap<Long,Multa>();
		
		//TODO Crear multas!!!!
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date fecha0 = null;
		Date fecha1 = null;
		Date fecha2 = null;
		
		try {
			fecha0 = sdf.parse("23/12/2018 12:23:44");
			fecha1 = sdf.parse("24/12/2018 21:10:23");
			fecha2 = sdf.parse("25/12/2018 23:54:10");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Agente agente1 = AgenteServicesImpl.getInstance().read(100L);
		Agente agente2 = AgenteServicesImpl.getInstance().read(101L);
		
		
		Multa m1 = new Multa();
		m1.setCodigo(100L);
		m1.setFechaHora(fecha0);
		m1.setAgente(agente1);
		m1.setMotivo("Motivo....");
		m1.setObservaciones("Observaciones...");
		m1.setImporte(100.0);
		m1.setTipo(Tipo.LEVE);
		m1.setAceptada(true);
		
		Multa m2 = new Multa();
		m2.setCodigo(101L);
		m2.setFechaHora(fecha1);
		m2.setAgente(agente2);
		m2.setMotivo("Motivo....");
		m2.setObservaciones("Observaciones...");
		m2.setImporte(100.0);
		m2.setTipo(Tipo.LEVE);
		m2.setAceptada(false);
		
		Multa m3 = new Multa();
		m3.setCodigo(102L);
		m3.setFechaHora(fecha2);
		m3.setAgente(agente2);
		m3.setMotivo("Motivo....");
		m3.setObservaciones("Observaciones...");
		m3.setImporte(200.0);
		m3.setTipo(Tipo.GRAVE);
		m3.setAceptada(false);
		
		MULTAS.put(m1.getCodigo(), m1);
		MULTAS.put(m2.getCodigo(), m2);
		MULTAS.put(m3.getCodigo(), m3);
		
	}
	
	private MultaServicesImpl() {
		
	}
	
	public static MultaServices getInstance() {
		return INSTANCE;
	}
	
	
	@Override
	public Multa create(Multa multa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Multa read(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Multa> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Multa> getByAgente(Agente agente) {
		// TODO Auto-generated method stub
		return null;
	}

}
