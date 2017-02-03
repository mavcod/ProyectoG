package co.edu.uis.main;

import com.google.common.eventbus.EventBus;
import co.edu.uis.implementacion.ArmarMensajeImpl;
import co.edu.uis.implementacion.EnviarMensajeImpl;
import co.edu.uis.implementacion.Sensor1Impl;
import co.edu.uis.implementacion.Sensor2Impl;
import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.SensorI;

public class Main {

	public static void main(String[] args) {

		ArmarMensaje armarMensaje = new ArmarMensajeImpl();
		EventBus evento = new EventBus();
		evento.register(new ArmarMensajeImpl());
		// eventBus.register(new EnviarMensajeImpl(armarMensaje));

		SensorI sensorA = new Sensor1Impl(evento, "1", armarMensaje);
		sensorA.start();

		EnviarMensaje enviarMensaje = new EnviarMensajeImpl(armarMensaje);
		enviarMensaje.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		SensorI sensorB = new Sensor2Impl(evento, "2", armarMensaje);
		sensorB.start();

		//PertinenciaMensaje pertinencia = new PertinenciaMensajeImpl(armarMensaje);
		//Pertinencia.start();

	}

}
