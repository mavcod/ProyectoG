package com.org.ClienteAdministradorPS;

import javax.jms.JMSException;
import javax.jms.MessageListener;

import info.source4code.jms.activemq.pubsub.Publisher;
import info.source4code.jms.activemq.pubsub.Subscriber;

public class Procedimientos {

	public static Publisher publicador = new Publisher();

	static final String ID_PUBLICADOR = "cliente1publicador";
	static final String TOPICO = "topico1";

	public static void IniciarPubicadordeltema1() {

		try {
			publicador.create(ID_PUBLICADOR, TOPICO);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TerminarPubicadordeltema1() {
		try {
			publicador.closeConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void EnviarMensajeDelPubicadordeltema1(String mensaje) {
		try {
			publicador.Enviarmensaje(mensaje);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Subscriber subcribe = new Subscriber();
	static final String ID_SUSCRIPTOR = "cliente1suscriptor";
	
	public static void IniciarSuscriptordeltema1() {

		try {
			subcribe.create(ID_SUSCRIPTOR, TOPICO);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void AgregarEscuchaAlSubscriptorDelTopicoDeInteres(MessageListener messageListener) {
		try {
			subcribe.escucharMensajes(messageListener);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void TerminarSuscriptordeltema1() {
		try {
			subcribe.closeConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
