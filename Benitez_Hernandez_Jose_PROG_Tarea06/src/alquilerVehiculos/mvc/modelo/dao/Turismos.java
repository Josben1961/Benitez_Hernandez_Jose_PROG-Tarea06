package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;

public class Turismos {
	private Turismo[] turismos;

	private final int MAX_TURISMOS = 20;

	public Turismos() {
		turismos = new Turismo[MAX_TURISMOS];
	}

	public Turismo[] getTurismos() {
		return turismos.clone();
	}

	public void anadirTurismo(Turismo turismo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(turismo);
		if (indiceNoSuperaTamano(indice))
			turismos[indice] = new Turismo(turismo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de turismos está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Turismo turismo) {
		int indice = 0;
		boolean turismoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
			if (turismos[indice] == null)
				turismoEncontrado = true;
			else if (turismos[indice].getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un vehículo con esa matrícula");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < turismos.length;
	}

	public void borrarTurismo(String matricula) {
		int indice = buscarIndiceTurismo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El vehículo a borrar no existe");
		}
	}

	private int buscarIndiceTurismo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (turismos[indice] != null && turismos[indice].getMatricula().equals(matricula))
				vehiculoEncontrado = true;
			else
				indice++;
		}
		return indice;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < turismos.length - 1 && turismos[i] != null; i++) {
			turismos[i] = turismos[i + 1];
		}
	}

	public Turismo buscarTurismo(String matricula) {
		int indice = buscarIndiceTurismo(matricula);
		if (indiceNoSuperaTamano(indice))
			return new Turismo(turismos[indice]);
		else
			return null;
	}
}
