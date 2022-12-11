package es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato;

import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.Partido.PartidoPetanca;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.exceptions.NoLigaException;
import es.unex.cum.mdp.e22_23.exceptions.NoPartidoException;
import es.unex.cum.mdp.e22_23.utils.ShowPetanca;

import java.util.*;

/**
 * Clase Liga
 * Consiste en modelar cada una de las ligas de una temporada.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 2/12/2022
 * @see Jornada
 * @see EquipoLiga
 */
public class Liga {

    //Atributos
    private String nombre;  //Identificador de la Liga.
    private List<Jornada> calendario;  //Lista de las distintas jornadas.
    private List<EquipoLiga> equiposLiga; //Lista de los distintos equipos de la Liga.

//Contructores

    /**
     * Constructor por defecto
     */
    public Liga() {
        nombre = new String();
        calendario = new ArrayList<Jornada>();
        equiposLiga = new LinkedList<EquipoLiga>();
    }

    /**
     * Constructor Parametrizado
     *
     * @param nombre Variable de tipo cadena. Recibe el nombre(identificador) de la Liga
     * @param calendario Recibe una Lista de Jornadas.
     * @param equiposLiga Reciben una lista de equiposLiga
     */
    public Liga(String nombre, ArrayList<Jornada> calendario, LinkedList<EquipoLiga> equiposLiga) {
        this.nombre = nombre;
        this.calendario = calendario;
        this.equiposLiga = equiposLiga;
    }

    /**
     * Constructor Copia
     *
     * @param l, Recibe un objeto de tipo Liga
     */
    public Liga(Liga l) {
        this.nombre = l.nombre;
        this.calendario = l.calendario;
        this.equiposLiga = l.equiposLiga;
    }

    /**
     * Constructor Copia
     * @param name Recibe el nombre(identificador) de la Liga
     */
    public Liga(String name) {
        nombre = name;
        calendario = new ArrayList<Jornada>();
        equiposLiga = new LinkedList<EquipoLiga>();
    }

    //Getters

    /**
     * Recupera el nombre de la liga
     *
     * @return nombre Variable de tipo cadena. Devuelve el nombre de la Liga
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Recupera una lista de Jornadas.
     *
     * @return calendario Devuelve una lista de jornadas.
     */
    public List<Jornada> getCalendario() {
        return calendario;
    }

    /**
     * Recupera una lista de equipos de la Liga
     *
     * @return equiposLiga, Devuelve una lista de equipos de la Liga
     */
    public List<EquipoLiga> getEquiposLiga() {
        return equiposLiga;
    }

    //Setters

    /**
     * Modifica el nombre(identificador) de una Liga
     *
     * @param nombre Variable de tipo cadena. Recibe el nombre de una Jornada.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica una lista de Jornadas.
     *
     * @param calendario recibe una lista de jornadas.
     */
    public void setCalendario(List<Jornada> calendario) {
        this.calendario = calendario;
    }

    /**
     * Modifica la lista de equipos de la Liga
     *
     * @param equiposLiga Recibe una lista de equipos de la Liga
     */
    public void setEquiposLiga(List<EquipoLiga> equiposLiga) {
        this.equiposLiga = equiposLiga;
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
        Liga liga = (Liga) o;
        return Objects.equals(nombre, liga.nombre) && Objects.equals(calendario, liga.calendario) && Objects.equals(equiposLiga, liga.equiposLiga);
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, calendario, equiposLiga);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Liga{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", calendario=").append(calendario);
        sb.append(", equiposLiga=").append(equiposLiga);
        sb.append('}');
        return sb.toString();
    }

                //TODO: Métodos a implementar
    /**
     * Obtenemos una Jornada dado su numero(identificador)
     *
     * @param numJornada Recibe número(identificador) de la Jornada
     * @return Devuelve un objeto de tipo Jornada
     * <ul>
     *     <li>NULL: Si NO existe la Jornada</li>
     *     <li>NO NULL: Si existe la Jornada</li>
     * </ul>
     */
    public Jornada getJornadaNum(int numJornada) {
        Jornada jor = null;
        if (calendario != null && numJornada >= 0) { //Si la lista de Jornadas no es nula y el numero de la Jornada no es negativo
            Iterator<Jornada> it = calendario.iterator();
            while (it.hasNext() && jor == null) { //Iteramos la lista de jornadas
                Jornada jor1 = it.next(); //Obtenemos una jornada
                //Comparamos el id de cada una de las jornadas con el nmumero(id) pasado por parámetro.
                if (jor1.getNumero() == numJornada) { //Si son iguales
                    jor = jor1; //Obtenemos la jornada
                }

            }
        }//En caso contrario no existe la Jornada, el método devuelve null

        return jor; //Si existe el método devuelve la Jornada.
    }

    /**
     * Añadimos una Jornada a la lista de Jornadas de una Liga
     *
     * @param jor Recibe un objeto de tipo Jornada
     * @return booleano Devuelve un valor booleano
     * <ul>
     *     <li>True: Se inserta la Jornada</li>
     *     <li>False: NO se inserta la Jornada</li>
     * </ul>
     */
    public boolean addJornada(Jornada jor) {
        boolean insertado = false;
        Jornada jor1 = getJornadaNum(jor.getNumero()); //Si devuelve NULL->No existe la jornada
                                                        //No NULL->Existe la Jornada, entonces añadimos
        if (jor != null && jor1 == null) { //Si no existe la Jornada en la lista de jornadas ya existentes.
            insertado = calendario.add(jor); //Añadimos la Jornada, el método devuelve true.
        }//En caso contrario devuelve false.
        return insertado;
    }


