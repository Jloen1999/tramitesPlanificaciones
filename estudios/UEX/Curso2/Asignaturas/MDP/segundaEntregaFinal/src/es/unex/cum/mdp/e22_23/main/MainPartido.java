package es.unex.cum.mdp.e22_23.main;

import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.Partido.PartidoPetanca;
import es.unex.cum.mdp.e22_23.enfrentamiento.EnfrentamientoPetanca;
import es.unex.cum.mdp.e22_23.equipo.Equipo;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.exceptions.NoEnfrentamientosException;
import es.unex.cum.mdp.e22_23.exceptions.NoPartidoException;
import es.unex.cum.mdp.e22_23.persona.Jugador;
import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
import es.unex.cum.mdp.e22_23.utils.ShowPetanca;

import java.util.Random;

public class MainPartido {
    private String tipo="Petanca";
    private EquipoLiga l=null;
    private EquipoLiga v=null;
    private Partido p=null;

    public static void main(String []args) {
        MainPartido m= new MainPartido();
        m.run();
    }
    public void run() {
        if (tipo.equals("Petanca")) {
            l=new EquipoLiga(10,new Equipo("Madrid","Madrid",null),new EstadisticaPetanca());
            v=new EquipoLiga(12,new Equipo("Barcelona","Barcelona",null),new EstadisticaPetanca());
            p= new PartidoPetanca(1,l,v);

        }else {
            l=new EquipoLiga(10,new Equipo("Jose","Mérida",null),new EstadisticaPetanca());
            v=new EquipoLiga(10,new Equipo("Manuel","Cáceres",null),new EstadisticaPetanca());
            p= new PartidoPetanca(1,l,v);
        }

        Random r= new Random();
        for (int i=0;i<10;i++) {
            Jugador j=new Jugador("Jugador"+(i+1),i+1,26,"Jugador"+(i+1),r.nextInt(10));
            l.addJugadores(j);
        }
        for (int i=10;i<20;i++) {
            Jugador j=new Jugador("Jugador"+(i+1),i+1,26,"Jugador"+(i+1),r.nextInt(10));
            v.addJugadores(j);
        }


        if (tipo.equals("Futbolin")) {
            p= new PartidoPetanca(1,l,v);

        }else {
            p= new PartidoPetanca(1,l,v);
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-------------------------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| CREANDO ENFRENTAMIENTOS |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-------------------------|                                                                  " + ConsoleColors.RESET);
        p.crearEnfrentamientos(l.getJugadores(), v.getJugadores());

        //Después de crear enfrentamientos Visualizamos los datos del partido
        try {
            ShowPetanca.showOnlyPartido(p,1);
        } catch (NoPartidoException | NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| JUGANDO |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------|                                                                  " + ConsoleColors.RESET);
        p.jugar(new int[]{10,3,1}, new int[] {12,7,8} );
        //Después de jugar Visualizamos los datos del partido
        try {
            ShowPetanca.showOnlyPartido(p,1);
        } catch (NoPartidoException | NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| SIMULANDO |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
        p.simular();
        //Después de simular Visualizamos los datos del partido
        try {
            ShowPetanca.showOnlyPartido(p,1);
        } catch (NoPartidoException | NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------------------------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| ACTUALIZANDO ESTADÍSTICAS |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------------------------|                                                                  " + ConsoleColors.RESET);
        p.actualizarEstadistica();
        //Después de actualizar Estadistica Visualizamos los datos del partido
        try {
            ShowPetanca.showOnlyPartido(p,1);
        } catch (NoPartidoException | NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }


    }
}
