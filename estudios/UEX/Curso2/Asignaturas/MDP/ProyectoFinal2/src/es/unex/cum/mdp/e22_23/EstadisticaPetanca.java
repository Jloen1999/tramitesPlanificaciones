package es.unex.cum.mdp.e22_23;

/**
 * Clase EstadisticaPetanca
 * Contiene
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 * @see es.unex.cum.mdp.e22_23.Estadistica Clase Padre Estadistica, tipo Abstract
 */

public class EstadisticaPetanca extends Estadistica {

    //No tiene atributos derivados

//Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public EstadisticaPetanca() {
        super();
    }

    /**
     * Constructor parametrizado.
     *
     * @param puntos          Recibe un valor de tipo entero.
     * @param partJugados     Recibe un valor de tipo entero.
     * @param partGanados     Recibe un valor de tipo entero.
     * @param partEmpatados   Recibe un valor de tipo entero.
     * @param partPerdidos    Recibe un valor de tipo entero.
     * @param enfrenGanados   Recibe un valor de tipo entero.
     * @param enfrenEmpatados Recibe un valor de tipo entero.
     * @param enfrenPerdidos  Recibe un valor de tipo entero.
     */
    public EstadisticaPetanca(int puntos, int partJugados, int partGanados, int partEmpatados, int partPerdidos, int enfrenGanados, int enfrenEmpatados, int enfrenPerdidos) {
        super(puntos, partJugados, partGanados, partEmpatados, partPerdidos, enfrenGanados, enfrenEmpatados, enfrenPerdidos);
    }


    /**
     * Calcula/Devuelve el total de puntos de cada Partido
     *
     * @return entero Devuelve la suma de las puntuaciones en base a:
     * <ul>
     *     <li>Partidos Ganados(partGanados)->5 puntos</li>
     *     <li>Partidos Empatados(partEmpatados)->2 puntos</li>
     *     <li>Partidos Perdidos(partPerdidos)->-3 puntos</li>
     * </ul>
     */

    @Override
    public int getPuntos() {
        return partGanados * 5 + partEmpatados * 2 + partPerdidos * (-3);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo entero
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EstadisticaPetanca{");
        sb.append('}');
        return sb.toString();
    }
}
