package clases;

public class LectorDatosClientes {

	private IClienteDao clientesDao;

	public void setClientesDao(IClienteDao clientesDao) {
		this.clientesDao = clientesDao;
	}

	public void escribirDatosCliente(String id) {
		clientesDao.leerClienteDao(id);
	}

}
