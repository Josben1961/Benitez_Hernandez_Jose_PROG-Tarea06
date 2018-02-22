package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Vehiculos {

	private Vehiculo[] vehiculos;
	private final int MAX_VEHICULOS = 100;

	public Vehiculos() {
		vehiculos = new Vehiculo[MAX_VEHICULOS];
	}

	public Vehiculo[] getVehiculos() {
		return vehiculos.clone();
	}

	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
		if (indiceNoSuperaTamano(indice)) {
			vehiculos[indice] = tipoVehiculo.getInstancia(vehiculo.getMatricula(), vehiculo.getMarca(), 
					vehiculo.getModelo(), vehiculo.getDatosTecnicos());
			vehiculo.setDisponible(true);

		} else
			throw new ExcepcionAlquilerVehiculos("El array de veh�culos est� lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (vehiculos[indice] == null)
				vehiculoEncontrado = true;
			else if (vehiculos[indice].getMatricula().equals(vehiculo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un veh�culo con esa matr�cula");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < vehiculos.length;
	}

	public void borrarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El veh�culo a borrar no existe");
		}
	}

	private int buscarIndiceVehiculo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (vehiculos[indice] != null && vehiculos[indice].getMatricula().equals(matricula))
				vehiculoEncontrado = true;
			else
				indice++;
		}
		return vehiculoEncontrado ? indice : vehiculos.length;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < vehiculos.length - 1 && vehiculos[i] != null; i++) {
			vehiculos[i] = vehiculos[i + 1];
		}
	}

	public Vehiculo buscarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		Vehiculo vehiculo = null;
		if (indiceNoSuperaTamano(indice)) {
			return vehiculos[indice];

		} else
			return null;
	}
}
