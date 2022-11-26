package es.unex.cum.mdp.e22_23;

import java.util.Objects;

/**
 * Clase Persona
 * Contiene información de cada Persona
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 */
public class Persona {

    //Atributos

    protected String nombre;
    protected int id; //Identificador único de cada Persona
    protected int edad;

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos de la
     * clase.
     */
    public Persona() {
        nombre = new String();
        id = 0;
        edad = 0;
    }

    /**
     * Constructor parametrizado.
     *
     * @param nombre Recibe un valor de tipo cadena.
     * @param id     Recibe un valor de tipo entero.
     * @param edad   Recibe un valor de tipo entero.
     */
    public Persona(String nombre, int id, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
    }

    /**
     * Constructor copia.
     *
     * @param p Recibe un objeto de tipo Persona.
     */
    public Persona(Persona p) {
        nombre = p.nombre;
        id = p.id;
        edad = p.edad;
    }

//Getter

    /**
     * Recupera el valor del atributo nombre
     *
     * @return nombre Devuelve un valor de tipo cadena
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Recupera el valor del atributo id
     *
     * @return id Devuelve un valor de tipo entero
     */

    public int getId() {
        return id;
    }

    /**
     * Recupera el valor del atributo edad
     *
     * @return edad Devuelve un valor de tipo entero
     */
    public int getEdad() {
        return edad;
    }

//Setter

    /**
     * Modifica el valor del atributo nombre
     *
     * @param nombre Recibe un valor de tipo cadena
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el valor del atributo id
     * @param id Recibe un valor de tipo entero
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Modifica el valor del atributo edad
     * @param edad Recibe un valor de tipo entero
     */

    public void setEdad(int edad) {
        this.edad = edad;
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
        Persona persona = (Persona) o;
        return id == persona.id && edad == persona.edad && Objects.equals(nombre, persona.nombre);
    }

    /**
     * Devuelve un código hash para el objeto
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, edad);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     * @return cadena Devuelve un valor de tipo cadena
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", id=").append(id);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }


}
