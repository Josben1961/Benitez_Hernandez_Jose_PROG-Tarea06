package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;


public enum TipoVehiculo {

	TURISMO("Turismo") {

		public Turismo getInstancia(String matricula, String marca, String modelo,
				DatosTecnicosVehiculo datosTecnicos) {
			return new Turismo(matricula, marca, modelo, datosTecnicos);
		}

	},
	DE_CARGA("DeCarga") {

		public DeCarga getInstancia(String matricula, String marca, String modelo,
				DatosTecnicosVehiculo datosTecnicos) {
			return new DeCarga(matricula, marca, modelo, datosTecnicos);
		}

	},

	AUTOBUS("Autobus") {

		public Autobus getInstancia(String matricula, String marca, String modelo,
				DatosTecnicosVehiculo datosTecnicos) {
			return new Autobus(matricula, marca, modelo, datosTecnicos);
		}

	};

	private String tipo;

	private TipoVehiculo(String tipo) {
		this.tipo = tipo;
	}
	
	public abstract Vehiculo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos);

	public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Ordinal de la opción no válido");
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}

	public String toString() {
		return tipo;
	}

}
