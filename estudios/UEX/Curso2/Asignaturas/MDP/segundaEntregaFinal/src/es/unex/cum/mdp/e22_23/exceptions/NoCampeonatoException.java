package es.unex.cum.mdp.e22_23.exceptions;

import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
/**
 * Clase NoCampeonatoException
 * Clase que captura los errores relacionados con un Campeonato
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 29/11/2022
 */

public class NoCampeonatoException extends Exception{
    public NoCampeonatoException(String msg){
        super(msg);
    }
    public NoCampeonatoException(){
        super();
        System.out.println(ConsoleColors.RED+"Error, NO existe el Campeonato"+ConsoleColors.RESET);
    }

    public NoCampeonatoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
