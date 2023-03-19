package src.p03.c01;

public class SistemaLanzador {
	public static void main(String[] args) {
		
		IParque parque = new Parque(); // TODO
		char letra_puerta = 'A';
		
		System.out.println("¡Parque abierto!");
		

		// Creación de hilos de entrada
	    String[] puertas = {"A", "B", "C", "D", "E"};
	    for (String puerta : puertas) {
	    	ActividadEntradaPuerta tareaEntrada = new ActividadEntradaPuerta(puerta, parque);
	        new Thread(tareaEntrada).start();
	    }

	  
	}	
}
