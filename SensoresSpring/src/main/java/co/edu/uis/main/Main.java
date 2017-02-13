package co.edu.uis.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PersistenciaMensaje;
import co.edu.uis.interfaces.Sensor;


public class Main {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("co/edu/uis/xml/beans.xml");

		
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

		PersistenciaMensaje pertinenciaA = (PersistenciaMensaje) appContext.getBean("pertinencia");
		pertinenciaA.start();

		((ConfigurableApplicationContext) appContext).close();

	}

}
