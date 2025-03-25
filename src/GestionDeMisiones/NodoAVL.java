package GestionDeMisiones;

public class NodoAVL {
    public int horasExp, FE, altura;
    public NodoAVL izq, der;
    public Astronauta astronauta;

    public NodoAVL(Astronauta astronauta, int horasExp) {
        this.astronauta = astronauta;
        this.horasExp = horasExp;
        this.izq = null;
        this.der = null;
        this.FE = 0;
        this.altura = 1;
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

    public void establecerHorasExp(int horasExp) {
        this.horasExp = horasExp;
    }

    public void establecerIzquierda(NodoAVL Astro) {
        this.izq = Astro;
    }

    public void establecerDerecha(NodoAVL Astro) {
        this.der = Astro;
    }

    public Astronauta obtenerAstronauta() {
        return this.astronauta;
    }

    public void establecerAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }
}
