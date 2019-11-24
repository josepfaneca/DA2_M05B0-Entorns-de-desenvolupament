package Projecte;

public class Pantalla {

	
	private final double ALT = 27.4;
	private final double AMPLE = 48.7;
	private final double POLZADES = 2.54;

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

	public double calcularPolzades(int pant) {
		return Math.round(Math.sqrt(pant * ALT * ALT + pant * AMPLE * AMPLE) / POLZADES);
	}

	// .....altres mètodes de la classe
	

} // fi de la classe
