package alquilerVehiculos.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private String nombre;
	private String dni;
	private DireccionPostal direccionPostal;
	private int identificador;
	private static int ultimoIdentificador = 0;
	private static int numClientes=0;
	
	// Constructor con los 5 parámetros
	public Cliente(String nombre, String dni, DireccionPostal direccionPostal) {
		setNombre(nombre);
		setDni(dni);
		setDireccionPostal(direccionPostal);
		asignarNuevoIdentificador();
		numClientes++;
		identificador = numClientes;
				
	}
	
	private void setNombre(String nombre) {
		if (nombre != null && !nombre.equals(""))
			this.nombre = nombre;
		else 
			throw new ExcepcionAlquilerVehiculos("Nombre no válido");
	}
	
	private void setDni(String dni) {
		if (compruebaDni(dni))
			this.dni = dni;
		else
			throw new ExcepcionAlquilerVehiculos("DNI no válido");
	}
	
	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = new DireccionPostal(direccionPostal);
	}
	
	// Constructor copia de la clase Cliente
	public Cliente(Cliente cliente) {
		nombre = cliente.getNombre();
		dni = cliente.getDni();
		direccionPostal = cliente.getDireccionPostal();
		identificador = cliente.getIdentificador();

	}
	
	private void asignarNuevoIdentificador() {
		ultimoIdentificador++;
		identificador = ultimoIdentificador;
	}

	// Métodos getter de los atributos
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public DireccionPostal getDireccionPostal() {
		return new DireccionPostal(direccionPostal);
	}

	public int getIdentificador() {
		return identificador;
	}

	// Método para comprobar el DNI introducido
	private boolean compruebaDni(String dni) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher emparejador;

		emparejador = patron.matcher(dni);
		return emparejador.matches();

	}
	// Método toString que representa al cliente

	@Override
	public String toString() {
		return String.format("Identificador: %d Nombre: %s DNI: %s %s %n", 
				identificador, nombre, dni, direccionPostal);
	}

}
