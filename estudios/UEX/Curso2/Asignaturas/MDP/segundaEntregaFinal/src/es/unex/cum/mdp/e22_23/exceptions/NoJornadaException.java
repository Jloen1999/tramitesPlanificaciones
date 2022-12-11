package es.unex.cum.mdp.e22_23.exceptions;

import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
/**
 * Clase NoJornadaException
 *  * Clase que captura los errores relacionados con una Jornada
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */

public class NoJornadaException extends Exception{

    public NoJornadaException() {
        super();
        System.out.println(ConsoleColors.RED+"Error, No existe la Jornada"+ConsoleColors.RESET);
    }

    public NoJornadaException(String msg)
    {
        super(msg);
    }

    public NoJornadaException(String msg, Throwable cause){
        super(msg, cause);
    }
}
