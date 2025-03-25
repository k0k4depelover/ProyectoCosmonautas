package GestionDeMisiones;
import java.util.ArrayList;
import java.util.List;
public class NodoMision {
	private List<NodoAVL> astronautas;
        private static int contador_misiones=1;
        private int idMision;
	private String nomMision;
	private NodoMision sig;
	private static final int MAX_ASTRONAUTAS = 4;
	public NodoMision(String nomMision) {
		this.idMision= contador_misiones++;
                this.nomMision= nomMision;
		this.astronautas= new ArrayList<>();
		this.sig=null;
	}
	public List<NodoAVL> obtenerAstronautas(){
		return this.astronautas;
	}
        public int obtenerIdMision() {
            return this.idMision;
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
    public boolean agregarAstronautas() {
        for(int i=0; i <MAX_ASTRONAUTAS; i++) {
         NodoAVL mayor= obtenerMayor();
         if (mayor != null){
             this.astronautas.add(mayor);
         }
         else{
             return false;
         }
        
        return true; 
    }
}
