package co.edu.uis.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.eventbus.EventBus;

import co.edu.uis.beans.ArmarMensajeImpl;
import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PertinenciaMensaje;
import co.edu.uis.interfaces.Sensor;

public class Main {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("co/edu/uis/xml/beans.xml");

		ArmarMensaje armarmensaje = (ArmarMensaje) appContext.getBean("armarmensaje");

		EventBus evento = (EventBus) appContext.getBean("eventBus");
		evento.register(armarmensaje);

		EnviarMensaje enviarMensaje = (EnviarMensaje) appContext.getBean("enviarMensaje");

		enviarMensaje.start();

		Sensor sensorA = (Sensor) appContext.getBean("sensor1");

		sensorA.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Sensor sensorB = (Sensor) appContext.getBean("sensor2");
		sensorB.start();

		PertinenciaMensaje pertinenciaA = (PertinenciaMensaje) appContext.getBean("pertinencia");
		pertinenciaA.start();

		((ConfigurableApplicationContext) appContext).close();

	}

}
