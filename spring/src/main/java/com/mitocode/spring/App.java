package com.mitocode.spring;
import com.mitocode.beans.AppConfig;
import com.mitocode.beans.AppConfig2;
import com.mitocode.beans.Mundo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
	 
	//hacemos referencia al archivo xml, se coloca la ruta porque esta en otro paquete, si estubiera en el mismo no se escribe.
	 ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
    
	//hacemos referencia al AppConfig en ves del xml, y la unica diferencia es que la clase Mundo, se le asigna inicialmente con @Value el valor inicial
	  ApplicationContext appContextAnotacion = new AnnotationConfigApplicationContext(AppConfig.class,AppConfig2.class);
	 
	 // otra forma de registrar los AppConfig
	 //AnnotationConfigApplicationContext appContextAnotacion = new AnnotationConfigApplicationContext();
	 //appContextAnotacion.register(AppConfig.class);
	 //appContextAnotacion.register(AppConfig2.class);
	 //appContextAnotacion.refresh();
	
	 
	 
	 // se hace un casteo y se llama al atributo mundo
	 Mundo normal = (Mundo)appContext.getBean("mundo");
	 
	 Mundo m = (Mundo)appContextAnotacion.getBean("mundo"); //tambien se puede escribir Mundo m = (Mundo)appContext.getBean(Mundo.class);
	 Mundo n = (Mundo)appContextAnotacion.getBean("marte"); // para utilizar otra variable de una clase Appconfig2
	 System.out.println("Con valor asignado por xml "+normal.getSaludo()+ " Con Anotacion 1 "+m.getSaludo()+" Con Anotacion 2 "+n.getSaludo());
	 ((ConfigurableApplicationContext)appContext).close();
	}

}
