package co.edu.uis.modulos;

import com.google.inject.AbstractModule;
import com.org.EjemploSensores.sensores.ArmarMensajeImpl;
import com.org.EjemploSensores.sensores.EnviarMensajeImpl;
import com.org.EjemploSensores.sensores.PertinenciaMensajeImpl;
import com.org.EjemploSensores.sensores.Sensor1Impl;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PertinenciaMensaje;
import co.edu.uis.interfaces.Sensor1;

public class PertinenciaMensajeM extends AbstractModule {

	
	private ArmarMensaje mensajeobtenido;

	public PertinenciaMensajeM(ArmarMensaje mensajeobtenido){
		this.mensajeobtenido=mensajeobtenido;
	
	}
	@Override
	protected void configure() {

		bind(ArmarMensaje.class).to(ArmarMensajeImpl.class);
		bind(PertinenciaMensaje.class).toInstance(new PertinenciaMensajeImpl(mensajeobtenido));
		
	}
	


}
