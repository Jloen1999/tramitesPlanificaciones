package es.unex.cum.mdp.e22_23.Partido;

import es.unex.cum.mdp.e22_23.enfrentamiento.EnfrentamientoPetanca;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.persona.Jugador;

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
            l=new EquipoLiga(10,null,new EstadisticaPetanca());
            v=new EquipoLiga(10,null,new EstadisticaPetanca());
            p= new PartidoPetanca(1,l,v);

        }else {
            l=new EquipoLiga(10,null,new EstadisticaPetanca());
            v=new EquipoLiga(10,null,new EstadisticaPetanca());
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
//        p.crearEnfrentamientos(l.getJugadores(), v.getJugadores());
//        System.out.println(l.getJugadores());
//        System.out.println(v.getJugadores());
//        for (EnfrentamientoPetanca enf:p.getEnfrentamientos()
//             ) {
//            System.out.println(enf);
//        }
//        p.simular();
//        for (EnfrentamientoPetanca enf:p.getEnfrentamientos()
//        ) {
//            System.out.println(enf);
//        }
//        System.out.println("Puntuacion del equipo Local en EquipoLiga: "+l.getCoef());
//        System.out.println("Puntuacion del equipo Visitante en equipoLiga: "+v.getCoef());
//        System.out.println("Puntuacion del equipo Local en Partido: "+p.getPuntosLocal());
//        System.out.println("Puntuacion del equipo Visitante en Partido: "+p.getPuntosVisitante());

        if (tipo.equals("Futbolin")) {
            p= new PartidoPetanca(1,l,v);

        }else {
            p= new PartidoPetanca(1,l,v);
        }
        p.crearEnfrentamientos(l.getJugadores(), v.getJugadores());
        System.out.println(l.getJugadores());
        System.out.println(v.getJugadores());
        for (EnfrentamientoPetanca enf:p.getEnfrentamientos()
        ) {
            System.out.println(enf);
        }
        //p.jugar(new int[]{10,3,1}, new int[] {12,7,8} );
        p.simular();
        for (EnfrentamientoPetanca enf:p.getEnfrentamientos()
        ) {
            System.out.println(enf);
        }
        System.out.println("Puntuacion del equipo Local en EquipoLiga: "+l.getCoef());
        System.out.println("Puntuacion del equipo Visitante en equipoLiga: "+v.getCoef());
        System.out.println("Puntuacion del equipo Local en Partido: "+p.getPuntosLocal());
        System.out.println("Puntuacion del equipo Visitante en Partido: "+p.getPuntosVisitante());
        p.actualizarEstadistica();
        System.out.println(l.toString());
        System.out.println(v.toString());

    }
}
