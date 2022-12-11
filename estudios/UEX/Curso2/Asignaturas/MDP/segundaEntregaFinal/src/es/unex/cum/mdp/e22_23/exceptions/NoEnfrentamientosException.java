package es.unex.cum.mdp.e22_23.exceptions;

import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
/**
 * Clase NoEnfrentamientosException
 * Clase que captura los errores relacionados con enfrentamientos
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */

public class NoEnfrentamientosException extends Exception{

    public NoEnfrentamientosException() {
        super();
        System.out.println(ConsoleColors.RED+"Error, No hay enfrentamientos"+ConsoleColors.RESET);
    }

    public NoEnfrentamientosException(String msg)
    {
        super(msg);
    }

    public NoEnfrentamientosException(String msg, Throwable cause){
        super(msg, cause);
    }
}
