package es.unex.cum.mdp.sesion2.test;

import es.unex.cum.mdp.sesion4.Persona;
import es.unex.cum.mdp.sesion4.Pieza;
import es.unex.cum.mdp.sesion4.Vehiculo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {
    private Vehiculo v, v1;
    private Pieza p, p1;
    @BeforeEach
    void setUp() {
        v = new Vehiculo();
        v1 = new Vehiculo("Opel", "Zafira", new Persona("Jose", "Y2323", 21), 1);
        p = new Pieza("12", "rueda", 2);
        p1 = new Pieza("13", "rueda", 2);
    }

    @AfterEach
    void tearDown() {
        v = null;
        v1 = null;
        p = null;
        p1 = null;
    }

    @Test
    void getPiezaV() {

    }

    @Test
    void getPiezas() {
    }

    @Test
    void addPiezaV() {
        assertTrue(v1.addPiezaV(p));
        assertTrue(v1.addPiezaV(p1));
        assertTrue(v.addPiezaV(p1));
    }

    @Test
    void getBastidor() {
    }

    @Test
    void setBastidor() {
    }

    @Test
    void getCont() {
    }

    @Test
    void setMarca() {
    }

    @Test
    void getMarca() {
    }

    @Test
    void setModelo() {
    }

    @Test
    void getModelo() {
    }

    @Test
    void setPropietario() {
    }

    @Test
    void getPropietario() {
    }

    @Test
    void existIDPieza() {
    }

    @Test
    void getPiezaForId() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }

//    @Test
//    void existID(){
//        assertFalse(v.existID("12"));
//    }

}