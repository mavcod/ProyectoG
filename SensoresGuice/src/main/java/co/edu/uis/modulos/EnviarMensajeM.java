package co.edu.uis.modulos;

import com.google.inject.AbstractModule;
import com.org.EjemploSensores.sensores.ArmarMensajeImpl;
import com.org.EjemploSensores.sensores.EnviarMensajeImpl;
import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;


public class EnviarMensajeM extends AbstractModule {

	private ArmarMensaje mensajeobtenido;
	public EnviarMensajeM(ArmarMensaje mensajeobtenido){
		this.mensajeobtenido=mensajeobtenido;
	}
	@Override
	protected void configure() {

		bind(ArmarMensaje.class).to(ArmarMensajeImpl.class);
		bind(EnviarMensaje.class).toInstance(new EnviarMensajeImpl(mensajeobtenido));
		
	}

}
