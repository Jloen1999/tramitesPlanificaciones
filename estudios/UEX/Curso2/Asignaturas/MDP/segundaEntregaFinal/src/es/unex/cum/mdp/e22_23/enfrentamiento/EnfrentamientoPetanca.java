package es.unex.cum.mdp.e22_23.enfrentamiento;

import es.unex.cum.mdp.e22_23.persona.Jugador;

import java.util.Objects;

/**
 * Clase EnfrentamientoPetanca
 * Permite modelar cada uno de los enfrentamientos del campeonato de petanca que hay en un partido.
 * Implementa el interface Enfrentamiento.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 * @see Enfrentamiento
 */

public class EnfrentamientoPetanca implements Enfrentamiento{

    //Atributos
    private int local;  //Puntuación obtenida por el equipo local
    private int visitante;  //Puntuación obtenida por el equipo visitante
    private int id; //identificador de enfrentamiento
    private Jugador jLocal;    //Jugador del equipo Local
    private Jugador jVis;  //Jugador del equipo Visitante

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public EnfrentamientoPetanca() {
        local = 0;
        visitante = 0;
        jLocal = new Jugador();
        jVis = new Jugador();
    }

    /**
     * Constructor parametrizado.
     * @param local Variable de tipo entero. Recibe los puntos locales
     * @param visitante Variable de tipo entero. Recibe los puntos visitante
     * @param id Variable de tipo entero. Recibe el identificador del enfrentamiento.
     * @param jLocal Objeto de tipo Jugador. Recibe el Jugador Local del enfrentamiento.
     * @param jVis Objeto de tipo Jugador. Recibe el Jugador Visitante del enfrentamiento.
     */
    public EnfrentamientoPetanca(int local, int visitante, int id, Jugador jLocal, Jugador jVis) {
        this.local = local;
        this.visitante = visitante;
        this.id = id;
        this.jLocal = jLocal;
        this.jVis = jVis;
    }

    /**
     * Constructor Copia
     */

    public EnfrentamientoPetanca(int id, Jugador jLocal, Jugador jVis){
        this.id = id;
        this.jLocal = jLocal;
        this.jVis = jVis;
    }

    //Getters

    /**
     * Recupera los puntos del equipo Local.
     *
     * @return local Variable de tip entero. Devuelve los puntos del equipo Local.
     */
    public int getLocal() {
        return local;
    }

    /**
     * Recupera los puntos del equipo Visitante.
     *
     * @return visitante Variable de tip entero. Devuelve los puntos del equipo Visitante.
     */
    public int getVisitante() {
        return visitante;
    }

    /**
     * Recupera el identificador del enfrentamiento.
     *
     * @return id Variable de tipo entero. Devuelve el identificador del enfrentamiento.
     */
    public int getId() {
        return id;
    }

    /**
     * Recupera un Jugador Local.
     *
     * @return jLocal Objeto de tipo Jugador. Devuelve un Jugador Local.
     */
    public Jugador getjLocal() {
        return jLocal;
    }

    /**
     * Recupera un Jugador Visitante.
     *
     * @return jVis Objeto de tipo Jugador. Devuelve un Jugador Visitante.
     */

    public Jugador getjVis() {
        return jVis;
    }


    //Setterss

    /**
     * Modifica los puntos del equipo Local.
     * @param local Variable de tipo entero. Recibe los puntos del equipo Local.
     */
    public void setLocal(int local) {
        this.local = local;
    }

    /**
     * Modifica los puntos del equipo Visitante.
     * @param visitante Variable de tipo entero. Recibe los puntos del equipo Visitante.
     */
    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    /**
     * Modifica el identificador del enfrentamiento.
     * @param id Variable de tipo entero. Recibe el identificador del enfrentamiento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Modifica un jugador Local.
     * @param jLocal Objeto de tipo Jugador. Recibe un jugador Local.
     */
    public void setjLocal(Jugador jLocal) {
        this.jLocal = jLocal;
    }

    /**
     * Modifica un jugador Visitante.
     * @param jVis Objeto de tipo Jugador. Recibe un jugador Visitante.
     */
    public void setjVis(Jugador jVis) {
        this.jVis = jVis;
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
        EnfrentamientoPetanca that = (EnfrentamientoPetanca) o;
        return local == that.local && visitante == that.visitante && id == that.id && Objects.equals(jLocal, that.jLocal) && Objects.equals(jVis, that.jVis);
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(local, visitante, id, jLocal, jVis);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EnfrentamientoPetanca{");
        sb.append("local=").append(local);
        sb.append(", visitante=").append(visitante);
        sb.append(", id=").append(id);
        sb.append(", jLocal=").append(jLocal);
        sb.append(", jVis=").append(jVis);
        sb.append("}");
        return sb.toString();
    }

    /**
     * Método que recibe el coeficiente del equipo local y del equipo visitante.
     * Devuelve un valor entero donde se ha usado el coeficiente del equipo local
     * junto con el coeficiente del jugador y se le ha restado el coeficiente del
     * equipo visitante junto con el coeficiente del jugador.
     *
     * @param coefEqLocal Recibe el coeficiente o puntuación del equipo local
     * @param coefEqVis Recibe el coeficiente o puntuación del equipo visitante
     * @return entero, Devuelve un valor de tipo entero
     * que representa el mejor coeficiente entre el equipo local y visitante
     * entero = (coefEqLocal+jLocal1.getCoef())-(coefEqVis+jVis1.getCoef())
     * <p>Valores</p>
     * <ul>
     *     <li>Valor Positivo:el equipo local junto con sus jugadores tiene
     *     mejor coeficiente que el equipo visitante </li>
     *     <li>Valor Negativo: el equipo local junto con sus jugadores tiene
     *     menor coeficiente que el equipo visitante </li>
     *     <li>Valor Nulo: Ambos equipos tienen el mismo coeficiente</li>
     * </ul>
     */
    @Override
    public int simular(int coefEqLocal, int coefEqVis) {
        this.local=coefEqLocal + jLocal.getCoef();
        this.visitante=coefEqVis + jVis.getCoef();
        return local-visitante;
    }


    /**
     * Método que recibe el número de puntos del equipo local y del equipo visitante
     * y al igual que antes se devuelve la resta de estos valores. Esta operación se utilizará
     * cuando el juez anote el resultado del enfrentamiento.
     * @param coefEqLocal Recibe el coeficiente del equipo Local.
     * @param coefEqVis Recibe el coeficiente del equipo Visitante.
     * @return entero Devuelve la diferencia entre el coeficiente del equipo Local y el visitante.
     */
    @Override
    public int jugar(int coefEqLocal, int coefEqVis) {
        local=coefEqLocal;
        visitante=coefEqVis;
        return local-visitante;
    }


}
