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
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	public double precioEspecifico() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}
}