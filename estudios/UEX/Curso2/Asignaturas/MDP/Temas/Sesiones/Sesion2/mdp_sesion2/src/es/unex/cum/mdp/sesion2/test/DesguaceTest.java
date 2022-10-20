package es.unex.cum.mdp.sesion2.test;

import es.unex.cum.mdp.sesion4.*;
import es.unex.cum.mdp.sesion4.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesguaceTest {
    private Desguace d,d1,d2;
    private Vehiculo v,v1,v2,v3;
    private Persona p;
    private Pieza pz, pz1, pz2, pz3;
        @BeforeEach
        public void setUp() throws Exception {
            d = new Desguace();
            d1 = new Desguace("Martin", 3);
            d2 = new Desguace("Martin", 2);
            p = new Persona("Erick","234eeer", 22);
            v = new Vehiculo();
            v1 = new Camion("Renault", "Laguna", p, 1, 3);
            v2 = new Coche( "BMW","Serie 1", p, 1,"rojo");
            v3 = new Camion("Cadillac", "ATS Coupé", p, 2, 3);
            pz = new Pieza();
            pz1 = new Pieza("1", "Rueda", 2);
            pz2 = new Pieza("2", "Motor", 2);
            pz3 = new Pieza("1", "Asiento", 2);

        }

        @AfterEach
        public void tearDown() throws Exception {
            v = null;
            v1 = null;
            v2 = null;
            v3 = null;
            p = null;
            pz = null;
            pz1 = null;
            pz2 = null;
            pz3 = null;
            d = null;
            d1 = null;
            d2 = null;
        }

        @Test
        void testVehiculo() {
            assertNotNull(v);
            assertNotNull(v1);
            assertNotNull(v2);
            assertNotNull(v3);
            assertEquals(v2, v3);
        }


    @Test
    void testDesguace(){
        assertNotNull(d);
        assertNotNull(d1);
        assertNotNull(d2);
    }

    @Test
    void testPersona(){
            assertNotNull(p);
    }

    @Test
    void testPieza(){
           assertNotNull(pz);
           assertNotNull(pz1);
           assertNotNull(pz2);
           assertNotNull(pz3);
           assertEquals(pz1, pz1);

    }

    @Test
    void getNombre() {
        assertEquals(d1.getNombre(), d2.getNombre());
    }

//    @Test
//    void addVehiculo() {
//        assertTrue(d1.addVehiculo(v1));
//        assertTrue(d1.addVehiculo(v2));
//    }


//
////    @Test
////    void getVehiculoBastidor() {
////        d.addVehiculo(v);
////        assertEquals(d.getVehiculoBastidor(1), new Vehiculo("Opel", "Zafira", new Persona("Jose", "Y2323", 21), 1));
////    }
//
//    @Test
//    void addPiezaVehiculo() {
//    }
//
//    @Test
//    void cuantasPiezasPar() {
//    }
//
//    @Test
//    void getInfoDerivada() {
//    }
//
//    @Test
//    public void testGetAddPieza() {
//        Pieza p1 = new Pieza("1", "Freno", 2);
//        Pieza p2 = new Pieza("2", "Faro", 5);
//        Pieza p3 = new Pieza("3", "Cambio", 1);
//        Pieza p4 = new Pieza("4", "Bujia", 1);
//        Pieza p5 = new Pieza("4", "Bujia", 1);
//        Pieza p6 = new Pieza("3", "Cambio", 1);
//        Pieza p7 = new Pieza("7", "Cambio", 1);
//        Pieza p8 = new Pieza("8", "Cambio", 1);
//        assertTrue(v2.addPiezaV(p1));
//        assertTrue(v2.addPiezaV(p2));
//        assertTrue(v2.addPiezaV(p3));
//        assertTrue(v2.addPiezaV(p4));
//        assertFalse(v2.addPiezaV(p5));
//        assertFalse(v2.addPiezaV(p6));
//        assertTrue(v2.addPiezaV(p7));
//        assertTrue(v2.addPiezaV(p8));
//
//    }
//
//    @Test
//    public void testGetPieza() {
//        Pieza p1 = new Pieza("1", "Freno", 2);
//        Pieza p2 = new Pieza("2", "Faro", 5);
//        Pieza p3 = new Pieza("3", "Cambio", 1);
//        v2.addPiezaV(p1);
//        v2.addPiezaV(p2);
//        v2.addPiezaV(p3);
//
//        assertNotNull(v2.getPiezaV(0));
//        assertEquals(p1, v2.getPiezaV(0));
//        Assertions.assertNull(v2.getPiezaV(10));
//        Assertions.assertNull(v2.getPiezaV(-5));
//        assertEquals(3, v2.getCont());
//    }

}