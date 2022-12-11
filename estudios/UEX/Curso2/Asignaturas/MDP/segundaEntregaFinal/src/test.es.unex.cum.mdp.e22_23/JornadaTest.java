package test.es.unex.cum.mdp.e22_23;

import es.unex.cum.mdp.e22_23.Partido.Partido;
import es.unex.cum.mdp.e22_23.Partido.PartidoPetanca;
import es.unex.cum.mdp.e22_23.equipo.Equipo;
import es.unex.cum.mdp.e22_23.equipo.EquipoLiga;
import es.unex.cum.mdp.e22_23.estadistica.EstadisticaPetanca;
import es.unex.cum.mdp.e22_23.exceptions.NoEnfrentamientosException;
import es.unex.cum.mdp.e22_23.exceptions.NoJornadaException;
import es.unex.cum.mdp.e22_23.exceptions.NoPartidoException;
import es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato.Jornada;
import es.unex.cum.mdp.e22_23.persona.Directivo;
import es.unex.cum.mdp.e22_23.persona.Jugador;
import es.unex.cum.mdp.e22_23.utils.ConsoleColors;
import es.unex.cum.mdp.e22_23.utils.ShowPetanca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class JornadaTest {
    private Jornada j;
    private final int numJugadoresEquipo = 10; // Número de jugadores por equipo
    private final int numPartidosJornada = 2;
    private final int numEquipoPartido = 2; // Número de equipos por liga. No puede ser impar


    @BeforeEach
    void setUp() throws NoPartidoException, NoJornadaException { //Inicializa los objetos y se ejecuta al arrancar el Test
        Random r = new Random();
        j = new Jornada(new Date(2022, 12, 06), 1);

        for (int i = 0; i < numPartidosJornada; i++) {
            j.addPartidos(new PartidoPetanca(i, r.nextInt(1,10),r.nextInt(1,10), new EquipoLiga(r.nextInt(1,10),new Equipo("Equipo" + String.valueOf(i), "Ciudad" + String.valueOf(i), new Directivo("Manuel", 1, 40, "Presidente")), new EstadisticaPetanca()),new EquipoLiga(r.nextInt(1,10),new Equipo("Equipo" + String.valueOf(i+1), "Ciudad" + String.valueOf(i+1), new Directivo("Sergio", 2, 40, "Presidente")), new EstadisticaPetanca())));
        }

        for (Partido p:j.getPartidos()
             ) {
            for (int i=0; i<numJugadoresEquipo; i++){
                p.getLocal().addJugadores(new Jugador("Jugador" + (i + 1), i + 1, 26, "nick" + (i + 1), r.nextInt(1, 10)));
                p.getVisitante().addJugadores(new Jugador("Jugador" + (i + 2), i + 2, 26, "nick" + (i + 2), r.nextInt(1, 10)));
            }
        }

    }

    @AfterEach
    void tearDown() { //Recolector de Basura y se Ejecuta al finalizar el Test
       j = null;
    }

    @Test
    public void testJornadaPorDefecto(){
        Jornada j = new Jornada();
        assertNotNull(j);
        j = null;
        assertNull(j);
    }

    @Test
    public void testJornadaParametrizado(){
        Jornada j = new Jornada(new Date(2022, 12, 9), 2);
        assertNotNull(j);
        j = null;
        assertNull(j);
    }
    @Test
    public void testJornadaCopia(){
        Jornada j1 = new Jornada(j);
        assertNotNull(j1);
        j1 = null;
        assertNull(j1);
    }

    @Test
    public void testJornadaCopiaPorNumero(){
        Jornada j = new Jornada(3);
        assertNotNull(j);
        j = null;
        assertNull(j);
    }

    @Test
    public void getFecha() {
        assertEquals(j.getFecha(), new Date(2022, 12, 06));
        assertNotEquals(j.getFecha(), new Date(2023, 12, 06));
    }

    @Test
    public void getNumero(){
        assertEquals(j.getNumero(), 1);
        assertNotEquals(j.getNumero(), 2);
    }

    @Test
    public void getPartidos(){
        //Mostramos los partidos de una jornada existente
        try {
            ShowPetanca.showManyPartidosJornada(j,1);
        } catch (NoPartidoException | NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        } catch (NoJornadaException e) {
            System.out.println(e.getMessage());
        }

        j = null;
        //Mostramos los partidos de una jornada inexistente.
        try {
            ShowPetanca.showManyPartidosJornada(j,1);
        } catch (NoPartidoException | NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        } catch (NoJornadaException e) {
            System.out.println(e.getMessage());
        }

    }


    @Test
    void addPartidos() {
        //Comprobamos que se añaden correctamente los partidos a la Jornada
        try {
            assertFalse(j.addPartidos(j.getPartidos().get(0)));  //Expected False->Ya existe ese partido.
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            //Añadimos un nuevo partido
            assertTrue(j.addPartidos(new PartidoPetanca(12,5,4,new EquipoLiga(10,null, new EstadisticaPetanca()),new EquipoLiga(20,null, new EstadisticaPetanca()))));  //Expected False
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getPartidoId() {
        //Verificamos que se obtiene el partido correctamente dado un id(numero) de Partido
        assertNull(j.getPartidoId(-1)); //No existe un partido con un id negativo
        assertNull(j.getPartidoId(20)); //No existe un partido con el id 20
        assertNotNull(j.getPartidoId(0)); //Existe el partido
    }

    @Test
    void crearEnfrentamientosJornada(){
        //Mostramos los partidos de la Jornada antes de crear los enfrentamientos
        try {
            ShowPetanca.showManyPartidosJornada(j,0); //Mostramos los partidos antes de crear los enfrentamientos
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        } catch (NoJornadaException e) {
            System.out.println(e.getMessage());
        } catch (NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }
        j.crearEnfrentamientosJornada();
        //Mostramos los partidos de la Jornada después de crear los enfrentamientos
        try {
            ShowPetanca.showManyPartidosJornada(j,0); //Despues de los enfrentamientos.
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        } catch (NoJornadaException e) {
            System.out.println(e.getMessage());
        } catch (NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void simular() {
        j.crearEnfrentamientosJornada();
        //Mostramos los partidos de la Jornada antes de simular los enfrentamientos
        try {
            ShowPetanca.showManyPartidosJornada(j,0); //Despues de los enfrentamientos.
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        } catch (NoJornadaException e) {
            System.out.println(e.getMessage());
        } catch (NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }

        assertTrue(j.simular());
        //Mostramos los partidos de la Jornada después de simular los enfrentamientos
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| SIMULANDO |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |-----------|                                                                  " + ConsoleColors.RESET);
        try {
            ShowPetanca.showManyPartidosJornada(j,0); //Despues de los enfrentamientos.
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        } catch (NoJornadaException e) {
            System.out.println(e.getMessage());
        } catch (NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }
        j.setPartidos(null);
        assertFalse(j.simular());  //False->La lista de partidos es nula

    }

    @Test
    void jugar() {

        j.crearEnfrentamientosJornada();
        //Mostramos los partidos de la Jornada antes de jugar
        try {
            ShowPetanca.showOnlyPartido(j.getPartidoId(0),1);
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        } catch (NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }

        assertFalse(j.jugar(20, new int[]{5, 5, 5}, new int[]{3, 13, 3})); //False->No existe un partido con el id 20
        assertFalse(j.jugar(0, new int[]{5, 5}, new int[]{3, 13, 3})); //False->El tamaño del array de puntos locales no es igual al total de enfrentamientosassertTrue(j.jugar(0, new int[]{5, 5, 5}, new int[]{3, 13, 3})); de un partidox
        assertTrue(j.jugar(0, new int[]{5, 5, 5}, new int[]{3, 13, 3}));
        //Mostramos los partidos de la Jornada antes de jugar
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------|                                                                  " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "******************************************************************| JUGANDO |******************************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "                                                                  |---------|                                                                  " + ConsoleColors.RESET);
        try {
            ShowPetanca.showOnlyPartido(j.getPartidoId(0),1);
        } catch (NoPartidoException e) {
            System.out.println(e.getMessage());
        } catch (NoEnfrentamientosException e) {
            System.out.println(e.getMessage());
        }

    }


}