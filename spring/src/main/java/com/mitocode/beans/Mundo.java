package com.mitocode.beans;

import org.springframework.beans.factory.annotation.Value;

public class Mundo {
	
	//se le asigna valor para utilizar anotaciones
	@Value("Hola Mundo!")
	private String saludo;
	
	//Al colocar la variable saludo en beans.xml y la ruta de la clase se puede ingresar sus valor por defecto,
	// spring busca esta variable por dentro de la clase, por medio del metodo set y lo devuelve atraves del metodo get
	public String getSaludo(){
		
		return saludo;
	}
	
	public void setSaludo(String saludo){
		
		this.saludo=saludo;
		
	}

}
