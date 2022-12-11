package es.unex.cum.mdp.e22_23.comparators;

import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;

import java.util.Comparator;

/**
 * Clase ComparatorEnfrentamientos
 * Compara los enfrentamientos
 * <ul>
 *     <li>Ganados</li>
 *     <li>Perdidos</li>
 *     <li>Empatados</li>
 * </ul>
 * de los equiposLiga Local y Visitante.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 * @see Comparator#compare(Object, Object)
 * @see EquipoLiga
 */

public class ComparatorEnfrentamientos implements Comparator<EquipoLiga> {

    /**
     * Compara los enfrentamientos ganados y/o empatados y/o perdidos
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
        int comparison = Integer.compare(eL.getEst().getEnfrenGanados(), eV.getEst().getEnfrenGanados()); //Primero comparamos los enfrentamientos ganados
        if(comparison != 0){
            return comparison;
        }
        comparison = Integer.compare(eL.getEst().getEnfrenEmpatados(), eV.getEst().getEnfrenEmpatados()); //Segundo comparamos los enfrentamientos empatados
        if(comparison != 0){
            return comparison;
        }
        return Integer.compare(eL.getEst().getEnfrenPerdidos(), eV.getEst().getEnfrenPerdidos()); //Y por último comparamos los enfrentamientos perdidos
    }
}
