package com.org.EjemploSensores.sensores;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.PertinenciaMensaje;


public class PertinenciaMensajeImpl implements PertinenciaMensaje {

	private String result;
	protected ScheduledExecutorService executor;
	private ArmarMensaje mensajeobtenido;
	
	@Inject 
	public PertinenciaMensajeImpl(ArmarMensaje mensajeobtenido) {
		this.mensajeobtenido = mensajeobtenido;
		 executor = Executors.newScheduledThreadPool(1);
	}

	public void pertinenciaMensaje() {

		result = mensajeobtenido.obtenermensaje();
		ArchivoImpl.LeeryEscribir(result);

	}	
	
	public void start() {
		executor.scheduleAtFixedRate(new Runnable() {

			public void run() {
				pertinenciaMensaje();						
			}
		}, 1, 3, TimeUnit.SECONDS);
		
	}

}