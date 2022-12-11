`````ad-warning
title: Duda método crearEnfentamiento
collapse: open
No devuelve nada?(void)
Si le pasamos una lista de x jugadores locales y visitantes a la hora de crear los enfrentamientos en teoría deberían hacer enfrentamientos todos los jugadores de par en par cada par 3 enfrentamientos? O solo necesitamos 2 jugadores random que hagan los 3 enfrentamientos?
````ad-warning
title: Y no entiendo esta parte del enunciado:
collapse: open
El sorteo de enfrentamientos se realizará desordenando estas listas y asignando los jugadores por posición, esdecir, posición 0 con posición 0, posición 1 con posición 1 y así sucesivamente.
````
```ad-success
title: Corrección
Debe hacer los enfrentamientos  con todos los jugadores de par en par.  

El sorteo primero se desordenan las listas y luego asignan el jugador local 0 con el jugador visitante 0. El siguiente enfrentamiento el jugador local 1 con el jugador visitante 1, y así sucesivamente.
```


`````

````ad-success
title: Corrección
Debe hacer los enfrentamientos  con todos los jugadores de par en par.  

El sorteo primero se desordenan las listas y luego asignan el jugador local 0 con el jugador visitante 0. El siguiente enfrentamiento el jugador local 1 con el jugador visitante 1, y así sucesivamente.
```ad-danger
title: Corrígeme si lo he entendido
PD:Entonces primero desordeno la lista. 
Ejemplo: Si hay 3 enfrentamientos por partido y tengo digamos 10 jugadores por cada equipoLiga, en teoría solo podrían jugar 6 jugadores en total, 3 pares de jugadores tendríamos porque solo hay 3 enfrentamientos ya que en cada enfrentamiento solo pueden jugar 2 jugadores por equipo? No se si lo he entendido bien, porque si fuese así tendría que limitar que a la hora de hacer los enfrentamientos coja solo 6 jugadores en total.
Y otra cosa que he pensado es que si son 10 jugadores simplemente todos juegan pero cada par de jugadores jugaría 3 enfrentamientos y en total serían 30 enfrentamientos pero no tendría sentido si numEnfrentamientos es 3.
```
````


````ad-warning
title: Clase MainPartido
collapse: open
Cuando hago la prueba de PartidoPetanca con el MainPartido el ID de los jugadores debe ser incremental verdad?   Porque pasaba que intentaba hacer la prueba y solo me aparecía un jugador por equipo y era porque en el MainJugador se intenta añadir jugadores con el mismo ID cosa que no es posible con el método addJugadores.
`````