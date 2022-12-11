package es.unex.cum.mdp.e22_23.comparators;

import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;

import java.util.Comparator;

public class ComparatorPuntos implements Comparator<EquipoLiga> {

    /**
     * Compara los puntos de los equipos Local y Visitante de la Liga.
     * @param eL the first object to be compared.
     * @param eV the second object to be compared.
     * @return entero, Devuelve un valor entero
     * <ul>
     *     <li>Positivo: mayor puntuacion o numero de enfrentamientos ganados del equipo Local</li>
     *     <li>Negativo: menor puntuación o numero de enfrentamientos ganados del equipo Visitante</li>
     *     <li>0: Ambos equipos tienen el mismo número de puntuación o enfrentamientos ganados.</li>
     * </ul>
     */
    @Override
    public int compare(EquipoLiga eL, EquipoLiga eV) {
        /*
        *   return valor mayor que 0->Tiene mayor puntuación el equipoLiga Local
        *   return valor menor que 0->Tiene mayor puntuación el equipoLiga Visitante
        *   return valor igual que 0->Ambnos equipos tienen los mismos puntos.
        *
         */
        return Integer.compare(eL.getEst().getPuntos(), eV.getEst().getPuntos());
    }


}
