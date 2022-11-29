# Clase EquipoLiga

## Métodos

### getJugador(int id)→Jugador 
- Pasos: ^getJugador
	- Comprobamos que la lista de jugadores no sea nula.
	- Comprobamos que el id no es negativo o cero.
	- Inicializamos un objeto de la clase Jugador a NULL.
	- Recorremos la lista de jugadores con un for, while o Iterator, obtenemos el id de cada jugador y lo comparamos con el id del jugador buscado:
		- si coinciden, almacenamos el jugador en el objeto inicializado y devolvemos el <font color="#00b050">jugador</font>.
		- Si no coinciden devolvemos <font color="#ff0000">NULL</font>.

### addJugador(Jugador j)→boolean
- Pasos:  ^addJugador
	- Comprobamos que el jugador no sea nulo.
		- Si Jugador no nulo: 
			- Obtenemos el id del jugador.
			- Reutilizamos el metodo getJugador(id), obtenemos un objeto de tipo Jugador:
				- Si devuelve NULL, podemos añadir el jugador y devolvemos <font color="#00b050">True</font>.
				- Si no es NULL, no añadimos y devolvemos <font color="#ff0000">False</font>
		- Si Jugador es Nulo: Devolvemos <font color="#ff0000">false</font>.

## Main(Comprobaciones)
### Comprobar el correcto funcionamiento de EquipoLiga con la clase MainEquipoLiga. [[2022-11-26]]

```java TI:"MainEquipoLiga.java"
import es.unex.cum.mdp.e22_23.*;  
  
public class MainEquipoLiga {  
    private Jugador j1=new Jugador("Pepe",1,20,"Pepe",10);  
    private Jugador j2=new Jugador("Ana",2,22,"Ana",12);  
    private Jugador j3=new Jugador("Juan",2,24,"Jaun",14);  
    private Jugador j4=new Jugador("Lupe",4,26,"Lupe",12);  
    private Partido p= new PartidoPetanca();  
    public static void main(String[]args) {  
        MainEquipoLiga m= new MainEquipoLiga();  
        m.run();  
    }  
  
    public void run() {  
        EquipoLiga el = new EquipoLiga();  
        el.addJugadores(j1);  
        el.addJugadores(j2);  
        el.addJugadores(j3);  
        el.addJugadores(j4);  
        System.out.println(el.getJugadores()); //[Jugador{nick='Pepe', coef=10}, Jugador{nick='Ana', coef=12}, Jugador{nick='Lupe', coef=12}]  
        System.out.println(el.getJugadorId(2)); //Jugador{nick='Ana', coef=12}  
        System.out.println(el.getJugadorId(5)); //null  
  
    }  
}
```

# Clase EnfrentamientoPetanca
## Métodos

### simular(intcoefEqLocal, int coefEqVis)→int
- Realizamos la siguiente operación:
```math
||{"id":455737260076}||
(local+jLocal1.getCoeficiente)-(visitante+jVis1.getCoeficiente)
```
- Valor de retorno:
	-  Valor positivo → gana el equipo Local
	- Valor 0 → empate(misma puntuación o coeficiente)
	-  Valor negativo → gana el equipo Visitante.

### jugar(int coefEqLocal, int coefEqVis)
- Realizamos la siguiente operación:
```math
||{"id":455737260076}||
local-visitante
```
- PosRequisito: <font color="red">El juez debe anotar el resultado del enfrentamiento</font>
## Main(Comprobaciones)
### Comprobar el correcto funcionamiento de EnfrentamientoPetanca con la clase MainEnfrentamiento. #Clase/Main @[[2022-11-26]]

```java TI:"MainEnfrentamiento.java"
package es.unex.cum.mdp.e22_23;  
  
import java.util.Random;  
  
public class MainEnfrentamiento {  
    private String tipo="Petanca";  
    private Jugador j1=new Jugador("Pepe",1,20,"Pepe",10);  
    private Jugador j2=new Jugador("Ana",2,22,"Ana",12);  
    private Jugador j3=new Jugador("Juan",3,24,"Jaun",14);  
    private Jugador j4=new Jugador("Lupe",4,26,"Lupe",12);  
    private Partido p= new PartidoPetanca();  
    public static void main(String[]args) {  
        MainEnfrentamiento m= new MainEnfrentamiento();  
        m.run();  
    }  
  
    public void run() {  
        Enfrentamiento e=null;  
        if (tipo.equals("Futbolin")) {  
            //e = new EnfrentamientoFutbolin(1,j1,j2,j3,j4);  
        }else {  
            e = new EnfrentamientoPetanca(1,j1,j2);  
        }  
        System.out.println(e.simular(14, 10)); //retorna 0 en petanca 2  
        System.out.println(e.simular(16, 10)); //retorna 2 en petanca 4  
        System.out.println(e.simular(11, 9));  //retorna -2 en petanca 0  
  
        System.out.println(e.jugar(5, 5)); //retorna 0 en petanca 0  
        System.out.println(e.jugar(2, 4)); //retorna -2 en petanca -2  
        System.out.println(e.jugar(5, 2)); //retorna 3 en petanca 3  
    }  
  
}
```

