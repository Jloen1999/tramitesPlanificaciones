package es.unex.cum.mdp.e22_23.Partido;

import es.unex.cum.mdp.e22_23.enfrentamiento.EnfrentamientoPetanca;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.persona.Juez;
import es.unex.cum.mdp.e22_23.persona.Jugador;

import java.util.*;

/**
 * Clase Partido
 * Contiene información de los partidos de cad Jornada.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 */
public abstract class Partido {

    //Atributos
    private int id; //Almacena el identificador del partido
    private int puntosLocal;    //Almacena el número de enfrentamientos que ha ganado el equipo local
    private int puntosVisitante;    //Almacena el número de enfrentamientos que ha ganado el equipo visitante
    private static int numEnfrentamiento = 3; //Total de enfrentamientos por partido

    private EquipoLiga local; //Almacena el equipo local del partido
    private EquipoLiga visitante; //Almacena el equipo visitante del partido
    private Juez j; //Almacena el juez que arbitrará todos los enfrentamientos de un partido.
    private List<EnfrentamientoPetanca> es;   //Lista de los distintos enfrentamientos que tendrá el partido.

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la clase.
     */
    public Partido() {
        id = 0;
        puntosLocal = 0;
        puntosVisitante = 0;
        local = new EquipoLiga();
        visitante = new EquipoLiga();
        j = new Juez();
        es = new LinkedList<EnfrentamientoPetanca>();
    }


    /**
     * Constructor parametrizado.
     *
     * @param id              Variable de tipo entero. Recibe el identificador de un partido
     * @param puntosLocal     Variable de tipo entero. Recibe los puntos(coeficiente) del equipoLiga Local
     * @param puntosVisitante Variable de tipo entero.  Recibe los puntos(coeficiente) del equipoLiga Visitante
     * @param local           Objeto de tipo EquipoLiga. Recibe un objeto el equipoLiga Local
     * @param visitante       Objeto de tipo EquipoLiga. Recibe un objeto del tipo equipoLiga Visitante
     */
    public Partido(int id, int puntosLocal, int puntosVisitante, EquipoLiga local, EquipoLiga visitante) {
        this.id = id;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.local = local;
        this.visitante = visitante;
        this.j = new Juez();
        this.es = new LinkedList<EnfrentamientoPetanca>();
    }


    /**
     * Constructor copia.
     *
     * @param p         Objeto de tipo Partido. Recibe el partido
     * @param local     Objeto de tipo EquipoLiga. Recibe el equipoLiga Local
     * @param visitante Objeto de tipo EquipoLiga. Recibe el equipoLiga Visitante
     */
    public Partido(Partido p, EquipoLiga local, EquipoLiga visitante) {
        id = p.id;
        puntosLocal = p.puntosLocal;
        puntosVisitante = p.puntosVisitante;
        this.local = local;
        this.visitante = visitante;
        j = p.j;
        es = p.es;
    }

    /**
     * Constructor copia.
     *
     * @param id        Variable de tipo entero. Recibe el identificador del partido
     * @param local     Objeto de tipo EquipoLiga. Recibe el equipoLiga Local
     * @param visitante Objeto de tipo EquipoLiga. Recibe el equipoLiga Visitante
     */
    public Partido(int id, EquipoLiga local, EquipoLiga visitante) {
        this.id = id;
        this.local = local;
        this.visitante = visitante;
        puntosLocal = 0;
        puntosVisitante = 0;
        j = new Juez();
        es = new LinkedList<EnfrentamientoPetanca>();
    }

    /**
     * Constructor Copia
     *
     * @param id Variable de tipo entero. Recibe el id del Partido
     */
    public Partido(int id) {
        this.id = id;
        puntosLocal = 0;
        puntosVisitante = 0;
        local = new EquipoLiga();
        visitante = new EquipoLiga();
        j = new Juez();
        es = new LinkedList<EnfrentamientoPetanca>();
    }

