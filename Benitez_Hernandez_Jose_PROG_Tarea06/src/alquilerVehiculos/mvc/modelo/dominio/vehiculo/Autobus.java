package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Autobus extends Vehiculo {

	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
		// TODO Apéndice de constructor generado automáticamente
	}
	
	public Autobus(Autobus autobus) {
		super(autobus);
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