# Clase Partido
## Métodos
### getEnfrentamientoId(int id)→EnfrentamientoPetanca 
- Pasos: 
	- Comprobamos que la lista de enfrentamientos no sea nula.
	- Comprobamos que el id no se negativo o cero.
	- Inicializamos un objeto de la clase EnfrentamientoPetanca a NULL.
	- Recorremos la lista de enfrentamientos con un for, while o Iterator, obtenemos el id de cada enfrentamiento y lo comparamos con el id del enfrentamiento buscado:
		- si coinciden almacenamos el jugador en el objeto inicializado y devolvemos el <font color="#00b050">enfrentamiento</font>.
		- si no coinciden devolvemos <font color="#ff0000">NULL</font>.

###  addEnfrentamientos(EnfrentamientoPetanca enf)→boolean
- Pasos:  
	- Comprobamos que el enfrentamiento no sea nulo.
		- Si Jugador no nulo: 
			- Obtenemos el id del enfrentamiento.
			- Reutilizamos el metodo getJugador(id), obtenemos un objeto de tipo EnfrentamientoPetanca:
				- Si devuelve NULL, podemos añadir el enfrentamiento y devolvemos <font color="#00b050">True</font>.
				- Si no es NULL, no añadimos y devolvemos <font color="#ff0000">False</font>
		- Si enfrentamiento es Nulo: Devolvemos <font color="#ff0000">false</font>.

# Clase PartidoPetanca
## Métodos

### simular()→void #testMethod #metodo #metodo/Partido 
- Creamos una variable que almacenará el valor resultante de la simulación del enfrentamiento.            
-  Recorremos la lista de enfrentamientos y por cada enfrentamiento obtenemos los equipos, local y visitante junto a la estadística de ambos, llamamos al método simular de enfrentamiento donde le pasamos como parámetros el coeficiente del equipoLiga Local y el coeficiente del equipo visitante, dicha función nos devuelve un valor entero:
	- Si es positivo: el equipoLocal tiene mayor puntuación o coeficiente, por lo tanto, realizamos las siguientes operaciones:
		-  Incrementamos el valor del atributo enfrentGanados de estadística del equipo local
		- Incrementamos el valor del atributo enfrentPerdidos del equipo Visitante.
		- Incrementamos el valor del atributo puntosLocal de la clase Partido que nos indica el numero de enfrentamientos ganados.
		- Incrementamos los puntos del equipo Local.
	- Si es negativo: el equipoVisitante tiene mayor puntuación, por lo tanto, realizamos las siguientes operaciones:
		- Incrementamos el valor del atributo enfrentGanados de estadística del equipo Visitante
		- Incrementamos el valor del atributo enfrentPerdidos del equipo Local.
		- Incrementamos el valor del atributo puntosVisitante de la clase Partido que nos indica el numero de enfrentamientos ganados.
		- Incrementamos los puntos del equipo Visitante.
	- Si es 0: Ambos equipos tienen la misma puntuación. Incrementamos el valor del atributo enfrentEmpatados de ambos equipos.

- Valor de retorno→tipo void.
```java TI:"simular"
/**  
 * Se encarga de realizar la simulación de todos los enfrentamientos * del partido, actualizando los puntos de cada equipo. Además, debe * actualizar las estadísticas. */@Override  
public void simular() {  
    Estadistica estEqLocal = super.getLocal().est;  
    Estadistica estEqVis = super.getVisitante().est;  
    EquipoLiga eqLocal = super.getLocal();  
    EquipoLiga eqVis = super.getVisitante();  
    int puntos;  //valor resultante de la simulación del enfrentamiento.  
  
    for (EnfrentamientoPetanca enfP : super.getEnfrentamientos()) { //Recorremos la lista de enfrentamientos  
        puntos = enfP.simular(eqLocal.getCoef(), eqVis.getCoef()); //Simulamos cada enfrentamiento  
        if (puntos > 0) {  
            //Atualizamos los puntos del equipo Local  
            eqLocal.setCoef(eqLocal.getCoef() + 1);  
            //Actualizamos las estadísticas del equipo Local  
            estEqLocal.setEnfrenGanados(estEqLocal.getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo local  
            estEqVis.setEnfrenPerdidos(estEqVis.getEnfrenPerdidos() + 1);   //Incrementamos el valor del atributo enfrentPerdidos del equipo Visitante.  
            super.setPuntosLocal(super.getPuntosLocal() + 1); //Incrementamos el contador de enfrentamientos ganados del equipo Local.            } else if (puntos > 0) {  
        } else if (puntos < 0) {  
            //Atualizamos los puntos del equipo Visitante  
            eqVis.setCoef(eqVis.getCoef() + 1);  
            //Actualizamos las estadísticas del equipo Visitante  
            estEqVis.setEnfrenGanados(estEqVis.getEnfrenGanados() + 1);  
            estEqLocal.setEnfrenPerdidos(estEqLocal.getEnfrenPerdidos() + 1);  
            super.setPuntosVisitante(super.getPuntosVisitante() + 1); //Incrementamos el contador de enfrentamientos ganados del equipo Visitante.  
        } else {  
            estEqVis.setEnfrenEmpatados(estEqVis.getEnfrenEmpatados() + 1);  
            estEqLocal.setEnfrenEmpatados(estEqLocal.getEnfrenEmpatados() + 1);  
        }  
    }  
  
}
```

### jugar(int[] puntosLocal, int[] puntosVis)→void #metodo/Partido #metodo 
- Hace lo mismo que simular pero recibe dos array de enteros:
	- Uno para los puntos del equipoLiga Local
	- Otro para los puntos del equipoLiga Visitante.

