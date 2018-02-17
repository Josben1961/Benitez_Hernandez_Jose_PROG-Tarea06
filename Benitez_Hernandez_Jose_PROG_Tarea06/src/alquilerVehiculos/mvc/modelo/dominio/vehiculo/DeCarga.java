package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class DeCarga extends Vehiculo {

	private double factorDeCarga = 0.0;

	public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	public DeCarga(Turismo deCarga) {
		super(deCarga);
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		// TODO Apéndice de método generado automáticamente
		return TipoVehiculo.DE_CARGA;
	}

	@Override
	public double precioEspecifico() {
		factorDeCarga= datosTecnicos.getPma()/20+1*datosTecnicos.getNumeroPlazas();
		return factorDeCarga;
	}
}
