package alquilerVehiculos.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DireccionPostal {
	private String calle;
	private String localidad;
	private String codigoPostal;

	public DireccionPostal(DireccionPostal direccionPostal) {
		calle = direccionPostal.getCalle();
		localidad = direccionPostal.getLocalidad();
		codigoPostal = direccionPostal.getCodigoPostal();
	}

	public DireccionPostal(String calle, String localidad, String codigoPostal) {
		setCalle(calle);
		setLocalidad(localidad);
		setCodigoPostal(codigoPostal);
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		if (calle != null && !calle.equals(""))
			this.calle = calle;
		else
			throw new ExcepcionAlquilerVehiculos("La calle no es correcta");
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		if (localidad != null && !localidad.equals(""))
			this.localidad = localidad;
		else
			throw new ExcepcionAlquilerVehiculos("Localidad no válida");
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		if (compruebaCodigoPostal(codigoPostal))
			this.codigoPostal = codigoPostal;
		else
			throw new ExcepcionAlquilerVehiculos("El formato del código no es válido");
	}

	boolean compruebaCodigoPostal(String codigoPostal) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}");
		Matcher emparejador;
		emparejador = patron.matcher(codigoPostal);
		return emparejador.matches();
	}

	public String toString() {
		return String.format("Calle: %s Localidad: %s Código Postal: %s", calle, localidad, codigoPostal);
	}
}