package es.unex.cum.mdp.e22_23.main;

import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.Partido.PartidoPetanca;
import es.unex.cum.mdp.e22_23.equipo.Equipo;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaFutbolin;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.exceptions.NoEnfrentamientosException;
import es.unex.cum.mdp.e22_23.exceptions.NoJornadaException;
import es.unex.cum.mdp.e22_23.exceptions.NoPartidoException;
import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Jornada;
import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Liga;
import es.unex.cum.mdp.e22_23.persona.Jugador;
import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
import es.unex.cum.mdp.e22_23.utils.ShowPetanca;

import java.util.Date;
import java.util.Random;

public class MainJornada {
    private String tipo = "Petanca";
    private EquipoLiga l1 = null;
    private EquipoLiga l2 = null;
    private EquipoLiga v1 = null;
    private EquipoLiga v2 = null;
    private Partido p1 = null;
    private Partido p2 = null;
    private Jornada j = null;
    private Liga liga;

    public static void main(String[] args) {
        MainJornada m = new MainJornada();
        m.run();
    }

    public void run() {
        //Creamos los equipos y los añadimos a los partidos
        if (tipo.equals("Petanca")) {
            l1 = new EquipoLiga(10, new Equipo("Equipo1","Madrid",null), new EstadisticaPetanca());
            l2 = new EquipoLiga(15, new Equipo("Equipo2","Barcelona",null), new EstadisticaPetanca());
            v1 = new EquipoLiga(10, new Equipo("Equipo3","Madrid",null), new EstadisticaPetanca());
            v2 = new EquipoLiga(12, new Equipo("Equipo4","Madrid",null), new EstadisticaPetanca());
            p1 = new PartidoPetanca(1, l1, v1);
            p2 = new PartidoPetanca(2, l2, v2);
            j = new Jornada(new Date(2022, 12, 06), 1);
            liga = new Liga("Liga Española Petanca");
            //Añadimos los jugadores a cada uno de los equipos
            Random r = new Random();
            //Cuando cree los enfrentamientos está claro que ganará el equipo Visitante debido a que los coeficientes de sus jugadores son superiores y ambos equipos tienen la misma puntuación.
            for (int i = 0; i < 6; i++) {
                Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "nick" + (i + 1), r.nextInt(1,10));
                l1.addJugadores(j);
            }
            for (int i = 6; i < 12; i++) {
                Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "nick" + (i + 1), r.nextInt(10,15));
                v1.addJugadores(j);
            }

            //Cuando cree los enfrentamientos está claro que ganará el equipo Local debido a que dicho equipo tiene mayor puntuación y sus jugadores tienen el mismo coeficiente.
            for (int i = 12; i < 18; i++) {
                Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "nick" + (i + 1), 7);
                l2.addJugadores(j);
            }
            for (int i = 24; i < 30; i++) {
                Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "nick" + (i + 1), 7);
                v2.addJugadores(j);
            }

        } else {
//            l1 = new EquipoLiga(10, null, new EstadisticaFutbolin());
//            l2 = new EquipoLiga(10, null, new EstadisticaFutbolin());
//            v1 = new EquipoLiga(10, null, new EstadisticaFutbolin());
//            v2 = new EquipoLiga(10, null, new EstadisticaFutbolin());
            p1 = new PartidoPetanca(1, l1, v1);
            p2 = new PartidoPetanca(2, l2, v2);
        }

        //Creamos la Jornada y añadimos los partidos a la lista de Jornadas
        j = new Jornada(new Date(), 1);
        try {
            j.addPartidos(p1);
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            j.addPartidos(p2);
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        }
//        //Añadimos la Jornada a la Liga
//        liga.addJornada(j);
//        liga.addEquipoLiga(l1);
//        liga.addEquipoLiga(v1);
//        liga.addEquipoLiga(l2);
//        liga.addEquipoLiga(v2);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-------------------------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| CREANDO ENFRENTAMIENTOS |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-------------------------|                                                                  " + ConsoleColors.RESET);
        j.crearEnfrentamientosJornada();
        //Después de crear enfrentamientos Visualizamos los datos de la Jornada
        try {
            ShowPetanca.showManyPartidosJornada(j,1);
        } catch (NoPartidoException | NoEnfrentamientosException | NoJornadaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| SIMULANDO |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
        j.simular();
        //Después de simular Visualizamos los datos de la Jornada
        try {
            ShowPetanca.showManyPartidosJornada(j,1);
        } catch (NoPartidoException | NoEnfrentamientosException | NoJornadaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| JUGANDO |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------|                                                                  " + ConsoleColors.RESET);
        j.jugar(1,new int[]{4,6,8}, new int[]{5,9,3} );    //Simulamos los enfrentamientos
        //Después de jugar Visualizamos los datos de la Jornada
        try {
            ShowPetanca.showManyPartidosJornada(j,1);
        } catch (NoPartidoException | NoEnfrentamientosException | NoJornadaException e) {
            System.out.println(e.getMessage());
        }

    }
}
