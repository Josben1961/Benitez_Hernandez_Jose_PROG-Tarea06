package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Autobus extends Vehiculo {

	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
		// TODO Ap�ndice de constructor generado autom�ticamente
	}
	
	public Autobus(Autobus autobus) {
		super(autobus);
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