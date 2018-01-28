package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilidades.Entrada;

public class Turismo {

	private String matricula;
	private String marca;
	private String modelo;
	private int cilindrada;
	private boolean disponible;

	// Constructor con cuatro par�metros
	public Turismo(String matricula, String marca, String modelo, int cilindrada) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		if (cilindrada > 0) {
			this.cilindrada = cilindrada;
		} else {
			throw new ExcepcionAlquilerVehiculos("Cilindrada no v�lida");
		}
		if (compruebaMatricula(matricula)) {
			this.matricula = matricula;
		} else {
			throw new ExcepcionAlquilerVehiculos("La matr�cula no es correcta");
		}

	}

	// Constructor copia de la clase Turismo
	public Turismo(Turismo turismo) {
		this.matricula = turismo.getMatricula();
		this.marca = turismo.getMarca();
		this.modelo = turismo.getModelo();
		this.cilindrada = turismo.getCilindrada();

	}

	// M�todos getter
	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public boolean getDisponible() {
		return disponible;
	}

	// M�todo setter para disponible
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Turismo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", cilindrada="
				+ cilindrada + ", disponible=" + disponible + "]";
	}

	// M�todo para comprobar la matr�cula introducida.
	// Matr�cula correcta: Cuatro n�meros, espacio y tres letras may�sculas
	// (excluyendo vocales)
	private boolean compruebaMatricula(String matricula) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("([0-9]{4})+([BCDFGHJKLMNPQRSTVWXYZ]{3})");
		Matcher emparejador;

		emparejador = patron.matcher(matricula);
		return emparejador.matches();
	}

}
