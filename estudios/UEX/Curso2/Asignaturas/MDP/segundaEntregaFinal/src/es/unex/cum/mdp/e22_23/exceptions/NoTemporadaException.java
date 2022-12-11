package es.unex.cum.mdp.e22_23.exceptions;

import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
/**
 * Clase NoTemporadaException
 * Clase que captura los errores relacionados con una temporada.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */

public class NoTemporadaException extends Exception{

    public NoTemporadaException() {
        super();
        System.out.println(ConsoleColors.RED+"Error, No exista la Temporada"+ConsoleColors.RESET);
    }

    public NoTemporadaException(String msg)
    {
        super(msg);
    }

    public NoTemporadaException(String msg, Throwable cause){
        super(msg, cause);
    }
}
