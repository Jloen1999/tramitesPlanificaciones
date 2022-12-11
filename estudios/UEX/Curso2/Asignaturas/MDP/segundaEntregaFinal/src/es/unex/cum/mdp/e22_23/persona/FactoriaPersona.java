package es.unex.cum.mdp.e22_23.persona;


/**
 * Clase FactoriaPersona
 * Consiste en crear una persona según su tipo y atributos.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 2/12/2022
 */
public class FactoriaPersona {

    /**
     *
     *
     * @param tipo,   recibe un valor de tipo caden
     * @param nombre, recibe un valor de tipo cadena
     * @param id,     recibe un valor de tipo entero
     * @param edad,   recibe un valor de entero
     * @param value1, recibe un valor de tipo entero
     * @param value2, recibe un valor de tipo entero
     * @return Persona
     */
    public Persona build(String tipo, String nombre, int id, int edad, String value1, String value2) {
        Persona persona = null;

        if (tipo.equals("Jugador")) {
            persona = new Jugador(nombre, edad, id, value1, Integer.parseInt(value2));
        } else if (tipo.equals("Juez")) {
            persona = new Juez(nombre, edad, id, Integer.parseInt(value1));
        } else if (tipo.equals("Directivo")) {
            persona = new Directivo(nombre, edad, id, value1);
        }

        return persona;
    }
}
