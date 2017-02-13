package co.edu.uis.beans;

import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import co.edu.uis.interfaces.ArmarMensaje;

public abstract class SensorBase {

	public static final String KEY_ID="Id-Dispositivo";
	
	private ArmarMensaje armarMensaje;

	private String id;

	private ScheduledExecutorService executor;

	protected SensorBase(String id, ArmarMensaje armarMensaje) {
		if ( id == null || armarMensaje == null) {
			throw new IllegalArgumentException();
		}
		this.armarMensaje = armarMensaje;
		this.id = id;
		executor = Executors.newScheduledThreadPool(1);		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArmarMensaje getArmarMensaje() {
		return armarMensaje;
	}

	public void setMensaje(ArmarMensaje armarMensaje) {
		this.armarMensaje = armarMensaje;
	}

	public abstract Hashtable<String, String> generarMedicion() ;
	
	public  void  armarMensaje() {	
		getArmarMensaje().enviarDatos(getId(), generarMedicion());		
	}

	public ScheduledExecutorService getExecutor() {
		return executor;
	}
	
	public void start() {
		getExecutor().scheduleAtFixedRate(new Runnable() {

			public void run() {
				// System.out.println(label);
				armarMensaje();
			}
		}, 1, 3, TimeUnit.SECONDS);

	}
}
