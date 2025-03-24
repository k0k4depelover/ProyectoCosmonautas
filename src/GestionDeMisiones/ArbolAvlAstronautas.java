package GestionDeMisiones;

public class ArbolAvlAstronautas {
	private NodoAVL raiz;
	
	public ArbolAvlAstronautas(){
            this.raizAstronauta=null;
	}
        private NodoAVL insercionArbol(NodoAVL nodo, Astronauta astro, int horasExp,  ){
            if (nodo==null){
                return new NodoAVL(horasExp, Astro);
            }
            if(horasExp<astro.obtenerHorasExp()){
                nodo.establecerIzquierda(insercionArbol(nodo.obtenerIzquierda, astro, horasExp));
            }
            else if(horasExp >astro.obtenerHorasExp()){
                nodo.establecerDerecha(insercionArbol(nodo.obtenerIzquierda, astro, horasExp));
            }

        }   
                
        public void insertar(Astronauta astro, int horasExp){
            raiz= insercionArbol(raiz, astro, horasExp);
        }
}
