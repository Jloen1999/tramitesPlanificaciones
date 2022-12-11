package es.unex.cum.mdp.e22_23.main;

import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.Partido.PartidoPetanca;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.persona.Jugador;

public class MainEquipoLiga {
    private Jugador j1=new Jugador("Pepe",1,20,"Pepe",10);
    private Jugador j2=new Jugador("Ana",2,22,"Ana",12);
    private Jugador j3=new Jugador("Juan",2,24,"Jaun",14);
    private Jugador j4=new Jugador("Lupe",4,26,"Lupe",12);
    private Partido p= new PartidoPetanca();
    public static void main(String[]args) {
        MainEquipoLiga m= new MainEquipoLiga();
        m.run();
    }

    public void run() {
        EquipoLiga el = new EquipoLiga();
        el.addJugadores(j1);
        el.addJugadores(j2);
        el.addJugadores(j3);
        el.addJugadores(j4);
        System.out.println(el.getJugadores()); //[Jugador{nick='Pepe', coef=10}, Jugador{nick='Ana', coef=12}, Jugador{nick='Lupe', coef=12}]
        System.out.println(el.getJugadorId(2)); //Jugador{nick='Ana', coef=12}
        System.out.println(el.getJugadorId(5)); //null

    }
}