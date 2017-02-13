package co.edu.uis.implementacion;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

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
		this.datos = mensaje;
		


	}

	public synchronized String obtenermensaje() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(sacarDatos(datos));
		buffer.append("-------------------------");			

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
