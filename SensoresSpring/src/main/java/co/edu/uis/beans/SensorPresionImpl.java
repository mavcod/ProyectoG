package co.edu.uis.beans;

import java.util.Calendar;
import java.util.Hashtable;
import co.edu.uis.interfaces.ArmarMensaje;
import co.edu.uis.interfaces.Sensor;


public class SensorPresionImpl extends SensorBase  implements Sensor {

	public SensorPresionImpl(String id, ArmarMensaje mensaje) {
		super(id, mensaje);

	}

	@Override
	public Hashtable<String, String> generarMedicion() {
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

	

}
