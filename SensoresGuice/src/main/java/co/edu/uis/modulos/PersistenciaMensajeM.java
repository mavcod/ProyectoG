package co.edu.uis.modulos;

import com.google.inject.AbstractModule;
import com.org.EjemploSensores.sensores.ArmarMensajeImpl;
import com.org.EjemploSensores.sensores.EnviarMensajeImpl;
import com.org.EjemploSensores.sensores.PersistenciaMensajeImpl;
import com.org.EjemploSensores.sensores.SensorTemperaturaImpl;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PersistenciaMensaje;
import co.edu.uis.interfaces.SensorI;

public class PersistenciaMensajeM extends AbstractModule {

	
	private ArmarMensaje mensajeobtenido;

	public PersistenciaMensajeM(ArmarMensaje mensajeobtenido){
		this.mensajeobtenido=mensajeobtenido;
	
	}
	@Override
	protected void configure() {

		bind(ArmarMensaje.class).to(ArmarMensajeImpl.class);
		bind(PersistenciaMensaje.class).toInstance(new PersistenciaMensajeImpl(mensajeobtenido));
		
	}
	


}
