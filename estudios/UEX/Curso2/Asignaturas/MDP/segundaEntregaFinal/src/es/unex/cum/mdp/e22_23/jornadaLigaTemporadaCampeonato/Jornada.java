package es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato;

import es.unex.cum.mdp.e22_23.exceptions.NoPartidoException;
import es.unex.cum.mdp.e22_23.Partido.Partido;

import java.util.*;

/**
 * Clase Jornada
 * Representa cada una de las jornadas de una liga.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 * @see Partido
 * @see Date
 */

public class Jornada {
    private Date fecha;  //Fecha en la que se juega la jornada
    private int numero; //Identificador de jornada.
    private ArrayList<Partido> partidos;    //Lista de los distintos partidos que tendrá la jornada

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos de la
     * clase.
     */
    public Jornada() {
        fecha = new Date();
        numero = 0;
        partidos = new ArrayList<Partido>();
    }


    /**
     * Constructor parametrizado.
     *
     * @param fecha  Recibe un objeto de tipo Date(fecha)
     * @param numero Recibe un valor de tipo entero
     */
    public Jornada(Date fecha, int numero) {
        this.fecha = fecha;
        this.numero = numero;
        partidos = new ArrayList<Partido>();
    }

    /**
     * Constructor copia.
     *
     * @param j Recibe un objeto de tipo Jornada
     */

    public Jornada(Jornada j) {
        this.fecha = j.fecha;
        this.numero = j.numero;
        partidos = j.partidos;
    }

    /**
     * Constructor copia.
     *
     * @param numero Variable de tipo entero, recibe el numero(idenfiticador) de una jornada
     */
    public Jornada(int numero) {
        fecha = new Date();
        this.numero = numero;
        partidos = new ArrayList<>();
    }

    //Getters

    /**
     * Recupera la fecha de una Jornada.
     *
     * @return fecha objeto de tipo Date. Devuelve la fecha de una Jornada.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Recupera el numero de una Jornada
     *
     * @return numero Variable de tipo entero. Devuelve el numero(identificador) de una Jornada.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Recupera una lista de partidos
     *
     * @return partidos Devuelve una lista de tipo Partido.
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    //Setters

    /**
     * Modifica la fecha de una Jornada.
     *
     * @param fecha objeto de tipo Date. Recibe la fecha de una Jornada.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Modifica el numero de una Jornada.
     *
     * @param numero Variable de tipo entero. Recibe el numero de una Jornada.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Modifica la lista de partidos
     *
     * @param partidos Recibe una lista de partidos.
     */
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
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
        Jornada jornada = (Jornada) o;
        return numero == jornada.numero && Objects.equals(fecha, jornada.fecha) && Objects.equals(partidos, jornada.partidos);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jornada{");
        sb.append("fecha=").append(fecha);
        sb.append(", numero=").append(numero);
        sb.append(", partidos=").append(partidos);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(fecha, numero, partidos);
    }

    /**
     * Obtenemos un partido dado su numero(id)
     *
     * @param numero Recibe un valor de tipo entero
     * @return Devuelve un objeto de tipo Partido
     * <ul>
     *     <li>NULL: Si NO existe el partido</li>
     *     <li>NO NULL: Si existe el partido</li>
     * </ul>
     */
    public Partido getPartidoId(int numero) {
        Partido p = null;
        if (partidos != null && numero >= 0) { //Si el numero(identificador) del partido no es negativo y la lista de partidos no es nula
            Iterator<Partido> it = partidos.iterator();
            while (it.hasNext() && p == null) {
                Partido p1 = it.next();
                //Comparamos el id del partido con el identificador pasado como parámetro.
                if (p1.getId() == numero) { //Si son iguales
                    p = p1; //Obtenemos el partido, por lo tanto, será el partido que devolverá la función.
                }

            }
        }//En caso contrario el método devuelve null

        return p;
    }

    /**
     * Añadimos un partido a la lista de partidos de una Jornada
     *
     * @param part Recibe un objeto de tipo Partido
     * @return booleano Devuelve un valor booleano
     * <ol>
     *     <li>True: Se inserta el partido</li>
     *     <li>False: NO se inserta el partido</li>
     * </ol>
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/c237c7ba3c4478ce1b0e9c6b9f56c28be1f44fb4/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Metodos/Metodos.md#addjugadorjugador-jboolean">Flujo normal y alterno</a>
     */
    public boolean addPartidos(Partido part) throws NoPartidoException {
        boolean insertado = false;
        if(part!=null) { //Si el partido no es nulo
            /*Si es nulo->No existe el partido, por lo tanto, se añade.
              Si no es nulo->Existe el partido
             */
            Partido part1 = getPartidoId(part.getId());
            if (part != null && part1 == null) { //Si NO existe el partido
                insertado = partidos.add(part); //Añadimos
            }
        }else{
            throw new NoPartidoException("Existe el partido"); //Si existe el partido
        }// En caso contrario devolvemos false.
        return insertado;
    }


    /**
     * Se encarga de realizar la simulación de todos los partidos de la
     * jornada. Tras cada partido, se debe actualizar las estadísticas.
     */
    public boolean simular() {
        boolean simulado = false;
        if (partidos != null) {  //Si la lista de partidos no es nula
            for (Partido p : partidos) {    //Recorremos dicha lista
               if(p.simular()){ //Simulamos cada uno de los partidos.
                   simulado = true;
                   p.actualizarEstadistica();  //Actualizamos las estadísticas de los equipos referidos de cada
                                                // partido siempre que el método simular devuelva true.
               }
            }
        }
        return simulado;
    }



    /**
     * Método que recibe dos arrays de entero con los puntos para el partido indicado por parámetro.
     * Tras el partido, se debe actualizar las estadísticas
     *
     * @param numPartido      Recibe el Identificador del partido.
     * @param puntosLocal     Recibe una lista con los puntos del equipo Local
     * @param puntosVisitante Recibe una lista con los puntos del equipo Visitante
     */
    public boolean jugar(int numPartido, int[] puntosLocal, int[] puntosVisitante) {
        boolean jugado = false;
        if (!partidos.isEmpty() && partidos != null && numPartido>=0) { //Si el numero(identificador) del partido no es negativo y la lista de partidos no está vacía y no es nula.
            Partido p = getPartidoId(numPartido);  //Si devuelve null->NO existe el partido con ese identificador
                                                    //NO null->Si existe el partido procedemos a jugar.
            if (p != null && p.jugar(puntosLocal, puntosVisitante)) {
                 jugado = true;
                //Actualizamos las estadísticas de cada uno de los equipos referidos siempre y cuando el método jugar devuelva true.
                p.actualizarEstadistica();
            }
        }

        return jugado;
    }

    /**
     * Consiste en crear enfrentamientos en cada uno de los partidos
     * de la lista partidos de Jornada
     */
    public void crearEnfrentamientosJornada() {
        if (!partidos.isEmpty()) {    //SI la lista de partidos no está vacía
            for (int i = 0; i < partidos.size(); i++) {
                //Creamos enfrentamientos por cada partido
                partidos.get(i).crearEnfrentamientos(partidos.get(i).getLocal().getJugadores(), partidos.get(i).getVisitante().getJugadores());
            }
        }

    }

}
