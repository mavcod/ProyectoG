package co.edu.uis.implementacion;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import com.google.common.eventbus.EventBus;

import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.SensorI;

public class SensorPresionImpl extends SensorBase {

	private EventBus evento;

	public SensorPresionImpl(EventBus evento, String id, ArmarMensaje mensaje) {
		super(id, mensaje);
		this.evento = evento;
	}

	public void armarmensajeSensor() {
		Hashtable<String, String> tablasensor = generarMedicionEnConsola(id);
		enviarmensajeeventbus(evento, tablasensor);

	}

	@Override
	public Hashtable<String, String> generarMedicionEnConsola(String id) {
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
		tablasensor2.put("IdSensor", id);
		tablasensor2.put("Fecha", Fecha);
		tablasensor2.put("Hora", HoraC);
		tablasensor2.put("Descripcion", "Presión");
		tablasensor2.put("Valor", Integer.toString(key));

		return tablasensor2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.EjemploSensores.sensores.Sensor1#start()
	 */
	public void start() {
		executor.scheduleAtFixedRate(new Runnable() {

			public void run() {
				// System.out.println(label);
				armarmensajeSensor();
			}
		}, 1, 3, TimeUnit.SECONDS);

	}

}
