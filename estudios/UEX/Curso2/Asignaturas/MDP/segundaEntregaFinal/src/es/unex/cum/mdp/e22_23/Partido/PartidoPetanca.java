package es.unex.cum.mdp.e22_23.Partido;

import es.unex.cum.mdp.e22_23.enfrentamiento.EnfrentamientoPetanca;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.persona.Jugador;

import java.util.*;

/**
 * Clase Derivada PartidoPetanca
 * Contiene información de los partidos de cada Jornada.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 * @see Partido Clase Padre Partido
 */

public class PartidoPetanca extends Partido {

    //Sin atributos derivados

    public PartidoPetanca() {
        super();
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
    public PartidoPetanca(int id, int puntosLocal, int puntosVisitante, EquipoLiga local, EquipoLiga visitante) {
        super(id, puntosLocal, puntosVisitante, local, visitante);
    }

    /**
     * Constructor Copia.
     *
     * @param p              Objeto de tipo Partio. Recibe un objeto de tipo Partido
     * @param local           Objeto de tipo EquipoLiga. Recibe un objeto el equipoLiga Local
     * @param visitante       Objeto de tipo EquipoLiga. Recibe un objeto del tipo equipoLiga Visitante
     */
    public PartidoPetanca(Partido p, EquipoLiga local, EquipoLiga visitante) {
        super(p, local, visitante);
    }

    /**
     * Constructor parametrizado.
     *
     * @param id              Variable de tipo entero. Recibe el identificador de un partido
     * @param local           Objeto de tipo EquipoLiga. Recibe un objeto el equipoLiga Local
     * @param visitante       Objeto de tipo EquipoLiga. Recibe un objeto del tipo equipoLiga Visitante
     */
    public PartidoPetanca(int id, EquipoLiga local, EquipoLiga visitante) {
        super(id, local, visitante);
    }

    /**
     * Constructor parametrizado.
     *
     * @param id  Variable de tipo entero. Recibe el identificador de un partido
     */
    public PartidoPetanca(int id) {
        super(id);
    }

    /**
     * Se encarga de realizar la simulación de todos los enfrentamientos
     * del partido, actualizando los puntos de cada equipo. Además, debe
     * actualizar las estadísticas.
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/master/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/PartidoPetanca/Clase%20PartidoPetanca.md#simular--boolean">Prerrequisitos y Flujo norma y alterno</a>
     */
    @Override
    public boolean simular() {

        //Obtenemos los equispos, los cuales vamos a simular el partido
        EquipoLiga eqLocal = super.getLocal();
        EquipoLiga eqVis = super.getVisitante();
        EnfrentamientoPetanca enf = null;
        int puntos = 0;  //valor resultante de la simulación del enfrentamiento.
        //Comprobamos que la lista de enfrentamientos no esté vacía.
        if (!super.getEnfrentamientos().isEmpty()) { //Si la lista de enfrentamientos no está vacía
            for (int i = 0; i < super.getNumEnfrentamiento(); i++) {
                enf = super.getEnfrentamientos().get(i); //Obtenemos cada uno de los enfrentamientos
                //Simulamos cada enfrentamiento
                puntos = enf.simular(eqLocal.getCoef(), eqVis.getCoef());
                //Comparamos los puntos generados.
                if (puntos > 0) {   //Gana el equipoLiga Local, Pierde el equipoLiga Visitante
                    //Actualizamos los puntos del enfrentamiento ganado del equipo Local.
                    //enf.setLocal(enf.getLocal() + 1);
                    //Actualizamos los puntos del equipo Local en Partido
                    super.setPuntosLocal(super.getPuntosLocal() + 1); //Incrementamos una unidad los puntosLocales del partido
                    //Actualizamos las estadísticas de ambos equipos
                    eqLocal.getEst().setEnfrenGanados(eqLocal.getEst().getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo local
                    eqVis.getEst().setEnfrenPerdidos(eqVis.getEst().getEnfrenPerdidos() + 1);   //Incrementamos el valor del atributo enfrentPerdidos del equipo Visitante.
                } else if (puntos < 0) { //Gana el equipoLiga Visitante, Pierde el equipoLiga Local
                    //Actualizamos los puntos del equipo Visitante en Partido
                    super.setPuntosVisitante(super.getPuntosVisitante() + 1);
                    //Actualizamos las estadísticas de ambos equipos
                    eqVis.getEst().setEnfrenGanados(eqVis.getEst().getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo Visitante
                    eqLocal.getEst().setEnfrenPerdidos(eqLocal.getEst().getEnfrenPerdidos() + 1); //Incrementamos el valor del atributo enfrentPerdidos de estadística del equipo local

                } else { //Empatan ambos equipos
                    //Actualizamos las estadísticas de ambos equipos
                    eqLocal.getEst().setEnfrenEmpatados(eqLocal.getEst().getEnfrenEmpatados() + 1); //Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Local
                    eqVis.getEst().setEnfrenEmpatados(eqVis.getEst().getEnfrenEmpatados() + 1); //Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Visitante
                }
            }
            return true; //TODO: Devuelve true
        }//En caso contrario el método devuelve false.
        return false;
    }

    /**
     * Método ue se encarga de realizar la simulación de todos los enfrentamientos del partido,
     * actualizando los puntos de cada equipo. Además debe actualizar las estadísticas de los equipos
     * con respecto al enfrentamiento: puntos, enfrentamientos.
     *
     * @param puntosLocal array de tipo entero que almacena los puntos(coeficiente) del equipo Local.
     * @param puntosVis   array de tipo entero que almacena los puntos(coeficiente) del equipo Visitante.
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/master/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/PartidoPetanca/Clase%20PartidoPetanca.md#jugar--boolean">Prerrequisitos y Flujo norma y alterno</a>
     */
    @Override
    public boolean jugar(int[] puntosLocal, int[] puntosVis) {

        //Obtenemos los equispos, los cuales vamos a simular el partido
        EquipoLiga eqLocal = super.getLocal();
        EquipoLiga eqVis = super.getVisitante();
        EnfrentamientoPetanca enf = null;

        //Comprobamos que la lista de enfrentamientos no sea nula y que los puntos locales del partido
        // y los puntos Visitante sean iguales que el total de enfrentamientos
        if (super.getEnfrentamientos()!=null && puntosLocal.length==super.getNumEnfrentamiento() && puntosVis.length==super.getNumEnfrentamiento() ) {
            for (int i = 0; i < super.getNumEnfrentamiento(); i++) {
                enf = super.getEnfrentamientos().get(i);
                int result=enf.jugar(puntosLocal[i],puntosVis[i]);
                if (result>0) { //Si gana el enfrentamiento el equipo Local y pierde el Visitante.
                    //Actualizamos los puntos del equipo Local en Partido
                    super.setPuntosLocal(super.getPuntosLocal() + 1);
                    //Actualizamos las estadísticas de ambos equipos
                    eqLocal.getEst().setEnfrenGanados(eqLocal.getEst().getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo local
                    eqVis.getEst().setEnfrenPerdidos(eqVis.getEst().getEnfrenPerdidos() + 1);   //Incrementamos el valor del atributo enfrentPerdidos del equipo Visitante.

                } else if (result<0) { //Si gana el enfrentamiento el equipo Visitante y pierde el Local.
                    //Actualizamos los puntos del equipo Visitante en Partido
                    super.setPuntosVisitante(super.getPuntosVisitante() + 1);
                    //Actualizamos las estadísticas de ambos equipos
                    eqVis.getEst().setEnfrenGanados(eqVis.getEst().getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo Visitante
                    eqLocal.getEst().setEnfrenPerdidos(eqLocal.getEst().getEnfrenPerdidos() + 1); ////Incrementamos el valor del atributo enfrentPerdidos de estadística del equipo local

                } else {    //Si empatan el enfrentamiento ambos equipos
                    //Actualizamos las estadísticas de ambos equipos
                    eqLocal.getEst().setEnfrenEmpatados(eqLocal.getEst().getEnfrenEmpatados() + 1); //Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Local
                    eqVis.getEst().setEnfrenEmpatados(eqVis.getEst().getEnfrenEmpatados() + 1); //Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Visitante

                }
            }

            return true; //TODO: Devuelve true
        }

        return false; //En caso contrario el método devuelve false.
    }


    /**
     * Se encargará de actualizar las estadísticas de los equipos referidas:
     * partidos y puntos. Este método es llamado desde Jornada
     * @see Partido#getEnfrentamientos()
     * @see Partido#getPuntosLocal()
     * @see Partido#getPuntosVisitante()
     * <ul>
     *     <li>Partidos Ganados(partGanados)->5 puntos</li>
     *     <li>Partidos Empatados(partEmpatados)->2 puntos</li>
     *     <li>Partidos Perdidos(partPerdidos)->-3 puntos</li>
     * </ul>
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/master/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/PartidoPetanca/Clase%20PartidoPetanca.md#actualizarestadistica--void">Prerrequisitos y Flujo norma y alterno</a>
     */
    @Override
    public void actualizarEstadistica() {
        //Obtenemos los equipos
        EquipoLiga eqLocal = super.getLocal();
        EquipoLiga eqVis = super.getVisitante();
        //Obtenemos las estadísticas de cada equipo
        EstadisticaPetanca estEqLocal = (EstadisticaPetanca) eqLocal.getEst();
        EstadisticaPetanca estEqVis = (EstadisticaPetanca) eqVis.getEst();

        if (!super.getEnfrentamientos().isEmpty() && super.getEnfrentamientos()!=null) {
            //Incrementamos los partidos jugados de ambos equipos
            estEqLocal.setPartJugados(estEqLocal.getPartJugados()+1);
            estEqVis.setPartJugados(estEqVis.getPartJugados()+1);

            if (super.getPuntosLocal() > super.getPuntosVisitante()) { //Gana el partido equipoLiga Local y pierde el Visitante
                //Actualizamos los partidos
                estEqLocal.setPartGanados(estEqLocal.getPartGanados() + 1); //Incrementamos una unidad los partidos Ganados del equipoLiga Local
                estEqVis.setPartPerdidos(estEqVis.getPartPerdidos() + 1); //Incrementamos una unidad los partidos Perdidos del equipoLiga Visitante.

                //Para que inmediatamente se me muestren actualizados los puntos de ambos equipos pero no es necesario en la lógica del programa.
                estEqLocal.setPuntos(estEqLocal.getPuntos());
                estEqVis.setPuntos(estEqVis.getPuntos());
            } else if (super.getPuntosLocal() < super.getPuntosVisitante()) { //Gana el partido equipoLiga Visitante y pierde el Local
                //Actualizamos los partidos de los equipos
                estEqVis.setPartGanados(estEqVis.getPartGanados() + 1); //Incrementamos una unidad los partidos Ganados del equipoLiga Visitante
                estEqLocal.setPartPerdidos(estEqLocal.getPartPerdidos() + 1); //Incrementamos una unidad los partidos Perdidos del equipoLiga Local.

                //Para que inmediatamente se me muestren actualizados los puntos de ambos equipos pero no es necesario en la lógica del programa.
                estEqLocal.setPuntos(estEqLocal.getPuntos());
                estEqVis.setPuntos(estEqVis.getPuntos());
            } else { //Empatan el partido equipoLiga Local.
                //Actualizamos los partidos de los equipos
                estEqVis.setPartEmpatados(estEqVis.getPartEmpatados() + 1); //Incrementamos una unidad los partidos Empatados del equipoLiga Visitante.
                estEqLocal.setPartEmpatados(estEqLocal.getPartEmpatados() + 1); //Incrementamos una unidad los partidos Empatados del equipoLiga Local.

                //Para que inmediatamente se me muestren actualizados los puntos de ambos equipos pero no es necesario en la lógica del programa.
                estEqLocal.setPuntos(estEqLocal.getPuntos());
                estEqVis.setPuntos(estEqVis.getPuntos());

            }
    }

}

    /**
     * Se encargará de crear los distintos enfrentamientos del partido.
     * En base al atributo del número de enfrentamientos que debe realizar
     * secrearán tanto enfrentamientos como se indique.  Recibe dos listas:
     * <ul>
     *     <li>Lista de jugadores locales</li>
     *     <li>Lista de jugadores visitantes.</li>
     * </ul>
     * El sorteo de enfrentamientosse realizará desordenando estas listas
     * y asignando los jugadores por posición, esdecir, posición 0 con
     * posición 0, posición 1 con posición 1 y así sucesivamente.
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/master/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/PartidoPetanca/Clase%20PartidoPetanca.md#crearenfrentamientoslist-llocal-list-lvis-void">Prerrequisitos y Flujo norma y alterno</a>
     * @param lLocal
     * @param lVis
     * @see Collections#shuffle(List)
     * @see Partido#addEnfrentamientos(EnfrentamientoPetanca)
     * @see Partido#getNumEnfrentamiento()
     */
    @Override
    public void crearEnfrentamientos(List<Jugador> lLocal, List<Jugador> lVis) {
        if (lLocal != null && lVis != null) {   //Comprobamos si la lista de jugadores Locales y jugadores Visitante están vacías
            int id = 1; //identificador del enfrentamiento
            //Desordenamos ambas listas de jugadores antes de crear los enfrentamientos
            Collections.shuffle(lLocal);
            Collections.shuffle(lVis);
            for (int i = 0; i < super.getNumEnfrentamiento(); i++) { //Realizamos los distintos enfrentamientos
                super.addEnfrentamientos(new EnfrentamientoPetanca(id, lLocal.get(i), lVis.get(i)));
                id++;
            }

        }
    }


}
