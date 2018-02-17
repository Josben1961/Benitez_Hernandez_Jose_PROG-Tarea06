package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos;

public interface IVistaAlquilerVehiculos {

	void setControlador(IControladorAlquilerVehiculos controlador);

	void comenzar();

	void salir();

	void anadirCliente();

	void borrarCliente();

	void buscarCliente();

	void listarClientes();

	void anadirVehiculo();

	void borrarVehiculo();

	void buscarVehiculo();

	void listarVehiculos();

	void abrirAlquiler();

	void cerrarAlquiler();

	void listarAlquileres();

}