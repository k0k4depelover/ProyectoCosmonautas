
package GestionDeMisiones;


public class Astronauta {
    public String nomAstro, apellAstro, nacionalidadAstro;
    
    public Astronauta(String nomAstro, String apellAstro, String nacionalidadAstro){
        this.nomAstro=nomAstro;
        this.apellAstro=apellAstro;
        this.nacionalidadAstro=nacionalidadAstro;
    }
    
    public String obtenerNombreAstro(){
        return this.nomAstro;
    }
        public String obtenerApellAstro(){
        return this.apellAstro;
    }
    public String obtenerNacionAstro(){
        return this.nacionalidadAstro;
    } 
    public void establecerNombreAstro(String nomAstro){
        this.nomAstro=nomAstro;
    }
    public void establecerApellAstro(String nomAstro){
        this.nomAstro=nomAstro;
    }
    public void establecerNacionAstro(String nacionAstro){
        this.nacionalidadAstro=nacionAstro;
    }
}
