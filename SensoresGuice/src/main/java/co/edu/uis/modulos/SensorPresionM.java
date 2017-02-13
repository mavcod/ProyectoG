package co.edu.uis.modulos;

import com.google.inject.AbstractModule;
import com.org.EjemploSensores.sensores.ArmarMensajeImpl;
import com.org.EjemploSensores.sensores.SensorPresionImpl;
import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.SensorI;


public class SensorPresionM extends AbstractModule {

	private ArmarMensaje mensajeobtenido;
	private String id;
	public SensorPresionM(String id,ArmarMensaje mensajeobtenido){
		this.mensajeobtenido=mensajeobtenido;
		this.id=id;
	}
	@Override
	protected void configure() {

		bind(ArmarMensaje.class).to(ArmarMensajeImpl.class);
		bind(SensorI.class).toInstance(new SensorPresionImpl(id,mensajeobtenido));
		
	}

}
