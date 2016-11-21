package com.org.ClienteAdministradorPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.org.ClienteAdministradorPS.entidades.Publicador;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		boolean pasoApaso = true;
				
		Procedimientos.IniciarPubicadordeltema1();	
		if(pasoApaso)mostrarMensaje("Se agrego publicador");			
		
		Procedimientos.IniciarSuscriptordeltema1();	
		if(pasoApaso)mostrarMensaje("Se agrego suscriptor");
		
		String mensaje1 = "Hola  (sin escucha)";
		
		Procedimientos.EnviarMensajeDelPubicadordeltema1(mensaje1);
		if(pasoApaso)mostrarMensaje("Se envio mensaje["+mensaje1+"] del productor 1");
		
		final String mensaje2 = "Hola  (escuchando)";
		
		Procedimientos.AgregarEscuchaAlSubscriptorDelTopicoDeInteres(new MessageListener() {
			
			@Override
			public void onMessage(Message arg0) {
				TextMessage textMessage = (TextMessage)arg0;
				try {
					System.out.println("Mensaje del escucha: "+textMessage.getText()+" y el mensaje esperado "+mensaje2);
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
					
		
		Procedimientos.EnviarMensajeDelPubicadordeltema1(mensaje2);
		if(pasoApaso)mostrarMensaje("Se envio mensaje["+mensaje2+"] del productor 1. Presiona alguna tecla para continuar");
		
		Procedimientos.TerminarPubicadordeltema1();
		Procedimientos.TerminarSuscriptordeltema1();
		if(pasoApaso)mostrarMensaje("La aplicacion termino");		
		
		
	}
	
	public static  void mostrarMensaje(String mensaje) throws IOException{		
		System.out.print("\n"+mensaje+". Presiona alguna tecla para continuar");
		new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

}
