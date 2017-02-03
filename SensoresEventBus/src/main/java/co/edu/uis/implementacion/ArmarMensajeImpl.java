package co.edu.uis.implementacion;

import java.util.Enumeration;
import java.util.Hashtable;
import com.google.common.eventbus.Subscribe;
import co.edu.uis.interfaces.ArmarMensaje;


public class ArmarMensajeImpl implements ArmarMensaje {

	private Hashtable<String, String> datos;

	public ArmarMensajeImpl() {
		datos = new Hashtable<String, String>();
	}

	@Subscribe
	public synchronized void recibirmensaje(Hashtable<String, String> mensaje) {
		datos.putAll(mensaje);
		// this.datos = mensaje;
		//System.out.println("entro sensor " + datos.size());


	}

	public synchronized String obtenermensaje() {

		Enumeration<String> keys = datos.keys();
		StringBuffer buffer = new StringBuffer();

		while (keys.hasMoreElements()) {
			//String id = keys.nextElement();
			buffer.append(sacarDatos(datos));
			buffer.append("-------------------------");
		}

		return buffer.toString();

	}

	private String sacarDatos(Hashtable<String, String> tablasensor) {

		StringBuffer buffer = new StringBuffer();
		Enumeration<String> enumaration = tablasensor.elements();
		Enumeration<String> enumarationKeys = tablasensor.keys();

		while (enumaration.hasMoreElements()) {
			buffer.append("" + enumarationKeys.nextElement() + "-" + enumaration.nextElement() + "\n");

		}

		return buffer.toString();
	}

}
