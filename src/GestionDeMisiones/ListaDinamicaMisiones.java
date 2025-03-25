package GestionDeMisiones;

public class ListaDinamicaMisiones {
    private NodoMision primer, ultimo;
    public ListaDinamicaMisiones(){
        this.primer= this.ultimo= null;
    }
    
    public void listarMision(){
        if(primer==null){
            System.out.println("La lista de misiones está vacia.");
        }
        else{
            NodoMision temp=primer;
            while(temp!= null){
                System.out.pritnln("El ID de la mision es: "+ temp.obtenerIdMision());
                System.out.println("El nombre de la mision es: " +  temp.obtenerNomMision());
                System.out.println("El total de horas de la mision es: "+ temp.sumarHorasAstronautas());
                List<NodoAVL> astronautas= temp.obtenerAstronautas();
                if(astronautas.isEmpty()){
                    System.out.println("La lista de astronautas esta vacia");
                }
                else{
                    for(NodoAVL astro: astronautas){
                        System.out.println("Nombre: " + astro.Astronauta.obtenerNomAstro()+
                                "Apellido: "+ astro.Astronauta.obtenerApellAstro()+"Nacionalidad: "+
                                astro.Astronauta.obtenerNacionAstro() + "Horas: "+ astro.obtenerHorasExp());
        }
                }
                temp=temp.obtenerSiguiente();
                
            }
        }
    }
    
    public int sumarHorasAstronautas(){
        int totalHoras=0;
        List<NodoAVL> astronautas= this.obtenerAstronautas();
        for(NodoAVL astro: astronautas){
            totalHoras+=astro.obtenerHorasExp();
        }
        return totalHoras;
    }
    public void insertarMision(NodoMision mision){
        if(primer==null){
            primer= ultimo=mision;
        }
        else{
            ultimo.establecerSiguiente(mision);
            ultimo=mision;
        }
        
    }
    
            
}
