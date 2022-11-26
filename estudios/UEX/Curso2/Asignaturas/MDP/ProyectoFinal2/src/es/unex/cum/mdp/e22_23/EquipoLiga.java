package es.unex.cum.mdp.e22_23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Clase EquipoLiga
 * Representa cada una de las participaciones que ha tenido
 * un determinado equipo en alguna liga de los campeonatos.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 */

public class EquipoLiga {

    //Atributos
    protected int coef; //Representa el coeficiente del equipo.
    protected Equipo e; //Almacena el equipo asociado a este EquipoLiga.
    protected Estadistica est;  //Representa la estadística para el equipoLiga.
    protected ArrayList<Jugador> jugadores;

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public EquipoLiga() {
        coef = 0;
        e = new Equipo();
        est = new EstadisticaPetanca(); //Campeonato Petanca.
        jugadores = new ArrayList<Jugador>();

    }


    /**
     * Constructor parametrizado.
     * @param coef  Recibe un valor de tipo entero
     * @param e Recibe un objeto de tipo Equipo
     * @param est  Recibe un objeto de tipo Estadistica
     */
    public EquipoLiga(int coef, Equipo e, EstadisticaPetanca est) {
        this.coef = coef;
        this.e = e;
        this.est = est;
        this.jugadores = new ArrayList<Jugador>();
    }

    //Getter

    /**
     * Recupera el valor del atributo coef
     *
     * @return nombre Devuelve un valor de tipo entero
     */
    public int getCoef() {
        return coef;
    }

    /**
     * Recupera el valor del objeto e
     *
     * @return nombre Devuelve un objeto de tipo Equipo
     */
    public Equipo getE() {
        return e;
    }

    /**
     * Recupera el valor del objeto est
     *
     * @return nombre Devuelve un objeto de tipo Estadistica
     */
    public Estadistica getEst() {
        return est;
    }

    /**
     * Recupera el objeto jugadores de la clase ArrayList
     *
     * @return nombre Devuelve una lista de tipo Jugador
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    //addJugador

    /**
     * Añadimos un jugador a la lista de jugadores del EquipoLiga
     * @param j Recibe un objeto de tipo Jugador
     * @return  booleano Devuelve un valor booleano
     * <ul>
     *     <li>True: Se inserta el jugador</li>
     *     <li>False: NO se inserta el jugador</li>
     * </ul>
     */
    public boolean addJugadores(Jugador j){
        boolean insertado = false;
        if(j!=null && jugadores != null){
            Jugador jaux = getJugadorId(j.getId());
            if(jaux == null){
                insertado = jugadores.add(j);
            }
        }
        return insertado;
    }

    //getJugador por id

    /**
     * Obtenemos un jugador dado su id
     * @param id    Recibe un valor de tipo entero
     * @return  Devuelve un objeto de tipo Jugador
     * <ul>
     *     <li>NULL: Si el jugador ya existe</li>
     *     <li>NO NULL: Si no existe el jugador</li>
     * </ul>
     */
    public Jugador getJugadorId(int id){
        Jugador j = null;
        Iterator<Jugador> it = jugadores.iterator();
        while(it.hasNext() && j == null){
            Jugador jug = it.next();
            if(jug.getId() == id){
                j=jug;
            }

        }
        return j;
    }

    //Setter

    /**
     * Modifica el valor del atributo coef
     *
     * @param coef Recibe un valor de tipo entero
     */
    public void setCoef(int coef) {
        this.coef = coef;
    }


    /**
     * Modifica el objeto e
     *
     * @param e Recibe un objeto de tipo Equipo
     */
    public void setE(Equipo e) {
        this.e = e;
    }

    /**
     * Modifica el objeto est
     *
     * @param est Recibe un objeto de tipo Estadistica
     */
    public void setEst(Estadistica est) {
        this.est = est;
    }

    /**
     * Modifica el objeto jugadores de la clase ArrayList.
     *
     * @param jugadores Recibe una lista de tipo Jugador
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Redefine el método equals de la clase Object, que comprueba la igualdad
     * de todos los atributos y objetos de la clase Persona.
     *
     * @param o Recibe un objeto de tipo Object.
     * @return booleano Devuelve un valor de tipo booleano
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipoLiga that = (EquipoLiga) o;
        return coef == that.coef && Objects.equals(e, that.e) && Objects.equals(est, that.est) && Objects.equals(jugadores, that.jugadores);
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(coef, e, est, jugadores);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EquipoLiga{");
        sb.append("coef=").append(coef);
        sb.append(", e=").append(e);
        sb.append(", est=").append(est);
        sb.append(", jugadores=").append(jugadores);
        sb.append('}');
        return sb.toString();
    }
}
