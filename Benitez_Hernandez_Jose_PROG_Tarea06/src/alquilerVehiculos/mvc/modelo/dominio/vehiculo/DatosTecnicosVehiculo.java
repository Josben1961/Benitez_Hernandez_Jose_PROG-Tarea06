package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class DatosTecnicosVehiculo {
	private int cilindrada;
	private int numeroPlazas;
	private int pma;
	
	public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {
		cilindrada= datosTecnicos.getCilindrada();
		numeroPlazas=datosTecnicos.getNumeroPlazas();
		pma= datosTecnicos.getPma();
	}
	
	public DatosTecnicosVehiculo(int cilindrada, int numeroPlazas, int pma) {
		
		setCilindrada(cilindrada);
		setNumeroPlazas(numeroPlazas);
		setPma(pma);				
	}

	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada > 0)
			this.cilindrada = cilindrada;
		else
			throw new ExcepcionAlquilerVehiculos("Cilindrada no válida");
	}

	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	public void setNumeroPlazas(int numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	public int getPma() {
		return pma;
	}

	public void setPma(int pma) {
		this.pma = pma;
	}

	@Override
	public String toString() {
		return " [Cilindrada = " + getCilindrada() + ", NumeroPlazas = " + getNumeroPlazas()
				+ ", Pma = " + getPma() + "]";
	}

	
	
	

}
