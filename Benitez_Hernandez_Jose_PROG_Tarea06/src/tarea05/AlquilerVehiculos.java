package tarea05;

public class AlquilerVehiculos {
	private final int MAX_TURISMOS = 100;
	private final int MAX_CLIENTES = 100;
	private final int MAX_ALQUILERES = 100;

	private Turismo[] turismos;
	private Cliente[] clientes;
	private Alquiler[] alquileres;

	// Constructor por defecto
	public AlquilerVehiculos() {
		turismos = new Turismo[MAX_TURISMOS];
		clientes = new Cliente[MAX_CLIENTES];
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	// M�todos getters
	public Turismo[] getTurismos() {
		return turismos;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public Alquiler[] getAlquileres() {
		return alquileres;
	}

	// M�todo get de Cliente con un par�metro (dni) para saber si existe este
	// cliente.
	public Cliente getCliente(String dni) {
		int posicion = 0;
		boolean encontrado = false;
		while (posicion < clientes.length && !encontrado) {
			if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni))
				encontrado = true;
			else
				posicion++;
		}
		if (encontrado)
			return clientes[posicion];
		else
			return null;
	}

	// M�todo para agregar clientes
	public void addCliente(Cliente cliente) {
		int posicion = 0;
		boolean posicionEncontrada = false;
		while (posicion < clientes.length && !posicionEncontrada) {
			if (clientes[posicion] == null)
				posicionEncontrada = true;
			else if (clientes[posicion].getDni().equals(cliente.getDni()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI");
			else
				posicion++;
		}
		if (posicionEncontrada)
			clientes[posicion] = cliente;
		else
			throw new ExcepcionAlquilerVehiculos("El array de clientes est� lleno.");
	}

	// M�todo para borrar un cliente (Si existe).
	public void delCliente(String dni) {
		int posicion = 0;
		boolean encontrado = false;
		while (posicion < clientes.length && !encontrado) {
			if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni))
				encontrado = true;
			else
				posicion++;
		}
		if (encontrado) {
			for (int i = posicion; i < clientes.length - 1; i++) {
				clientes[i] = clientes[i + 1];
			}
			clientes[clientes.length - 1] = null;
		} else {
			throw new ExcepcionAlquilerVehiculos("El cliente a borrar no existe");
		}
	}

	// M�todo get de Turismo con un par�metro (matricula) para saber si existe este
	// Turismo.
	public Turismo getTurismo(String matricula) {
		int posicion = 0;
		boolean encontrado = false;
		while (posicion < turismos.length && !encontrado) {
			if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula))
				encontrado = true;
			else
				posicion++;
		}
		if (encontrado)
			return turismos[posicion];
		else
			return null;

	}

	// M�todo para agregar turismos si se puede.
	public void addTurismo(Turismo turismo) {
		int posicion = 0;
		boolean posicionEncontrada = false;
		while (posicion < turismos.length && !posicionEncontrada) {
			if (turismos[posicion] == null)
				posicionEncontrada = true;
			else if (turismos[posicion].getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un veh�culo con esa matr�cula");
			else
				posicion++;
			turismo.setDisponible(true);
		}
		if (posicionEncontrada)
			turismos[posicion] = turismo;
		else
			throw new ExcepcionAlquilerVehiculos("El array de veh�culos est� lleno.");
	}

	// M�todo para borrar un turismo si este existe y sino, lanzar excepci�n.
	public void delTurismo(String matricula) {
		int posicion = 0;
		boolean encontrado = false;
		while (posicion < turismos.length && !encontrado) {
			if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula))
				encontrado = true;
			else
				posicion++;
		}
		if (encontrado) {
			for (int i = posicion; i < turismos.length - 1; i++) {
				turismos[i] = turismos[i + 1];
			}
			turismos[turismos.length - 1] = null;
		} else {
			throw new ExcepcionAlquilerVehiculos("El veh�culo a borrar no existe");
		}
	}

	// M�todo para crear un nuevo alquiler si el turismo est� disponible.
	public void openAlquiler(Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean posicionEncontrada = false;
		while (posicion < alquileres.length && !posicionEncontrada) {
			if (alquileres[posicion] == null)
				posicionEncontrada = true;
			else if (alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para este veh�culo");
			else
				posicion++;
			turismo.setDisponible(false);
		}
		if (posicionEncontrada)
			alquileres[posicion] = new Alquiler(cliente, turismo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de trabajos est� lleno.");
	}

	// M�todo para cerrar un alquiler
	public void closeAlquiler(Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean encontrado = false;
		while (posicion < alquileres.length && !encontrado) {
			if (alquileres[posicion] != null
					&& alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula()))

				encontrado = true;
			else
				posicion++;

		}
		if (encontrado)
			alquileres[posicion].close();
		turismo.setDisponible(true);

		throw new ExcepcionAlquilerVehiculos("No hay ning�n alquiler abierto para ese veh�culo");
	}
}
