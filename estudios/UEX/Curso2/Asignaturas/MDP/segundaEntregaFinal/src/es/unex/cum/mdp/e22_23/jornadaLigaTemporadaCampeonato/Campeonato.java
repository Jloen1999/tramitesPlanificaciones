package es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato;

import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.comparators.ComparatorEnfrentamientos;
import es.unex.cum.mdp.e22_23.comparators.ComparatorPartidos;
import es.unex.cum.mdp.e22_23.comparators.ComparatorPuntos;
import es.unex.cum.mdp.e22_23.equipo.Equipo;
import es.unex.cum.mdp.e22_23.equipo.EquipoBuilder;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.exceptions.NoLigaException;
import es.unex.cum.mdp.e22_23.persona.Directivo;
import es.unex.cum.mdp.e22_23.persona.FactoriaPersona;
import es.unex.cum.mdp.e22_23.persona.Jugador;
import es.unex.cum.mdp.e22_23.persona.Persona;

import java.util.*;


/**
 * Clase Campeonato
 * Clase que se encuentra formada por las Personas, Equipos, temporadas y el tipo de campeonato que se quiere jugar
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 2/12/2022
 */

public class Campeonato {
    //Atributos
    private Map<String, Equipo> equipos;
    private Map<Integer, Persona> federados;
    private List<Temporada> temporadas;


    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos de la
     * clase.
     */
    public Campeonato() {
        equipos = new HashMap<>();
        federados = new HashMap<>();
        temporadas = new ArrayList<>();
    }

    //Getters

    /**
     * Recupera los equipos del campeonato.
     *
     * @return Map<String, Equipo>
     */
    public Map<String, Equipo> getEquipos() {
        return equipos;
    }

    /**
     * Recupera los federados del campeonato.
     *
     * @return Map<Integer, Persona>
     */
    public Map<Integer, Persona> getFederados() {
        return federados;
    }

    /**
     * Recupera las temporadas del campeonato.
     *
     * @return List<Temporada>
     */
    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    //Setters

    /**
     * Modifica el mapa de los equipos del Campeonato.
     *
     * @param equipos Recibe un mapa de equipos
     */
    public void setEquipos(Map<String, Equipo> equipos) {
        this.equipos = equipos;
    }

    /**
     * Modifica el mapa de los federados del campeonato.
     *
     * @param federados Recibe un mapa de los federados
     */
    public void setFederados(Map<Integer, Persona> federados) {
        this.federados = federados;
    }

