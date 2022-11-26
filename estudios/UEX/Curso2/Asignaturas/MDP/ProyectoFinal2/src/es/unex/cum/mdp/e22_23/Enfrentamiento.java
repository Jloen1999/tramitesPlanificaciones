package es.unex.cum.mdp.e22_23;

/**
 * Interface Enfrentamiento
 * Permite modelar cada uno de los enfrentamientos que hay en un partido.
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2023
 */
public interface Enfrentamiento {
    public int simular(int coefEqLocal, int coefEqVis);
    public void operation();
    public int jugar(int gLocal, int gVis);
    public void operation2();
}
