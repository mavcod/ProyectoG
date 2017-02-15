package co.edu.uis.beans;

import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.common.eventbus.EventBus;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.Sensor;

public abstract class SensorBase implements Sensor  {

	public static final String KEY_ID="Id-Dispositivo";
	
	protected ArmarMensaje armarMensaje;
	protected EventBus evento;
	protected String id;

	protected ScheduledExecutorService executor;

	protected SensorBase(String id, ArmarMensaje armarMensaje) {
		if ( id == null || armarMensaje == null) {
			throw new IllegalArgumentException();
		}
		this.armarMensaje = armarMensaje;
		this.id = id;
		executor = Executors.newScheduledThreadPool(1);		
	}

	public void armarmensajeSensor() {
		// TODO Auto-generated method stub

	}

	public Hashtable<String, String> generarMedicionEnConsola(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void start() {
		// TODO Auto-generated method stub

	}

	public void enviarmensajeeventbus(EventBus evento, Hashtable<String, String> mensaje) {
		Hashtable<String, String> tablasensor = mensaje;
		this.evento = evento;
		evento.post(tablasensor);
	}
}
