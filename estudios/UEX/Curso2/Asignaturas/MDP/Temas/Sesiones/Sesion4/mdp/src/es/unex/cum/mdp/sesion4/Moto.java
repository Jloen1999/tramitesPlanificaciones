/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 * @see Vehiculo
 */


package es.unex.cum.mdp.sesion4;

import java.util.Objects;

public class Moto extends Vehiculo{
    private int potencia;

    public Moto() {
        potencia = 0;
    }


    public Moto(String marca, String modelo, Persona propietario, Integer bastidor, int potencia) {
        super(marca, modelo, propietario, bastidor);
        this.potencia = potencia;
    }

    public Moto(String marca, String modelo, Persona propietario, Integer bastidor) {
        super(marca, modelo, propietario, bastidor);
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Moto moto = (Moto) o;
        return potencia==moto.potencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), potencia);
    }

    @Override
    public String toString(){
        return "Moto[marca="+getMarca()+", modelo="+getModelo()+", bastidor="+getBastidor()+", potencia="+getPotencia()+"]";
    }
}
