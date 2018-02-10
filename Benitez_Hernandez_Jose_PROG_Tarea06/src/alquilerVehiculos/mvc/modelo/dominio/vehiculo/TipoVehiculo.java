package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.vista.IUTextual;

public enum TipoVehiculo {

	SALIR("Salir") {
		public void ejecutar() {
			vista.salir();
		}

	},
	TURISMO("Turismo") {

	},
	DE_CARGA("Vehículo de Carga") {

	},

	AUTOBUS("Autobus") {

	};

	private String tipo;
	private static IUTextual vista;

	private TipoVehiculo(String tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return tipo;
	}

	public static TipoVehiculo getOpcionSegunOridnal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Ordinal de la opción no válido");
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}

	public String toString() {
		return String.format("%d.- %s", ordinal(), tipo);
	}

}
