package es.unex.cum.mdp.e22_23.persona;

import java.util.Objects;

/**
 * Clase Derivada Directivo
 * Contiene Información de cada Juez.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 * @see Persona Clase Padre Persona
 */

public class Directivo extends Persona {

    //Atributos

    private String puesto; //Contiene Información del cargo

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public Directivo() {
        puesto = new String();
    }

    /**
     * Constructor parametrizado.
     *
     * @param nombre Recibe un valor de tipo cadena.
     * @param id     Recibe un valor de tipo entero.
     * @param edad   Recibe un valor de tipo entero.
     * @param puesto Recibe un valor de tipo cadena.
     */
    public Directivo(String nombre, int id, int edad, String puesto) {
        super(nombre, id, edad);
        this.puesto = puesto;
    }

    /**
     * Constructor copia.
     *
     * @param p Recibe un objeto de tipo Persona.
     * @param puesto Recibe un valor de tipo cadena.
     */
    public Directivo(Persona p, String puesto) {
        super(p);
        this.puesto = puesto;
    }

    //Getters

    /**
     * Recupera el valor del atributo nombre
     *
     * @return puesto Devuelve un valor de tipo cadena
     */
    public String getPuesto() {
        return puesto;
    }

    //Setters

    /**
     * Modifica el valor del atributo nombre
     *
     * @param puesto Recibe un valor de tipo cadena
     */

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
        Directivo directivo = (Directivo) o;
        return puesto.equals(directivo.puesto);
    }

    /**
     * Devuelve un código hash para el objeto
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), puesto);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Directivo{");
        sb.append("puesto='").append(puesto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
