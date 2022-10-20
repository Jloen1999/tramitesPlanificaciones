/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 * @see Vehiculo
 */

package es.unex.cum.mdp.sesion2;

import java.util.Objects;

public class Camion extends Vehiculo{
    private int tonelaje;

    public Camion() {
        tonelaje = 0;
    }


    public Camion(String marca, String modelo, Persona propietario, Integer bastidor, int tonelaje) {
        super(marca, modelo, propietario, bastidor);
        this.tonelaje = tonelaje;
    }

    public Camion(String marca, String modelo, Persona propietario, Integer bastidor) {
        super(marca, modelo, propietario, bastidor);
    }

    public int getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(int tonelaje) {
        this.tonelaje = tonelaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Camion camion = (Camion) o;
        return tonelaje==camion.tonelaje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tonelaje);
    }

    @Override
    public String toString(){
        return "Camion[marca="+getMarca()+", modelo="+getModelo()+", bastidor="+getBastidor()+", tonelaje="+getTonelaje()+"]";
    }
}
