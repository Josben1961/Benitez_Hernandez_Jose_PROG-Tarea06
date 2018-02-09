package aplicacion;

import tarea05.Alquiler;
import tarea05.AlquilerVehiculos;
import tarea05.Cliente;
import tarea05.ExcepcionAlquilerVehiculos;
import tarea05.Turismo;
import utilidades.Entrada;

public class Principal {

	public static void main(String[] args) {

		AlquilerVehiculos miAlquiler = new AlquilerVehiculos();
		Cliente cliente1 = new Cliente("aaaas", "11111111A", "cazalla", "Almería", "04000");
		Cliente cliente2 = new Cliente("bbbbs", "22222222B", "cabo", "Almería", "04000");
		miAlquiler.addCliente(cliente1);
		miAlquiler.addCliente(cliente2);
		miAlquiler.delCliente("11111111A");
		Turismo turismo1 = new Turismo("1111BBB", "Seat", "Ibiza", 1900);
		Turismo turismo2 = new Turismo("2222BBB", "Opel", "Corsa", 1600);
		miAlquiler.addTurismo(turismo1);
		miAlquiler.addTurismo(turismo2);
		miAlquiler.openAlquiler(cliente1, turismo1);
		miAlquiler.openAlquiler(cliente2, turismo2);
		miAlquiler.closeAlquiler(cliente1, turismo1);
		miAlquiler.delTurismo("1111BBB");

		for (Cliente cliente : miAlquiler.getClientes())
			if (cliente != null)
				System.out.println(cliente);
		System.out.println("--------------");
		for (Turismo turismo : miAlquiler.getTurismos())
			if (turismo != null)
				System.out.println(turismo);
		System.out.println("--------------");
		for (Alquiler alquiler : miAlquiler.getAlquileres())
			if (alquiler != null)
				System.out.println(alquiler);

		int opcion;
		do {
			System.out.println("Alquiler de Vehículos");
			System.out.println("---------------");
			System.out.println("1.- Añadir cliente");
			System.out.println("2.- Borrar cliente");
			System.out.println("3.- Buscar cliente");
			System.out.println("4.- Listar clientes");
			System.out.println("5.- Añadir turismo");
			System.out.println("6.- Borrar turismo");
			System.out.println("7.- Buscar turismo");
			System.out.println("8.- Listar turismos");
			System.out.println("9.- Abrir alquiler");
			System.out.println("10.- Cerrar alquiler");
			System.out.println("11.- Listar alquileres");
			System.out.println("0.- Salir");

			do {
				System.out.print("\nElige una opción (0-11): ");
				opcion = Entrada.entero();
			} while (opcion < 0 || opcion > 11);
			switch (opcion) {
			case 1:
				Cliente nuevoCliente = null;
				do {
					System.out.println("\nAñadir cliente");
					System.out.println("--------------");
					System.out.print("Nombre: ");
					String nombre = Entrada.cadena();
					System.out.print("DNI: ");
					String dni = Entrada.cadena();
					System.out.print("Dirección: ");
					String direccion = Entrada.cadena();
					System.out.print("Localidad: ");
					String localidad = Entrada.cadena();
					System.out.print("Código postal: ");
					String codigoPostal = Entrada.cadena();
					try {
						nuevoCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
					} catch (ExcepcionAlquilerVehiculos e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
						System.out.println("Vuelve a introducir los datos de forma correcta");
					}
				} while (nuevoCliente == null);
				try {
					miAlquiler.addCliente(nuevoCliente);
				} catch (ExcepcionAlquilerVehiculos e) {
					System.out.printf("ERROR: %s%n%n", e.getMessage());
				}
				break;
			case 2:
				System.out.println("\nBorrar cliente");
				System.out.println("--------------");
				System.out.print("\nIntroduce el DNI del cliente a borrar: ");
				String dniBorrar = Entrada.cadena();
				try {
					miAlquiler.delCliente(dniBorrar);
					System.out.println("Cliente borrado satisfactoriamente\n");
				} catch (Exception e) {
					System.out.printf("ERROR: %s%n%n", e.getMessage());
				}
				break;
			case 3:
				System.out.println("\nBuscar cliente");
				System.out.println("--------------");
				System.out.print("\nIntroduce el DNI del cliente a buscar: ");
				String dniBuscar = Entrada.cadena();
				Cliente clienteBuscado = miAlquiler.getCliente(dniBuscar);
				System.out.print("\nResultado de la búsqueda: ");
				String mensaje = (clienteBuscado != null) ? clienteBuscado.toString() : "El cliente no existe";
				System.out.printf("%s%n%n", mensaje);
				break;
			case 4:
				System.out.println("\nListado de clientes");
				System.out.println("-------------------");
				for (Cliente cliente : miAlquiler.getClientes()) {
					if (cliente != null)
						System.out.println(cliente);
				}
				System.out.println("");
				break;
			case 5:
				Turismo nuevoTurismo = null;
				System.out.println("\nAñadir vehículo");
				System.out.println("---------------");
				System.out.print("Matrícula: ");
				String matricula = Entrada.cadena();
				System.out.print("Marca: ");
				String marca = Entrada.cadena();
				System.out.print("Modelo: ");
				String modelo = Entrada.cadena();
				System.out.print("Cilindrada: ");
				int cilindrada = Entrada.entero();
				try {
					nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
					miAlquiler.addTurismo(nuevoTurismo);
				} catch (ExcepcionAlquilerVehiculos e) {
					System.out.printf("ERROR: %s%n%n", e.getMessage());
				}
				break;
			case 6:
				System.out.println("\nBorrar vehículo");
				System.out.println("---------------");
				System.out.print("\nIntroduce la matrícula del vehículo a borrar: ");
				String matriculaBorrar = Entrada.cadena();
				try {
					miAlquiler.delTurismo(matriculaBorrar);
					System.out.println("Turismo borrado satisfactoriamente\n");
				} catch (ExcepcionAlquilerVehiculos e) {
					System.out.printf("ERROR: %s%n%n", e.getMessage());
				}
				break;
			case 7:
				System.out.println("\nBuscar vehículo");
				System.out.println("---------------");
				System.out.print("\nIntroduce la matrícula del vehículo a buscar: ");
				String matriculaBuscar = Entrada.cadena();
				Turismo turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
				System.out.print("\nResultado de la búsqueda: ");
				mensaje = (turismoBuscado != null) ? turismoBuscado.toString() : "El vehículo no existe";
				System.out.printf("%s%n%n", mensaje);
				break;
			case 8:
				System.out.println("\nListado de vehículos");
				System.out.println("--------------------");
				for (Turismo turismo : miAlquiler.getTurismos()) {
					if (turismo != null)
						System.out.println(turismo);
				}
				System.out.println("");
				break;
			case 9:
				System.out.println("\nAbrir alquiler");
				System.out.println("-------------");
				System.out.print("\nIntroduce la matrícula del vehículo: ");
				matriculaBuscar = Entrada.cadena();
				turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
				System.out.print("\nIntroduce el dni del cliente: ");
				dniBuscar = Entrada.cadena();
				clienteBuscado = miAlquiler.getCliente(dniBuscar);
				if (turismoBuscado == null || clienteBuscado == null)
					System.out.println("ERROR: No existe este alquiler");
				else {
					try {
						miAlquiler.openAlquiler(clienteBuscado, turismoBuscado);
						System.out.println("Alquiler abierto satisfactoriamente\n");
					} catch (ExcepcionAlquilerVehiculos e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
					}
				}
				break;
			case 10:
				System.out.println("\nCerrar alquiler");
				System.out.println("--------------");
				System.out.print("\nIntroduce la matrícula del vehículo: ");
				matriculaBuscar = Entrada.cadena();
				turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
				System.out.print("\nIntroduce el dni del cliente: ");
				dniBuscar = Entrada.cadena();
				clienteBuscado = miAlquiler.getCliente(dniBuscar);
				if (turismoBuscado == null || clienteBuscado == null)
					System.out.println("ERROR: No existe este alquiler");
				else {
					try {
						miAlquiler.closeAlquiler(clienteBuscado, turismoBuscado);
						System.out.println("Alquiler cerrado satisfactoriamente");
					} catch (ExcepcionAlquilerVehiculos e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
					}
				}
				break;

			case 11:
				System.out.println("\nListado de alquileres");
				System.out.println("---------------------");
				for (Alquiler alquiler : miAlquiler.getAlquileres()) {
					if (alquiler != null)
						System.out.println(alquiler);
				}
				System.out.println("");
				break;
			default:
				break;
			}
		} while (opcion != 0);
		System.out.println("Ha elegido salir de la Aplicación");
	}

}
