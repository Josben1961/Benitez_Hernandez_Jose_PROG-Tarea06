package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class DeCarga extends Vehiculo {

	public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	public DeCarga(DeCarga deCarga) {
		super(deCarga);
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public double precioEspecifico() {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}
}