    //Getters

    /**
     * Recupera el identificador del partido
     *
     * @return id Variable de tipo entero. Devuelve identificador del partido
     */
    public int getId() {
        return id;
    }

    /**
     * Recupera el valor del atributo puntosLocal
     *
     * @return puntosLocal Variable de tipo entero. Devuelve los puntos del EquipoLiga Local
     */
    public int getPuntosLocal() {
        return puntosLocal;
    }

    /**
     * Recupera el valor del atributo puntosVisitante
     *
     * @return puntosVisitante Variable de tipo entero. Devuelve los puntos del EquipoLiga Local
     */
    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    /**
     * Recupera el valor del atributo numEnfrentamiento
     *
     * @return numEnfrentamiento Variable de tipo entero. Devuelve el número máximo de enfrentamientos por partido.
     */
    public static int getNumEnfrentamiento() {
        return numEnfrentamiento;
    }

    /**
     * Recupera el objeto equipoLiga local
     *
     * @return local Objeto de tipo EquipoLiga Local. Devuelve el equipoLiga Local
     */
    public EquipoLiga getLocal() {
        return local;
    }

    /**
     * Recupera el objeto equipoLiga Visitante
     *
     * @return visitante Objeto de tipo EquipoLiga Local. Devuelve el equipoLiga Visitante
     */
    public EquipoLiga getVisitante() {
        return visitante;
    }

    /**
     * Recupera el objeto Juez
     *
     * @return j Objeto de tipo Juez. Devuelve el Juez del Partido.
     */
    public Juez getJ() {
        return j;
    }

    /**
     * Recupera la lista de Enfrentamientos
     *
     * @return es Objeto de tipo EnfrentamientoPetanca. Devuelve la lista de enfrentamientos Petanca
     */
    public List<EnfrentamientoPetanca> getEnfrentamientos() {
        return es;
    }

    /**
     * Recupera la lista de Enfrentamientos
     *
     * @return es Objeto de tipo EnfrentamientoPetanca. Devuelve la lista de enfrentamientos Petanca
     */
    public List<EnfrentamientoPetanca> getEs() {
        return es;
    }
    //Setters

    /**
     * Modifica el identificador del Partido
     *
     * @param id Variable de tipo entero. Recibe el identificador de un Partido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Modifica los puntos del equipoLiga Local
     *
     * @param puntosLocal Variable de tipo entero. Recibe los puntos del equipoLiga Local
     */
    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    /**
     * Modifica los puntos del equipoLiga Visitante
     *
     * @param puntosVisitante Variable de tipo entero. Recibe los puntos del equipoLiga Visitante
     */
    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    /**
     * Modifica el total de enfrentamientos de un partido
     *
     * @param numEnfrentamiento Variable de tipo entero. Recibe el total de enfrentamientos de un partido
     */
    public static void setNumEnfrentamiento(int numEnfrentamiento) {
        Partido.numEnfrentamiento = numEnfrentamiento;
    }

    /**
     * Modifica un objeto de tipo EquipoLiga Local.
     *
     * @param local Objeto de tipo EquipoLiga Local. Recibe un objeto de tipo EquipoLiga Local.
     */
    public void setLocal(EquipoLiga local) {
        this.local = local;
    }

    /**
     * Modifica un objeto de tipo EquipoLiga Visitante
     *
     * @param visitante Objeto de tipo EquipoLiga Visitante. Recibe un objeto de tipo EquipoLiga Visitante.
     */
    public void setVisitante(EquipoLiga visitante) {
        this.visitante = visitante;
    }

    /**
     * Modifica un objeto de tipo Juez.
     *
     * @param j Objeto de tipo Juez. Recibe un objeto de tipo Juez.
     */
    public void setJ(Juez j) {
        this.j = j;
    }

    public void setEs(List<EnfrentamientoPetanca> es) {
        this.es = es;
    }

