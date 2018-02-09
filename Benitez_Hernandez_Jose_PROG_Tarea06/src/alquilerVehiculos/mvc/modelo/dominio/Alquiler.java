package alquilerVehiculos.mvc.modelo.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Alquiler {

	private Cliente cliente;
	private Vehiculo vehiculo;
	private Date fecha;
	private int dias;
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private final int MS_DIA = 1000 * 60 * 60 * 24;
	private final double PRECIO_DIA = 30.0;
	private boolean disponible;

	// Constructor con dos parámetros
	public Alquiler(Cliente cliente, Vehiculo vehiculo) {
		setCliente(cliente);
		setVehiculo(vehiculo);
		fecha = new Date();
		dias = 0;
		vehiculo.setDisponible(false);
	}
	
	private void setCliente(Cliente cliente) {
		if (cliente != null)
			this.cliente = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El trabajo debe tener un vehículo identificado");
	}
	
	private void setVehiculo(Vehiculo vehiculo) {
		if (vehiculo != null)
			this.vehiculo = new Vehiculo(vehiculo);
		else
			throw new ExcepcionAlquilerVehiculos("El trabajo debe tener un vehículo identificado");
	}

	// Métodos getters
	public Cliente getCliente() {
		return cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getDias() {
		return dias;
	}

	public double getPrecio() {
		return PRECIO_DIA * getDias() + (vehiculo.getCilindrada() / 100);
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
		return "Alquiler [cliente = " + cliente + "\n, vehiculo = " + vehiculo + "\n, fecha = " + fecha + ", dias = "
				+ dias + ", disponible = " + disponible + " , precio= " + getPrecio() + "]\n";
	}

}