```java TI:"jugar"
/**  
 * Método ue se encarga de realizar la simulación de todos los enfrentamientos del partido, * actualizando los puntos de cada equipo. Además debe actualizar las estadísticas de los equipos * con respecto al enfrentamiento: puntos, enfrentamientos. * * @param puntosLocal array de tipo entero que almacena los puntos del equipo Local.  
 * @param puntosVis   array de tipo entero que almacena los puntos del equipo Visitante.  
 */@Override  
public void jugar(int[] puntosLocal, int[] puntosVis) {  
    Estadistica estEqLocal = super.getLocal().est;  
    Estadistica estEqVis = super.getVisitante().est;  
    EquipoLiga eqLocal = super.getLocal();  
    EquipoLiga eqVis = super.getVisitante();  
  
    for (int i = 0; i < super.getNumEnfrentamiento(); i++) {  
        if (puntosLocal[i] > puntosVis[i]) {  
            //Atualizamos los puntos del equipo Local  
            eqLocal.setCoef(eqLocal.getCoef() + 1);  
            //Actualizamos las estadísticas del equipo Local  
            estEqLocal.setEnfrenGanados(estEqLocal.getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo local  
            estEqVis.setEnfrenPerdidos(estEqVis.getEnfrenPerdidos() + 1);   //Incrementamos el valor del atributo enfrentPerdidos del equipo Visitante.  
            super.setPuntosLocal(super.getPuntosLocal() + 1); //Incrementamos el contador de enfrentamientos ganados del equipo Local.            } else if (puntos > 0) {  
  
        } else if (puntosLocal[i] < puntosVis[i]) {  
            //Atualizamos los puntos del equipo Visitante  
            eqVis.setCoef(eqVis.getCoef() + 1);  
            //Actualizamos las estadísticas del equipo Visitante  
            estEqVis.setEnfrenGanados(estEqVis.getEnfrenGanados() + 1);  
            estEqLocal.setEnfrenPerdidos(estEqLocal.getEnfrenPerdidos() + 1);  
            super.setPuntosVisitante(super.getPuntosVisitante() + 1); //Incrementamos el contador de enfrentamientos ganados del equipo Visitante.  
        } else {  
            //Actualizamos las estadísticas del equipo Local y Visitante  
            estEqVis.setEnfrenEmpatados(estEqVis.getEnfrenEmpatados() + 1);  
            estEqLocal.setEnfrenEmpatados(estEqLocal.getEnfrenEmpatados() + 1);  
        }  
    }  
}
```

PosRequisito: <font color="red">El juez debe anotar el resultado del enfrentamiento</font>

### jugarCopia(int[] puntosLocal, int[] puntosVis)→void #metodo/Partido #metodo
```java TI:"jugar"
public void jugar(int[] puntosLocal, int[] puntosVis) {  
    Estadistica estEqLocal = super.getLocal().est;  
    Estadistica estEqVis = super.getVisitante().est;  
    EquipoLiga eqLocal = super.getLocal();  
    EquipoLiga eqVis = super.getVisitante();  
    EnfrentamientoPetanca enf = null;  
    int puntos = 0;  
    System.out.println(eqLocal);  
    System.out.println(eqVis);  
    for (int i = 0; i < super.getEnfrentamientos().size(); i++) {  
        enf = super.getEnfrentamientos().get(i);  
        for (int j = 0; j < super.getNumEnfrentamiento(); j++) {  
            System.out.println("Puntos del enfrentamiento Local: " + puntosLocal[j]);  
            System.out.println("Puntos del enfrentamiento Local: " + puntosVis[j]);  
            if (puntosLocal[j] > puntosVis[j]) {  
                //Atualizamos los puntos del equipo Local en EquipoLiga  
                //eqLocal.setCoef(eqLocal.getCoef() + 1);                //Actualizamos los puntos del enfrentamiento ganado del equipo Local.                enf.setLocal(enf.getLocal() + 1);  
                //Actualizamos los puntos del equipo Local en Partido  
                super.setPuntosLocal(super.getPuntosLocal() + 1);  
                //Actualizamos las estadísticas del equipo Local  
                estEqLocal.setEnfrenGanados(estEqLocal.getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo local  
                estEqVis.setEnfrenPerdidos(estEqVis.getEnfrenPerdidos() + 1);   //Incrementamos el valor del atributo enfrentPerdidos del equipo Visitante.  
  
            } else if (puntosLocal[j] < puntosVis[j]) {  
                //Atualizamos los puntos del equipo Visitante en EquipoLiga  
                //eqVis.setCoef(eqVis.getCoef() + 1);                //Actualizamos los puntos del enfrentamiento ganado del equipo Visitante.                enf.setVisitante(enf.getVisitante() + 1);  
                //Actualizamos los puntos del equipo Visitante en Partido  
                super.setPuntosVisitante(super.getPuntosVisitante() + 1);  
                //Actualizamos las estadísticas del equipo Visitante  
                estEqVis.setEnfrenGanados(estEqVis.getEnfrenGanados() + 1);  
                estEqLocal.setEnfrenPerdidos(estEqLocal.getEnfrenPerdidos() + 1);  
  
            } else {  
                //Actualizamos las estadísticas del equipo Local y Visitante  
                estEqVis.setEnfrenEmpatados(estEqVis.getEnfrenEmpatados() + 1);  
                estEqLocal.setEnfrenEmpatados(estEqLocal.getEnfrenEmpatados() + 1);  
            }  
        }  
  
  
    }  
}
```

