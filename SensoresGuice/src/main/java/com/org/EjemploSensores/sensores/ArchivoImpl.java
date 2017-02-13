package com.org.EjemploSensores.sensores;

import java.io.*;

import co.edu.uis.interfaces.Archivo;

public class ArchivoImpl implements Archivo {
	
	
	public static  void LeeryEscribir (String texto)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/nuevo.txt");
            pw = new PrintWriter(fichero);
            pw.println(texto); 
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
    
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}