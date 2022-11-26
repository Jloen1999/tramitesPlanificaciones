package es.unex.cum.mdp.e22_23;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Clase Derivada PartidoPetanca
 * Contiene información de los partidos de cad Jornada.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 * @see es.unex.cum.mdp.e22_23.Partido Clase Padre Partido
 */

public class PartidoPetanca extends Partido {

    //Sin atributos derivados


    public PartidoPetanca() {
        super();
    }

    public PartidoPetanca(int id, int puntosLocal, int puntosVisitante, EquipoLiga local, EquipoLiga visitante) {
        super(id, puntosLocal, puntosVisitante, local, visitante);
    }

    public PartidoPetanca(Partido p, EquipoLiga local, EquipoLiga visitante) {
        super(p, local, visitante);
    }

    public PartidoPetanca(int id, EquipoLiga local, EquipoLiga visitante) {
        super(id, local, visitante);
    }

    /**
     * Se encarga de realizar la simulación de todos los enfrentamientos
     * del partido, actualizando los puntos de cada equipo. Además, debe
     * actualizar las estadísticas.
     */
    @Override
    public void simular() {
        for (int i = 0; i < getNumEnfrentamiento(); i++) {
          int resEnfrentamiento = super.getEnfrentamientos().get(i).simular(super.getLocal().getCoef(), super.getVisitante().getCoef());
          if(resEnfrentamiento>0){

          }else if(resEnfrentamiento<0){

          }else{

          }
        }
    }

    /**
     * @param golLocal
     * @param golVis
     */
    @Override
    public void jugar(int[] golLocal, int[] golVis) {
        EstadisticaPetanca est = new EstadisticaPetanca();
        EnfrentamientoPetanca en = new EnfrentamientoPetanca();
        Random gol = new Random();
        int totalPuntosL = 0, totalPuntosV = 0;
        for (int i = 0; i < getNumEnfrentamiento(); i++) {
            golLocal[i] = gol.nextInt(10);
            golVis[i] = gol.nextInt(10);

            if (golLocal[i] > golVis[i]) {
                totalPuntosL += 1;
            } else if (golLocal[i] < golVis[i]) {
                totalPuntosV += 1;
            }

        }

        if (en.simular(totalPuntosL, totalPuntosV) > 0) {
            est.setPartGanados(est.getPartGanados() + 1);
            est.setPartPerdidos(est.getPartPerdidos() + 1);
        }else if(en.simular(totalPuntosL, totalPuntosV) < 0){

        }else{

        }

    }

    /**
     *
     */
    @Override
    public void actualizarEstadistica() {

    }

    /**
     * @param lLocal
     * @param lVis
     */
    @Override
    public void crearEnfrentamientos(List lLocal, List lVis) {
        //Ordenamos ambas listas
        Collections.sort(lLocal);
        Collections.sort(lVis);
        for (int i = 0; i < getNumEnfrentamiento(); i++) {
            Iterator<Jugador> it = lLocal.iterator();
            Iterator<Jugador> it1 = lLocal.iterator();
            while (it.hasNext() && it1.hasNext()) {
                Jugador jL = (Jugador) it.next();
                //Jugador jV = (Jugador) it.next();


            }
        }
    }
}