### JugarCopia2(int[] puntosLocal, int[] puntosVis)→void #testMethod
```java TI:"jugarCopia2"
public void jugar(int[] puntosLocal, int[] puntosVis) {  
    Estadistica estEqLocal = super.getLocal().est;  
    Estadistica estEqVis = super.getVisitante().est;  
    EquipoLiga eqLocal = super.getLocal();  
    EquipoLiga eqVis = super.getVisitante();  
    EnfrentamientoPetanca enf = null;  
    int puntos = 0;  
    System.out.println(eqLocal);  
    System.out.println(eqVis);  
    if (!super.getEnfrentamientos().isEmpty()) {  
        for (int i = 0; i < super.getNumEnfrentamiento(); i++) {  
            enf = super.getEnfrentamientos().get(i);  
  
            System.out.println("Puntos del enfrentamiento Local: " + puntosLocal[i]);  
            System.out.println("Puntos del enfrentamiento Local: " + puntosVis[i]);  
            //Sabemos cuántos puntos tiene cada enfrentamiento  
            //Actualizamos los puntos de cada enfrentamiento            enf.setLocal(puntosLocal[i]);  
            enf.setVisitante(puntosVis[i]);  
            if (puntosLocal[i] > puntosVis[i]) { //Si gana el enfrentamiento el equipo Local  
                //Actualizamos los puntos del equipo Local en Partido                super.setPuntosLocal(super.getPuntosLocal() + 1);  
                //Actualizamos las estadísticas del equipo Local  
                estEqLocal.setEnfrenGanados(estEqLocal.getEnfrenGanados() + 1); //Incrementamos el valor del atributo enfrentGanados de estadística del equipo local  
                estEqVis.setEnfrenPerdidos(estEqVis.getEnfrenPerdidos() + 1);   //Incrementamos el valor del atributo enfrentPerdidos del equipo Visitante.  
  
            } else if (puntosLocal[i] < puntosVis[i]) { //Si gana el enfrentamiento el equipo Visitante  
                //Actualizamos los puntos del equipo Visitante en Partido                super.setPuntosVisitante(super.getPuntosVisitante() + 1);  
                //Actualizamos las estadísticas del equipo Visitante  
                estEqVis.setEnfrenGanados(estEqVis.getEnfrenGanados() + 1);  
                estEqLocal.setEnfrenPerdidos(estEqLocal.getEnfrenPerdidos() + 1);  
  
            } else {    //Si empatan ambos equipos  
                //Actualizamos las estadísticas del equipo Local y Visitante                estEqVis.setEnfrenEmpatados(estEqVis.getEnfrenEmpatados() + 1);  
                estEqLocal.setEnfrenEmpatados(estEqLocal.getEnfrenEmpatados() + 1);  
            }  
        }  
    }  
  
  
}
```
## actualizarEstadistica()→void #metodo/Partido #metodo
- Realizamos las siguientes operaciones:
	- El equipo que tenga más enfrentamientos ganados:
		- Incrementamos el valor del atributo partGanados e incrementamos partPerdidos del otro equipo.
	- En caso de tener la misma cantidad de enfrentamientos ganados:
		- Incrementamos el valor del atributo partEmpatados en ambos equipos.
```java Ti:"actualizarEstadistica"
/**  
     * Se encargará de actualizar las estadísticas de los equipos referidas:
     * partidos y puntos. Este método es llamada desde Jornada     
     * * <ul>  
     * *     <li>Partidos Ganados(partGanados)->5 puntos</li>  
     * *     <li>Partidos Empatados(partEmpatados)->2 puntos</li>  
     * *     <li>Partidos Perdidos(partPerdidos)->-3 puntos</li>  
     * * </ul>  
     */  
    @Override  
    public void actualizarEstadistica() {  
        Estadistica estEqLocal = super.getLocal().est;  
        Estadistica estEqVis = super.getVisitante().est;  
        EquipoLiga eqLocal = super.getLocal();  
        EquipoLiga eqVis = super.getVisitante();  
        ComparatorEnfrentamientos compE = new ComparatorEnfrentamientos();  
        if (!super.getEnfrentamientos().isEmpty()) {  
                if (estEqLocal.getEnfrenGanados() > estEqVis.getEnfrenGanados()) {  
                //Si el equipo Local gana el partido  
	                    //Actualizamos los partidos de los equipos                    
	                    estEqLocal.setPartGanados(estEqLocal.getPartGanados() + 1);  
	                    estEqVis.setPartPerdidos(estEqVis.getPartPerdidos() + 1);  
                    //Actualizamos los puntos de las estadísticas de los equipos referidas  
	                    estEqVis.setPuntos(estEqVis.getPuntos()+5);  
	                    estEqLocal.setPuntos(estEqLocal.getPuntos()-3);  
                } else if (estEqLocal.getEnfrenGanados() < estEqVis.getEnfrenGanados()) {
	                 //Si el equipo Visitante gana el partido  
                    //Actualizamos los partidos de los equipos                    
                    estEqVis.setPartGanados(estEqVis.getPartGanados() + 1);  
                    estEqLocal.setPartPerdidos(estEqLocal.getPartPerdidos() + 1);  
                    //Actualizamos los puntos de las estadísticas de los equipos referidas  
                    estEqVis.setPuntos(estEqVis.getPuntos()+5);  
                    estEqLocal.setPuntos(estEqLocal.getPuntos()-3);  
                } else {  //En caso de empate: Incrementamos los puntos a 2 en ambos equipos  
		                    //Actualizamos los partidos de los equipos                
		                    estEqVis.setPartEmpatados(estEqVis.getPartEmpatados() + 1);  
		                    estEqLocal.setPartEmpatados(estEqLocal.getPartEmpatados() + 1);  
		                    //Actualimos los puntos de las estadísticas de los equipos referidas.  
		                    estEqVis.setPuntos(estEqVis.getPuntos()+2);  
		                    estEqLocal.setPuntos(estEqLocal.getPuntos()+2);  
  
                }  
  
    }  
  
}
```

