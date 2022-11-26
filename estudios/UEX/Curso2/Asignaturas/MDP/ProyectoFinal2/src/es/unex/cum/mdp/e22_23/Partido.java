package es.unex.cum.mdp.e22_23;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Partido
 * Contiene información de los partidos de cad Jornada.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 */
public abstract class  Partido {

    //Atributos
    private int id; //Almacena el identificador del partido
    private int puntosLocal;    //Almacena el número de enfrentamientos que ha ganado el equipo local
    private int puntosVisitante;    //Almacena el número de enfrentamientos que ha ganado el equipo visitante
    private static int numEnfrentamiento=3;

    private EquipoLiga local; //Almacena el equipoLiga local del partido
    private EquipoLiga visitante; //Almacena el equipoLiga visitante del partido
    private Juez j; //Almacena el juez que arbitrará todos los enfrentamientos de este partido.
    private LinkedList<EnfrentamientoPetanca> es;   //Lista de los distintos enfrentamientos que tendrá el partido.
    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos de la
     * clase.
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
     * @param id    Recibe un valor de tipo entero
     * @param puntosLocal   Recibe un valor de tipo entero
     * @param puntosVisitante   Recibe un valor de tipo entero
     * @param local Recibe un objeto de tipo EquipoPetanca
     * @param visitante Recibe un objeto de tipo EquipoPetanca
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
     * @param p Recibe un objeto de Partido
     * @param local Recibe un objeto de tipo Equipo
     * @param visitante Recibe un objeto de tipo Equipo
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
     * @param id    Recibe un valor de tipo entero
     * @param local Recibe un objeto de tipo Equipo
     * @param visitante Recibe un objeto de tipo Equipo
     */
    public Partido(int id, EquipoLiga local, EquipoLiga visitante) {
        this.id = id;
        puntosLocal = 0;
        puntosVisitante = 0;
        this.local = local;
        this.visitante = visitante;
        j = new Juez();
        es = new LinkedList<EnfrentamientoPetanca>();
    }
    //Getter

    /**
     * Recupera el valor del atributo id
     *
     * @return id Devuelve un valor de tipo entero
     */
    public int getId() {
        return id;
    }

    /**
     * Recupera el valor del atributo puntosLocal
     *
     * @return puntosLocal Devuelve un valor de tipo entero
     */
    public int getPuntosLocal() {
        return puntosLocal;
    }

    /**
     * Recupera el valor del atributo puntosVisitante
     *
     * @return puntosVisitante Devuelve un valor de tipo entero
     */
    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    /**
     * Recupera el valor del atributo numEnfrentamiento
     *
     * @return numEnfrentamiento Devuelve un valor de tipo entero
     */
    public int getNumEnfrentamiento() {
        return numEnfrentamiento;
    }

    /**
     * Recupera el valor del atributo local
     *
     * @return local Devuelve un objeto de tipo EquipoPetanca
     */
    public EquipoLiga getLocal() {
        return local;
    }

    /**
     * Recupera el valor del atributo visitante
     *
     * @return visitante Devuelve un objeto de tipo EquipoPetanca
     */
    public EquipoLiga getVisitante() {
        return visitante;
    }

    /**
     * Recupera el valor del atributo j
     *
     * @return j Devuelve un objeto de tipo Juez
     */
    public Juez getJ() {
        return j;
    }

//addEnfrentamientos

    /**
     * Añadimos un jugador a la lista de Enfrentamientos de un partido
     * @param e Recibe un objeto de tipo Enfrentamiento
     * @return  booleano Devuelve un valor booleano
     * <ul>
     *     <li>True: Se inserta el Enfrentamiento</li>
     *     <li>False: NO se inserta el Enfrentamiento</li>
     * </ul>
     */
    public boolean addEnfrentamientos(EnfrentamientoPetanca e){
        boolean insertado = false;
        if(e!=null && es != null){
            EnfrentamientoPetanca eaux = getEnfrentamiento(e.getId());
            if(eaux == null){
                insertado = es.add(e);
            }
        }
        return insertado;
    }

    //getEnfrentamiento por id

    /**
     * Obtenemos un Enfrentamiento dado su id
     * @param id    Recibe un valor de tipo entero
     * @return  Devuelve un objeto de tipo Enfrentamiento
     * <ul>
     *     <li>NULL: Si el Enfrentamiento ya existe</li>
     *     <li>NO NULL: Si no existe el Enfrentamiento/li>
     * </ul>
     */
    public EnfrentamientoPetanca getEnfrentamiento(int id){
        EnfrentamientoPetanca e = null;
        Iterator<EnfrentamientoPetanca> it = es.iterator();
        while(it.hasNext() && e == null){
            EnfrentamientoPetanca e1 = it.next();
            if(e1.getId() == id){
                e=e1;
            }

        }
        return e;
    }

    public List<EnfrentamientoPetanca> getEnfrentamientos(){
        return es;
    }
    //Setter

    /**
     * Modifica el valor del atributo id
     * @param id Recibe un valor de tipo entero
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Modifica el valor del atributo puntosLocal
     * @param puntosLocal Recibe un valor de tipo entero
     */
    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    /**
     * Modifica el valor del atributo puntosVisitante
     * @param puntosVisitante Recibe un valor de tipo entero
     */
    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
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
        return id == partido.id && puntosLocal == partido.puntosLocal && puntosVisitante == partido.puntosVisitante && numEnfrentamiento == partido.numEnfrentamiento;
    }

    /**
     * Devuelve un código hash para el objeto
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, puntosLocal, puntosVisitante, numEnfrentamiento);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Partido{");
        sb.append("id=").append(id);
        sb.append(", puntosLocal=").append(puntosLocal);
        sb.append(", puntosVisitante=").append(puntosVisitante);
        sb.append(", numEnfrentamiento=").append(numEnfrentamiento);
        sb.append('}');
        return sb.toString();
    }

    //Metodos a implementar en las clases derivadas
    public abstract void simular();
    public abstract void jugar(int[] golLocal, int[] golVis);
    public abstract void actualizarEstadistica();
    public abstract void crearEnfrentamientos(List lLocal, List lVis);
}
