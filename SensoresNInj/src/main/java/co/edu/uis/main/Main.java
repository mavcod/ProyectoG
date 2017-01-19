package co.edu.uis.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edu.uis.beans.EnviarMensajeImpl;
import co.edu.uis.beans.PertinenciaMensajeImpl;
import co.edu.uis.beans.Sensor1Impl;
import co.edu.uis.beans.Sensor2Impl;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PertinenciaMensaje;
import co.edu.uis.interfaces.Sensor1;
import co.edu.uis.interfaces.Sensor2;

public class Main {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("co/edu/uis/xml/beans.xml");

		EnviarMensaje enviarMensaje = (EnviarMensajeImpl) appContext.getBean("enviarMensaje");

		enviarMensaje.start();

		Sensor1 sensorA = (Sensor1Impl) appContext.getBean("sensor1");

		sensorA.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Sensor2 sensorB = (Sensor2Impl) appContext.getBean("sensor2");

		sensorB.start();

		PertinenciaMensaje pertinenciaA = (PertinenciaMensajeImpl) appContext.getBean("pertinencia");
		pertinenciaA.start();

		((ConfigurableApplicationContext) appContext).close();

	}

}