### actualizarEstadisticaCopia()→void #testMethod #Method #metodo/Partido

```java
public void actualizarEstadistica() {  
        Estadistica estEqLocal = super.getLocal().est;  
        Estadistica estEqVis = super.getVisitante().est;  
        EquipoLiga eqLocal = super.getLocal();  
        EquipoLiga eqVis = super.getVisitante();  
        ComparatorEnfrentamientos compE = new ComparatorEnfrentamientos();  
        if (!super.getEnfrentamientos().isEmpty()) {  
            if (compE.compare(eqLocal, eqVis) > 0) {  
                //Actualizamos los partidos de los equipos  
                estEqLocal.setPartGanados(estEqLocal.getPartGanados() + 1);  
                estEqVis.setPartPerdidos(estEqVis.getPartPerdidos() + 1);  
                //Actualizamos los puntos de las estadísticas de los equipos referidas  
                estEqVis.setPuntos(estEqVis.getPuntos()+5);  
                estEqLocal.setPuntos(estEqLocal.getPuntos()-3);  
            } else if (compE.compare(eqLocal, eqVis) < 0) {  
                //Actualizamos los partidos de los equipos  
                estEqVis.setPartGanados(estEqVis.getPartGanados() + 1);  
                estEqLocal.setPartPerdidos(estEqLocal.getPartPerdidos() + 1);  
                //Actualizamos los puntos de las estadísticas de los equipos referidas  
                estEqVis.setPuntos(estEqVis.getPuntos()+5);  
                estEqLocal.setPuntos(estEqLocal.getPuntos()-3);  
            } else {  
                //Actualizamos los partidos de los equipos  
                estEqVis.setPartEmpatados(estEqVis.getPartEmpatados() + 1);  
                estEqLocal.setPartEmpatados(estEqLocal.getPartEmpatados() + 1);  
                //Actualimos los puntos de las estadísticas de los equipos referidas.  
                estEqVis.setPuntos(estEqVis.getPuntos()+2);  
                estEqLocal.setPuntos(estEqLocal.getPuntos()+2);  
  
            }  
    }  
  
}
```

## crearEnfrentamientos(List lLocal, List lVis)→void #metodo/Partido #metodo 

```java TI:"crearEnfrentamientos"
/**  
 * Se encargará de crear los distintos enfrentamientos delpartido. * En base al atributo del número de enfrentamientos que debe realizar  
 * secrearán tanto enfrentamientos como se indique.  Recibe dos listas: * <ul>  
 *     <li>una con losjugadores locales</li>  
 *     <li>y otra con los jugadores visitantes.</li>  
 * </ul>  
 * El sorteo de enfrentamientosse realizará desordenando estas listas   
 * y asignando los jugadores por posición, esdecir, posición 0 con   
 * posición 0, posición 1 con posición 1 y así sucesivamente.  
 * @param lLocal  
 * @param lVis  
 * @see List#sort(Comparator)  
 */@Override  
public void crearEnfrentamientos(List lLocal, List lVis) {  
    EquipoLiga eqLocal = super.getLocal();  
    EquipoLiga eqVis = super.getVisitante();  
    //Ordenamos ambas listas  
    Collections.sort(lLocal, new ComparatorEnfrentamientos());  //??  
    Collections.sort(lVis, new ComparatorEnfrentamientos());  
    if (lLocal != null && lVis != null) {   //Comprobamos si las listas están vacías.  
        Iterator<Jugador> it1 = lLocal.iterator();  
        Iterator<Jugador> it2 = lVis.iterator();  
        while (it1.hasNext() && it2.hasNext()) {  
            Jugador jL = (Jugador) it1.next();  //Obtenemos el jugador local y visitante por cada iteración  
            Jugador jV = (Jugador) it2.next();  
            for (int i = 0; i < super.getNumEnfrentamiento(); i++) { //Realizamos los distintos enfrentamientos  
                super.addEnfrentamientos(new EnfrentamientoPetanca(i, jL, jV));  
            }  
  
        }  
    }  
}
```

