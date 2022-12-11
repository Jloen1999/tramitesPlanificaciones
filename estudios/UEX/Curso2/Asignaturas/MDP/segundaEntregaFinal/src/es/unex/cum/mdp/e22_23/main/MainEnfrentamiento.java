package es.unex.cum.mdp.e22_23.main;

import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.Partido.PartidoPetanca;
import es.unex.cum.mdp.e22_23.enfrentamiento.Enfrentamiento;
import es.unex.cum.mdp.e22_23.enfrentamiento.EnfrentamientoPetanca;
import es.unex.cum.mdp.e22_23.persona.Jugador;
import es.unex.cum.mdp.e22_23.utils.ShowPetanca;

public class MainEnfrentamiento {
    private String tipo="Petanca";
    private Jugador j1=new Jugador("Pepe",1,20,"Pepe",10);
    private Jugador j2=new Jugador("Ana",2,22,"Ana",12);
    private Jugador j3=new Jugador("Juan",3,24,"Jaun",14);
    private Jugador j4=new Jugador("Lupe",4,26,"Lupe",12);
    private Partido p= new PartidoPetanca();
    public static void main(String[]args) {
        MainEnfrentamiento m= new MainEnfrentamiento();
        m.run();
    }

    public void run() {
        Enfrentamiento e=null;
        if (tipo.equals("Futbolin")) {
            //e = new EnfrentamientoFutbolin(1,j1,j2,j3,j4);
        }else {
            e = new EnfrentamientoPetanca(1,j1,j2);
        }
        ShowPetanca.showEnfrentamientos((EnfrentamientoPetanca) e,1,14, 10);
        ShowPetanca.showEnfrentamientos((EnfrentamientoPetanca) e,1, 16, 10);
        ShowPetanca.showEnfrentamientos((EnfrentamientoPetanca) e, 1,11, 9);

        ShowPetanca.showEnfrentamientos((EnfrentamientoPetanca) e, 2,5, 5);
        ShowPetanca.showEnfrentamientos((EnfrentamientoPetanca) e, 2,2, 4);
        ShowPetanca.showEnfrentamientos((EnfrentamientoPetanca) e, 2,5, 2);
    }

}
