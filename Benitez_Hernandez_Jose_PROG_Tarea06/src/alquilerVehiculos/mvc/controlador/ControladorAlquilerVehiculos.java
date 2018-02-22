package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;

public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculos {

	private IModeloAlquilerVehiculos modelo;
	private IVistaAlquilerVehiculos vista;

	public ControladorAlquilerVehiculos(IVistaAlquilerVehiculos vista, IModeloAlquilerVehiculos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		vista.setControlador(this);
	}

	public void comenzar() {
		modelo.anadirDatosPrueba();
		vista.comenzar();
	}

	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}

	public void borrarCliente(String dni) {
		modelo.borrarCliente(dni);
	}

	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}

	public Cliente[] obtenerClientes() {
		return modelo.obtenerClientes();
	}

	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		modelo.anadirVehiculo(vehiculo, tipoVehiculo);
	}

	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}

	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}

	public Vehiculo[] obtenerVehiculos() {
		return modelo.obtenerVehiculos();
	}

	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.abrirAlquiler(cliente, vehiculo);
	}

	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.cerrarAlquiler(cliente, vehiculo);

	}

	public Alquiler[] obtenerAlquileres() {
		return modelo.obtenerAlquileres();
	}

	public void anadirDatosPrueba() {

	}

}
