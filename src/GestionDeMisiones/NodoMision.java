package GestionDeMisiones;
import java.util.ArrayList;
import java.util.List;
public class NodoMision {
	private List<NodoAVL> astronautas;
	private String nomMision;
	private NodoMision sig;
	private static final int MAX_ASTRONAUTAS = 4;
	public NodoMision(String nomMision) {
		this.nomMision= nomMision;
		this.astronautas= new ArrayList<>();
		this.sig=null;
	}
	public List<NodoAVL> obtenerAstronautas(){
		return this.astronautas;
	}
	
	public String obtenerNomMision() {
		return this.nomMision;
	}
	public NodoMision obtenerSiguiente() {
		return this.sig;
	}
	public void establecerNomMision(String nomMision) {
		this.nomMision=nomMision;
	}
	public void establecerSiguiente(NodoMision mision) {
		this.sig=mision;
	}
    public boolean agregarAstronauta(NodoAVL astro) {
        if (this.astronautas.size() >= MAX_ASTRONAUTAS) {
            System.out.println("Error: No se pueden agregar más astronautas a la misión " + this.nomMision);
            return false;
        }
        this.astronautas.add(astro);
        return true; 
    }
}
