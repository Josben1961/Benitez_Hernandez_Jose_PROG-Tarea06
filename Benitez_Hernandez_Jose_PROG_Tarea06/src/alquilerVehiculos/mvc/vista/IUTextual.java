package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.vista.utilidades.Consola;

public class IUTextual {

	ControladorAlquilerVehiculos controlador;

	public IUTextual() {
		Opcion.setVista(this);
	}

	public void setControlador(ControladorAlquilerVehiculos controlador) {
		this.controlador = controlador;
	}

	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOridnal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	public void salir() {
		System.out.println("Ha elegido salir de la aplicación");
	}

	public void anadirCliente() {
		Consola.mostrarCabecera("Añadir cliente");
		Cliente cliente = Consola.leerCliente();
		try {
			controlador.anadirCliente(cliente);
			System.out.println("Cliente añadido satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		String dni = Consola.leerDni();
		try {
			controlador.borrarCliente(dni);
			System.out.println("Cliente borrado satisfactoriamente\n");
		} catch (Exception e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		String dni = Consola.leerDni();
		Cliente cliente = controlador.buscarCliente(dni);
		String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	public void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		for (Cliente cliente : controlador.obtenerClientes()) {
			if (cliente != null)
				System.out.println(cliente);
		}
		System.out.println("");
	}

	public void anadirVehiculo() {
		Consola.mostrarCabecera("Añadir vehículo");
		String dni = Consola.leerDni();
		Cliente propietario = controlador.buscarCliente(dni);
		Vehiculo turismo = Consola.leerVehiculo(propietario);
		try {
			controlador.anadirTurismo(turismo);
			System.out.println("Vehículo añadido satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	public void borrarVehiculo() {
		Consola.mostrarCabecera("Borrar vehículo");
		String matricula = Consola.leerMatricula();
		try {
			controlador.borrarTurismo(matricula);
			System.out.println("Turismo borrado satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	public void buscarVehiculo() {
		Consola.mostrarCabecera("Buscar vehículo");
		String matricula = Consola.leerMatricula();
		Vehiculo turismoBuscado = controlador.buscarTurismo(matricula);
		String mensaje = (turismoBuscado != null) ? turismoBuscado.toString() : "El vehículo no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	public void listarVehiculos() {
		Consola.mostrarCabecera("Listar vehículos");
		for (Vehiculo turismo : controlador.obtenerTurismos()) {
			if (turismo != null)
				System.out.println(turismo);
		}
		System.out.println("");
	}

	public void abrirAlquiler() {
		Consola.mostrarCabecera("Abrir trabajo");
		String matricula = Consola.leerMatricula();
		String dni = Consola.leerDni();
		Vehiculo turismo = controlador.buscarTurismo(matricula);
		Cliente cliente = controlador.buscarCliente(dni);
		if (turismo == null)
			System.out.println("ERROR: No existe un turismo con esa matrícula\n");
		else {
			try {
				controlador.abrirAlquiler(turismo, cliente);
				System.out.println("Trabajo abierto satisfactoriamente\n");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

	public void cerrarAlquiler() {
		Consola.mostrarCabecera("Cerrar trabajo");
		String matricula = Consola.leerMatricula();
		Vehiculo turismo = controlador.buscarTurismo(matricula);
		String dni = Consola.leerDni();
		Cliente cliente = controlador.buscarCliente(dni);
		if (turismo == null)
			System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
		else {
			try {
				controlador.cerrarAlquiler(turismo, cliente);
				System.out.println("Trabajo cerrado satisfactoriamente\n");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

	public void listarAlquileres() {
		Consola.mostrarCabecera("Listar Alquileres");
		for (Alquiler alquiler : controlador.obtenerAlquileres()) {
			if (alquiler != null)
				System.out.println(alquiler);
		}
		System.out.println("");
	}
}
