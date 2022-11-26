package es.unex.cum.mdp.e22_23;

import java.util.Objects;

/**
 * Clase Derivada Juez
 * Contiene Información de cada Juez.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 * @see es.unex.cum.mdp.e22_23.Persona Clase Padre Persona
 */

public class Juez extends Persona{

    //Atributos

    private int antiguedad; //Almacena la antigüedad como juez

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public Juez() {
        antiguedad = 0;
    }

    /**
     * Constructor parametrizado.
     *
     * @param nombre Recibe un valor de tipo cadena.
     * @param id     Recibe un valor de tipo entero.
     * @param edad   Recibe un valor de tipo entero.
     * @param antiguedad Recibe un valor de tipo entero.
     */
    public Juez(String nombre, int id, int edad, int antiguedad) {
        super(nombre, id, edad);
        this.antiguedad = antiguedad;
    }

    /**
     * Constructor copia.
     *
     * @param p Recibe un objeto de tipo Persona.
     * @param antiguedad Recibe un valor de tipo entero.
     */
    public Juez(Persona p, int antiguedad) {
        super(p);
        this.antiguedad = antiguedad;
    }

    //Getter

    /**
     * Recupera el valor del atributo antigüedad.
     *
     * @return antiguedad Devuelve un valor de tipo entero
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    //Setter

    /**
     * Modifica el valor del atributo antigüedad.
     *
     * @param antiguedad Recibe un valor de tipo entero
     */

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * Redefine el método equals de la clase Object, que comprueba la igualdad
     * de todos los atributos y objetos de la clase Persona.
     * @param o Recibe un objeto de tipo Object.
     * @return booleano Devuelve un valor de tipo booleano
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Juez directivo = (Juez) o;
        return antiguedad==directivo.antiguedad;
    }

    /**
     * Devuelve un código hash para el objeto
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), antiguedad);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Juez{");
        sb.append("antiguedad=").append(antiguedad);
        sb.append('}');
        return sb.toString();
    }
}
