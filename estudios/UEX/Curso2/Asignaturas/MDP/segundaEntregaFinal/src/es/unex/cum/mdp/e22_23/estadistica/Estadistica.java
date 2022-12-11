package es.unex.cum.mdp.e22_23.estadistica;

import java.util.Objects;

/**
 * Clase Abstracta Estadística
 * Contiene todos los datos estadísticos de un equipo que participa en un determinado campeonato
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 */

public abstract class Estadistica {

    //Atributos
    protected int puntos;   //Puntos de un equipo.
    protected int partJugados;  //Partidos Jugados de un equipo
    protected int partGanados; //Partidos ganados de un equipo
    protected int partEmpatados; //Partidos empatados de un equipo
    protected int partPerdidos; //Partidos perdidos de un equipo
    protected int enfrenGanados; //Enfrentamientos ganados de un equipo
    protected int enfrenEmpatados; //Enfrentamientos empatados de un equipo
    protected int enfrenPerdidos; //Enfrentamientos perdidos de un equipo


    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos y objetos de la
     * clase.
     */
    public Estadistica() {
        puntos = 0;
        partJugados = 0;
        partGanados = 0;
        partEmpatados = 0;
        partPerdidos = 0;
        enfrenGanados = 0;
        enfrenEmpatados = 0;
        enfrenPerdidos = 0;

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
    public Estadistica(int puntos, int partJugados, int partGanados, int partEmpatados, int partPerdidos, int enfrenGanados, int enfrenEmpatados, int enfrenPerdidos) {
        this.puntos = puntos;
        this.partJugados = partJugados;
        this.partGanados = partGanados;
        this.partEmpatados = partEmpatados;
        this.partPerdidos = partPerdidos;
        this.enfrenGanados = enfrenGanados;
        this.enfrenEmpatados = enfrenEmpatados;
        this.enfrenPerdidos = enfrenPerdidos;
    }

    /**
     * Constructor Copia
     * @param est, recibe un objeto de tipo Estadística
     */
    public Estadistica(Estadistica est){
        this.puntos = est.puntos;
        this.partJugados = est.partJugados;
        this.partGanados = est.partGanados;
        this.partEmpatados = est.partEmpatados;
        this.partPerdidos = est.partPerdidos;
        this.enfrenGanados = est.enfrenGanados;
        this.enfrenEmpatados = est.enfrenEmpatados;
        this.enfrenPerdidos = est.enfrenPerdidos;
    }

    //Getters

    /**
     * Recupera los puntos de un equipo
     * @return puntos Variable de tipo entero. Devuelve los puntos de un equipo
     */

    public int getPuntos() {
        return puntos;
    }


    /**
     * Recupera los partidos Jugados de un equipo.
     *
     * @return partJugados Variable de tipo entero. Devuelve los partidos Jugados de un equipo.
     */
    public int getPartJugados() {
        return partJugados;
    }

    /**
     * Recupera los partidos Ganados de un equipo.
     *
     * @return partGanados Variable de tipo entero. Devuelve los partidos Ganados de un equipo.
     */

    public int getPartGanados() {
        return partGanados;
    }

    /**
     * Recupera los partidos Empatados de un equipo.
     *
     * @return partEmpatados Variable de tipo entero. Devuelve los partidos Empatados de un equipo.
     */

    public int getPartEmpatados() {
        return partEmpatados;
    }

    /**
     * Recupera los partidos Perdidos de un equipo.
     *
     * @return partPerdidos Variable de tipo entero. Devuelve los partidos Perdidos de un equipo.
     */
    public int getPartPerdidos() {
        return partPerdidos;
    }

    /**
     * Recupera los enfrentamientos Ganados de un equipo.
     *
     * @return enfrenGanados Variable de tipo entero. Devuelve los enfrentamientos Ganados de un equipo.
     */

    public int getEnfrenGanados() {
        return enfrenGanados;
    }

    /**
     * Recupera los enfrentamientos Empatados de un equipo.
     *
     * @return enfrenEmpatados Variable de tipo entero. Devuelve los enfrentamientos Empatados de un equipo.
     */


    public int getEnfrenEmpatados() {
        return enfrenEmpatados;
    }

    /**
     * Recupera los enfrentamientos Perdidos de un equipo.
     *
     * @return enfrenPerdidos Variable de tipo entero. Devuelve los enfrentamientos Perdidos de un equipo.
     */


    public int getEnfrenPerdidos() {
        return enfrenPerdidos;
    }

    //Setters

    /**
     * Modifica los puntos de un equipo.
     *
     * @param puntos Variable de tipo entero. Recibe los puntos de un equipo.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Modifica los partidos Jugados de un equipo.
     *
     * @param partJugados Variable de tipo entero. Recibe los partidos Jugados de un equipo.
     */

    public void setPartJugados(int partJugados) {
        this.partJugados = partJugados;
    }

    /**
     * Modifica los partidos Ganados de un equipo.
     *
     * @param partGanados Variable de tipo entero. Recibe los partidos Ganados de un equipo.
     */

    public void setPartGanados(int partGanados) {
        this.partGanados = partGanados;
    }

    /**
     * Modifica los partidos Empatados de un equipo.
     *
     * @param partEmpatados Variable de tipo entero. Recibe los partidos Empatados de un equipo.
     */

    public void setPartEmpatados(int partEmpatados) {
        this.partEmpatados = partEmpatados;
    }

    /**
     * Modifica los partidos Perdidos de un equipo.
     *
     * @param partPerdidos Variable de tipo entero. Recibe los partidos Perdidos de un equipo.
     */
    public void setPartPerdidos(int partPerdidos) {
        this.partPerdidos = partPerdidos;
    }

    /**
     * Modifica los enfrentamientos Ganados de un equipo.
     *
     * @param enfrenGanados Variable de tipo entero. Recibe los enfrentamientos Ganados de un equipo.
     */
    public void setEnfrenGanados(int enfrenGanados) {
        this.enfrenGanados = enfrenGanados;
    }

    /**
     * Modifica los enfrentamientos Empatados de un equipo.
     *
     * @param enfrenEmpatados Variable de tipo entero. Recibe los enfrentamientos Empatados de un equipo.
     */
    public void setEnfrenEmpatados(int enfrenEmpatados) {
        this.enfrenEmpatados = enfrenEmpatados;
    }

    /**
     * Modifica los enfrentamientos Perdidos de un equipo.
     *
     * @param enfrenPerdidos Variable de tipo entero. Recibe los enfrentamientos Perdidos de un equipo.
     */

    public void setEnfrenPerdidos(int enfrenPerdidos) {
        this.enfrenPerdidos = enfrenPerdidos;
    }

    /**
     * Redefine el método equals de la clase Object, que comprueba la igualdad
     * de todos los atributos y objetos de la clase Persona.
     *
     * @param o Recibe un objeto de tipo Object.
     * @return booleano Devuelve un valor de tipo booleano
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estadistica that = (Estadistica) o;
        return puntos == that.puntos && partJugados == that.partJugados && partGanados == that.partGanados && partEmpatados == that.partEmpatados && partPerdidos == that.partPerdidos && enfrenGanados == that.enfrenGanados && enfrenEmpatados == that.enfrenEmpatados && enfrenPerdidos == that.enfrenPerdidos;
    }

    /**
     * Devuelve un código hash para el objeto
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(puntos, partJugados, partGanados, partEmpatados, partPerdidos, enfrenGanados, enfrenEmpatados, enfrenPerdidos);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estadistica{");
        sb.append("puntos=").append(puntos);
        sb.append(", partJugados=").append(partJugados);
        sb.append(", partGanados=").append(partGanados);
        sb.append(", partEmpatados=").append(partEmpatados);
        sb.append(", partPerdidos=").append(partPerdidos);
        sb.append(", enfrenGanados=").append(enfrenGanados);
        sb.append(", enfrenEmpatados=").append(enfrenEmpatados);
        sb.append(", enfrenPerdidos=").append(enfrenPerdidos);
        sb.append('}');
        return sb.toString();
    }
}
