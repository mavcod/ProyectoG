package co.edu.uis.modulos;

import com.google.inject.AbstractModule;
import com.org.EjemploSensores.sensores.ArmarMensajeImpl;
import com.org.EjemploSensores.sensores.EnviarMensajeImpl;
import com.org.EjemploSensores.sensores.Sensor1Impl;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.Sensor1;

public class Sensor1M extends AbstractModule {

	private ArmarMensaje mensajeobtenido;
	private String id;
	public Sensor1M(String id,ArmarMensaje mensajeobtenido){
		this.mensajeobtenido=mensajeobtenido;
		this.id=id;
	}
	@Override
	protected void configure() {

		bind(ArmarMensaje.class).to(ArmarMensajeImpl.class);
		bind(Sensor1.class).toInstance(new Sensor1Impl(id,mensajeobtenido));
		
	}
	
	

}
