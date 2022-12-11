package es.unex.cum.mdp.e22_23.main;

import es.unex.cum.mdp.e22_23.equipo.Equipo;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.exceptions.NoEnfrentamientosException;
import es.unex.cum.mdp.e22_23.exceptions.NoJornadaException;
import es.unex.cum.mdp.e22_23.exceptions.NoLigaException;
import es.unex.cum.mdp.e22_23.exceptions.NoPartidoException;
import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Liga;
import es.unex.cum.mdp.e22_23.persona.Directivo;
import es.unex.cum.mdp.e22_23.persona.Jugador;
import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
import es.unex.cum.mdp.e22_23.utils.ShowPetanca;

import java.util.Random;

public class MainLiga {

    private static ConsoleColors color;
    private String tipo = "Petanca";
    private Liga liga = null;
    // Datos por liga
    private final int numJugadoresEquipo = 10; // Número de jugadores por equipo
    private final int numEquipoLiga = 4; // Número de equipos por liga. No puede ser impar

    public static void main(String[] args) {
        MainLiga m = new MainLiga();
        m.run();
    }

    public void run() {
        //Creamos la Liga
        liga = new Liga("2022-2023");
        //Creamos los equipos y los añadimos a los partidos
        if (tipo.equals("Petanca")) {
            Random r = new Random();
            //Equipos para la Jornada 1
            // Añado n equpo con nombre Equipo+i (con id +n)
            for (int i = 0; i < numEquipoLiga; i++) {
                liga.addEquipoLiga(new EquipoLiga(r.nextInt(1, 20), new Equipo("Equipo" + String.valueOf(i), "Ciudad" + String.valueOf(i), new Directivo("Manuel", 1, 40, "Presidente")), new EstadisticaPetanca()));
            }

            for (EquipoLiga eL:liga.getEquiposLiga()
                 ) {
                for (int i = 0; i < numJugadoresEquipo; i++) {
                    eL.addJugadores(new Jugador("Jugador" + (i + 1), i + 1, 26, "Jugador" + (i + 1), r.nextInt(10)));
                }
            }

            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                      |--------------|                                                                  " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT + "**********************************************************************| LIGA PETANCA |************************************************************" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                      |--------------|                                                                  " + ConsoleColors.RESET);
            liga.crearCalendario(tipo); //Creamos el calendario
            liga.simular(); //Simulamos los enfrentamientos
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| SIMULANDO |******************************************************************" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
            //Después de simular Visualizamos los datos de la Liga
                try {
                    ShowPetanca.showJornadaLiga(liga);
                } catch (NoLigaException e) {
                    System.out.println(e.getMessage());
                } catch (NoJornadaException e) {
                    System.out.println(e.getMessage());
                }

            try {
                liga.MostrarEstadistica(liga.getEquiposLiga(),""); //Mostramos las estadísticas de los equipos de la Liga
            } catch (NoLigaException e) {
                System.out.println(e.getMessage());
            }
            //Mostramos los partidos




        }
    }
}
