# Clase EquipoLiga

## Métodos

### getJugador(int id)→Jugador 
- Pasos: ^getJugador
	- Comprobamos que la lista de jugadores no sea nula.
	- Comprobamos que el id no se negativo o cero.
	- Inicializamos un objeto de la clase Jugador a NULL.
	- Recorremos la lista de jugadores con un for, while o Iterator, obtenemos el id de cada jugador y lo comparamos con el id del jugador buscado:
		- si coinciden almacenamos el jugador en el objeto inicializado y devolvemos el <font color="#00b050">jugador</font>.
		- si no coinciden devolvemos <font color="#ff0000">NULL</font>.

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
- PreRequisito: <font color="red">Solo se usa cuando el juez anota el resultado del enfrentamiento</font>
- Realizamos la siguiente operación:
```math
||{"id":455737260076}||
local-visitante
```
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