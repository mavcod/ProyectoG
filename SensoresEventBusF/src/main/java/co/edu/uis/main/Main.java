package co.edu.uis.main;

import com.google.common.eventbus.EventBus;
import co.edu.uis.implementacion.ArmarMensajeImpl;
import co.edu.uis.implementacion.EnviarMensajeImpl;
import co.edu.uis.implementacion.PersistenciaMensajeImpl;
import co.edu.uis.implementacion.SensorTemperaturaImpl;
import co.edu.uis.implementacion.SensorPresionImpl;
import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PersistenciaMensaje;
import co.edu.uis.interfaces.SensorI;

public class Main {

	public static void main(String[] args) {

		ArmarMensaje armarMensaje = new ArmarMensajeImpl();
		EventBus evento = new EventBus();
		evento.register(armarMensaje);
		
		SensorI sensorA = new SensorTemperaturaImpl(evento, "1", armarMensaje);
		sensorA.start();

		EnviarMensaje enviarMensaje = new EnviarMensajeImpl(armarMensaje);
		enviarMensaje.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		SensorI sensorB = new SensorPresionImpl(evento, "2", armarMensaje);
		sensorB.start();

		PersistenciaMensaje pertinencia = new PersistenciaMensajeImpl(armarMensaje);
		pertinencia.start();

	}

}
