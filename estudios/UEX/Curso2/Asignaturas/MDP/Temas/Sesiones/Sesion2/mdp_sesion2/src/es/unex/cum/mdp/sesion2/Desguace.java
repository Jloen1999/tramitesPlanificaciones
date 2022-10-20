/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 */

package es.unex.cum.mdp.sesion2;

import java.util.Arrays;
import java.util.Objects;

public class Desguace {
    private String nombre;
    private Vehiculo[] vehiculos;
    private int cont;

    public Desguace(String nombre, int tam) {
        this.nombre = nombre;
        this.vehiculos = new Vehiculo[tam];
        cont = 0;
    }

    public Desguace() {
        nombre = "";
        vehiculos = new Vehiculo[3];
        cont = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desguace desguace = (Desguace) o;
        return nombre.equals(desguace.nombre);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nombre);
        result = 31 * result + Arrays.hashCode(vehiculos);
        return result;
    }

    @Override
    public String toString() {
        return "Desguace{" +
                "nombre='" + nombre + '\'' +
                ", vehiculos=" + Arrays.toString(vehiculos) +
                ", cont=" + cont +
                '}';
    }


    public boolean existBastidorVehiculo(Integer bastidor) {
        int i = 0;
        boolean exist = false;
        while (i < cont && !exist) {
            if (bastidor.equals(vehiculos[i].getBastidor())) {
                exist = true;
            }
            i++;
        }
        return exist;
    }


    public boolean addVehiculo(Vehiculo v) {
        boolean add = false;
        int i = 0;

        if (cont<vehiculos.length) {
            if(!existBastidorVehiculo(v.getBastidor())){
                vehiculos[cont] = v;
                cont++;
                add = true;
            }

        }

        return add;
    }
    /**
     * @param bastidor
     * @return vehiculos[i] (Vehiculo)
     * @Function getVehiculoBastidor
     * @Description La operación que permita buscar un vehículo por su bastidor. Se debe controlar los posibles errores.
     * @see boolean getVehiculoBastidor
     */
    public Vehiculo getVehiculoBastidor(Integer bastidor) {
        boolean exist;
        exist = false;
        Vehiculo v = null;
        int i = 0;
        while(i< cont && !exist){
            if(bastidor.equals(vehiculos[i].getBastidor())){
                v = vehiculos[i];
                exist = true;
            }
            i++;
        }
        return v;

    }

    /**
     * @param p        (Pieza)
     * @param bastidor (Integer)
     * @return add (booleano)
     * @function addPiezaVehiculo
     * @description La operación de añadir una pieza a un vehículo por bastidor en desguace (coche, moto, camión).
     * Si existe dicha pieza (por el ID) se debe incrementar el número de dicha pieza al vehículo
     * (se implementa esta operabilidad en Desguace). En el caso de no existir, se añade tal y como está implementado en Vehículo
     * @see Vehiculo
     */
    public boolean addPiezaVehiculo(Pieza p, Integer bastidor) {
        Vehiculo v = getVehiculoBastidor(bastidor);
        boolean exist = false;
        Pieza p2 = null;
        if(v != null){
            exist = v.addPiezaV(p);
            if(!exist){
                p2 = v.getPiezaForId(p.getId());
                if(p2 != null){
                    p2.setStock(p2.getStock()+p.getStock());
                    exist = true;
                }
            }
        }

        return exist;


    }

    /**
     * @return nVehiculos (int)
     * @function cuantasPiezas
     * @description Operación que devuelva cuantos vehículos, con piezas, tienen un número de piezas par
     * (no que el número de stock de la pieza es par)
     */
    public int cuantasPiezasPar() {
        int nVehiculos = 0;
        for (int i=0; i<cont; i++) {
            if(vehiculos[i].getCont() > 0){
                if (vehiculos[i].getCont() % 2 == 0) {
                    nVehiculos++;
                }
            }
        }
        return nVehiculos;
    }

    /**
     * @param pos (int)
     * @return vAtributo (String)
     * @function getInfoDerivada
     * @description La operación que permita obtener el valor del atributo derivado de la clase vehículo como String
     * situado en una posición del array del vehículo. Se debe controlar los posibles errores, en cuyo se devolverá null.
     */
    public String getInfoDerivada(int pos) {
        String vAtributo = null;
        if(pos>=0 && pos<=cont){
            if(vehiculos.length != 0) {
                Vehiculo v = vehiculos[pos];
                if (v != null) {
                    if (v.getClass().equals(Coche.class)) {
                        Coche co = (Coche) v;
                        vAtributo = co.getColor();
                    } else if (v.getClass().equals(Camion.class)) {
                        Camion ca = (Camion) v;
                        vAtributo = String.valueOf(ca.getTonelaje());
                    } else if (v.getClass().equals(Moto.class)) {
                        Moto m = (Moto) v;
                        vAtributo = String.valueOf(m.getPotencia());
                    }
                }
            }
        }

        return vAtributo;
    }
}
