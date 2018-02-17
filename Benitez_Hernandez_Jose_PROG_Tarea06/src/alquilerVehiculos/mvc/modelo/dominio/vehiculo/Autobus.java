package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Autobus extends Vehiculo {

	private double factorAutobus = 0.0;

	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
		// TODO Apéndice de constructor generado automáticamente
	}

	public Autobus(Turismo autobus) {
		super(autobus);
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		// TODO Apéndice de método generado automáticamente
		return TipoVehiculo.AUTOBUS;
	}

	@Override
	public double precioEspecifico() {
		factorAutobus= datosTecnicos.getCilindrada()/50+1*datosTecnicos.getNumeroPlazas();
		return factorAutobus;
	}

}
