package alquilerVehiculos.aplicacion;

import alquilerVehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.vista.IUTextual;

public class Principal {

	public static void main(String[] args) {
		AlquilerVehiculos modelo = new AlquilerVehiculos();
		IUTextual vista = new IUTextual();
		ControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(vista, modelo);

		controlador.comenzar();
	}

}
