package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class Clientes {

	private final int MAX_CLIENTES = 100;
	private Cliente[] clientes;

	public Clientes() {
		clientes = new Cliente[MAX_CLIENTES];
	}

	public Cliente[] getClientes() {
		return clientes.clone();
	}

	public void anadirCliente(Cliente cliente) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(cliente);
		if (indiceNoSuperaTamano(indice))
			clientes[indice] = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Cliente cliente) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
			if (clientes[indice] == null)
				clienteEncontrado = true;
			else if (clientes[indice].getDni().equals(cliente.getDni()))
				throw new ExcepcionAlquilerVehiculos("El cliente ya existe");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < clientes.length;
	}

	public void borrarCliente(String dni) {
		int indice = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El cliente a borrar no existe");
		}
	}

	private int buscarIndiceCliente(String dni) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
			if (clientes[indice] != null && clientes[indice].getDni().equals(dni))
				clienteEncontrado = true;
			else
				indice++;
		}
		return indice;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
			clientes[i] = clientes[i + 1];
		}
	}

	public Cliente buscarCliente(String dni) {
		int posicion = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(posicion))
			return new Cliente(clientes[posicion]);
		else
			return null;
	}
}

