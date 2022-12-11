package es.unex.cum.mdp.e22_23.equipo;

import es.unex.cum.mdp.e22_23.estadistica.Estadistica;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaFutbolin;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.persona.Jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Clase EquipoLiga
 * Representa cada una de las participaciones que ha tenido
 * un determinado equipo en alguna liga de los campeonatos.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 * @see Equipo
 * @see Estadistica
 * @see Jugador
 */

public class EquipoLiga {

    //Atributos
    protected int coef; //Representa el coeficiente o puntuación del EquipoLiga.
    protected Equipo e; //Almacena el equipo asociado a este EquipoLiga.
    protected Estadistica est;  //Representa la estadística para el EquipoLiga.
    protected List<Jugador> jugadores;

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public EquipoLiga() {
        coef = 0;
        e = new Equipo();
        est = new EstadisticaPetanca();
        jugadores = new ArrayList<Jugador>();

    }


    /**
     * Constructor parametrizado.
     *
     * @param coef Variable de tipo entero. Recibe el coeficiente del equipoLiga
     * @param e Objeto de tipo Equipo. Recibe un equipo.
     * @param est Objeto de tipo Estadística. Recibe la estadística del equipoLiga.
     */
    public EquipoLiga(int coef, Equipo e, Estadistica est) {
        this.coef = coef;
        this.e = e;
        this.est = est;
        this.jugadores = new ArrayList<Jugador>();
    }

    /**
     *
     * @param coef Variable de tipo entero. Recibe el coeficiente del equipoLiga
     * @param build Recibe un objeto build
     */
    public EquipoLiga(int coef, Equipo build) {
        this.coef = coef;
        jugadores = new ArrayList<Jugador>();
        this.e = build;
        est = new EstadisticaPetanca(); //Campeonato Petanca.

    }

    //Getters

    /**
     * Recupera el coeficiente de un equipoLiga
     *
     * @return coef Variable de tipo entero. Devuelve el coeficiente de un equipoLiga.
     */
    public int getCoef() {
        return coef;
    }

    /**
     * Recupera un equipo.
     *
     * @return e Objeto de tipo Equipo. Devuelve un equipo.
     */
    public Equipo getE() {
        return e;
    }

    /**
     * Recupera la estadistica de un equipoLiga
     *
     * @return est Objeto de tipo EstadisticaPetanca. Devuelve la estadistica de un equipoLiga.
     */
    public Estadistica getEst() {
        return est;
    }

    /**
     * Recupera una lista de jugadores.
     *
     * @return jugadores Devuelve una lista de jugadores.
     */
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    //Setters

    /**
     * Modifica el coeficiente de un equipoLiga
     *
     * @param coef Variable de tipo entero. Recibe el coeficiente de un equipoLiga.
     */
    public void setCoef(int coef) {
        this.coef = coef;
    }


    /**
     * Modifica un equipo
     *
     * @param e Objeto de tipo Equipo. Recibe un equipo.
     */
    public void setE(Equipo e) {
        this.e = e;
    }

    /**
     * Modifica el objeto est
     *
     * @param est Recibe un objeto de tipo Estadistica
     */
    public void setEst(EstadisticaPetanca est) {
        this.est = est;
    }

    /**
     * Modifica el objeto jugadores de la clase ArrayList.
     *
     * @param jugadores Recibe una lista de tipo Jugador
     */
    public void setJugadores(List<Jugador> jugadores) {
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


            //TODO: Métodos a implementar.
    /**
     * Añadimos un jugador a la lista de jugadores del EquipoLiga
     *
     * @param j Objeto de tip Jugador. Recibe un Jugador.
     * @return booleano Devuelve un valor booleano
     * <ul>
     *     <li>True: Se inserta el jugador</li>
     *     <li>False: NO se inserta el jugador</li>
     * </ul>
     */
    public boolean addJugadores(Jugador j) {
        boolean insertado = false;
        if (j != null) { //Si el jugador pasado como parámetro no es nulo.
            Jugador jaux = getJugadorId(j.getId());
            if (jaux == null) { //Si no existe el jugador
                insertado = jugadores.add(j); //Añadimos a la lista de jugadores del EquipoLiga
            }//En caso contrario ya existe el jugador y no se puede añadir.
        }
        return insertado; //Devuelve true si se ha añadido correctamente el jugador
                            //En caso contrario devuelve false->Ya existe el jugador.
    }

    /**
     * Obtenemos un jugador dado su id
     *
     * @param id Recibe el identificador del jugador.
     * @return Devuelve un objeto de tipo Jugador.
     * <ul>
     *     <li>NULL: Si NO existe el jugador</li>
     *     <li>NO NULL: Si existe el jugador</li>
     * </ul>
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/c237c7ba3c4478ce1b0e9c6b9f56c28be1f44fb4/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Metodos/Metodos.md#getjugadorint-idjugador">Flujo normal y alterno</a>
     */
    public Jugador getJugadorId(int id) {
        Jugador j = null;
        //Comprobamos de que el la lista de jugadores no sea nula y que el id pasado como parámetro no sea menor que 0.
        if (jugadores != null && id>=0) {  //Si se cumple.
            //Iteramos la lista de jugadores
            Iterator<Jugador> it = jugadores.iterator();
            while (it.hasNext() && j == null) {
                Jugador jug = (Jugador) it.next();
                //Comparamos el id de cada uno de los jugadores con el id pasado como parámetro.
                if (jug.getId() == id) {  //Si son iguales.
                    j = jug; //Obtenemos el jugador
                }

            }
        } //En caso contrario devolvemos null.

        return j; //Si existe el Jugador devuelve el Jugador
    }


}