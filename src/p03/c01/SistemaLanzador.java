package src.p03.c01;

public class SistemaLanzador {
	public static void main(String[] args) {
		
		IParque parque = new Parque();
		char letra_puerta = 'A';
		
		System.out.println("¡Parque abierto!");
		
//		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
//			
//			String puerta = ""+((char) (letra_puerta++));
//			
//			// Creación de hilos de entrada
//			ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
//			new Thread (entradas).start();			
//		}
		
		// Creación de hilos de entrada
	    String[] puertas = {"A", "B","C","D","E"};
	    for (String puerta : puertas) {
	    	ActividadEntradaPuerta tareaEntrada = new ActividadEntradaPuerta(puerta, parque);
	        new Thread(tareaEntrada).start();
	    }

	    // Creación de hilos de salida
	    for (String puerta : puertas) {
	    	ActividadSalidaPuerta tareaSalida = new ActividadSalidaPuerta(puerta, parque);
	        new Thread(tareaSalida).start();
	    }
	}	
}
