package alquilerVehiculos.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Turismo {

	private String matricula;
	private String marca;
	private String modelo;
	private int cilindrada;
	private boolean disponible;

	// Constructor con cuatro par�metros
	public Turismo(String matricula, String marca, String modelo, int cilindrada) {

		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);

	}

	// Constructor copia de la clase Turismo
	public Turismo(Turismo turismo) {
		matricula = turismo.getMatricula();
		marca = turismo.getMarca();
		modelo = turismo.getModelo();
		cilindrada = turismo.getCilindrada();

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

	private void setMatricula(String matricula) {
		if (compruebaMatricula(matricula))
			this.matricula = matricula;
		else
			throw new ExcepcionAlquilerVehiculos("La matr�cula no es correcta");
	}

	private void setMarca(String marca) {
		if (marca != null && !marca.equals(""))
			this.marca = marca;
		else
			throw new ExcepcionAlquilerVehiculos("La marca no es v�lida");
	}

	private void setModelo(String modelo) {
		if (modelo != null && !modelo.equals(""))
			this.modelo = modelo;
		else
			throw new ExcepcionAlquilerVehiculos("El modelo no es v�lido");
	}

	// M�todo setter para disponible
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada > 0)
			this.cilindrada = cilindrada;
		else
			throw new ExcepcionAlquilerVehiculos("Cilindrada no v�lida");
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

	@Override
	public String toString() {
		return String.format("Matr�cula: %s, Marca: %s Modelo: %s Color: %s Cilindrada: %d%n\t", matricula, marca,
				modelo, cilindrada);
	}

}