    /**
     * Modifica la lista de temporadas del campeonato.
     *
     * @param temporadas Recibe una lista de temporadas del Campeonato
     */
    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
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
        Campeonato that = (Campeonato) o;
        return Objects.equals(equipos, that.equipos) && Objects.equals(federados, that.federados) && Objects.equals(temporadas, that.temporadas);
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(equipos, federados, temporadas);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Campeonato{");
        sb.append("equipos=").append(equipos);
        sb.append(", federados=").append(federados);
        sb.append(", temporadas=").append(temporadas);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Obtenemos una temporada dado su numero(id)
     *
     * @param name Recibe el nombre(identificador) de la temporada
     * @return Devuelve un objeto de tipo Temporada
     * <ul>
     *     <li>NULL: Si no existe la temporada</li>
     *     <li>NO NULL: Si existe la temporada</li>
     * </ul>
     */
    public Temporada getTemporada(String name) {
        Temporada tem = null;
        if (temporadas != null && name != null) { //Si la lista de temporadas y el nombre no son nulos.
            Iterator<Temporada> it = temporadas.iterator();
            while (it.hasNext() && tem == null) { //Iteramos cada una de las temporadas
                Temporada tem1 = (Temporada) it.next(); //Obtenemos cada temporada
                if (tem1.getNombre().equals(name)) { //Si el nombre de la temporada actual es igual al nombre pasado por parámetro
                    tem = tem1; //Almacenamos la temporada encontrada y entonces será la que devuelva la función
                }

            }
        }//En caso contrario devuelve NULL->No existe la temporada
        return tem;
    }

    /**
     * Añadimos una temporada a la lista de temporadas de un Campeonato
     *
     * @param name Recibe el nombre(identificador) de la temporada
     * @return booleano Devuelve un valor booleano
     * <ul>
     *     <li>True: Se inserta la temporada</li>
     *     <li>False: NO se inserta la temporada</li>
     * </ul>
     */
    public boolean addTemporada(String name) {
        Temporada t = getTemporada(name);
        if (t == null) { //Si devuelve null
            temporadas.add(new Temporada(name)); //Añadimos la temporada
            return true; //Devolvemos true
        }
        return false; //En caso contrario
    }


    /**
     * Añade un nuevo equipo a partir de su nombre, ciudad e identificador de una federado.
     *
     * @param nombre Recibe el nombre(identificador) del equipo
     * @param ciudad Recibe la ciudad del equipo
     * @param id Recibe el id de la persona federada->Directivo
     * @return <ul>
     * <li>true: Se añade el equipo</li>
     * <li>false: NO se añade el equipo.</li>
     * </ul>
     */
    public boolean addEquipo(String nombre, String ciudad, int id) {
        /*Para añadir un equipo a la lista de equipos de un campeonato.
           * Tiene que cumplirse:
           *    El id de la Persona no debe ser negativo y debe pertenecer a un federado y el federado debe ser de tipo Directivo
           *    El nombre no tiene que ser nulo.
           *    La lista de equipos no tiene que contener un equipo con ese mismo nombre.
         */
        if (id >= 0 && nombre != null && !equipos.containsKey(nombre)) {
            if ((Persona) federados.get(id) != null && (Persona) federados.get(id) instanceof Directivo) { //Si se cumple
                //Añadimos el equipo a la lista.
                equipos.put(nombre, new EquipoBuilder().withNombre(nombre).withCiudad(ciudad).withCargo((Directivo) federados.get(id)).build());
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene un equipo a través de su nombre.
     *
     * @param nombre Recibe el nombre(identificador) del equipo
     * @return Equipo
     */
    public Equipo getEquipo(String nombre) {
        if (!equipos.isEmpty() && nombre != null) { //Si la lista de equipos no está vacía y el nombre del equipo no es nulo
            return equipos.get(nombre); //Retornamos el equipo que contenga la clave nombre(identificador) del equipo
        }
        return null; //En caso contrario
    }

    /**
     * Añade una nueva persona a partir de su tipo, nombre, identificador, edad, valor1 y valor2. Siendo estos dos ultimos atributos propios de cierto tipo de federados.
     *
     * @param tipo Variable de tipo cadena. Recibe el tipo de Campeonato
     * @param nombre Recibe el nombre(identificador) de la persona.
     * @param id    Recibe el id de la persona federada
     * @param edad   Recibe la edad de la persona
     * @param value1 Variable de tpo cadena. Recibe el valor del atributo propio de Juez o Directivo
     * @param value2 Variable de tpo cadena. Recibe el valor del atributo propio de Jugador
     * @return <ul>
     * <li>true: Se añade la persona</li>
     * <li>false: NO se añade la persona.</li>
     * </ul>
     */
    public boolean addPersona(String tipo, String nombre, int id, int edad, String value1, String value2) {
        /*Para añadir una persona a la lista federados.
         * Tiene que cumplirse:
         *    El id de la Persona no debe ser negativo y debe pertenecer a un federado.
         *    El valor de los atributos tipo y nombre no tienen que ser nulos.
         *    El valor de la edad tiene que ser mayor o igual a 0(bebé jjj.).
         *    La lista de federados no tiene que contener la clave de la persona.
         */
        if (tipo != null && nombre != null && !federados.containsKey(id) && edad >=0) {
            federados.put(id, new FactoriaPersona().build(tipo, nombre, id, edad, value1, value2));
            return true; //Se añade la persona
        }
        return false;//No se añade la persona.
    }

    /**
     * Obtenemos una persona dado su numero(id)
     *
     * @param id Recibe un valor de tipo entero
     * @return Devuelve un objeto de tipo Persona
     * <ul>
     *     <li>NULL: Si NO existe la persona</li>
     *     <li>NO NULL: Si existe la persona</li>
     * </ul>
     */
    public Persona getPersona(int id) {
        if (!federados.isEmpty()) { //Si la lista de federados o personas del Campeonato no está vacía
            return federados.get(id); //Retornamos la persona a través de su clave.
        }
        return null; //En caso contrario

    }

    /**
     * Añade una nueva liga dado de su nombre a una temporada a partir de su nombre.
     *
     * @param nomTemp Recibe el nombre(identificador) de la temporada.
     * @param nomLiga Recibe el nombre(identificador) de la liga.
     * @return <ul>
     * <li>true: Se ha añadido la Liga</li>
     * <li>false: NO se añade la Liga</li>
     * </ul>
     */
    public boolean crearLigaTemporada(String nomTemp, String nomLiga) {
        boolean existLT = false;
        Temporada temp = getTemporada(nomTemp); //Si devuelve null->No existe la temporada
                                                //Si devuelve NO null->Existe la temporada
        //Si existe la temporada, y el nombre de la liga no es nula y la lista de ligas de la temporada no contiene la liga.
        if (temp != null && temp.getLigaName(nomLiga) == null && nomLiga!=null && nomTemp!=null) {
                temp.getLigas().put(nomLiga, new Liga(nomLiga)); //Añadimos la liga a la temporada
                existLT = true;
        }

        return existLT;
    }

    /**
     * Añade un equipo a una liga de una determinada temporada a partir de su coeficiente.
     *
     * @param nomTemp Recibe el nombre(identificador) de una temporada.
     * @param nomLiga Recibe el nombre(identificador) de una liga.
     * @param nomEq Recibe el nombre(identificador) de un equipo.
     * @param coef Recibe el coeficiente de un equipo.
     * @return boolean Variable de tipo booleano:
     * <ul>
     *     <li>true: Si el equipo se ha añadido</li>
     *     <li>false: de lo contrario.</li>
     * </ul>
     * @exception NoLigaException
     */
    public boolean addEquipoLigaTemporada(String nomTemp, String nomLiga, String nomEq, int coef){
        /*Para añadir un equipo dado su nombre y coeficiente a una liga dado su nombre de un temporada dado su nombre
         * Tiene que cumplirse:
         *  nombre de la temporada, el nombre de la liga, el nombre del equipo y la lista de temporadas no tienen que ser nulos.
         *
         */
        if (nomTemp != null && nomLiga != null && nomEq != null && temporadas != null) {
                try{
                Liga lig = getTempLiga(nomTemp, nomLiga);
                if (lig != null && lig.getEquiposLiga() != null) {  //Si la liga no es nula y la lista de equipos de dicha liga tampoco es nula
                    EquipoLiga eL = lig.getEquipoLiga(nomEq);
                    if (eL == null) { //Si NO Existe el equipo en la Liga.
                        Equipo e = equipos.get(nomEq);
                        if (e != null) { //Pero Si existe el equipo en la lista de equipos del Campeonato
                            return lig.addEquipoLiga(new EquipoLiga(coef, new EquipoBuilder().withNombre(nomEq).build())); //Añadimos el equipo en la Liga
                            //devuelve true
                        }

                    }
                }

                }catch(NoLigaException e){
                    System.out.println(e.getMessage()); //En caso de que no exista la liga
                }

            }//En caso contrario devuelve false
        return false;
    }


    /**
     * Añade un jugador a un equipo de una determinada liga y temporada.
     *
     * @param nomTemp Recibe el nombre(identificador) de la temporada.
     * @param nomLiga Recibe el nombre(identificador) de la liga.
     * @param nomEq Recibe el nombre(identificador) del equipo.
     * @param idJug Recibe el id(identificador) del Jugador.
     * @return
     * <ul>
     *     <li>true: si el jugador se ha añadido</li>
     *     <li>false: de lo contrario.</li>
     * </ul>
     * @exception NoLigaException
     */
    public boolean addJugadorEquipoLigaTemporada(String nomTemp, String nomLiga, String nomEq, int idJug) {

        if (nomTemp != null && nomLiga != null && nomEq != null && temporadas != null) {
            try {
                EquipoLiga equipoLiga = getTempLiga(nomTemp, nomLiga).getEquipoLiga(nomEq); //Obtenemos el equipo del campeonato a partir del nombre de la temporada, liga y el nombre del equipo
                if (equipoLiga != null && equipoLiga.getJugadores() != null) { //Si el equipo existe en el campeonato y la lista no de jugadores no es nula
                    Jugador j = equipoLiga.getJugadorId(idJug); //Obtenemos el jugador del equipo a partir de su id.
                    if (j == null) { //Si no existe el jugador
                        Jugador j1 = (Jugador) federados.get(idJug);  //Obtenemos el jugador en la lista de federados del campeonato
                        if (j1 != null) { //Y existe el jugador en la lista de federados
                            return equipoLiga.addJugadores(j1); //Añadimos el jugador al equipoLiga.
                        }
                    }
                }

            } catch (NoLigaException e) {
                System.out.println(e.getMessage()); //Si no existe la liga
                return false;
            }
        }
        return false;
    }

    /**
     * Crea un calendario para una determinada liga y temporada. Se especifica el tipo de juego para el que se crea el calendario.
     *
     * @param nomTemp Recibe el nombre(identificador) de la temporada.
     * @param nomLiga Recibe el nombre(identificador) de la Liga.
     * @param tipo Variable de tipo cadena. Recibe el tipo de Campeonato
     * @return
     * <ul>
     *     <li>true: si el calendario se ha creado.</li>
     *     <li>false: de lo contrario.</li>
     * </ul>
     * @exception NoLigaException
     */
    public boolean crearCalendario(String nomTemp, String nomLiga, String tipo){
        try {
            Liga liga = getTempLiga(nomTemp, nomLiga); //Obtenemos la liga a partir de su nombre y la temporada
            if (liga != null && nomTemp != null && nomLiga != null && tipo != null && liga.getCalendario() != null) {
                return liga.crearCalendario(tipo); //Creamos el calendario de la liga.
            }
        } catch (NoLigaException e1) {
            System.out.println(e1.getMessage()); //Si no existe la liga
        }
        return false;
    }




    /**
     * Obtiene una liga para una determinada temporada a través de sus nombres.
     *
     * @param nomTemp Recibe el nombre(identificador) de la temporada.
     * @param nomLiga Recibe el nombre(identificador) de la liga.
     * @return Liga
     * @throws NoLigaException
     */
    public Liga getTempLiga(String nomTemp, String nomLiga) throws NoLigaException {

        if (nomTemp != null && nomLiga != null && temporadas != null) { //Si el nombre de la temporada y el nombre de la liga no son nulas.

            Temporada temp = getTemporada(nomTemp); //Obtenemos la temporada en cuestión a partir de su nombre.

            if (temp != null) { //Si existe la temporada
                if (temp.getLigas().containsKey(nomLiga)) { //Si dicha temporada no contiene la liga
                    return temp.getLigas().get(nomLiga); //Retornamos la liga a partir de su nombre.
                }
            }
        }
        throw new NoLigaException(); //En caos de que no existe la liga.
    }


    /**
     * Juega un partido de una determinada jornada, liga y temporada.
     * Se indican el numero de puntos del equipo local y visitante.
     *
     * @param nomTemp Recibe el nombre(identificador) de la temporada.
     * @param nomLiga Recibe el nombre(identificador) de la liga.
     * @param numJornada Recibe el numero(identificador) de la Jornada
     * @param idPartido Recibe el id del Partido
     * @param puntosLocal Recibe los puntos del equipo Local
     * @param puntosVis Recibe los puntos del equipo Visitante.
     * @return <ul>
     * <li>true: si el partido se ha jugado</li>
     * <li>false: de lo contrario.</li>
     * </ul>
     * @throws NoLigaException
     */

    public boolean jugar(String nomTemp, String nomLiga, int numJornada, int idPartido, int[] puntosLocal, int[] puntosVis) {

        if (nomTemp != null && nomLiga != null && puntosLocal.length == Partido.getNumEnfrentamiento() && puntosVis.length == Partido.getNumEnfrentamiento() && temporadas != null) {
            try {
                Liga liga = getTempLiga(nomTemp, nomLiga); //Obtenemos la liga a partir de su nombre y la temporada
                if (liga != null) { //Si existe la liga
                    Jornada j = liga.getJornadaNum(numJornada); //Obtenemos la Jornada a partir de su nombre y su liga
                    if (j != null) return j.jugar(idPartido, puntosLocal, puntosVis); //Si la jornada no es nula procedemos a jugarla.
                    //Devuelve true

                }//En caso contrario return false
            } catch (NoLigaException e) {
                System.out.println(e.getMessage()); //Si existe la liga
                return false;
            }
        }
        return false;
    }


    /**
     * Juega un partido de una determianda liga y temporada.
     *
     * @param nomTemp Recibe el nombre(identificador) de la temporada.
     * @param nomLiga Recibe el nombre(identificador) de la liga.
     * @return boolean
     * <ul>
     *     <li>true: Se simula la liga</li>
     *     <li>false: NO se simula la liga</li>
     * </ul>
     */
    public boolean simular(String nomTemp, String nomLiga) {
        if (nomTemp != null && nomLiga != null && temporadas != null) {
            try {
                Liga lig = getTempLiga(nomTemp, nomLiga);//Obtenemos la liga a partir de su nombre y la temporada
                if(lig!=null){ //Si existe la liga
                    return lig.simular(); //Simulamos la liga, return true.
                }//En caso contrario return false
            } catch (NoLigaException e) {
                e.printStackTrace(); //Si no existe la liga
                return false;
            }
        }
        return false;
    }


    /**
     * Muestra las estadisticas una determinada liga y temporada segun el tipo de campeonato.
     *
     * @param nomTemp Recibe el nombre(identificador) de la temporada.
     * @param nomLiga Recibe el nombre(identificador) de la liga.
     * @param tipo Variable de tipo cadena. Recibe el tipo de campeonato
     * @return boolean
     * <ul>
     *      <li>true: Se muestran las estadisticas</li>
     *      <li>false: NO se muestran las estadisticas</li>
     * </ul>
     */
    public boolean MostrarEstadistica(String nomTemp, String nomLiga, String tipo) {
        if (nomTemp != null && nomLiga != null && tipo != null && temporadas != null) {
            try {
                Liga liga = getTempLiga(nomTemp, nomLiga); //Obtenemos la liga a partir de su nombre y la temporada
                if (liga != null) { //Si existe la liga
                    if (tipo.equals("Puntos")) { //Ordenamos la lista de equipos de la liga en base a los puntos
                        Collections.sort(liga.getEquiposLiga(), Collections.reverseOrder(new ComparatorPuntos())); //Orden Descendente
                        liga.MostrarEstadistica(liga.getEquiposLiga(), tipo); //Mostramos las estadisticas
                        return true;
                    } else if (tipo.equals("Goles")) { //Ordenamos la lista de equipos de la liga en base a los goles
                        //liga.getEquiposLiga().sort(new ComparatorGoles());
                        return true;
                    } else if (tipo.equals("Enfrentamientos")) { //Ordenamos la lista de equipos de la liga en base a los enfrentamientos
                        Collections.sort(liga.getEquiposLiga(), Collections.reverseOrder(new ComparatorEnfrentamientos())); //Orden Descendente
                        liga.MostrarEstadistica(liga.getEquiposLiga(), tipo); //Mostramos las estadisticas
                        return true;
                    } else if (tipo.equals("Partidos")) { //Ordenamos la lista de equipos de la liga en base a los Partidos
                        Collections.sort(liga.getEquiposLiga(), Collections.reverseOrder(new ComparatorPartidos())); //Orden Descendente
                        liga.MostrarEstadistica(liga.getEquiposLiga(), tipo); //Mostramos las estadisticas
                        return true;
                    }
                }
                return false; //Si no existe la liga
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


}