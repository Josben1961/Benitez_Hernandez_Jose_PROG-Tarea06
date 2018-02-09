package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Alquileres {

	private Alquiler[] alquileres;

	private final int MAX_TRABAJOS = 20;

	public Alquileres() {
		alquileres = new Alquiler[MAX_TRABAJOS];
	}

	public Alquiler[] getAlquileres() {
		return alquileres.clone();
	}

	public void abrirAlquiler(Vehiculo vehículo, Cliente cliente) {
		int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(vehículo);
		if (indiceNoSuperaTamano(indice))
			alquileres[indice] = new Alquiler(cliente, vehículo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de alquileres está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Vehiculo vehículo) {
		int indice = 0;
		boolean trabajoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !trabajoEncontrado) {
			if (alquileres[indice] == null)
				trabajoEncontrado = true;
			else if (alquileres[indice].getVehiculo().getMatricula().equals(vehículo.getMatricula())
					&& !alquileres[indice].getVehiculo().getDisponible())
				throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para este vehículo");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < alquileres.length;
	}

	public void cerrarAlquiler(Vehiculo vehículo) {
		int indice = buscarAlquilerAbierto(vehículo);
		if (indiceNoSuperaTamano(indice))
			alquileres[indice].cerrar();
		else
			throw new ExcepcionAlquilerVehiculos("No hay ningún alquiler abierto para ese vehículo");
	}

	private int buscarAlquilerAbierto(Vehiculo vehículo) {
		int indice = 0;
		boolean trabajoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !trabajoEncontrado) {
			if (alquileres[indice] != null
					&& alquileres[indice].getVehiculo().getMatricula().equals(vehículo.getMatricula())
					&& !alquileres[indice].getVehiculo().getDisponible())
				trabajoEncontrado = true;
			else
				indice++;
		}
		return indice;
	}

}

