package GestionDeMisiones;

public class ArbolAvlAstronautas {
	private NodoAVL raiz;
	
	public ArbolAvlAstronautas(){
            this.raiz=null;
	}
	
    public void insertar(Astronauta astro, int horasExp){
        raiz= insercionArbol(raiz, astro, horasExp);
    }
    
        private NodoAVL insercionArbol(NodoAVL nodo, Astronauta astro, int horasExp ){
            if (nodo==null){
                return new NodoAVL(horasExp, astro);
            }
            if(horasExp<nodo.obtenerHorasExp()){
                nodo.establecerIzquierda(insercionArbol(nodo.obtenerIzquierda(), astro, horasExp));
            }
            else if(horasExp >nodo.obtenerHorasExp()){
                nodo.establecerDerecha(insercionArbol(nodo.obtenerDerecha(), astro, horasExp));
            }
            else {
                int comparacionNombre = astro.obtenerNombreAstro().compareTo(nodo.Astronauta.obtenerNombreAstro());
                int comparacionApellido = astro.obtenerApellAstro().compareTo(nodo.Astronauta.obtenerApellAstro());

                if (comparacionNombre == 0 && comparacionApellido == 0) {
                    System.out.println("Error: El astronauta " + astro.obtenerNombreAstro() + " " + astro.obtenerApellAstro() + " ya ha sido ingresado.");
                    return nodo; 
                }

                if (comparacionNombre < 0 || (comparacionNombre == 0 && comparacionApellido < 0)) {
                    nodo.establecerIzquierda(insercionArbol(nodo.obtenerIzquierda(), astro, horasExp)); 
                } else {

                    nodo.establecerDerecha(insercionArbol(nodo.obtenerDerecha(), astro, horasExp)); 
                }

            }
            nodo.altura=1+Math.max(altura(nodo.obtenerIzquierda()), altura(nodo.obtenerDerecha()));
            
            int balance= obtenerBalance(nodo);
            
            
            if(balance>1 && horasExp < nodo.obtenerIzquierda().obtenerHorasExp()) {
            	return rotacionSimpleIzquierda(nodo);
            }
            
            if(balance < -1 && horasExp > nodo.obtenerDerecha().obtenerHorasExp()) {
            	return rotacionSimpleDerecha(nodo);
            }
            
            if(balance >1 && horasExp > nodo.obtenerIzquierda().obtenerHorasExp()) {
            	return rotacionDobleIzquierdaDerecha(nodo);
            }
            if(balance < -1 && horasExp < nodo.obtenerDerecha().obtenerHorasExp() ) {
            	return rotacionDobleDerechaIzquierda(nodo);
            }
            return nodo;
        }
        

		private int altura(NodoAVL nodo) {
        	return (nodo==null) ? 0: nodo.altura; 
        }
        
        private int obtenerBalance(NodoAVL nodo) {
        	return (nodo==null)? 0: altura(nodo.obtenerIzquierda()) -altura(nodo.obtenerDerecha()); 
        }
        
        private NodoAVL rotacionSimpleIzquierda(NodoAVL x) {
        	NodoAVL y= x.obtenerIzquierda();
        	NodoAVL yDerecha= y.obtenerDerecha();
        	y.establecerDerecha(x);
        	x.establecerIzquierda(yDerecha);
        	
        	x.altura=Math.max(altura(x.obtenerIzquierda()), altura(x.obtenerDerecha()));
        	y.altura=Math.max(altura(y.obtenerIzquierda()), altura(y.obtenerDerecha()));
        	return y;
        }
        private NodoAVL rotacionSimpleDerecha(NodoAVL x) {
        	NodoAVL y= x.obtenerDerecha();
        	NodoAVL yIzquierda= y.obtenerIzquierda();
        	y.establecerIzquierda(x);
        	x.establecerDerecha(yIzquierda);
        	
        	x.altura=Math.max(altura(x.obtenerIzquierda()), altura(x.obtenerDerecha()))+1;
        	y.altura=Math.max(altura(y.obtenerIzquierda()), altura(y.obtenerDerecha()))+1;
        	return y;
        } 
        
        private NodoAVL rotacionDobleIzquierdaDerecha(NodoAVL z) {
            z.establecerIzquierda(rotacionSimpleIzquierda(z.obtenerIzquierda()));

            return rotacionSimpleDerecha(z);
        }
        
        private NodoAVL rotacionDobleDerechaIzquierda(NodoAVL z) {
        	z.establecerDerecha(rotacionSimpleDerecha(z.obtenerDerecha()));
        	return rotacionSimpleIzquierda(z);
        }
        
        public NodoAVL obtenerMayorRecursivo(NodoAVL nodo){
            if(nodo.obtenerDerecha()== null || nodo==null){
                return nodo;
            }
            nodo= obtenerMayor(nodo.obtenerDerecha());
        }
        public NodoAVL  obtenerMayor(){
            return obtenerMayor(raiz);
        }
}
