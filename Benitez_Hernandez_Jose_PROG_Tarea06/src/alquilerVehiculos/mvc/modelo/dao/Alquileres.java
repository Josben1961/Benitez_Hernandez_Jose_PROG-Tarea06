/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class Alquileres.
 */
public class Alquileres {

	/** The alquileres. */
	private Alquiler[] alquileres;

	/** The max alquileres. */
	private final int MAX_ALQUILERES = 100;

	/**
	 * Instantiates a new alquileres.
	 */
	public Alquileres() {
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	/**
	 * Gets the alquileres.
	 *
	 * @return the alquileres
	 */
	public Alquiler[] getAlquileres() {
		return alquileres.clone();
	}

	/**
	 * Abrir alquiler.
	 *
	 * @param cliente
	 *            the cliente
	 * @param vehiculo
	 *            the vehiculo
	 */
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(vehiculo);
		if (indiceNoSuperaTamano(indice))
			alquileres[indice] = new Alquiler(cliente, vehiculo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de alquileres está lleno.");
	}

	/**
	 * Buscar primer indice libre comprobando existencia otro abierto.
	 *
	 * @param vehiculo
	 *            the vehiculo
	 * @return the int
	 */
	private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Vehiculo vehiculo) {
		int indice = 0;
		boolean encontrado = false;
		while (indiceNoSuperaTamano(indice) && !encontrado) {
			if (alquileres[indice] == null)
				encontrado = true;
			else if (alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
					&& !alquileres[indice].getVehiculo().getDisponible())
				throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para este vehículo");
			else
				indice++;
		}
		return indice;
	}

	/**
	 * Indice no supera tamaño.
	 *
	 * @param indice
	 *            the indice
	 * @return true, if successful
	 */
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < alquileres.length;
	}

	/**
	 * Cerrar alquiler.
	 *
	 * @param cliente
	 *            the cliente
	 * @param vehiculo
	 *            the vehiculo
	 */
	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		int indice = buscarAlquilerAbierto(cliente, vehiculo);
		if (indiceNoSuperaTamano(indice)) {
			alquileres[indice].cerrar();
			vehiculo.setDisponible(true);
		} else {
			throw new ExcepcionAlquilerVehiculos("No hay ningún alquiler abierto para ese vehículo");
		}
	}

	/**
	 * Buscar alquiler abierto.
	 *
	 * @param cliente
	 *            the cliente
	 * @param vehiculo
	 *            the vehiculo
	 * @return the int
	 */
	private int buscarAlquilerAbierto(Cliente cliente, Vehiculo vehiculo) {
		int indice = 0;
		boolean alquilerEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !alquilerEncontrado) {
			if (alquileres[indice] != null
					&& alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
					&& alquileres[indice].getDias() == 0)
				alquilerEncontrado = true;
			else
				indice++;
		}
		return indice;
	}

}
