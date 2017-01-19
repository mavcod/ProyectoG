package co.edu.uis.beans;

import java.util.Enumeration;
import java.util.Hashtable;

import co.edu.uis.interfaces.ArmarMensaje;


public class ArmarMensajeImpl implements ArmarMensaje {

	private Hashtable<String, Hashtable<String, String>> datos;

	public ArmarMensajeImpl() {
		datos = new Hashtable<String, Hashtable<String,String>>();
	}

	public synchronized void recibirDatos(String id, Hashtable<String, String> tablasensor) {
		datos.put(id, tablasensor);
	}
	
	public synchronized String obtenermensaje() {
		//System.out.println("entro1");
		Enumeration<String> keys = datos.keys();
		
		StringBuffer buffer = new StringBuffer();

		while (keys.hasMoreElements()) {
			String id = keys.nextElement();
			buffer.append(sacarDatos(id, datos.get(id)));
			buffer.append("-------------------------");			
		}
				
		
		
		return buffer.toString();

	}

	public synchronized Hashtable<String, Hashtable<String, String>> getDatos() {
		return datos;
	}

	public synchronized void setDatos(Hashtable<String, Hashtable<String, String>> datos) {
		this.datos = datos;
	}

	private String sacarDatos(String id, Hashtable<String, String> tablasensor) {

		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("===========" + id + "============");
		
		Enumeration<String> enumaration = tablasensor.elements();
		Enumeration<String> enumarationKeys = tablasensor.keys();

		
		while (enumaration.hasMoreElements()) {
			buffer.append("" + enumarationKeys.nextElement() + "-" + enumaration.nextElement() + "\n");
			
		}
		
		return buffer.toString();
	}
	


}
