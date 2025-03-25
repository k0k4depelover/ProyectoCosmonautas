package GestionDeMisiones;

public class ArbolAvlAstronautas {
    private NodoAVL raiz;

    public ArbolAvlAstronautas() {
        this.raiz = null;
    }

    public void insertar(Astronauta astro, int horasExp) {
        NodoAVL nuevoNodo = new NodoAVL(astro, horasExp);
        raiz = insercionArbol(raiz, nuevoNodo);
    }

    private NodoAVL insercionArbol(NodoAVL nodo, NodoAVL nuevoNodo) {
        if (nodo == null) {
            return nuevoNodo;
        }

        if (nuevoNodo.obtenerHorasExp() < nodo.obtenerHorasExp()) {
            nodo.establecerIzquierda(insercionArbol(nodo.obtenerIzquierda(), nuevoNodo));
        } else if (nuevoNodo.obtenerHorasExp() > nodo.obtenerHorasExp()) {
            nodo.establecerDerecha(insercionArbol(nodo.obtenerDerecha(), nuevoNodo));
        } else {
            int comparacionNombre = nuevoNodo.obtenerAstronauta().obtenerNombreAstro()
                .compareTo(nodo.obtenerAstronauta().obtenerNombreAstro());
            int comparacionApellido = nuevoNodo.obtenerAstronauta().obtenerApellAstro()
                .compareTo(nodo.obtenerAstronauta().obtenerApellAstro());

            if (comparacionNombre == 0 && comparacionApellido == 0) {
                System.out.println("Error: El astronauta ya ha sido ingresado.");
                return nodo;
            }

            if (comparacionNombre < 0 || (comparacionNombre == 0 && comparacionApellido < 0)) {
                nodo.establecerIzquierda(insercionArbol(nodo.obtenerIzquierda(), nuevoNodo));
            } else {
                nodo.establecerDerecha(insercionArbol(nodo.obtenerDerecha(), nuevoNodo));
            }
        }
        return balancear(nodo);
    }

    private NodoAVL balancear(NodoAVL nodo) {
        nodo.altura = 1 + Math.max(altura(nodo.obtenerIzquierda()), altura(nodo.obtenerDerecha()));
        int balance = obtenerBalance(nodo);

        if (balance > 1 && obtenerBalance(nodo.obtenerIzquierda()) >= 0) {
            return rotacionSimpleDerecha(nodo);
        }
        if (balance > 1 && obtenerBalance(nodo.obtenerIzquierda()) < 0) {
            nodo.establecerIzquierda(rotacionSimpleIzquierda(nodo.obtenerIzquierda()));
            return rotacionSimpleDerecha(nodo);
        }
        if (balance < -1 && obtenerBalance(nodo.obtenerDerecha()) <= 0) {
            return rotacionSimpleIzquierda(nodo);
        }
        if (balance < -1 && obtenerBalance(nodo.obtenerDerecha()) > 0) {
            nodo.establecerDerecha(rotacionSimpleDerecha(nodo.obtenerDerecha()));
            return rotacionSimpleIzquierda(nodo);
        }
        return nodo;
    }

    private int altura(NodoAVL nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private int obtenerBalance(NodoAVL nodo) {
        return (nodo == null) ? 0 : altura(nodo.obtenerIzquierda()) - altura(nodo.obtenerDerecha());
    }

    private NodoAVL rotacionSimpleIzquierda(NodoAVL x) {
        NodoAVL y = x.obtenerDerecha();
        x.establecerDerecha(y.obtenerIzquierda());
        y.establecerIzquierda(x);
        actualizarAltura(x);
        actualizarAltura(y);
        return y;
    }

    private NodoAVL rotacionSimpleDerecha(NodoAVL x) {
        NodoAVL y = x.obtenerIzquierda();
        x.establecerIzquierda(y.obtenerDerecha());
        y.establecerDerecha(x);
        actualizarAltura(x);
        actualizarAltura(y);
        return y;
    }

    private void actualizarAltura(NodoAVL nodo) {
        if (nodo != null) {
            nodo.altura = 1 + Math.max(altura(nodo.obtenerIzquierda()), altura(nodo.obtenerDerecha()));
        }
    }

    public NodoAVL obtenerMayor() {
        return obtenerMayorRecursivo(raiz);
    }

    private NodoAVL obtenerMayorRecursivo(NodoAVL nodo) {
        if (nodo == null || nodo.obtenerDerecha() == null) {
            return nodo;
        }
        return obtenerMayorRecursivo(nodo.obtenerDerecha());
    }
}
