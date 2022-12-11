package es.unex.cum.mdp.e22_23.exceptions;

import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
/**
 * Clase NoPersonaException
 * Clase que captura los errores relacionados con una persona.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */

public class NoPersonaException extends Exception{

    public NoPersonaException() {
        super();
        System.out.println(ConsoleColors.RED+"Error, No existe la Persona"+ConsoleColors.RESET);
    }

    public NoPersonaException(String msg)
    {
        super(msg);
    }

    public NoPersonaException(String msg, Throwable cause){
        super(msg, cause);
    }
}
