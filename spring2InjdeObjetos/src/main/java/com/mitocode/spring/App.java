package com.mitocode.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Persona;



public class App {

	public static void main(String[] args) {
	 
	//hacemos referencia al archivo xml, se coloca la ruta porque esta en otro paquete, si estubiera en el mismo no se escribe.
	 ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
    
	 
	 // se hace un casteo 
	 Persona per=(Persona)appContext.getBean("persona");
	 System.out.println(per.getId() +" "+per.getNombre()+" "+ per.getApodo()+" "+per.getPais().getNombre()+ " "+per.getPais().getCiudad().getNombre());
			
	 ((ConfigurableApplicationContext)appContext).close();
	}

}
