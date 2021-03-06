package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public enum Opcion {
	SALIR("Salir") {
		public void ejecutar() {
			vista.salir();
		}
	},
	ANADIR_CLIENTE("A�adir cliente") {
		public void ejecutar() {
			vista.anadirCliente();
		}
	},
	BORRAR_CLIENTE("Borrar cliente") {
		public void ejecutar() {
			vista.borrarCliente();
		}
	},
	BUSCAR_CLIENTE("Buscar cliente") {
		public void ejecutar() {
			vista.buscarCliente();
		}
	},
	LISTAR_CLIENTES("Listar clientes") {
		public void ejecutar() {
			vista.listarClientes();
		}
	},
	ANADIR_VEHICULO("A�adir veh�culo") {
		public void ejecutar() {
			vista.anadirVehiculo();
		}
	},
	BORRAR_VEHICULO("Borrar veh�culo") {
		public void ejecutar() {
			vista.borrarVehiculo();
		}
	},
	BUSCAR_VEHICULO("Buscar veh�culo") {
		public void ejecutar() {
			vista.buscarVehiculo();
		}
	},
	LISTAR_VEHICULOS("Listar veh�culos") {
		public void ejecutar() {
			vista.listarVehiculos();
		}
	},
	ABRIR_ALQUILERES("Abrir alquiler") {
		public void ejecutar() {
			vista.abrirAlquiler();
		}
	},
	CERRAR_ALQUILER("Cerrar Alquiler") {
		public void ejecutar() {
			vista.cerrarAlquiler();
		}
	},

	LISTAR_ALQUILERES("Listar Alquileres") {
		public void ejecutar() {
			vista.listarAlquileres();
		}
	};

	private String mensaje;
	private static IVistaAlquilerVehiculos vista;

	private Opcion(String mensaje) {
		this.mensaje = mensaje;
	}

	public abstract void ejecutar();

	public String getMensaje() {
		return mensaje;
	}

	public static void setVista(IVistaAlquilerVehiculos vista) {
		Opcion.vista = vista;
	}

	public String toString() {
		return String.format("%d.- %s", ordinal(), mensaje);
	}

	public static Opcion getOpcionSegunOridnal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Opci�n no v�lida");
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}
}
