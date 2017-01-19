package co.edu.uis.main;

import com.org.EjemploSensores.sensores.ArmarMensajeImpl;
import com.org.EjemploSensores.sensores.EnviarMensajeImpl;
import com.org.EjemploSensores.sensores.PertinenciaMensajeImpl;
import com.org.EjemploSensores.sensores.Sensor1Impl;
import com.org.EjemploSensores.sensores.Sensor2Impl;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PertinenciaMensaje;
import co.edu.uis.interfaces.Sensor1;
import co.edu.uis.interfaces.Sensor2;

public class Main {

	public static void main(String[] args) {
		
		ArmarMensaje armarMensaje = new ArmarMensajeImpl();
		
		EnviarMensaje enviarMensaje = new EnviarMensajeImpl(armarMensaje);
		enviarMensaje.start();
		
		Sensor1 sensorA = new Sensor1Impl("1" , armarMensaje);		
		sensorA.start();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
		
		Sensor2 sensorB = new Sensor2Impl("2" , armarMensaje);		
		sensorB.start();
		
		PertinenciaMensaje pertinencia = new PertinenciaMensajeImpl(armarMensaje);		
		pertinencia.start();
		
		
	}
	
}
