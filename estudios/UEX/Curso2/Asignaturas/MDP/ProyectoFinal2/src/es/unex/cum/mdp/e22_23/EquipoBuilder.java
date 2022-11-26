package es.unex.cum.mdp.e22_23;

import es.unex.cum.mdp.e22_23.Directivo;
import es.unex.cum.mdp.e22_23.Equipo;

public class EquipoBuilder {
    private String nombre;
    private String ciudad;
    private Directivo cargo;

    public EquipoBuilder() {
    }

    public EquipoBuilder withNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }


    public EquipoBuilder withCiudad(final String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public EquipoBuilder withCargo(final Directivo cargo) {
        this.cargo = cargo;
        return this;
    }


    public Equipo build() {
        return new Equipo(this.nombre, this.ciudad, this.cargo);
    }

    @java.lang.Override
    public String toString() {
        return "Equipo.EquipoBuilder(nombre=" + this.nombre + ", ciudad=" + this.ciudad + ", cargo="
                + this.cargo + ")";
    }
}
