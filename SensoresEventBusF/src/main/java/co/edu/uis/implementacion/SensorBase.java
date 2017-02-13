package co.edu.uis.implementacion;

import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.google.common.eventbus.EventBus;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.SensorI;

public class SensorBase implements SensorI {

	protected ArmarMensaje armarMensaje;
	protected EventBus evento;
	protected String id;

	protected ScheduledExecutorService executor;

	public SensorBase(String id, ArmarMensaje mensaje) {
		this.armarMensaje = mensaje;
		executor = Executors.newScheduledThreadPool(1);
		this.id = id;
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
