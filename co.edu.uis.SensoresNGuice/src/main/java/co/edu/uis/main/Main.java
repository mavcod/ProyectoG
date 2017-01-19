package co.edu.uis.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
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
import co.edu.uis.modulos.ArmarMensajeM;
import co.edu.uis.modulos.EnviarMensajeM;
import co.edu.uis.modulos.PertinenciaMensajeM;
import co.edu.uis.modulos.Sensor1M;
import co.edu.uis.modulos.Sensor2M;

public class Main {

	public static void main(String[] args) {
		
		Injector injector =Guice.createInjector(new ArmarMensajeM());
		ArmarMensaje armarMensaje=injector.getInstance(ArmarMensaje.class);
		
		//ArmarMensaje armarMensaje = new ArmarMensajeImpl();
		
		Injector injector2 =Guice.createInjector(new EnviarMensajeM(armarMensaje));
		EnviarMensaje enviarMensaje=injector2.getInstance(EnviarMensaje.class);
		
		
		
		//EnviarMensaje enviarMensaje = new EnviarMensajeImpl(armarMensaje);
		enviarMensaje.start();
		
		Injector injector3 =Guice.createInjector(new Sensor1M("1",armarMensaje));
		Sensor1 sensorA=injector3.getInstance(Sensor1.class);
		//Sensor1 sensorA = new Sensor1Impl("1" , armarMensaje);		
		sensorA.start();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
		Injector injector4 =Guice.createInjector(new Sensor2M("2",armarMensaje));
		Sensor2 sensorB=injector4.getInstance(Sensor2.class);
		//Sensor2 sensorB = new Sensor2Impl("2" , armarMensaje);		
		sensorB.start();
		
		Injector injector5 =Guice.createInjector(new PertinenciaMensajeM(armarMensaje));
		PertinenciaMensaje pertinencia=injector5.getInstance(PertinenciaMensaje.class);
	//	PertinenciaMensaje pertinencia = new PertinenciaMensajeImpl(armarMensaje);		
		pertinencia.start();
		
		
	}
	
}
