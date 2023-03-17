package src.p03.c01;

import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque{


    private static final int AFORO_MAXIMO = 50;
	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
    long primerMomentoEntrada;

	
	
	
	public Parque() {
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
	}


	public void entrarAlParque(String puerta){		
		
	    // Verificar si ya se alcanzó el aforo máximo
	    if (contadorPersonasTotales >= AFORO_MAXIMO) {
	        System.out.println("Aforo máximo alcanzado. No se permite la entrada.");
	        return;
	    }

		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)+1);
		
		
		 // Mostrar información de la entrada
	    System.out.println("Entrada por la puerta " + puerta + ". Personas totales: " + contadorPersonasTotales);
		
	}
	
	public synchronized void salir(String puerta) {
	    // Verificar si hay personas en el parque
	    if (contadorPersonasTotales <= 0) {
	        System.out.println("No hay personas en el parque. No se permite la salida.");
	        return;
	    }
	    
	    // Verificar si hay personas por esa puerta
	    if (contadoresPersonasPuerta.get(puerta) == null || contadoresPersonasPuerta.get(puerta) <= 0) {
	        System.out.println("No hay personas por la puerta " + puerta + ". No se permite la salida.");
	        return;
	    }
	   
	    
	    // Imprimir información de la salida y del estado del parque
	    imprimirInfo(puerta, "Salida");
	}
	
	
	private void imprimirInfo (String puerta, String movimiento){
		System.out.println(movimiento + " por puerta " + puerta);
		System.out.println("--> Personas en el parque " + contadorPersonasTotales); //+ " tiempo medio de estancia: "  + tmedio);
		
		// Iteramos por todas las puertas e imprimimos sus entradas
		for(String p: contadoresPersonasPuerta.keySet()){
			System.out.println("----> Por puerta " + p + " " + contadoresPersonasPuerta.get(p));
		}
		System.out.println(" ");
	}
	
	private int sumarContadoresPuerta() {
		int sumaContadoresPuerta = 0;
			Enumeration<Integer> iterPuertas = contadoresPersonasPuerta.elements();
			while (iterPuertas.hasMoreElements()) {
				sumaContadoresPuerta += iterPuertas.nextElement();
			}
		return sumaContadoresPuerta;
	}
	
	protected void checkInvariante() {
		assert sumarContadoresPuerta() == contadorPersonasTotales : "INV: La suma de contadores de las puertas debe ser igual al valor del contador del parte";
		// TODO 
		// TODO
		
		
		
	}

	protected void comprobarAntesDeEntrar(){
		//
		// TODO
		//
	}

	protected void comprobarAntesDeSalir(){
		//
		// TODO
		//
	}


}
