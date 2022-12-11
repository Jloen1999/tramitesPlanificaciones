package es.unex.cum.mdp.e22_23.exceptions;

import es.unex.cum.mdp.e22_23.utils.ConsoleColors;

/**
 * Clase NoLigaException.
 *  * Clase que captura los errores relacionados con una Liga
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */



public class NoLigaException extends Exception  {
    public NoLigaException(String msg){
        super(msg);
    }
    public NoLigaException(){
        super();
        System.out.println(ConsoleColors.RED+"Error, NO existe la Liga"+ConsoleColors.RESET);
    }

    public NoLigaException(String msg, Throwable cause){
        super(msg, cause);
    }
}
