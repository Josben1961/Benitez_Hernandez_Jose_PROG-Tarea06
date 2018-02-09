package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.mvc.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;
import alquilerVehiculos.mvc.vista.IUTextual;

public class ControladorAlquilerVehiculos {

	private AlquilerVehiculos modelo;
	private IUTextual vista;

	public ControladorAlquilerVehiculos(IUTextual vista, AlquilerVehiculos modelo) {
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

	public void anadirTurismo(Turismo turismo) {
		modelo.anadirTurismo(turismo);
	}

	public void borrarTurismo(String matricula) {
		modelo.borrarTurismo(matricula);
	}

	public Turismo buscarTurismo(String matricula) {
		return modelo.buscarTurismo(matricula);
	}

	public Turismo[] obtenerTurismos() {
		return modelo.obtenerTurismos();
	}

	public void abrirAlquiler(Turismo turismo, Cliente cliente) {
		modelo.abrirAlquiler(turismo, cliente);
	}

	public void cerrarAlquiler(Turismo turismo, Cliente cliente) {
		modelo.cerrarAlquiler(turismo);
	}

	public Alquiler[] obtenerAlquileres() {
		return modelo.obtenerAlquileres();
	}

	public void anadirDatosPrueba() {
		modelo.anadirDatosPrueba();
	}

}
