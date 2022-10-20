package es.unex.cum.mdp.sesion2.test;

import es.unex.cum.mdp.sesion4.Reloj;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * The test class RelojTest.
 *
 * @author  Luis Arévalo 
 * @version 1.0
 */
public class TestReloj
{
    @Test
    public void testReloj(){
        Reloj r= new Reloj();
        assertNotNull(r);
        Reloj r1= new Reloj(1,1,1);
        Assertions.assertNotNull(r1);
    }

    @Test
    public void testToString(){
        Reloj r= new Reloj();
        Assertions.assertEquals(r.toString(),"Reloj [horas=0, minutos=0, segundos=0]");
        Reloj r1= new Reloj(1,1,1);
        Assertions.assertEquals(r1.toString(),"Reloj [horas=1, minutos=1, segundos=1]");
    }

    @Test
    public void testGetter() {
        Reloj r1= new Reloj(1,1,1);
        Assertions.assertEquals(1, r1.getHoras());
        Assertions.assertEquals(1, r1.getMinutos());
        Assertions.assertEquals(1, r1.getSegundos());
    }

    @Test
    public void testSetter() {
        Reloj r1= new Reloj(1,1,1);
        r1.setHoras(2);
        r1.setMinutos(2);
        r1.setSegundos(2);
        Assertions.assertEquals(2, r1.getHoras());
        Assertions.assertEquals(2, r1.getMinutos());
        Assertions.assertEquals(2, r1.getSegundos());
    }

    @Test
    public void testIncrementarSegundos() {
        Reloj r1= new Reloj(1,1,1);
        r1.incrementarSegundos();
        Assertions.assertEquals(1, r1.getHoras());
        Assertions.assertEquals(1, r1.getMinutos());
        Assertions.assertEquals(2, r1.getSegundos());
        r1= new Reloj(1,1,59);
        r1.incrementarSegundos();
        Assertions.assertEquals(1, r1.getHoras());
        Assertions.assertEquals(2, r1.getMinutos());
        Assertions.assertEquals(0, r1.getSegundos());
        r1= new Reloj(1,59,59);
        r1.incrementarSegundos();
        Assertions.assertEquals(2, r1.getHoras());
        Assertions.assertEquals(0, r1.getMinutos());
        Assertions.assertEquals(0, r1.getSegundos());
    }

    @Test
    public void testDecrementarSegundos() {
        Reloj r1= new Reloj(1,1,1);
        r1.decrementarSegundos();
        Assertions.assertEquals(1, r1.getHoras());
        Assertions.assertEquals(1, r1.getMinutos());
        Assertions.assertEquals(0, r1.getSegundos());
        r1= new Reloj(1,1,0);
        r1.decrementarSegundos();
        Assertions.assertEquals(1, r1.getHoras());
        Assertions.assertEquals(0, r1.getMinutos());
        Assertions.assertEquals(59, r1.getSegundos());
        r1= new Reloj(1,0,0);
        r1.decrementarSegundos();
        Assertions.assertEquals(0, r1.getHoras());
        Assertions.assertEquals(59, r1.getMinutos());
        Assertions.assertEquals(59, r1.getSegundos());
        r1= new Reloj(0,0,0);
        r1.decrementarSegundos();
        Assertions.assertEquals(0, r1.getHoras());
        Assertions.assertEquals(0, r1.getMinutos());
        Assertions.assertEquals(0, r1.getSegundos());
    }

    @Test
    public void testGetTiempo() {
        Reloj r1= new Reloj(1,1,1);
        Assertions.assertEquals(3661, r1.getTiempo());
        r1= new Reloj(10,59,59);
        Assertions.assertEquals(39599, r1.getTiempo());

    }

    @Test
    public void testSetTiempo(){
        Reloj r1= new Reloj(0,0,0);
        r1.setTiempo(3661);
        Assertions.assertEquals(r1.toString(),"Reloj [horas=1, minutos=1, segundos=1]");
        r1.setTiempo(39599);
        Assertions.assertEquals(r1.toString(),"Reloj [horas=10, minutos=59, segundos=59]");
    }

    @Test
    public void testAnadirTiempo() {
        Reloj r1= new Reloj(1,1,1);
        Reloj r2= new Reloj(1,1,1);
        r1.anadirTiempo(r2);
        Assertions.assertEquals(r1.toString(),"Reloj [horas=2, minutos=2, segundos=2]");
        r1= new Reloj(2,0,2);
        r2= new Reloj(1,59,59);
        r1.anadirTiempo(r2);
        Assertions.assertEquals(r1.toString(),"Reloj [horas=4, minutos=0, segundos=1]");
    }

    @Test
    public void testRestarTiempo() {
        Reloj r1= new Reloj(1,1,2);
        Reloj r2= new Reloj(1,1,1);
        r1.restarTiempo(r2);
        Assertions.assertEquals(r1.toString(),"Reloj [horas=0, minutos=0, segundos=1]");
        r1= new Reloj(2,58,58);
        r2= new Reloj(1,59,59);
        r1.restarTiempo(r2);
        Assertions.assertEquals(r1.toString(),"Reloj [horas=0, minutos=58, segundos=59]");
    }

    @Test
    public void testEquals() {
        Reloj r1= new Reloj(1,1,1);
        Reloj r2= new Reloj(1,1,1);
        Assertions.assertEquals(r1, r2);
        //assertEquals(r1,r2);
        r2= new Reloj(1,1,2);
        Assertions.assertNotEquals(r1, r2);
    }


}

