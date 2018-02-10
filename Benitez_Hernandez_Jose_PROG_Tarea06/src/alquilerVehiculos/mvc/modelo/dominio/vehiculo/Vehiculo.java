package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class Vehiculo {

	private String matricula;
	private String marca;
	private String modelo;
	private boolean disponible;
	private DatosTecnicosVehiculo datosTecnicos;
	private final  double FACTOR_CILINDRADA =0;
	private final  double FACTOR_NUMERO_PLAZAS =0;
	private final  double FACTOR_PMA =0;

	// Constructor con cuatro parámetros
	public Vehiculo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {

		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setDatosTecnicos(datosTecnicos);

	}

	// Constructor copia de la clase Turismo
	
	public Vehiculo(Vehiculo vehiculo) {
		matricula = vehiculo.getMatricula();
		marca = vehiculo.getMarca();
		modelo = vehiculo.getModelo();
		datosTecnicos = vehiculo.getDatosTecnicos();

	}
	
	public void setDatosTecnicos(DatosTecnicosVehiculo datosTecnicos) {
		// TODO Apéndice de método generado automáticamente
		
	}

	public DatosTecnicosVehiculo getDatosTecnicos() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	// Métodos getter
	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}


	public boolean getDisponible() {
		return disponible;
	}

	private void setMatricula(String matricula) {
		if (compruebaMatricula(matricula))
			this.matricula = matricula;
		else
			throw new ExcepcionAlquilerVehiculos("La matrícula no es correcta");
	}

	private void setMarca(String marca) {
		if (marca != null && !marca.equals(""))
			this.marca = marca;
		else
			throw new ExcepcionAlquilerVehiculos("La marca no es válida");
	}

	private void setModelo(String modelo) {
		if (modelo != null && !modelo.equals(""))
			this.modelo = modelo;
		else
			throw new ExcepcionAlquilerVehiculos("El modelo no es válido");
	}

	// Método setter para disponible
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	// Método para comprobar la matrícula introducida.
	// Matrícula correcta: Cuatro números, espacio y tres letras mayúsculas
	// (excluyendo vocales)
	private boolean compruebaMatricula(String matricula) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("([0-9]{4})+([BCDFGHJKLMNPQRSTVWXYZ]{3})");
		Matcher emparejador;
		emparejador = patron.matcher(matricula);
		return emparejador.matches();
	}

	@Override
	public String toString() {
		return String.format("Matrícula: %s, Marca: %s Modelo: %s Color: %s Cilindrada: %d%n\t", matricula, marca,
				modelo, datosTecnicos);
	}

}
