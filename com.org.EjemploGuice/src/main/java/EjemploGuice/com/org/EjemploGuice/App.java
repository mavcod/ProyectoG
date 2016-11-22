package EjemploGuice.com.org.EjemploGuice;

//import java.lang.reflect.Constructor;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String args[]) {
		
		Injector injector = Guice.createInjector(new JdbcInjectionModule());		
		LectorDatosClientes lectorClientes = injector.getInstance(LectorDatosClientes.class);
		lectorClientes.escribirDatosCliente("Hola 1");
		
		
		Injector injector2 = Guice.createInjector(new JdbcInjectionModule2());
		lectorClientes=injector2.getInstance(LectorDatosClientes.class);
		lectorClientes.escribirDatosCliente("Hola 2");
		
		Injector injector3 = Guice.createInjector(new ClienteProveedor("Manuel","ejemplo"));
		lectorClientes=injector3.getInstance(LectorDatosClientes.class);
		lectorClientes.escribirDatosCliente("Hola 3");
	}

	public static class JdbcInjectionModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(IClienteDao.class).to(ClienteDaoJdbc.class);
		}
	}
	
	

	public static class JdbcInjectionModule2 extends AbstractModule {

		@Override
		protected void configure() {		
			bind(IClienteDao.class).to(ClienteDaoJdbc.class);
			
			
		}
	}
	
	public static class ClienteProveedor extends AbstractModule {
		
		private String nombre;
		private String mensaje;

		public ClienteProveedor(String nombre,String mensaje ) {
			this.nombre=nombre;
			this.mensaje=mensaje;
		}
		
		@Override
		protected void configure() {			
			try {
				//Constructor<ClienteDaoJdbc3> cons = ClienteDaoJdbc3.class.getConstructor(String.class,String.class);												
				//bind(IClienteDao.class).toConstructor(cons);
				bind(IClienteDao.class).toInstance(new ClienteDaoJdbc3(nombre,mensaje));
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
	}
	
	public static void mainformanormal(String[] args) {
		
		LectorDatosClientes lector = new LectorDatosClientes();
		lector.setClientesDao(new ClienteDaoJdbc());
		lector.escribirDatosCliente("Hola");
	}
}
