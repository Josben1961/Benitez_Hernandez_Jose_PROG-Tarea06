package alquilerVehiculos.mvc.modelo;

import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.dao.Vehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class AlquilerVehiculos {
	private Clientes clientes;
	private Vehiculos vehiculos;
	private Alquileres alquileres;

	public AlquilerVehiculos() {
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

	public void anadirVehiculo(Vehiculo vehiculo) {
		vehiculos.anadirVehiculos(vehiculo);
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

	public void abrirAlquiler(Vehiculo vehiculo, Cliente cliente) {
		comprobarExistenciaVehiculo(vehiculo);
		alquileres.abrirAlquiler(vehiculo, cliente);
	}

	private void comprobarExistenciaVehiculo(Vehiculo vehiculo) {
		if (vehiculos.buscarVehiculo(vehiculo.getMatricula()) == null)
			throw new ExcepcionAlquilerVehiculos("El vehículo no existe");
	}

	public void cerrarAlquiler(Vehiculo vehiculo) {
		comprobarExistenciaVehiculo(vehiculo);
		alquileres.cerrarAlquiler(vehiculo);
	}

	public Alquiler[] obtenerAlquileres() {
		return alquileres.getAlquileres();
	}

	public void anadirDatosPrueba() {
		Cliente cliente1 = new Cliente("aa", "11111111A", new DireccionPostal("aa", "Almería", "04001"));
		Cliente cliente2 = new Cliente("bb", "22222222B", new DireccionPostal("bb", "Almería", "04002"));
		anadirCliente(cliente1);
		anadirCliente(cliente2);
		Vehiculo vehiculo1 = new Vehiculo("1234BBB", "Renault", "Clio", 1900);
		Vehiculo vehiculo2 = new Vehiculo("2345BBB", "Citröen", "C4", 1600);
		anadirVehiculo(vehiculo1);
		anadirVehiculo(vehiculo2);
		abrirAlquiler(vehiculo1, cliente1);
		abrirAlquiler(vehiculo2, cliente2);
		cerrarAlquiler(vehiculo1);
	}

}