//getEquipoLiga por nombre de equipoLiga

    /**
     * Obtenemos un equipoLiga dado su nombre
     *
     * @param name Recibe el nombre(identificador) del EquipoLiga
     * @return Devuelve un objeto de tipo equipoLiga
     * <ul>
     *     <li>NULL: Si NO existe equipoLiga</li>
     *     <li>NO NULL: Si existe el equipoLiga</li>
     * </ul>
     */
    public EquipoLiga getEquipoLiga(String name) {
        EquipoLiga eLiga = null;
        if (equiposLiga != null && name != null) { //SI la lista de equipos de la Liga y el nombre del equipoLiga no son nulos.
            Iterator<EquipoLiga> it = equiposLiga.iterator();
            while (it.hasNext() && eLiga == null) { //Iteramos la lista de equipos de la Liga
                EquipoLiga eLiga1 = (EquipoLiga) it.next(); //Obtenemos el equipoLiga
                if (eLiga1.getE().getNombre().equals(name)) { //Si el nombre del equipoLiga de la iteración es igual al pasado por parámetro
                    eLiga = eLiga1; //Almacenamos el equipoLiga, el cual devolverá la función..
                }

            }
        }//EN caso contrario el método devuelve null

        return eLiga;
    }

    /**
     * Añadimos un equipoLiga a la lista de equipos de la Liga
     *
     * @param eLiga Recibe un EquipoLiga
     * @return booleano Devuelve un valor booleano
     * <ul>
     *     <li>True: Se inserta el EquipoLiga</li>
     *     <li>False: NO se inserta el EquipoLiga</li>
     * </ul>
     */
    public boolean addEquipoLiga(EquipoLiga eLiga) {
        boolean insertado = false;
        if (eLiga != null && !equiposLiga.contains(eLiga)) { //SI el equipoLiga no es nulo y NO se encuentra en la lista de equiposLiga
            insertado = equiposLiga.add(eLiga); //Añadimos el equipo, devuelve true.
        }//En caso contrario devuelve false.
        return insertado;
    }


    /**
     * Se encarga de realizar la simulación de todas las jornadas
     * de la Liga.
     */
    public boolean simular() {
        if (!calendario.isEmpty() && calendario != null) {  //Si la lista de jornadas no está vacía y no es nula.
            for (Jornada jor : calendario) {    //Recorremos dicha lista
                jor.simular(); //Simulamos cada Jornada
            }
            return true;
        }
        return false;
    }

    /**
     * Método que recibe dos arrays de entero con los puntos para
     * la jornada indicada para el número de la Jornada indicada.
     *
     * @param numJornada      Recibe el número(identificador) de la Jornada.
     * @param puntosLocal     Recibe una lista con los puntos del equipo Local
     * @param puntosVisitante Recibe una lista con los puntos del equipo Visitante
     */
    public boolean jugar(int numJornada, int numPartido, int[] puntosLocal, int[] puntosVisitante) {
        if (!calendario.isEmpty() && calendario != null) { //comprobamos si la lista de jornadas no está vacía
            //Obtenemos la Jornada dado su numero.
            Jornada jor = getJornadaNum(numJornada);
            if (jor != null) { //Si existe la Jornada
                return jor.jugar(numPartido, puntosLocal, puntosVisitante); //Jugamos
            }//Si no existe la jornada no podemos jugar.

        }
        return false;
    }


    /**
     * Muestra las estadísticas de los equipos de una Liga.
     * @param lE Recibe la lista de equipos de una Liga.
     * @param tipo variable de tipo cadena, recibe el tipo de ordenación
     */
    public void MostrarEstadistica(List<EquipoLiga> lE, String tipo) throws NoLigaException {
        if (lE != null) { //Si la lista de equiposLiga no es nula
            ShowPetanca.showEstadisticas(equiposLiga, tipo); //Mostramos las estadísticas de una manera agradable.
        }else{
            throw new NoLigaException("No existe la Lista de equiposLiga"); //Si no existe la lista de equiposLiga
        }
    }


    /**
     * Se encarga de realizar el reparto de jornadas y partidos para los equipos existente en la liga.
     * @param tipo Variable de tipo cadena. Recibe el tipo de Campeonato(Petanca|Futbolin)
     * @return
     * <ul>
     *     <li>true: Si cumple las siguientes condiciones: <br>
     *       - la lista de equiposLiga no está vacía y no es nula<br>
     *       - el tamaño de la lista de jugadores de cada equipoLiga es mayor o igual al doble del total de enfrentamientos del partido
     *       </li>
     *     <li>false: En caso contrario</li>
     * </ul>
     */
    public boolean crearCalendario(String tipo) {
        int numTeams = equiposLiga.size();
        int numDays = (numTeams - 1); // Días que tendrá el torneo
        int halfSize = numTeams / 2; // cálculo de la mitad
        boolean numEnfPart2EqualJugadores = true;
        if (equiposLiga != null && !equiposLiga.isEmpty()) { //Si la lista de equiposLiga no está vacía y no es nula
            Iterator<EquipoLiga> it = equiposLiga.iterator();
            while (it.hasNext() && numEnfPart2EqualJugadores) {
                EquipoLiga eL = (EquipoLiga) it.next();
                if (eL.getJugadores().size() < Partido.getNumEnfrentamiento() * 2) {
                    //Si el tamaño de la lista de jugadores de cada equipoLiga es menor al doble total de enfrentamientos del partido
                    numEnfPart2EqualJugadores = false;
                }
            }
            //Si el número de jugadores de todos los equiposLiga es igual o mayor al doble total de enfrentamientos del partido
            if (numEnfPart2EqualJugadores) {
                // Copiamos la lista de jugadores
                List<EquipoLiga> teams = new ArrayList<EquipoLiga>();
                teams.addAll(equiposLiga); // Añado todos los equipos al temporal
                teams.remove(teams.get(0)); // Elimino el primer elemento
                int teamsSize = teams.size();

                for (int day = 0; day < numDays; day++) {
                    // Primer partido de la jornada
                    //System.out.println("Jornada: " + day);

                    int teamIdx = day % teamsSize;

                    // Creamos la jornada
                    Jornada jor = new Jornada(day);
                    // Creamos los partidos
                    Partido p = new PartidoPetanca(jor.getPartidos().size());
                    //Obtenemos los equipos
                    p.setLocal(teams.get(teamIdx)); //El siguiente->Local
                    p.setVisitante(equiposLiga.get(0)); //El anterior->Visitante

                    //Inicializamos las estadísticas de ambos equipos
                    if (tipo.equals("Petanca")) {
                        p.getLocal().setEst(new EstadisticaPetanca());
                        p.getVisitante().setEst(new EstadisticaPetanca());
                    }


                    // Creamos enfrentamiento para cada partido
                    p.crearEnfrentamientos(p.getLocal().getJugadores(), p.getVisitante().getJugadores());
                    try {
                        jor.addPartidos(p); //Añadimos el partido a la jornada después de haber creado los enfrentamientos
                    } catch (NoPartidoException e) { //En caso de que no exista el partido
                        System.out.println(e.getMessage());
                    }

                    // El resto de partidos de la jornada
                    for (int idx = 1; idx < halfSize; idx++) {
                        int firstTeam = (day + idx) % teamsSize;
                        int secondTeam = (day + teamsSize - idx) % teamsSize;
                        // Creamos el partido
                        Partido p2 = new PartidoPetanca(jor.getPartidos().size());
                        p2.setLocal(teams.get(firstTeam));
                        p2.setVisitante(teams.get(secondTeam));

                        // Inicializamos las estadísticas
                        if (tipo.equals("Petanca")) {
                            p2.getLocal().setEst(new EstadisticaPetanca());
                            p2.getVisitante().setEst(new EstadisticaPetanca());
                        }

                        // Creamos enfrentamiento para cada partido
                        p2.crearEnfrentamientos(p2.getLocal().getJugadores(), p2.getVisitante().getJugadores());
                        try {
                            jor.addPartidos(p2); //Añadimos el partido a la jornada después de haber creado los enfrentamientos
                        } catch (NoPartidoException e) { //En caso de que no exista el partido
                            System.out.println(e.getMessage());
                        }


                    }
                    calendario.add(jor); //Añadimos la jornada a la lista de Jornadas.
                }
            }
            return numEnfPart2EqualJugadores;

        }

        return false;

    }


}
