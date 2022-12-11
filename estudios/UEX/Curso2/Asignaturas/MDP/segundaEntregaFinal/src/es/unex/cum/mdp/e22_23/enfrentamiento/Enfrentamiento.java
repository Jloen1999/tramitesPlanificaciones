package es.unex.cum.mdp.e22_23.enfrentamiento;

/**
 * Interface Enfrentamiento
 * Permite definir los métodos a implementar en el Enfrentamiento del Campeonato en cuestión.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 */
public interface Enfrentamiento {
    public int simular(int coefEqLocal, int coefEqVis);
    public int jugar(int gLocal, int gVis);
}
