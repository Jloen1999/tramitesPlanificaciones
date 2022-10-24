/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 */

package es.unex.cum.mdp.sesion4;

import java.util.*;

public class Desguace {
    private String nombre;
    private List<Vehiculo> vehiculos;
    private Map<Empleado, String> empleados;

    public Desguace(String nombre, int tam) {
        this.nombre = nombre;
        vehiculos = new ArrayList<Vehiculo>();
        empleados = new LinkedHashMap<Empleado,String>();
    }

    public Desguace() {
        nombre = "";
        vehiculos = new ArrayList<Vehiculo>();
        empleados = new LinkedHashMap<Empleado,String>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Map<Empleado, String> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Map<Empleado, String> empleados) {
        this.empleados = empleados;
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
        return Objects.hash(nombre, vehiculos);
    }

    @Override
    public String toString() {
        return "Desguace{" +
                "nombre='" + nombre + '\'' +
                ", vehiculos=" + getVehiculos() +
                '}';
    }


    /**
     * @param bastidor
     * @return vehiculos[i] (Vehiculo)
     * @Function getVehiculoBastidor
     * @Description La operación que permita buscar un vehículo por su bastidor. Se debe controlar los posibles errores.
     * @see boolean getVehiculoBastidor
     */
    public Vehiculo getVehiculoBastidor(Integer bastidor) {
        Vehiculo v = null;
        Iterator<Vehiculo> item = vehiculos.iterator();
        while (item.hasNext() && v == null) {
            Vehiculo vehi = item.next();
            if (vehi.getBastidor().equals(bastidor)) {
                //index = vehiculos.indexOf(vehi);
                v = vehi;
            }
        }

        return v;
    }


    public boolean addVehiculo(Vehiculo v) {
        boolean insertado = false;
        if (v != null && vehiculos != null) {
            Vehiculo vaux = getVehiculoBastidor(v.getBastidor());
            if (vaux == null) {
                insertado = vehiculos.add(v);
            }
        }
        return insertado;
    }

    public boolean addPiezaVehiculo(String id, Integer bastidor) {
        boolean add = false;
        Pieza pz2 = null;
        if (vehiculos != null && id != null && bastidor != null) {
            Vehiculo v = getVehiculoBastidor(bastidor);
            if (v != null) {
                Pieza p = v.getPiezaForId(id);
                if (p != null) {
                    p.setStock(p.getStock() - 1);
                }else{
                    add = v.addPiezaV(p);
                }
            }
        }

        return add;

    }

    public Vehiculo mayorStock() {
        Vehiculo v = null;
        if(vehiculos != null){
            Collections.sort(vehiculos);
            v = vehiculos.get(0);
        }
        return v;
    }

    public Pieza getPiezaDesguace(String id){
        return null;
    }

    public Pieza getPiezaVehiculo(String idP, Integer bastidor) {
        Pieza p = null;
        if (vehiculos != null && idP != null && bastidor != null) {
            Vehiculo v = getVehiculoBastidor(bastidor);
            if (v != null) {
                Pieza pz2 = v.getPiezaForId(idP);
                if (pz2 != null) {
                    p = pz2;
                }
            }
        }

        return p;

    }

    public boolean addEmpleado(Empleado e){
        return false;
    }
    public Empleado getEmpleado(String dni){
        return null;
    }

    public float getMediaSueldo(){
        return 1;
    }

}
