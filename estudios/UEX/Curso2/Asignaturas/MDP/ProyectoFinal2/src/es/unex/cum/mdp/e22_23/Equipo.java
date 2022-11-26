package es.unex.cum.mdp.e22_23;

import java.util.Objects;

/**
 * Clase Equipo
 * Contiene Información de cada Jugador
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 */

public class Equipo {

    //Atributos
    protected String nombre;
    protected String ciudad;
    protected Directivo cargo;

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public Equipo() {
        nombre = new String();
        ciudad = new String();
        cargo = new Directivo();
    }


    /**
     * Constructor parametrizado.
     *
     * @param nombre Recibe un valor de tipo cadena.
     * @param ciudad     Recibe un valor de tipo cadena.
     * @param cargo   Recibe un valor de tipo Directivo.
     */

    public Equipo(String nombre, String ciudad, Directivo cargo) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cargo = cargo;
    }

    /**
     * Constructor copia.
     *
     * @param e Recibe un objeto de tipo Directivo.
     */
    public Equipo(Equipo e) {
        nombre = e.nombre;
        ciudad = e.ciudad;
        cargo =e.cargo;
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
     * Recupera el valor del atributo ciudad
     *
     * @return nombre Devuelve un valor de tipo cadena
     */

    public String getCiudad() {
        return ciudad;
    }

    /**
     * Recupera el valor del atributo cargo
     *
     * @return cargo Devuelve un objeto de tipo Directivo
     */

    public Directivo getCargo() {
        return cargo;
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
     * Modifica el valor del atributo ciudad
     *
     * @param ciudad Recibe un valor de tipo cadena
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Modifica el valor del atributo cargo
     *
     * @param cargo Recibe un objeto de tipo Directivo
     */
    public void setCargo(Directivo cargo) {
        this.cargo = cargo;
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
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre) && Objects.equals(ciudad, equipo.ciudad) && Objects.equals(cargo, equipo.cargo);
    }

    /**
     * Devuelve un código hash para el objeto
     * @return entero Devuelve un valor de tipo entero
     */

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ciudad, cargo);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", ciudad='").append(ciudad).append('\'');
        sb.append(", cargo=").append(cargo);
        sb.append('}');
        return sb.toString();
    }
}
