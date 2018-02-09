package alquilerVehiculos.mvc.vista.utilidades;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
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

	public static Vehiculo leerVehiculo(Cliente propietario) {
		Vehiculo nuevoVehiculo = null;
		System.out.print("Matrícula: ");
		String matricula = Entrada.cadena();
		System.out.print("Marca: ");
		String marca = Entrada.cadena();
		System.out.print("Modelo: ");
		String modelo = Entrada.cadena();
		System.out.print("Cilindrada: ");
		int cilindrada = Entrada.entero();
		try {
			nuevoVehiculo = new Vehiculo(matricula, marca, modelo, cilindrada);
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

}
