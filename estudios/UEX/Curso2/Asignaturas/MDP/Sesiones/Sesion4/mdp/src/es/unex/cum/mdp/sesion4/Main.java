package es.unex.cum.mdp.sesion4;

import java.util.Arrays;

public class Main {
    private static Vehiculo v,v1,v2;
    private static Persona p;
    private static Desguace d1, d2;
    private static Pieza pz, pz1, pz2, pz3,pz4, pz5;
    public static void main(String[] args){
        p = new Persona("Erick","234eeer", 22);
        v = new Camion("Cadillac", "ATS Coupé", p, 2, 3);
        v1 = new Coche("Renault", "Laguna", p, 3, "rojo");
        v2 = new Moto( "BMW","Serie 1", p, 1,123);
        pz = new Pieza();
        pz1 = new Pieza("1", "Rueda", 100);
        pz2 = new Pieza("2", "Motor", 2);
        pz3 = new Pieza("3", "Asiento", 1);
        pz4 = new Pieza("3", "Asiento", 6);
        pz5 = new Pieza("4", "Asiento", 6);
        d1 = new Desguace("Martin", 3);
        d2 = new Desguace("Jorge", 2);
        System.out.println(d1.equals(d2));
        v1.addPiezaV(pz1);
        v.addPiezaV(pz2);
        v.addPiezaV(pz3);
        d1.addVehiculo(v);
        d1.addVehiculo(v1);
        System.out.println(d1.toString());
        System.out.println(d1.getVehiculos().get(1).getPiezas().size());
        Vehiculo aux = d1.mayorStock();
        System.out.println(aux.toString());
        System.out.println(d1.getVehiculos().size());
        System.out.println(d1.getVehiculos().get(1).getPiezas().size());
    }
}
