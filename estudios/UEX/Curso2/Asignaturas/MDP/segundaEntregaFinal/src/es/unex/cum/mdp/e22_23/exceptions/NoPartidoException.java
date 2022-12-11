package es.unex.cum.mdp.e22_23.exceptions;

import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
/**
 * Clase NoPartidoException
 * Clase que captura los errores relacionados con un partido.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */

public class NoPartidoException extends Exception{

    public NoPartidoException() {
        super();
        System.out.println(ConsoleColors.RED+"Error, No existe el Partido"+ConsoleColors.RESET);
    }

    public NoPartidoException(String msg)
    {
        super(msg);
    }

    public NoPartidoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