### crearEnfrentamientosCopia1(List lLocal, List lVis)→void) #metodo #metodo/Partido 
```java TI:"crearEnfrentmientsoCopia1
    @Override
    public void crearEnfrentamientosCopia1(List<Jugador> lLocal, List<Jugador> lVis) {
        if (lLocal != null && lVis != null) {   //Comprobamos si las listas están vacías.
            //Desordenamos ambas listas
            Collections.shuffle(lLocal);
            Collections.shuffle(lVis);
            Iterator<Jugador> it1 = lLocal.iterator();
            Iterator<Jugador> it2 = lVis.iterator();
            int cont=1;
            while (it1.hasNext() && it2.hasNext()) {
                Jugador jL = (Jugador) it1.next();  //Obtenemos el jugador local y visitante por cada iteración
                Jugador jV = (Jugador) it2.next();
                for (int i = 0; i < super.getNumEnfrentamiento(); i++) { //Realizamos los distintos enfrentamientos
                    super.addEnfrentamientos(new EnfrentamientoPetanca(cont, jL, jV));
                    cont++;
                }

            }
        }
    }>)
```

### crearEnfrentamientosCopia2(List lLocal, List lVis)→void #metodo #metodo/Partido

```java
public void crearEnfrentamientos(List<Jugador> lLocal, List<Jugador> lVis) {  
    if (lLocal != null && lVis != null) {   //Comprobamos si las listas están vacías.  
        int cont = 1;  
        for (int j = 0; j < lLocal.size(); j++) {  
            for (int i = 0; i < super.getNumEnfrentamiento(); i++) { //Realizamos los distintos enfrentamientos  
                //Desordenamos ambas listas en cada enfrentamiento                
                Collections.shuffle(lLocal);  
                Collections.shuffle(lVis);  
                super.addEnfrentamientos(new EnfrentamientoPetanca(cont, lLocal.get(j), lVis.get(j)));  
                cont++;  
            }  
  
        }  
    }  
}
```
### crearEnfrentamientosCopia3(List lLocal, List lVis)→void #testMethod #metodo #metodo/Partido

```java 
public void crearEnfrentamientosCopia3(List<Jugador> lLocal, List<Jugador> lVis) {  
    if (lLocal != null && lVis != null) {   //Comprobamos si las listas están vacías.  
        int cont = 1;  
        for (int i = 0; i < super.getNumEnfrentamiento(); i++) { //Realizamos los distintos enfrentamientos  
            //Desordenamos ambas listas en cada enfrentamiento            Collections.shuffle(lLocal);  
            Collections.shuffle(lVis);  
            super.addEnfrentamientos(new EnfrentamientoPetanca(cont, lLocal.get(i), lVis.get(i)));  
            cont++;  
        }  
  
    }  
}
```
## Main(Comprobaciones)
### Comprobar el correcto funcionamiento de Partido con la clase MainPartido. [[2022-11-26]]

```java TI:"MainPartido.java"
package es.unex.cum.mdp.e22_23;  
  
import java.util.Random;  
  
public class MainPartido {  
    private String tipo="Petanca";  
    private EquipoLiga l=null;  
    private EquipoLiga v=null;  
    private Partido p=null;  
  
    public static void main(String []args) {  
        MainPartido m= new MainPartido();  
        m.run();  
    }  
    public void run() {  
        if (tipo.equals("Petanca")) {  
            l=new EquipoLiga(10,null,new EstadisticaPetanca());  
            v=new EquipoLiga(10,null,new EstadisticaPetanca());  
            p= new PartidoPetanca(1,l,v);  
  
        }else {  
            l=new EquipoLiga(10,null,new EstadisticaPetanca());  
            v=new EquipoLiga(10,null,new EstadisticaPetanca());  
            p= new PartidoPetanca(1,l,v);  
        }  
  
        Random r= new Random();  
        for (int i=0;i%3C10;i++) {  
            Jugador j=new Jugador("Jugador"+i,4,26,"Jugador"+i,r.nextInt(10));  
            l.addJugadores(j);  
        }  
        for (int i=10;i<20;i++) {  
            Jugador j=new Jugador("Jugador"+i,4,26,"Jugador"+i,r.nextInt(10));  
            v.addJugadores(j);  
        }  
        System.out.println(l);  
        System.out.println(v);  
        p.crearEnfrentamientos(l.getJugadores(), v.getJugadores());  
        p.simular();  
        System.out.println(p.getPuntosLocal());  
        System.out.println(p.getPuntosVisitante());  
  
        if (tipo.equals("Futbolin")) {  
            p= new PartidoPetanca(1,l,v);  
  
        }else {  
            p= new PartidoPetanca(1,l,v);  
        }  
        p.crearEnfrentamientos(l.getJugadores(), v.getJugadores());  
        p.jugar(new int[]{5,6,7}, new int[] {4,7,8} );  
        System.out.println(p.getPuntosLocal());  
        System.out.println(p.getPuntosVisitante());  
    }  
}
)
```

# Clases Comparator
## ComparatorPuntos #testMethod #comparator
```java TI:"ComparatorPuntos.java"
/**  
 * Compara los puntos de los equipos Local y Visitante de la Liga. * @param e1 the first object to be compared.  
 * @param e2 the second object to be compared.  
 * @return entero, Devuelve un valor entero  
 * <ul>  
 *     <li>Positivo: mayor puntuacion o numeros de enfrentamientos ganados del equipo Local</li>  
 *     <li>Negativo: menor puntuacion o numeros de enfrentamientos ganados del equipo Visitante</li>  
 *     <li>0: Ambos equipos tienen el mismo número de puntuación o enfrentamientos ganados.</li>  
 * </ul>  
 */  
@Override  
public int compare(EquipoLiga e1, EquipoLiga e2) {  
    return e1.getCoef()-e2.getCoef();  
}
```

