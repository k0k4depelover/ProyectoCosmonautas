package GestionDeMisiones;

import java.util.List;

public class ListaDinamicaMisiones {
    private NodoMision primer, ultimo;

    public ListaDinamicaMisiones() {
        this.primer = this.ultimo = null;
    }

    public void listarMision() {
        if (primer == null) {
            System.out.println("La lista de misiones está vacía.");
        } else {
            NodoMision temp = primer;
            
            while (temp != null) {
                System.out.println("El ID de la misión es: " + temp.obtenerIdMision() + "\n");
                System.out.println("El nombre de la misión es: " + temp.obtenerNomMision()+ "\n");
                System.out.println("El total de horas de la misión es: " + sumarHorasAstronautas(temp)+ "\n");
                

                List<NodoAVL> astronautas = temp.obtenerAstronautas();
                
                if (astronautas.isEmpty()) {
                    System.out.println("La lista de astronautas está vacía.");
                } else {

                    for (NodoAVL astro : astronautas) {
                        Astronauta astronauta = astro.obtenerAstronauta(); 
                        System.out.println("Nombre: " + astronauta.obtenerNombreAstro() + "\n"+
                                " Apellido: " + astronauta.obtenerApellAstro() + "\n"+
                                " Nacionalidad: " + astronauta.obtenerNacionAstro() + "\n"+
                                " Horas: " + astro.obtenerHorasExp()+ "\n");
                    }
                }
                temp = temp.obtenerSiguiente();
            }
        }
    }

    public void insertarMision(NodoMision mision) {
        if (primer == null) {
            primer = ultimo = mision;
        } else {
            ultimo.establecerSiguiente(mision);
            ultimo = mision;
        }
    }
    
    public void eliminarMision(ArbolAvlAstronautas arbol) {
    	if(primer==null) {
    		System.out.println("No hay misiones para eliminar.");
    	}
    	else {
            System.out.println("El ID de la misión es: " + primer.obtenerIdMision()+ "\n");
            System.out.println("El nombre de la misión es: " + primer.obtenerNomMision()+ "\n");
            System.out.println("El total de horas de la misión es: " + sumarHorasAstronautas(primer)+ "\n");
            

            List<NodoAVL> astronautas = primer.obtenerAstronautas();
    		
            if (astronautas.isEmpty()) {
                System.out.println("La lista de astronautas está vacía.");
            } else {

                for (NodoAVL astro : astronautas) {
                    Astronauta astronauta = astro.obtenerAstronauta(); 
                    System.out.println("Nombre: " + astronauta.obtenerNombreAstro() +
                            " Apellido: " + astronauta.obtenerApellAstro() +
                            " Nacionalidad: " + astronauta.obtenerNacionAstro() +
                            " Horas: " + astro.obtenerHorasExp());
                    arbol.insertar(astronauta, astro.obtenerHorasExp());
                }
            }
    		primer= primer.obtenerSiguiente();
    		if(primer==null) {
    			System.out.println("La lista de misiones ya no tiene más objetos.");
    			ultimo=null;
    		}

    	}
    }


    public int sumarHorasAstronautas(NodoMision mision) {
        int totalHoras = 0;
        

        List<NodoAVL> astronautas = mision.obtenerAstronautas();
        

        for (NodoAVL astro : astronautas) {
            totalHoras += astro.obtenerHorasExp();
        }
        
        return totalHoras;
    }
}

