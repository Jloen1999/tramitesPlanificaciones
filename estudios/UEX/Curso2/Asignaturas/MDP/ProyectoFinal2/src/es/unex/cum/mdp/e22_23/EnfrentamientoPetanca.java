package es.unex.cum.mdp.e22_23;

import java.util.Objects;

/**
 * Clase EnfrentamientoPetanca
 * Permite modelar cada uno de los enfrentamientos del campeonato de petanca que hay en un partido.
 * Implementa el interface Enfrentamiento.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 * @see es.unex.cum.mdp.e22_23.Enfrentamiento
 */

public class EnfrentamientoPetanca implements Enfrentamiento {

    //Atributos
    private int local;  //Puntuación obtenida por el equipo local
    private int visitante;  //Puntuación obtenida por el equipo visitante
    private int id; //identificador de enfrentamiento
    private Jugador jLocal1;    //Jugador 1 del equipo Local
    private Jugador jVis1;  //Jugador 1 del equipo Visitante

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public EnfrentamientoPetanca() {
        local = 0;
        visitante = 0;
        jLocal1 = new Jugador();
        jVis1 = new Jugador();
    }

    /**
     * Constructor parametrizado.
     * @param local Recibe un valor de tipo entero
     * @param visitante Recibe un valor de tipo entero
     * @param id    Recibe un valor de tipo entero
     * @param jLocal1   Recibe un valor de tipo Jugador
     * @param jVis1     Recibe un valor de tipo Jugador
     */
    public EnfrentamientoPetanca(int local, int visitante, int id, Jugador jLocal1, Jugador jVis1) {
        this.local = local;
        this.visitante = visitante;
        this.id = id;
        this.jLocal1 = jLocal1;
        this.jVis1 = jVis1;
    }

    //Getter

    /**
     * Recupera el valor del atributo local
     *
     * @return local Devuelve un valor de tipo entero
     */
    public int getLocal() {
        return local;
    }

    /**
     * Recupera el valor del atributo visitante
     *
     * @return visitante Devuelve un valor de tipo entero
     */
    public int getVisitante() {
        return visitante;
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
     * Recupera el valor del atributo jLocal1
     *
     * @return jLocal1 Devuelve un valor de tipo Jugador
     */
    public Jugador getjLocal1() {
        return jLocal1;
    }

    /**
     * Recupera el valor del atributo jVis1
     *
     * @return jVis1 Devuelve un valor de tipo Jugador
     */

    public Jugador getjVis1() {
        return jVis1;
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
        return local == that.local && visitante == that.visitante && id == that.id && Objects.equals(jLocal1, that.jLocal1) && Objects.equals(jVis1, that.jVis1);
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(local, visitante, id, jLocal1, jVis1);
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
        sb.append(", jLocal1=").append(jLocal1);
        sb.append(", jVis1=").append(jVis1);
        sb.append('}');
        return sb.toString();
    }

    /**
     * @param coefEqLocal Recibe el coeficiente o puntuación del equipo local
     * @param coefEqVis Recibe el coeficiente o puntuación del equipo visitante
     * @return entero Devuelve un valor de tipo entero
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
        return (coefEqLocal+jLocal1.getCoef())-(coefEqVis+jVis1.getCoef());
    }

    /**
     *
     */
    @Override
    public void operation() {

    }

    /**
     * @param gLocal
     * @param gVis
     * @return
     */
    @Override
    public int jugar(int gLocal, int gVis) {
        return gLocal-gVis;
    }

    /**
     *
     */
    @Override
    public void operation2() {

    }



}
