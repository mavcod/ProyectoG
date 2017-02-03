package co.edu.uis.interfaces;

import java.util.Hashtable;

public interface SensorI {

	void armarmensajeSensor();

	Hashtable<String, String> generarMedicionEnConsola(String id);

	void start();

}