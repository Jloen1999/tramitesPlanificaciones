package es.unex.cum.mdp.e22_23.exceptions;

/**
 * Clase NoEquipoException
 *  * Clase que captura los errores relacionados con un equipo.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */

public class NoEquipoException extends Exception{

    public NoEquipoException() {
        super();
        System.out.println("No existe la lista de Equipos");
    }

    public NoEquipoException(String msg)
    {
        super(msg);
    }

    public NoEquipoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
