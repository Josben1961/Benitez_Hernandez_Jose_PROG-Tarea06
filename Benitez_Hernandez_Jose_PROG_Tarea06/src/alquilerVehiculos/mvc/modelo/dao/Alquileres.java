package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Alquileres {

	private Alquiler[] alquileres;

	private final int MAX_ALQUILERES = 100;

	public Alquileres() {
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	public Alquiler[] getAlquileres() {
		return alquileres.clone();
	}

	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(vehiculo);
		if (indiceNoSuperaTamano(indice))
			alquileres[indice] = new Alquiler(cliente, vehiculo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de alquileres está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Vehiculo vehiculo) {
		int indice = 0;
		boolean trabajoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !trabajoEncontrado) {
			if (alquileres[indice] == null)
				trabajoEncontrado = true;
			else if (alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
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

	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		int indice = buscarAlquilerAbierto(cliente, vehiculo);
		if (indiceNoSuperaTamano(indice))
			alquileres[indice].cerrar();
		else
			throw new ExcepcionAlquilerVehiculos("No hay ningún alquiler abierto para ese vehículo");
	}

	private int buscarAlquilerAbierto(Cliente cliente, Vehiculo vehiculo) {
		int indice = 0;
		boolean trabajoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !trabajoEncontrado) {
			if (alquileres[indice] != null
					&& alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
					&& !alquileres[indice].getVehiculo().getDisponible())
				trabajoEncontrado = true;
			else
				indice++;
		}
		return indice;
	}
	

}
