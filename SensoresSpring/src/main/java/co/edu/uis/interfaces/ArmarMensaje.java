package co.edu.uis.interfaces;

import java.util.Hashtable;

public interface ArmarMensaje {
	
	public void enviarDatos(String id, Hashtable<String, String> tablasensor);
	
	public String obtenermensaje();


	

}
