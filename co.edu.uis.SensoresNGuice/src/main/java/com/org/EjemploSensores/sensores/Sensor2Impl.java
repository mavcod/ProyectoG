package com.org.EjemploSensores.sensores;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.Sensor2;

public class Sensor2Impl extends Sensor implements Sensor2  {

	@Inject 
	public Sensor2Impl(String id, ArmarMensaje mensaje) {
		super(id, mensaje);
		
	}
	
	/* (non-Javadoc)
	 * @see com.org.EjemploSensores.sensores.Sensor2#armarmensajeSensor2()
	 */
	public void armarmensajeSensor2() {
		Hashtable<String, String> tablasensor = generarMedicionEnConsola2();
		armarMensaje.recibirDatos(id, tablasensor);

	}
	
	/* (non-Javadoc)
	 * @see com.org.EjemploSensores.sensores.Sensor2#generarMedicionEnConsola2()
	 */
	public Hashtable<String, String> generarMedicionEnConsola2() {
		Hashtable<String, String> tablasensor2 = new Hashtable<String, String>();

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
		tablasensor2.put("Fecha", Fecha);
		tablasensor2.put("Hora", HoraC);
		tablasensor2.put("Descripcion", "Presión");
		tablasensor2.put("Valor", Integer.toString(key));

		return tablasensor2;
	}

	/* (non-Javadoc)
	 * @see com.org.EjemploSensores.sensores.Sensor2#start()
	 */
	public void start() {
		executor.scheduleAtFixedRate(new Runnable() {

			public void run() {
				//System.out.println(label);
				armarmensajeSensor2();						
			}
		}, 1, 3, TimeUnit.SECONDS);
		
	}

}
