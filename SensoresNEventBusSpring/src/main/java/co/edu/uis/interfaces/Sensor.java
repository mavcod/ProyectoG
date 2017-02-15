package co.edu.uis.interfaces;

import java.util.Hashtable;

public interface Sensor {

	
	Hashtable<String, String> generarMedicionEnConsola(String id);

	void start();

}