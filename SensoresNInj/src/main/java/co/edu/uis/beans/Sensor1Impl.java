package co.edu.uis.beans;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.Sensor1;

public class Sensor1Impl extends Sensor implements Sensor1 {

	private String id;
	private ArmarMensaje mensaje;
	
	public Sensor1Impl(String id, ArmarMensaje mensaje) {
		super(id, mensaje);
		
	}
	
	
	public synchronized String getId() {
		return id;
	}


	public synchronized void setId(String id) {
		this.id = id;
	}


	public ArmarMensaje getMensaje() {
		return mensaje;
	}


	public synchronized void setMensaje(ArmarMensaje mensaje) {
		this.mensaje = mensaje;
	}


	public synchronized void armarmensajeSensor1() {
		Hashtable<String, String> tablasensor = generarMedicionEnConsola();
		//System.out.println("entro3 "+id);
		armarMensaje.recibirDatos(id, tablasensor);

	}
	
	
	public Hashtable<String, String> generarMedicionEnConsola() {
		Hashtable<String, String> tablasensor1 = new Hashtable<String, String>();
		
		// valor
		int key = (int) (Math.random() * 200 + 1);
		// fecha
		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		String Fecha = dia + "/" + mes + "/" + annio;

		// hora

		String hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
		String minutos = Integer.toString(c.get(Calendar.MINUTE));
		String segundos = Integer.toString(c.get(Calendar.SECOND));
		String HoraC = hora + ":" + minutos + ":" + segundos;

		// HashTable
		tablasensor1.put("Fecha", Fecha);
		tablasensor1.put("Hora", HoraC);
		tablasensor1.put("Descripcion", "Temperatura");
		tablasensor1.put("Valor", Integer.toString(key));
		
		return tablasensor1;
	}
	
	
	/* (non-Javadoc)
	 * @see com.org.EjemploSensores.sensores.Sensor1#start()
	 */
	public void start() {
		executor.scheduleAtFixedRate(new Runnable() {

			public void run() {
				//System.out.println(label);
				armarmensajeSensor1();						
			}
		}, 1, 3, TimeUnit.SECONDS);
		
	}

}
