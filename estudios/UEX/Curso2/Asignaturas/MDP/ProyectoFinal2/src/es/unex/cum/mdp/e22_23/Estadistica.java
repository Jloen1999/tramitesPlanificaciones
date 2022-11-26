package es.unex.cum.mdp.e22_23;

import java.util.Objects;

/**
 * Clase Abstracta Estadística
 * Contiene todos los datos estadísticos de un equipo que participa en un determinado campeonato
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 */

public abstract class Estadistica {

    //Atributos
    protected int puntos;
    protected int partJugados;
    protected int partGanados;
    protected int partEmpatados;
    protected int partPerdidos;
    protected int enfrenGanados;
    protected int enfrenEmpatados;
    protected int enfrenPerdidos;


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
     * @param puntos          Recibe un valor de tipo entero.
     * @param partJugados     Recibe un valor de tipo entero.
     * @param partGanados     Recibe un valor de tipo entero.
     * @param partEmpatados   Recibe un valor de tipo entero.
     * @param partPerdidos    Recibe un valor de tipo entero.
     * @param enfrenGanados   Recibe un valor de tipo entero.
     * @param enfrenEmpatados Recibe un valor de tipo entero.
     * @param enfrenPerdidos  Recibe un valor de tipo entero.
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

    //Getter

    /**
     * Recupera el valor del atributo puntos
     *
     * @return nombre Devuelve un valor de tipo entero
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Recupera el valor del atributo partJugados
     *
     * @return nombre Devuelve un valor de tipo entero
     */
    public int getPartJugados() {
        return partJugados;
    }

    /**
     * Recupera el valor del atributo partGanados
     *
     * @return nombre Devuelve un valor de tipo entero
     */

    public int getPartGanados() {
        return partGanados;
    }

    /**
     * Recupera el valor del atributo partEmpatados
     *
     * @return nombre Devuelve un valor de tipo entero
     */

    public int getPartEmpatados() {
        return partEmpatados;
    }

    /**
     * Recupera el valor del atributo partPerdidos
     *
     * @return nombre Devuelve un valor de tipo entero
     */
    public int getPartPerdidos() {
        return partPerdidos;
    }

    /**
     * Recupera el valor del atributo enfrenGanados
     *
     * @return nombre Devuelve un valor de tipo entero
     */

    public int getEnfrenGanados() {
        return enfrenGanados;
    }

    /**
     * Recupera el valor del atributo enfrenEmpatados
     *
     * @return nombre Devuelve un valor de tipo entero
     */

    public int getEnfrenEmpatados() {
        return enfrenEmpatados;
    }

    /**
     * Recupera el valor del atributo enfrenPerdidos
     *
     * @return nombre Devuelve un valor de tipo entero
     */

    public int getEnfrenPerdidos() {
        return enfrenPerdidos;
    }

    //Setter

    /**
     * Modifica el valor del atributo puntos
     *
     * @param puntos Recibe un valor de tipo entero
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Modifica el valor del atributo partJugados
     *
     * @param partJugados Recibe un valor de tipo entero
     */

    public void setPartJugados(int partJugados) {
        this.partJugados = partJugados;
    }

    /**
     * Modifica el valor del atributo partGanados
     *
     * @param partGanados Recibe un valor de tipo entero
     */

    public void setPartGanados(int partGanados) {
        this.partGanados = partGanados;
    }

    /**
     * Modifica el valor del atributo partEmpatados
     *
     * @param partEmpatados Recibe un valor de tipo entero
     */

    public void setPartEmpatados(int partEmpatados) {
        this.partEmpatados = partEmpatados;
    }

    /**
     * Modifica el valor del atributo partPerdidos
     *
     * @param partPerdidos Recibe un valor de tipo entero
     */
    public void setPartPerdidos(int partPerdidos) {
        this.partPerdidos = partPerdidos;
    }

    /**
     * Modifica el valor del atributo enfrenGanados
     *
     * @param enfrenGanados Recibe un valor de tipo entero
     */
    public void setEnfrenGanados(int enfrenGanados) {
        this.enfrenGanados = enfrenGanados;
    }

    /**
     * Modifica el valor del atributo enfrenEmpatados
     *
     * @param enfrenEmpatados Recibe un valor de tipo entero
     */
    public void setEnfrenEmpatados(int enfrenEmpatados) {
        this.enfrenEmpatados = enfrenEmpatados;
    }

    /**
     * Modifica el valor del atributo enfrenPerdidos
     *
     * @param enfrenPerdidos Recibe un valor de tipo entero
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
