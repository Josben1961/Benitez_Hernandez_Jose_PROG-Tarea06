package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Autobus extends Vehiculo {

	private double factorAutobus = 0.0;

	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
		// TODO Ap�ndice de constructor generado autom�ticamente
	}

	public Autobus(Turismo autobus) {
		super(autobus);
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return TipoVehiculo.AUTOBUS;
	}

	@Override
	public double precioEspecifico() {
		factorAutobus= datosTecnicos.getCilindrada()/50+1*datosTecnicos.getNumeroPlazas();
		return factorAutobus;
	}

}
