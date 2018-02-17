package alquilerVehiculos.mvc.vista.utilidades;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Turismo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.vista.Opcion;

public class Consola {

	public static void mostrarMenu() {
		mostrarCabecera("Alquiler de Vehículos");
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
	}

	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		System.out.println(String.format("%0" + mensaje.length() + "d%n", 0).replace("0", "-"));
	}

	public static int elegirOpcion() {
		int ordinalOpcion;
		do {
			System.out.print("\nElige una opción: ");
			ordinalOpcion = Entrada.entero();
		} while (!Opcion.esOrdinalValido(ordinalOpcion));
		return ordinalOpcion;
	}

	public static Cliente leerCliente() {
		Cliente cliente = null;
		System.out.print("Nombre: ");
		String nombre = Entrada.cadena();
		System.out.print("DNI: ");
		String dni = Entrada.cadena();
		System.out.print("Calle: ");
		String calle = Entrada.cadena();
		System.out.print("Localidad: ");
		String localidad = Entrada.cadena();
		System.out.print("Código postal: ");
		String codigoPostal = Entrada.cadena();
		try {
			cliente = new Cliente(nombre, dni, new DireccionPostal(calle, localidad, codigoPostal));
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
		return cliente;
	}

	public static String leerDni() {
		System.out.print("Introduce el DNI del cliente: ");
		String dniBorrar = Entrada.cadena();
		return dniBorrar;
	}

	public static Vehiculo leerVehiculo() {
		Vehiculo nuevoVehiculo = null;
		System.out.print("Matrícula: ");
		String matricula = Entrada.cadena();
		System.out.print("Marca: ");
		String marca = Entrada.cadena();
		System.out.print("Modelo: ");
		String modelo = Entrada.cadena();
		System.out.print("Cilindrada: ");
		int cilindrada = Entrada.entero();
		System.out.print("Número de plazas: ");
		int numeroPlazas = Entrada.entero();
		System.out.print("Peso máximo autorizado: ");
		int pma = Entrada.entero();

		try {
			int ordinalTipoVehiculo = 0;
			nuevoVehiculo = TipoVehiculo.getTipoVehiculoSegunOrdinal(ordinalTipoVehiculo).getInstancia(matricula, marca, modelo,
					new DatosTecnicosVehiculo(cilindrada, numeroPlazas, pma));
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
		return nuevoVehiculo;
	}

	public static String leerMatricula() {
		System.out.print("Introduce la matrícula del vehículo: ");
		String matriculaBorrar = Entrada.cadena();
		return matriculaBorrar;
	}

	public static int elegirTipoVehiculo() {
		int ordinalTipoVehiculo;
		do {
			System.out.printf("Introduce el tipo de vehículo: (%s)", obtenerTiposVehiculo());
			ordinalTipoVehiculo = Entrada.entero();
		} while (!TipoVehiculo.esOrdinalValido(ordinalTipoVehiculo));
		return ordinalTipoVehiculo;
	}

	private static String obtenerTiposVehiculo() {
		StringBuilder tiposVehiculos = new StringBuilder("");
		for (TipoVehiculo tipoVehiculo : TipoVehiculo.values()) {
			tiposVehiculos.append(tipoVehiculo.ordinal()).append(".- ").append(tipoVehiculo).append(" ");
		}
		return tiposVehiculos.toString();
	}
	
}
