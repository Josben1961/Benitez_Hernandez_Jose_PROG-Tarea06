package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Turismo extends Vehiculo {
	private double factorTurismo = 0.0;

	public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	public Turismo(Turismo turismo) {
		super(turismo);
	}

	public TipoVehiculo getTipoVehiculo() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return TipoVehiculo.TURISMO;
	}

	public double precioEspecifico() {
		factorTurismo= datosTecnicos.getCilindrada()/50;
		return factorTurismo;
	}
}