package com.org.EjemploSensores.sensores;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import co.edu.uis.interfaces.ArmarMensaje;


public class Sensor {
	
	protected ArmarMensaje armarMensaje;

	protected String id;
	
	protected ScheduledExecutorService executor;
	
	public Sensor(String id, ArmarMensaje mensaje) {
		this.armarMensaje = mensaje;
		 executor = Executors.newScheduledThreadPool(1);
		 this.id = id;
	}

	
	

}
