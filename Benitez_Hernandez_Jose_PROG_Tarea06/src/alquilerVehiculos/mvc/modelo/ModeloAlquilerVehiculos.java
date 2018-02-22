package alquilerVehiculos.mvc.modelo;

import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.dao.Vehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Autobus;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.DeCarga;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Turismo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class ModeloAlquilerVehiculos implements IModeloAlquilerVehiculos {
	private Clientes clientes;
	private Vehiculos vehiculos;
	private Alquileres alquileres;

	public ModeloAlquilerVehiculos() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
	}

	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}

	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}

	public Cliente buscarCliente(String dni) {
		return clientes.buscarCliente(dni);
	}

	public Cliente[] obtenerClientes() {
		return clientes.getClientes();
	}

	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		vehiculos.anadirVehiculo(vehiculo, tipoVehiculo);
	}

	public void borrarVehiculo(String matricula) {
		vehiculos.borrarVehiculo(matricula);
	}

	public Vehiculo buscarVehiculo(String matricula) {
		return vehiculos.buscarVehiculo(matricula);
	}

	public Vehiculo[] obtenerVehiculos() {
		return vehiculos.getVehiculos();
	}

	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		alquileres.abrirAlquiler(cliente, vehiculo);
	}

	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {

		alquileres.cerrarAlquiler(cliente, vehiculo);
	}

	public Alquiler[] obtenerAlquileres() {
		return alquileres.getAlquileres();
	}

	public void anadirDatosPrueba() {
		Cliente cliente1 = new Cliente("Antonio", "11111111A", new DireccionPostal("Mota", "Almería", "04001"));
		Cliente cliente2 = new Cliente("Luis", "22222222B", new DireccionPostal("Tinaja", "Almería", "04002"));
		Cliente cliente3 = new Cliente("José", "12345678C", new DireccionPostal("Pasaje", "Granada", "28345"));
		anadirCliente(cliente1);
		anadirCliente(cliente2);
		anadirCliente(cliente3);
		Vehiculo vehiculo1 = new Turismo("1234BBB", "Renault", "Clio", new DatosTecnicosVehiculo (1600, 5, 1000));
		Vehiculo vehiculo2 = new Turismo("2345BBB", "Citröen", "C4", new DatosTecnicosVehiculo (1500, 5, 800));
		Vehiculo vehiculo3 = new DeCarga("3456BBB", "Man", "3700", new DatosTecnicosVehiculo (2500, 5, 3000));
		Vehiculo vehiculo4 = new Autobus("4567BBB", "Volvo", "8100", new DatosTecnicosVehiculo (2900, 60, 2000));
		anadirVehiculo(vehiculo1, TipoVehiculo.TURISMO);
		anadirVehiculo(vehiculo2, TipoVehiculo.TURISMO);
		anadirVehiculo(vehiculo3, TipoVehiculo.DE_CARGA);
		anadirVehiculo(vehiculo4, TipoVehiculo.AUTOBUS);
		abrirAlquiler(cliente1, vehiculo1);
		vehiculo1.setDisponible(false);
		abrirAlquiler(cliente2, vehiculo2);
		vehiculo2.setDisponible(false);
		abrirAlquiler(cliente3, vehiculo3);
		vehiculo3.setDisponible(false);
		cerrarAlquiler(cliente1, vehiculo1);
		vehiculo1.setDisponible(true);
		cerrarAlquiler(cliente2, vehiculo2);
		vehiculo2.setDisponible(true);
		cerrarAlquiler(cliente3, vehiculo3);
		vehiculo3.setDisponible(true);
	}
	
}
