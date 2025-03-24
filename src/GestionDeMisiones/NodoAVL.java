package GestionDeMisiones;
//Esta clase representa astronauta en forma de un nodo.
//En este proyecto todas las clases y atributos tendran nombres en español

public class NodoAVL {
	public int horasExp, FE, altura;
	public NodoAVL izq, der;
        public Astronauta Astronauta;
	
	public NodoAVL(int horasExp, Astronauta Astronauta){
                this.Astronauta=Astronauta;
		this.horasExp=horasExp;
		this.izq=null;
		this.der=null;
		this.FE=0;
		this.altura=1;
		
	}
	
	public int obtenerHorasExp() {
		return this.horasExp;
	}
	public NodoAVL obtenerIzquierda() {
		return this.izq;
	}
	public NodoAVL obtenerDerecha() {
		return this.der;
	}
	public void establecerHorasExp() {
		this.horasExp=horasExp;
	}
	public void establecerIzquierda(NodoAVL Astro) {
		this.izq=Astro;
	}
	public void establecerDerecha(NodoAVL Astro) {
		this.der=Astro;
	}
        
}