## ComparatorPartidos #testMethod #comparator

```java TI:"ComparatorPartidos.java"
/**  
 * Compara los partidos ganados y/o empatados y/o perdidos * de los equipos Local y Visitante de la Liga. * @param e1 the first object to be compared.  
 * @param e2 the second object to be compared.  
 * @return entero, Devuelve un valor de tipo entero  
 */@Override  
public int compare(EquipoLiga e1, EquipoLiga e2) {  
    int comparison = Integer.compare(e1.est.partGanados,e2.est.partGanados); //Primero comparamos los partidos ganados  
    if(comparison != 0){  
        return comparison;  
    }  
    comparison = Integer.compare(e1.est.partEmpatados,e2.est.partEmpatados); //Primero comparamos los partidos empatados  
    if(comparison != 0){  
        return comparison;  
    }  
    return Integer.compare(e1.est.partPerdidos,e2.est.partPerdidos); //Primero comparamos los partidos perdidos  
}
```

## ComparatorEnfrentamientos #testMethod #comparator

```java TI:"ComparatorEnfrentamientos.java"
/**  
 * Compara los enfrentamientos ganados y/o empatados y/o perdidos * de los equipos Local y Visitante de la Liga. * @param e1 the first object to be compared.  
 * @param e2 the second object to be compared.  
 * @return  
 */  
@Override  
public int compare(EquipoLiga e1, EquipoLiga e2) {  
    int comparison = Integer.compare(e1.est.enfrenGanados,e2.est.enfrenGanados); //Primero comparamos los enfrentamientos ganados  
    if(comparison != 0){  
        return comparison;  
    }  
    comparison = Integer.compare(e1.est.enfrenEmpatados,e2.est.enfrenEmpatados); //Primero comparamos los enfrentamientos empatados  
    if(comparison != 0){  
        return comparison;  
    }  
    return Integer.compare(e1.est.enfrenPerdidos,e2.est.enfrenPerdidos); //Primero comparamos los enfrentamientos perdidos  
}
```

# Clase Jornada
## Métodos
### crearEnfrentamientosJornada()→void #testMethod #metodo/Jornada
```java TI:"crearEnfrentamientosJornada"
/**  
 * Consiste en crear enfrentamientos en cada uno de los partidos * de la lista partidos de Jornada */public void crearEnfrentamientosJornada(){  
    if(!partidos.isEmpty()){    //Comprobamos que la lista de partidos no esté vacía  
        for (int i = 0; i < partidos.size(); i++) {  
            //Creamos enfrentamientos por cada partido  
            partidos.get(i).crearEnfrentamientos(partidos.get(i).getLocal().jugadores , partidos.get(i).getVisitante().jugadores);  
        }  
    }  
  
}
```
### jugar(int numPartido, int[] puntosLocal, int[] puntosVisitante)→boolean #metodo #meodo/Jornada #testMethod
```java TI:"jugar"
 /**  
 * Método que recibe dos arrays de entero con los puntos para el partido indicado por parámetro. * Tras el partido, se debe actualizar las estadísticas * @param numPartido      Recibe el Identificador del partido.  
 * @param puntosLocal     Recibe una lista con los puntos del equipo Local  
 * @param puntosVisitante Recibe una lista con los puntos del equipo Visitante  
 */
 public boolean jugar(int numPartido, int[] puntosLocal, int[] puntosVisitante) {  
    if (!partidos.isEmpty()) { //comprobamos si la lista de partidos no está vacía  
        //Comprobamos que exista el identificador numPartido del Partido        if (getPartidoId(numPartido) != null) { //Si existe el Identificador del partido numPartido  
            for (Partido p : partidos) {  
                /*Realizamos la simulación de todos los enfrentamientos  
                de cada uno de los partidos*/                if (p.jugar(puntosLocal, puntosVisitante)) {  
                    //Actualizamos las estadísticas de los equipos referidos.  
                    p.actualizarEstadistica();  
                }  
  
            }  
            return true;  
        }  
  
    }  
    return false;  
}
```
### simular()→boolean #metodo #metodo/Jornada #testMethod 
```java TI:"simular"
/**  
 * Se encarga de realizar la simulación de todos los partidos de la * jornada. Tras cada partido, se debe actualizar las estadísticas. */public boolean simular() {  
    if (!partidos.isEmpty()) {  //Comprobamos que exista o que no esté vacía la lista de partidos  
        for (Partido p : partidos) {    //Recorremos dicha lista  
            if (p.simular()) {  //Simulamos los enfrentamientos de cada partido  
                p.actualizarEstadistica();  //Actualizamos las estadísticas de los equipos referidos.  
            }  
        }  
        return true;  
    }  
    return false;  
}
```

