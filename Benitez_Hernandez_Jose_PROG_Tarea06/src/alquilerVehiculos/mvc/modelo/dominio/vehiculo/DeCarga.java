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
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	public double precioEspecifico() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}
}
