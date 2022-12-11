package es.unex.cum.mdp.e22_23.estadistica;

/**
 * Clase EstadisticaPetanca
 * Contiene todos los datos estadísticos de un equipo que participa del campeonato Petanca.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 * @see Estadistica Clase Padre Estadistica, tipo Abstract
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
     * @param puntos   Variable de tipo entero. Recibe los puntos de un equipo
     * @param partJugados  Variable de tipo entero. Recibe los partidos jugados de un equipo
     * @param partGanados  Variable de tipo entero. Recibe los partidos Ganados de un equipo
     * @param partEmpatados  Variable de tipo entero. Recibe los partidos empatados de un equipo
     * @param partPerdidos  Variable de tipo entero. Recibe los partidos Perdidos de un equipo
     * @param enfrenGanados  Variable de tipo entero. Recibe los enfrentamientos ganados de un equipo
     * @param enfrenEmpatados Variable de tipo entero. Recibe los enfrentamientos empatados de un equipo
     * @param enfrenPerdidos  Variable de tipo entero. Recibe los enfrentamientos Perdidos de un equipo
     */
    public EstadisticaPetanca(int puntos, int partJugados, int partGanados, int partEmpatados, int partPerdidos, int enfrenGanados, int enfrenEmpatados, int enfrenPerdidos) {
        super(puntos, partJugados, partGanados, partEmpatados, partPerdidos, enfrenGanados, enfrenEmpatados, enfrenPerdidos);
    }

    /**
     * Constructor Copia
     * @param est, recibe un objeto de tipo EstadísticaPetanca
     */
    public EstadisticaPetanca(EstadisticaPetanca est) {
        super(est);
    }

            //TODO: Métodos a implementar
    /**
     * Calcula/Devuelve el total de puntos de cada Partido
     *
     * @return puntos Variable de tipo entero. Devuelve la suma de las puntuaciones en base a:
     * <ul>
     *     <li>Partidos Ganados(partGanados)->5 puntos</li>
     *     <li>Partidos Empatados(partEmpatados)->2 puntos</li>
     *     <li>Partidos Perdidos(partPerdidos)->-3 puntos</li>
     * </ul>
     * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/master/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/EstadisticaPetanca/Clase%20EstadisticaPetanca.md#getpuntos-int">Prerrequisitos y Flujo norma y alterno</a>
     */
    @Override
    public int getPuntos() { //Redefinimos el método getPuntos
        puntos = partGanados*5 + partEmpatados*2 + partPerdidos*(-3);
        return puntos;
    }


}
