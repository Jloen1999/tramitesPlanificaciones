package es.unex.cum.mdp.e22_23.persona;

import java.util.Objects;

/**
 * Clase Persona
 * Contiene información de cada Persona
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 */
public class Persona {

    //Atributos

    protected String nombre;
    protected int id; //Identificador único de cada Persona
    protected int edad;

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la clase.
     */
    public Persona() {
        nombre = new String();
        id = 0;
        edad = 0;
    }

    /**
     * Constructor parametrizado.
     *
     * @param nombre Variable de tipo cadena. Recibe el nombre de una persona.
     * @param id Variable de tipo entero. Recibe identificador de la Persona.
     * @param edad Variable de tipo entero. Recibe la edad de una persona.
     */
    public Persona(String nombre, int id, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
    }

    /**
     * Constructor copia.
     *
     * @param p Objeto de tipo Persona. Recibe un objeto de tipo Persona.
     */
    public Persona(Persona p) {
        nombre = p.nombre;
        id = p.id;
        edad = p.edad;
    }

//Getters

    /**
     * Recupera el nombre de una persona.
     *
     * @return nombre Variable de tipo cadena. Devuelve el nombre de una persona.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Recupera el identificador de una persona
     *
     * @return id Variable de tipo entero. Devuelve el identificador de una persona
     */

    public int getId() {
        return id;
    }

    /**
     * Recupera la edad de una Persona.
     *
     * @return edad Variable de tipo entero. Devuelve la edad de una Persona.
     */
    public int getEdad() {
        return edad;
    }

//Setters

    /**
     * Modifica el nombre de una persona.
     *
     * @param nombre Variable de tipo cadena. Recibe el nombre de una persona.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el identificador de una persona.
     * @param id Variable de tipo entero. Recibe el identificador de una persona.
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Modifica la edad de una persona
     * @param edad Variable de tipo entero. Recibe la edad de una persona.
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
