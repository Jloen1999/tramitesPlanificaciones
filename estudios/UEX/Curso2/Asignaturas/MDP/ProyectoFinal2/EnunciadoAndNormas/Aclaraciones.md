## Day Planner
- [ ] [[2022-11-26]] Cumplir todas las siguientes aclaraciones
#normas
````````ad-warning
title: comparators
collapse: open
## Day Planner
- [ ] [[2022-11-26]] #todo

Todos los comparators reciben objetos EquipoLiga pues a la hora de ordenar, se ordena la lista de EquipoLiga de la liga #todo

```````ad-danger
title: GestionDeportiva(Campeonato) & EstadisticaPetanca(no goles)
collapse: close
## Day Planner
- [ ] [[2022-11-26]] #todo
Con respecto a la segunda entrega final, informaros:  
1. La clase GestionDeportiva debe llamarse Campeonato.  
2. La clase derivada EstadisticaPetanca no tiene ningún atributos (en la petanca no hay goles). Es un error que he cometido.
```````

``````ad-warning
title: getLigaTemporada
collapse: close
## Day Planner
- [ ] [[2022-11-26]] #todo

El método getLigaTemporada de la clase Campeonato debe ser público en lugar de privado (tal y como aparece en el UML). Además este método debe devolver la excepcion NoLigaException.
``````

`````ad-warning
title: No modificar batería test bitbucker
collapse: close
## Day Planner
- [ ] [[2022-11-26]] #todo
NO SE PUEDE modificar la bateria de test para que funcione, pues luego no se validará con la mía.
`````

````ad-note
title: crearCalendario
collapse: close
## Day Planner
- [ ] [[2022-11-26]]
Informaros que he modificado el algoritmo de crearCalendario del enunciado de la Entrega Final. Debe devolver un boolean y además he añadido dos comprobaciones que son necesarias. Lo he dejado en el bitbucket de la asignatura.  

Igualmente he actualizado MainEnfrentamiento.java que tenía un error.  

Cualquier cambio en el enunciado lo comunicaré por aquí.
````

```ad-warning
title: Metodos jugar() y simular() de Liga, Jornada, Partido, los puntos, goles(no usar en Campeonato Petanca) comparators y enfrentamientos
collapse: close
## Day Planner
- [ ] [[2022-11-26]]
- Los métodos jugar() y simular() de Liga, Jornada, Partido devuelven un void (no devuelven nada). Me dí cuenta de esto una vez liberado el diagrama UML y por tanto los controles que deben hacerse en simular() y jugar los he realizado en campeonato. Mi recomendación es que los métodos jugar() y simular() de Liga, Jornada y Partido devuelvan un boolean y así es más sencilla la implementación.  
- Con respecto a los comparators:  
	- Con puntos: se comparan los puntos del equipo local con el visitante.  
	- Con partidos: en primer lugar se comparan los partidos ganados de los dos equipos (si uno tiene más ganados que otro, ya es mejor). En el caso que sean iguales se comparan los empatados y finalmente se comparan los perdidos (son necesarios al menos 6 if).  
	- Con goles: Se suma de goles a favor menos los goles en contra del equipo y se comparan con el otro.  
	- Con Enfrentamientos: en primer lugar se comparan los enfrentamientos ganados de los dos equipos. En el caso que sean iguales se comparan los empatados y finalmente se comparan los perdidos (son necesarios al menos 6 if).
```

````````



