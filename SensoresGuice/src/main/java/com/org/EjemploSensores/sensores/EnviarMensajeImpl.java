package com.org.EjemploSensores.sensores;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;

public class EnviarMensajeImpl implements EnviarMensaje {

	private ArmarMensaje mensajeobtenido;
	
	private ScheduledExecutorService executor;
	@Inject 
	public EnviarMensajeImpl(ArmarMensaje mensajeobtenido) {
		this.mensajeobtenido = mensajeobtenido;
		 executor = Executors.newScheduledThreadPool(1);
	}

	
	public void enviarMensaje() {

		String result = mensajeobtenido.obtenermensaje();
		//System.out.println("EnviarMensaje");
		System.out.println(result);

	}
	
	public void start() {
		executor.scheduleAtFixedRate(new Runnable() {

			public void run() {
				
				enviarMensaje();						
			}
		}, 1, 2, TimeUnit.SECONDS);
		
	}
	

}
