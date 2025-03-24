package GestionDeMisiones;
//Esta clase representa astronauta en forma de un nodo.
//En este proyecto todas las clases y atributos tendran nombres en español

public class Astronauta {
	private int horasExp, FE, altura;
	private Astronauta izq, der;
	private String nomAstro, apellAstro;
	
	public Astronauta(int horasExp,String nomAstro, String apellAstro) {
		this.horasExp=horasExp;
		this.nomAstro=nomAstro;
		this.apellAstro=apellAstro;
		this.izq=null;
		this.der=null;
		this.FE=0;
		this.altura=1;
		
	}
	
	public int obtenerHorasExp() {
		return this.horasExp;
	}
	public String obtenerNomAstro() {
		return this.nomAstro;
	}
	public String obtenerApellAstro() {
		return this.apellAstro;
	}
	public Astronauta obtenerIzquierda() {
		return this.izq;
	}
	public Astronauta obtenerDerecha() {
		return this.der;
	}
	
	public void establecerHorasExp(int horasExp) {
		this.horasExp=horasExp;
	}
	public void establecerNomAstro(String nomAstro) {
		this.nomAstro=nomAstro;
	}
	public void establecerApellAstro(String apellAstro) {
		this.apellAstro=apellAstro;
	}
	public void establecerIzquierda(Astronauta Astro) {
		this.izq=Astro;
	}
	public void establecerDerecha(Astronauta Astro) {
		this.der=Astro;
	}
}
