package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Turismo extends Vehiculo {

	public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	public Turismo(Turismo turismo) {
		super(turismo);
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