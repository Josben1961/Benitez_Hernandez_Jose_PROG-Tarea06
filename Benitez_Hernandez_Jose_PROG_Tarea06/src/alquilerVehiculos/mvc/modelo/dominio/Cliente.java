package mvo.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private String nombre;
	private String dni;
	private String direccion;
	private String localidad;
	private String codigoPostal;
	private int identificador;
	private static int numClientes=0;

	// Constructor con los 5 par�metros
	public Cliente(String nombre, String dni, String direccion, String localidad, String codigoPostal) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		numClientes++;
		identificador = numClientes;
		// Validaci�n DNI
		if (compruebaDni(dni)) {
			this.dni = dni;
		} else {
			throw new ExcepcionAlquilerVehiculos("El formato del DNI es erroneo");
		}

		// Validaci�n c�digo postal
		if (compruebaCodigoPostal(codigoPostal)) {
			this.codigoPostal = codigoPostal;
		} else {
			throw new ExcepcionAlquilerVehiculos("El formato del C�digo Postal es erroneo");
		}
	}

	// Constructor copia de la clase Cliente
	public Cliente(Cliente cliente) {
		this.nombre = cliente.getNombre();
		this.dni = cliente.getDni();
		this.direccion = cliente.getDireccion();
		this.localidad = cliente.getLocalidad();
		this.codigoPostal = cliente.getCodigoPostal();

	}

	// M�todos getter de los atributos
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public int getIdentificador() {
		return identificador;
	}

	// M�todo para comprobar el c�digo postal introducido
	private boolean compruebaCodigoPostal(String codigoPostal) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}");
		Matcher emparejador;

		emparejador = patron.matcher(codigoPostal);
		return emparejador.matches();

	}

	// M�todo para comprobar el DNI introducido
	private boolean compruebaDni(String dni) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher emparejador;

		emparejador = patron.matcher(dni);
		return emparejador.matches();

	}
	// M�todo toString que representa al cliente

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", codigoPostal=" + codigoPostal + ", identificador=" + identificador + ", numClientes=" + numClientes
				+ "]";
	}

}
