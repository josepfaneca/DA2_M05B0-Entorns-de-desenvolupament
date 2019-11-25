package Projecte;

public class Pantalla {


	/**
	 * Escriu les polzades d'unes pantalles
	 */
	public void escriuPolzades() {
		System.out.println(
				"La pantalla normal té " + calcularPolzades(1) + " polzades");

		System.out.println("La pantalla de doble ample i de llarg té "
				+ calcularPolzades(2) + " polzades");

		System.out.println("La pantalla de triple ample i de llarg té "
				+ calcularPolzades(3) + " polzades");
	}

	private double calcularPolzades(int pant) {
		double alt = 27.4;
		double ample = 48.7;
		double polzades = 2.54;
		return Math.round(Math.sqrt(pant * alt * alt + pant * ample * ample) / polzades);
	}



	// .....altres mètodes de la classe
	

} // fi de la classe
