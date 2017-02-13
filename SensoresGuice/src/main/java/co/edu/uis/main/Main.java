package co.edu.uis.main;

import com.google.inject.Guice;
import com.google.inject.Injector;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.EnviarMensaje;
import co.edu.uis.interfaces.PersistenciaMensaje;
import co.edu.uis.interfaces.SensorI;
import co.edu.uis.modulos.ArmarMensajeM;
import co.edu.uis.modulos.EnviarMensajeM;
import co.edu.uis.modulos.PersistenciaMensajeM;
import co.edu.uis.modulos.SensorTemperaturaM;
import co.edu.uis.modulos.SensorPresionM;

public class Main {

	public static void main(String[] args) {
		
		Injector injector =Guice.createInjector(new ArmarMensajeM());
		ArmarMensaje armarMensaje=injector.getInstance(ArmarMensaje.class);
						
		Injector injector2 =Guice.createInjector(new EnviarMensajeM(armarMensaje));
		EnviarMensaje enviarMensaje=injector2.getInstance(EnviarMensaje.class);
		enviarMensaje.start();
		
		Injector injector3 =Guice.createInjector(new SensorTemperaturaM("1",armarMensaje));
		SensorI sensorA=injector3.getInstance(SensorI.class);
		sensorA.start();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
		Injector injector4 =Guice.createInjector(new SensorPresionM("2",armarMensaje));
		SensorI sensorB=injector4.getInstance(SensorI.class);
		sensorB.start();
		
		Injector injector5 =Guice.createInjector(new PersistenciaMensajeM(armarMensaje));
		PersistenciaMensaje pertinencia=injector5.getInstance(PersistenciaMensaje.class);
		pertinencia.start();
		
		
	}
	
}
