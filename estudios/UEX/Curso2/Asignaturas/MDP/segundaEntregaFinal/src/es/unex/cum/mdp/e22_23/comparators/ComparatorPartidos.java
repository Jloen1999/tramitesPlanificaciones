package es.unex.cum.mdp.e22_23.comparators;

import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;

import java.util.Comparator;

/**
 * Clase ComparatorPartidos
 *Compara los partidos:
 * <ul>
 *     <li>Ganados</li>
 *     <li>Perdidos</li>
 *     <li>Empatados</li>
 * </ul>
 */
public class ComparatorPartidos implements Comparator<EquipoLiga> {
    /**
     * Compara los partidos ganados y/o empatados y/o perdidos
     * de los equipos Local y Visitante de la Liga.
     * @param eL el primer objeto a comparar(EquipoLiga Local)
     * @param eV el segundo objeto a comparar(EquipoLiga Visitante).
     * @return entero, Devuelve un valor de tipo entero:
     * <ul>
     *     <li>Entero mayor que cero->Gana el equipoLiga Local.</li>
     *     <li>Entero igual a cero->El equipoLiga Local y Visitante están empatados.</li>
     *     <li>Entero menor que cero->Gana el equipoLiga Visitante.</li>
     * </ul>
     */
    @Override
    public int compare(EquipoLiga eL, EquipoLiga eV) {
        int comparison = Integer.compare(eL.getEst().getPartGanados(), eV.getEst().getPartGanados()); //Primero comparamos los partidos ganados
        if(comparison != 0){
            return comparison;
        }
        comparison = Integer.compare(eL.getEst().getPartEmpatados(), eV.getEst().getPartEmpatados()); //Segundo comparamos los partidos empatados
        if(comparison != 0){
            return comparison;
        }
        return Integer.compare(eL.getEst().getPartPerdidos(), eV.getEst().getPartPerdidos()); //Y por último comparamos los partidos perdidos
    }
}
