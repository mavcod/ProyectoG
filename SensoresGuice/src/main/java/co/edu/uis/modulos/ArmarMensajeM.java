package co.edu.uis.modulos;

import com.google.inject.AbstractModule;
import com.org.EjemploSensores.sensores.ArmarMensajeImpl;

import co.edu.uis.interfaces.ArmarMensaje;

public class ArmarMensajeM extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(ArmarMensaje.class).to(ArmarMensajeImpl.class);
		
		
	}

}
