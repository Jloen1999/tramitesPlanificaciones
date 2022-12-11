package es.unex.cum.mdp.e22_23.equipo;

import es.unex.cum.mdp.e22_23.persona.Directivo;

/**
 * Clase EquipoBuilder
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 22/11/2022
 * @see Directivo
 */
public class EquipoBuilder {

    //Atributos del objeto a construir
    private String nombre;
    private String ciudad;
    private Directivo cargo;
//    private int id;

    public EquipoBuilder() {
    }

    // Métodos setter que establecen los valores de cada atributo
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

    // Método build que crea y devuelve el objeto
    public Equipo build() {
        return new Equipo(this.nombre, this.ciudad, this.cargo);
    }

    @java.lang.Override
    public String toString() {
        return "Equipo.EquipoBuilder(nombre=" + this.nombre + ", ciudad=" + this.ciudad + ", cargo="
                + this.cargo + ")";
    }
}
