package alquilerVehiculos.mvc.modelo.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alquiler {

	private Cliente cliente;
	private Turismo turismo;
	private Date fecha;
	private int dias;
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private final int MS_DIA = 1000 * 60 * 60 * 24;
	private final double PRECIO_DIA = 30.0;
	private boolean disponible;

	// Constructor con dos parámetros
	public Alquiler(Cliente cliente, Turismo turismo) {
		setCliente(cliente);
		setTurismo(turismo);
		fecha = new Date();
		dias = 0;
		turismo.setDisponible(false);
	}
	
	private void setCliente(Cliente cliente) {
		if (cliente != null)
			this.cliente = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El trabajo debe tener un vehículo identificado");
	}
	
	private void setTurismo(Turismo turismo) {
		if (turismo != null)
			this.turismo = new Turismo(turismo);
		else
			throw new ExcepcionAlquilerVehiculos("El trabajo debe tener un vehículo identificado");
	}

	// Métodos getters
	public Cliente getCliente() {
		return cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getDias() {
		return dias;
	}

	public double getPrecio() {
		return PRECIO_DIA * getDias() + (turismo.getCilindrada() / 100);
	}

	public void cerrar() {
		Date entrega = new Date();
		dias = difDias(entrega, fecha);
		if (entrega == fecha) {
			dias = 1;
		}

	}

	private int difDias(Date fechaFin, Date fechaInicio) {
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
		long dias = milisegundos / MS_DIA;
		return (int) dias + 1;
	}

	@Override
	public String toString() {
		return "Alquiler [cliente = " + cliente + "\n, turismo = " + turismo + "\n, fecha = " + fecha + ", dias = "
				+ dias + ", disponible = " + disponible + " , precio= " + getPrecio() + "]\n";
	}

}