### addPartidos(Partido part)→boolean #metodo #metodo/Jornada #metodoAdicional 
```java TI:"addPartidos"
/**  
 * Añadimos un partido a la lista de partidos de una Jornada * * @param part Recibe un objeto de tipo Partido  
 * @return booleano Devuelve un valor booleano  
 * <ul>  
 *     <li>True: Se inserta el enfrentamiento</li>  
 *     <li>False: NO se inserta el enfrentamiento</li>  
 * </ul>  
 * <a href="https://github.com/Jloen1999/tramitesPlanificaciones/blob/c237c7ba3c4478ce1b0e9c6b9f56c28be1f44fb4/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Metodos/Metodos.md#addjugadorjugador-jboolean">Flujo normal y alterno</a>  
 */  
public boolean addPartidos(Partido part) {  
    boolean insertado = false;  
    Partido part1 = getPartidoId(part.getId());  
    if (part != null && part1 == null) {  
        insertado = partidos.add(part);  
    }  
    return insertado;  
}
```

### getPartidoId(int numero)→Partido
```java TI:"getPartidoId"
/**  
 * Obtenemos un partido dado su numero(id) * * @param numero Recibe un valor de tipo entero  
 * @return Devuelve un objeto de tipo Partido  
 * <ul>  
 *     <li>NULL: Si el partido ya existe</li>  
 *     <li>NO NULL: Si no existe el partido</li>  
 * </ul>  
 */  
public Partido getPartidoId(int numero) {  
    Partido p = null;  
    if (partidos != null && numero > 0) {  
        Iterator<Partido> it = partidos.iterator();  
        while (it.hasNext() && p == null) {  
            Partido p1 = it.next();  
            if (p1.getId() == numero) {  
                p = p1;  
            }  
  
        }  
    }  
  
    return p;  
}
```

## Test de Jornada
### MainJornada
```java TI:"MainJornada"
package es.unex.cum.mdp.e22_23;  
  
import java.util.Date;  
import java.util.Random;  
  
public class MainJornada {  
    private String tipo = "Petanca";  
    private EquipoLiga l1 = null;  
    private EquipoLiga l2 = null;  
    private EquipoLiga v1 = null;  
    private EquipoLiga v2 = null;  
    private Partido p1 = null;  
    private Partido p2 = null;  
    private Jornada j = null;  
  
    public static void main(String[] args) {  
        MainJornada m = new MainJornada();  
        m.run();  
    }  
  
    public void run() {  
        //Creamos los equipos y los añadimos a los partidos  
        if (tipo.equals("Petanca")) {  
            l1 = new EquipoLiga(10, null, new EstadisticaPetanca());  
            l2 = new EquipoLiga(11, null, new EstadisticaPetanca());  
            v1 = new EquipoLiga(12, null, new EstadisticaPetanca());  
            v2 = new EquipoLiga(13, null, new EstadisticaPetanca());  
            p1 = new PartidoPetanca(1, l1, v1);  
            p2 = new PartidoPetanca(2, l2, v2);  
  
        } else {  
            l1 = new EquipoLiga(10, null, new EstadisticaFutbolin());  
            l2 = new EquipoLiga(10, null, new EstadisticaFutbolin());  
            v1 = new EquipoLiga(10, null, new EstadisticaFutbolin());  
            v2 = new EquipoLiga(10, null, new EstadisticaFutbolin());  
            p1 = new PartidoPetanca(1, l1, v1);  
            p2 = new PartidoPetanca(2, l2, v2);  
        }  
  
        //Creamos la Jornada y añadimos los partidos a la lista de Jornadas  
        j = new Jornada(new Date(), 1);  
        j.addPartidos(p1);  
        j.addPartidos(p2);  
        System.out.println(j.getPartidos()); //Comprobamos que los partidos han sido añadidos correctamente  
  
        //Añadimos los jugadores a cada uno de los equipos        Random r = new Random();  
        for (int i = 0; i < 10; i++) {  
            Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "Jugador" + (i + 1), r.nextInt(10));  
            l1.addJugadores(j);  
        }  
        for (int i = 10; i < 20; i++) {  
            Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "Jugador" + (i + 1), r.nextInt(10));  
            v1.addJugadores(j);  
        }  
        for (int i = 20; i < 30; i++) {  
            Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "Jugador" + (i + 1), r.nextInt(10));  
            l2.addJugadores(j);  
        }  
        for (int i = 30; i < 40; i++) {  
            Jugador j = new Jugador("Jugador" + (i + 1), i + 1, 26, "Jugador" + (i + 1), r.nextInt(10));  
            v2.addJugadores(j);  
        }  
  
//        j.crearEnfrentamientosPartido(); //Creamos los enfrentamientos por cada partido  
//        System.out.println(j.getPartidos().get(0).getEnfrentamientos().toString()); //Mostramos los enfrentamientos dle primer partido antes de ser simulados  
//        j.simular();    //Simulamos los enfrentamientos  
//        //Mostramos los enfrentamientos dle primer partido después de ser simulados  
//        System.out.println(j.getPartidos().get(0).getEnfrentamientos().toString());  
  
        j.crearEnfrentamientosJornada(); //Creamos los enfrentamientos por cada partido  
        System.out.println(j.getPartidos().get(0).getEnfrentamientos().toString()); //Mostramos los enfrentamientos dle primer partido antes de ser simulados  
        j.jugar(1,new int[]{4,6,8}, new int[]{5,9,3} );    //Simulamos los enfrentamientos  
        //Mostramos los enfrentamientos dle primer partido después de ser simulados        System.out.println(j.getPartidos().get(0).getEnfrentamientos().toString());  
  
    }  
}
```
### Bateria de Test de Jornada
```java TI:"testJornada"
package test.es.unex.cum.mdp.e22_23;  
  
public class TestJornada {  
}
```