    //Métodos a implementar

    /**
     * Obtenemos un enfrentamiento dado su id
     *
     * @param id Variable de tipo entero. Recibe el identificador de un enfrentamiento.
     * @return Objeto de tipo EnfrentamientoPetanca. Devuelve un objeto de tipo enfrentamiento Petanca
     * <ul>
     *     <li>NO NULL: Si ya existe un enfrentamiento con ese id.</li>
     *     <li>NULL: Si no existe un enfrentamiento con ese id.</li>
     * </ul>
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/master/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/Partido/Clase%20Partido.md#getenfrentamientoidint-id">Prerrequisitos y Flujo normal y alterno</a>
     */
    public EnfrentamientoPetanca getEnfrentamientoId(int id) {
        EnfrentamientoPetanca enf = null;
        if (es != null && id >= 0) { //Comprobamos que el id pasado por parámetro no sea menor que 0 y que la lista de enfrentamientos no sea nula.
            //Iteramos la lista de enfrentamientos
            Iterator<EnfrentamientoPetanca> it = es.iterator();
            while (it.hasNext() && enf == null) {
                EnfrentamientoPetanca enf1 = it.next(); //Obtenemos cada uno de los enfrentamientos
                //comparamos el id de cada enfrentamiento con el id pasado por parámetro
                if (enf1.getId() == id) { //Si son iguales
                    enf = enf1; //Obtenemos dicho enfrentamiento->NO NULL
                }//En caso contrario devolvemos NULL

            }
        }

        return enf;
    }

    //addEnfrentamientos

    /**
     * Añadimos un enfrentamiento a la lista de enfrentamientos de un Partido
     *
     * @param enf Objeto de tipo EnfrentamientoPetanca. Recibe un objeto de tipo EnfrentamientoPetanca
     * @return Variable de tipo booleano. Devuelve:
     * <ul>
     *     <li>true: Si se inserta el enfrentamiento</li>
     *     <li>false: Si NO se inserta el enfrentamiento</li>
     * </ul>
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/master/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/Partido/Clase%20Partido.md#addenfrentamientosenfrentamientopetanca-enf">Prerrequisitos y Flujo normal y alterno</a>
     * @see Partido#getEnfrentamientoId(int)
     */
    public boolean addEnfrentamientos(EnfrentamientoPetanca enf) {
        boolean insertado = false;
        /*Reutilizamos el método getEnfrentamientoId, el cual devuelve null si no existe el enfrentamiento
         * En caso contrario devuelve un enfrentamiento
         */

        EnfrentamientoPetanca enf1 = getEnfrentamientoId(enf.getId());
        if (enf != null && enf1 == null) { //Si devuelve null es porque el enfrentamiento no existe
            insertado = es.add(enf); //entonces procedemos a añadirlo. Devuelve true
        }//En caso contrario devuelve false
        return insertado;
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
        Partido partido = (Partido) o;
        return id == partido.id && puntosLocal == partido.puntosLocal && puntosVisitante == partido.puntosVisitante && numEnfrentamiento == numEnfrentamiento;
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, puntosLocal, puntosVisitante, numEnfrentamiento);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Partido{");
        sb.append("id=").append(id);
        sb.append(", puntosLocal=").append(puntosLocal);
        sb.append(", puntosVisitante=").append(puntosVisitante);
        sb.append(", local=").append(local);
        sb.append(", visitante=").append(visitante);
        sb.append(", j=").append(j);
        sb.append(", es=").append(es);
        sb.append('}');
        return sb.toString();
    }

    //Metodos a implementar en las clases derivadas->PartidoPetanca y PartidoFutbolin
    public abstract boolean simular();

    public abstract boolean jugar(int[] puntosLocal, int[] puntosVis);

    public abstract void actualizarEstadistica();

    public abstract void crearEnfrentamientos(List<Jugador> lLocal, List<Jugador> lVis);


}
