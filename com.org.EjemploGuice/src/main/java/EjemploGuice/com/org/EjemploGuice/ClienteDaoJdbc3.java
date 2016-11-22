package EjemploGuice.com.org.EjemploGuice;

public class ClienteDaoJdbc3 implements IClienteDao {

	private String nombre;
	private String mensaje;
	
	public ClienteDaoJdbc3(String nombre,String mensaje ) {
		this.nombre=nombre;
		this.mensaje=mensaje;
	}
	
	public void leerClienteDao(String id) {

		System.out.println("Datos de cliente3: " + id+" suministrados por el proveedor "+nombre+" con el mensaje "+mensaje);

	}

}
