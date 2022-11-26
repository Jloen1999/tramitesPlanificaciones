package es.unex.cum.mdp.e22_23;

import java.util.Objects;

/**
 * Clase Derivada Jugador
 * Contiene Información de cada Jugador
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 * @see java.lang.Comparable
 * @see es.unex.cum.mdp.e22_23.Persona Clase Padre Persona
 */

public class Jugador extends Persona implements Comparable{

    //Atributos

    private String nick; //Almacena el nick (como se le conoce)
    private int coef;   //Almacena el coeficiente(puntuación del jugador)
    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public Jugador() {
        super();
        nick = new String();
        coef = 0;
    }

    /**
     * Constructor parametrizado.
     *
     * @param nombre Recibe un valor de tipo cadena.
     * @param id     Recibe un valor de tipo entero.
     * @param edad   Recibe un valor de tipo entero.
     * @param nick Recibe un valor de tipo cadena.
     */
    public Jugador(String nombre, int id, int edad, String nick, int coef) {
        super(nombre, id, edad);
        this.nick = nick;
        this.coef = coef;
    }

    /**
     * Constructor copia.
     *
     * @param p Recibe un objeto de tipo Persona.
     * @param nick Recibe un valor de tipo cadena.
     */
    public Jugador(Persona p, String nick) {
        super(p);
        this.nick = nick;
    }

    //Getter

    /**
     * Recupera el valor del atributo nick
     *
     * @return puesto Devuelve un valor de tipo cadena
     */
    public String getNick() {
        return nick;
    }

    /**
     * Recupera el valor del atributo coef
     *
     * @return coef Devuelve un valor de tipo entero
     */

    public int getCoef() {
        return coef;
    }

    //Setter

    /**
     * Modifica el valor del atributo nombre
     *
     * @param nick Recibe un valor de tipo cadena
     */

    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * Modifica el valor del atributo coef
     *
     * @param coef Recibe un valor de tipo entero
     */

    public void setCoef(int coef) {
        this.coef = coef;
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
        Jugador jugador = (Jugador) o;
        return coef == jugador.coef && Objects.equals(nick, jugador.nick);
    }

    /**
     * Devuelve un código hash para el objeto
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nick, coef);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jugador{");
        sb.append("nick='").append(nick).append('\'');
        sb.append(", coef=").append(coef);
        sb.append('}');
        return sb.toString();
    }


    /**
     * @param o the object to be compared.
     * @return  entero, Devuelve un 0 si igual, 1 si mayor, -1 si menor
     */
    @Override
    public int compareTo(Object o) {
        Jugador jug = (Jugador) o;
        return Integer.compare(coef, jug.getCoef());
    }
}
