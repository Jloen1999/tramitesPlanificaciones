package es.unex.cum.mdp.e22_23.utils;

import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Campeonato;
import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Liga;
import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Temporada;
import es.unex.cum.mdp.e22_23.enfrentamiento.EnfrentamientoPetanca;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.exceptions.*;
import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Jornada;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Clase ShowPetanca
 * Clase que visualiza todos los datos del Campeonato con una buena visualización.
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 2/12/2022
 */



public interface ShowPetanca {

    /**
     * //Visualiza las temporadas de un Campeonato con sus ligas, jornadas, partidos, enfrentamientos, jugadores y estadisticas
     * @param c Objeto de tipo Campeonato. Recibe un campeonato.
     * @throws NoCampeonatoException Salta si no existe el campeonato.
     * @throws NoJornadaException Salta si no existe la Jornada o lista de jornadas de una liga
     * @throws NoTemporadaException Salta si no existe la temporada o la lista de temporadas de un campeonato
     * @throws NoLigaException Salta si no existe la Liga o la lista de ligas de una temporada
     */
    public static void showTempCampeonato(Campeonato c) throws NoCampeonatoException, NoJornadaException, NoTemporadaException, NoLigaException {
        if (c != null) { //Si existe el campeonato
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "******************************************************************* CAMPEONATO PETANCA ************************************************************" + ConsoleColors.RESET);
            for (Temporada t : c.getTemporadas()
            ) {
                showLigaTemp(t); //Visualiza cada una de las temporadas del Campeonato en cuestión
            }
        } else {
            throw new NoCampeonatoException(); //Si no existe el campeonato
        }
    }

    /**
     * //Visualiza las ligas de una temporada con sus jornadas, partidos, enfrentamientos, jugadores y estadisticas
     * @param t Objeto de tipo Temporada. Recibe una temporada
     * @throws NoLigaException Salta si no existe la Liga o la lista de ligas de una temporada
     * @throws NoJornadaException Salta si no existe la Jornada o la lista de jornadas de una liga
     * @throws NoTemporadaException Salta si no existe la temporada
     */
    public static void showLigaTemp(Temporada t) throws NoLigaException, NoJornadaException, NoTemporadaException {
        if (t != null) { //Si existe la temporada
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "******************************************************************* TEMPORADA " + t.getNombre() + " ************************************************************" + ConsoleColors.RESET);
            for (Map.Entry<String, Liga> liga : t.getLigas().entrySet()) {
                showJornadaLiga(liga.getValue());  //Visualiza cada una de las ligas de una temporada.
            }
        } else {
            throw new NoTemporadaException(); //Si no existe la Temporada
        }
    }

    /**
     * //Visualiza las Jornadas con sus partidos, enfrentamientos, jugadores y estadisticas.
     * @param l Objeto de tipo Liga. Recibe una Liga
     * @throws NoLigaException Salta si no existe la liga
     * @throws NoJornadaException Salta si no existe la jornada o la lista de jornadas de una liga
     */
    public static void showJornadaLiga(Liga l) throws NoLigaException, NoJornadaException {
        if (l != null) { //Si existe la liga
            int i = 0;
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "******************************************************************* LIGA " + l.getNombre() + " ************************************************************" + ConsoleColors.RESET);
            for (Jornada j : l.getCalendario()) {
                try {
                    showManyPartidosJornada(j, i); //Visualiza cada una de las Jornadas
                    i++;
                } catch (NoPartidoException | NoEnfrentamientosException p) {
                    System.out.println(p.getMessage()); //Si no existe el partido o el enfrentamiento
                }
            }
        } else {
            throw new NoLigaException(); //Si no existe la Liga
        }
    }

    /**
     * //Visualiza cada una de partidos de una Jornada
     * @param j Objeto de tipo Jornada. Recibe una Jornada
     * @param index Variable de tipo entero. Recibe el indice de una Jornada
     * @throws NoPartidoException Salta si no existe el Partido o la lista de partidos
     * @throws NoJornadaException   Salta si no existe la Jornada o la lista de Jornadas
     * @throws NoEnfrentamientosException   Salta si no existe el enfrentamiento o la lista de enfrentamientos
     */
    public static void showManyPartidosJornada(Jornada j, int index) throws NoPartidoException, NoJornadaException, NoEnfrentamientosException {
        if (j != null) { //SI existe la Jornada
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "******************************************************************* JORNADA " + index + " ID: -> " + j.getNumero() + " ***********************************************************" + ConsoleColors.RESET);
            if (j.getPartidos() != null || !j.getPartidos().isEmpty()) {
                int i = 1;
                for (Partido p : j.getPartidos()
                ) {
                    showOnlyPartido(p, i); //Visualiza cada una de partidos de una Jornada
                    i++;
                }
            } else {
                throw new NoPartidoException("La lista de Partidos es Nula o está vacía"); //Si no existe el partido
            }
        } else {
            throw new NoJornadaException(); //Si no existe la jornada
        }

    }

    /**
     * //Visualiza un partido con sus jugadores, enfrentamientos y estadisticas
     * @param p Objeto de tipo Persona. Recibe una Persona.
     * @param day Variable de tipo entero. Recibe el indice de un partido.
     * @throws NoPartidoException Salta si no existe el partido
     * @throws NoEnfrentamientosException Salta si no existe el enfrentamiento o los enfrentamientos.
     */

    public static void showOnlyPartido(Partido p, int day) throws NoPartidoException, NoEnfrentamientosException {
        if (p != null) { //Si existe el partido
            System.out.println(ConsoleColors.CYAN_UNDERLINED + "------------------------------------------------------------------- PARTIDO " + day + " ID: -> " + p.getId() + " -----------------------------------------------------------" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.PURPLE_BOLD + "-----------------------------LOCAL---------------------------- EQUIPOS ----------------------------------VISITANTE------------------------------" + ConsoleColors.BLUE_BRIGHT + "|");
            //Muestra los nombres de los equipos Local y Visitante
            System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.YELLOW + " \t\t\t\t\t" + p.getLocal().getE().getNombre() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + p.getVisitante().getE().getNombre() + "\t\t\t\t\t\t\t\t " + ConsoleColors.BLUE_BRIGHT + "|");
            System.out.println(ConsoleColors.BLUE_BRIGHT + "|------------------------------------------------------------------------------------------------------------------------------------------------|");

            //Muestra los jugadores de ambos equipos
            System.out.println("|--------------------------------------------------------- Jugadores EquipoLiga Local -----------------------------------------------------------|");
            p.getLocal().getJugadores().forEach(jug -> System.out.println("| " + jug + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t |"));
            System.out.println("|--------------------------------------------------------- Jugadores EquipoLiga Visitante -------------------------------------------------------|");
            p.getVisitante().getJugadores().forEach(jug -> System.out.println("| " + jug + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t |"));

            if (p.getEnfrentamientos() != null && !p.getEnfrentamientos().isEmpty()) {
                System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.PURPLE_BOLD + "-------------------------------------------------------------- ENFRENTAMIENTOS -----------------------------------------------------------------" + ConsoleColors.BLUE_BRIGHT + "|");
                System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.PURPLE_BOLD + "-----------------------------LOCAL--------------------------- " + p.getLocal().getE().getNombre() + ConsoleColors.RED + " VS " + ConsoleColors.PURPLE_BOLD + p.getVisitante().getE().getNombre() + " ------------------------VISITANTE-----------------------------" + ConsoleColors.BLUE_BRIGHT + "|");
                for (EnfrentamientoPetanca en : p.getEnfrentamientos()) {
                             //Muestra los enfrentamientos
                    if (en.getjLocal().getNombre().length() >= 9 || en.getjVis().getNombre().length() >= 9 || String.valueOf(en.getVisitante()).length() >= 2 || String.valueOf(en.getLocal()).length() >= 2 && en.getjLocal().getNick().length() >= 9 || en.getjVis().getNick().length() >= 9) {
                        System.out.println("|Nombre Jugador = " + en.getjLocal().getNombre() + ", Coeficiente Jugador = " + en.getjLocal().getCoef() + ", Puntos Equipo = " + en.getLocal() + ConsoleColors.RED + " VS " + ConsoleColors.BLUE_BRIGHT + "Nombre Jugador = " + en.getjVis().getNombre() + ", Coeficiente Jugador = " + en.getjVis().getCoef() + ", Puntos Equipo = " + en.getVisitante() + " |");
                    } else {
                        System.out.println("|Nombre Jugador = " + en.getjLocal().getNombre() + ", Coeficiente Jugador = " + en.getjLocal().getCoef() + ", Puntos Equipo = " + en.getLocal() + ConsoleColors.RED + " VS " + ConsoleColors.BLUE_BRIGHT + "Nombre Jugador = " + en.getjVis().getNombre() + ", Coeficiente Jugador = " + en.getjVis().getCoef() + ", Puntos Equipo = " + en.getVisitante() + "  |");
                    }

                }

                //Muestra los puntos del partido de los equipos
                System.out.println(ConsoleColors.BLUE_BRIGHT + "|------------------------------------------------------------------------------------------------------------------------------------------------|");
                System.out.println(ConsoleColors.BLUE_BRIGHT + "| \t\tPuntos Partido equipoLiga Local \t\t\t\t\t\t\t\t\t\t\t\t\t\tPuntos Partido equipoLiga Visitante\t\t\t\t |");
                System.out.println("| \t\t\t\t\t\t" + p.getPuntosLocal() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + p.getPuntosVisitante() + "\t\t\t\t\t\t\t |");
                System.out.println(ConsoleColors.BLUE_BRIGHT + "|------------------------------------------------------------------------------------------------------------------------------------------------|");
            } else {
                System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.PURPLE_BOLD + "-------------------------------------------------------------- SIN ENFRENTAMIENTOS -------------------------------------------------------------" + ConsoleColors.BLUE_BRIGHT + "|");
            }

            //Muestra las estadisticas de ambos equipos
            System.out.println("|--------------------------------------------------------- Estadisticas EquipoLiga Local --------------------------------------------------------|");
            System.out.println("| " + p.getLocal().getEst() + "\t |");
            System.out.println("|--------------------------------------------------------- Estadisticas EquipoLiga Visitante ----------------------------------------------------|");
            System.out.println("| " + p.getVisitante().getEst() + "\t |");
            if (p.getLocal().getEst().getPartJugados() != 0 && p.getVisitante().getEst().getPartJugados() != 0) {
                        //Muestra el nombre del equipo que gana, pierde o si empatan.
                if (p.getLocal().getEst().getPuntos() > p.getVisitante().getEst().getPuntos()) {
                    System.out.println("|" + ConsoleColors.GREEN + " Gana el equipo Local " + ConsoleColors.YELLOW + p.getLocal().getE().getNombre() + ConsoleColors.GREEN + " con -> " + p.getLocal().getEst().getPuntos() + " Puntos\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + ConsoleColors.BLUE_BRIGHT + " |");
                    System.out.println("|" + ConsoleColors.GREEN + " Pierde el equipo Visitante " + ConsoleColors.YELLOW + p.getVisitante().getE().getNombre() + ConsoleColors.GREEN + " con -> " + p.getVisitante().getEst().getPuntos() + " Puntos\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + ConsoleColors.BLUE_BRIGHT + " |");

                } else if (p.getLocal().getEst().getPuntos() < p.getVisitante().getEst().getPuntos()) {
                    System.out.println("|" + ConsoleColors.GREEN + " Gana el equipo Visitante " + ConsoleColors.YELLOW + p.getVisitante().getE().getNombre() + ConsoleColors.GREEN + " con -> " + p.getVisitante().getEst().getPuntos() + " Puntos\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + ConsoleColors.BLUE_BRIGHT + "|");
                    System.out.println("|" + ConsoleColors.GREEN + " Pierde el equipo Local " + ConsoleColors.YELLOW + p.getLocal().getE().getNombre() + ConsoleColors.GREEN + " con -> " + p.getLocal().getEst().getPuntos() + " Puntos\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + ConsoleColors.BLUE_BRIGHT + " |");
                } else {
                    System.out.println("|" + ConsoleColors.GREEN + " Empatan el equipo Local " + ConsoleColors.YELLOW + p.getLocal().getE().getNombre() + ConsoleColors.GREEN + " y Visitante " + ConsoleColors.YELLOW + p.getVisitante().getE().getNombre() + ConsoleColors.GREEN + " con -> " + p.getLocal().getEst().getPuntos() + " Puntos\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + ConsoleColors.BLUE_BRIGHT + "|");
                }

                //Puede ser que un equipo tenga más puntos que otro debido a que ganó más partidos anteriores pero en caso de empatar el partido actual se muestra también.
                if (p.getPuntosLocal() == p.getPuntosVisitante()) {
                    System.out.println("|" + ConsoleColors.GREEN + " Partido Actual: Empatan el equipo Local " + ConsoleColors.YELLOW + p.getLocal().getE().getNombre() + ConsoleColors.GREEN + " y Visitante " + ConsoleColors.YELLOW + p.getVisitante().getE().getNombre() + ConsoleColors.GREEN + " con -> " + p.getPuntosLocal() + " Puntos\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + ConsoleColors.BLUE_BRIGHT + "|");
                }
            }
            System.out.println(ConsoleColors.BLUE_BRIGHT + "|------------------------------------------------------------------------------------------------------------------------------------------------|");
        }
    }

    /**
     * Visualiza los puntos de la simulación o del juego de un enfrentamiento en concreto.
     * @param en Recibe un enfrentamiento
     * @param sj Recibe un entero:
     *           <ul>
     *                  <li>1: simular()</li>
     *                  <li>!=1: jugar()</li>
     *           </ul>
     * @param puntosLocal Recibe los puntos del equipo Local.
     * @param puntosVis Recibe los puntos del equipo Visitante.
     */
    public static void showEnfrentamientos(EnfrentamientoPetanca en,int sj, int puntosLocal, int puntosVis) {
        if (en != null) { //Si existe el enfrentamiento
            System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.PURPLE_BOLD + "-------------------------------------------------------------- ENFRENTAMIENTOS -----------------------------------------------------------" + ConsoleColors.BLUE_BRIGHT + "|");
            //Muestra los nombres de los jugadores del enfrentamiento
            System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.PURPLE_BOLD + "-----------------------------JUGADOR "+en.getjLocal().getNombre()+"------------------------------ " + ConsoleColors.RED + " VS " + ConsoleColors.PURPLE_BOLD +" --------------------------JUGADOR--------------"+en.getjVis().getNombre() + "-----------|"+ ConsoleColors.BLUE_BRIGHT);
            //Muestra los datos de ambos jugadores
            if (en.getjLocal().getNombre().length() >= 9 || en.getjVis().getNombre().length() >= 9 || String.valueOf(en.getVisitante()).length() >= 2 || String.valueOf(en.getLocal()).length() >= 2 || String.valueOf(en.getjLocal().getCoef()).length() >= 2 || String.valueOf(en.getjVis().getCoef()).length() >= 2) {
                System.out.println("|Nombre Jugador = " + en.getjLocal().getNombre() + ", Coeficiente Jugador = " + en.getjLocal().getCoef() + ", Puntos Equipo = " + puntosLocal + ConsoleColors.RED + " VS " + ConsoleColors.BLUE_BRIGHT + "Nombre Jugador = " + en.getjVis().getNombre() + ", Coeficiente Jugador = " + en.getjVis().getCoef() + ", Puntos Equipo = " + puntosLocal + " |");
            } else {
                System.out.println("|Nombre Jugador = " + en.getjLocal().getNombre() + ", Coeficiente Jugador = " + en.getjLocal().getCoef() + ", Puntos Equipo = " + puntosVis + ConsoleColors.RED + " VS " + ConsoleColors.BLUE_BRIGHT + "Nombre Jugador = " + en.getjVis().getNombre() + ", Coeficiente Jugador = " + en.getjVis().getCoef() + ", Puntos Equipo = " + puntosVis + "\t |");
            }
            //Muestra los puntos generados de la simulación o del juego.
            if(sj==1){
                System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.GREEN_BOLD + "-------------------------------------------------------------- PUNTOS SIMULADOS: "+ en.simular(puntosLocal, puntosVis)+" ------------------------------------------------------" + ConsoleColors.BLUE_BRIGHT + "|");
            }else{
                System.out.println(ConsoleColors.BLUE_BRIGHT + "|" + ConsoleColors.GREEN_BOLD + "-------------------------------------------------------------- PUNTOS JUGADOS: "+ en.jugar(puntosLocal, puntosVis)+" ------------------------------------------------------" + ConsoleColors.BLUE_BRIGHT + "|");
            }

        }
    }

    /**
     * Muestra las estadísticas de todos los equipos de la Liga
     * @param equipos Lista de equipos de la Liga
     * @param tipo variable de tipo cadena, recibe el tipo de ordenación
     */
    public static void showEstadisticas(List<EquipoLiga> equipos, String tipo) {
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "*************************************************************** ESTADISTICAS "+tipo+" **********************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_UNDERLINED + "---------------------------------------------------------------- EQUIPOS --------------------------------------------------------------------------" + ConsoleColors.RESET);

        int i = 1;
        Iterator<EquipoLiga> it = equipos.iterator();
        while (it.hasNext()) { //recorremos la lista de equiposLiga
            EquipoLiga eL = (EquipoLiga) it.next(); //Obtiene el equipo
            //Muestra las estadísticas de cada equipo de la Liga.
            System.out.println(ConsoleColors.YELLOW_UNDERLINED + "------------------------------ " + eL.getE().getNombre() + " -----------------------------------------------------------------------------------------------------------" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BRIGHT + "| \tP\t\t\tPJ\t\t\tPG\t\t\tPE\t\t\tPP\t\t\tEG\t\t\tEE\t\t\tEP\t\t\t\t\t\t\t\t\t\t\t\t\t\t |");
            System.out.println("| \t" + eL.getEst().getPuntos() + "\t\t\t" + eL.getEst().getPartJugados() + "\t\t\t" + eL.getEst().getPartGanados() + "\t\t\t" + eL.getEst().getPartEmpatados() + "\t\t\t" + eL.getEst().getPartPerdidos() + "\t\t\t" + eL.getEst().getEnfrenGanados() + "\t\t\t" + eL.getEst().getEnfrenEmpatados() + "\t\t\t" + eL.getEst().getEnfrenPerdidos() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t |");
            System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------|");
            i++;
        }

    }

}
