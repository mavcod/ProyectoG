package co.edu.uis.interfaces;

import java.util.Hashtable;

public interface ArmarMensaje {
	
	public void recibirDatos(String id, Hashtable<String, String> tablasensor);
	
	public String obtenermensaje();


	

}
