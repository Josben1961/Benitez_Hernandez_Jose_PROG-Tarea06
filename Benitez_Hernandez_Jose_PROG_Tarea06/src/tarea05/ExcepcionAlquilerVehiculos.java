package tarea05;

public class ExcepcionAlquilerVehiculos extends RuntimeException {
	
	private String mensaje;
	
	public ExcepcionAlquilerVehiculos (String mensaje) {
		
		super(mensaje);
		
				 		
	}

}
