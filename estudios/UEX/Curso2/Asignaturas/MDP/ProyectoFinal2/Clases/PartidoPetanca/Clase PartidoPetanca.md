# Diagrama

![umlPartido](https://github.com/Jloen1999/tramitesPlanificaciones/blob/26afb42c69971252b87213bb37c73a81551e9078/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/PartidoPetanca/images/umlPartidoPetanca.png)


# Métodos
## Prerrequisitos y Flujo normal y alterno
### simular() → boolean
- Comprobamos que la lista de enfrentamientos no esté vacía:
	- Si está vacía el método devuelve false.
	- En caso contrario recorremos la lista y obtenemos cada enfrentamiento. →Devuelve true
		- Simulamos cada enfrentamiento y comparamos los puntos generados:
			- Si puntos > 0: Gana el enfrentamiento el equipoLiga Local y pierde el Visitante.
				- Incrementamos una unidad los puntosLocales del partido
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Ganados del equipoLiga Local
					- Incrementamos una unidad los enfrentamientos Perdidos del equipoLiga Visitante.
			- Si puntos < 0: Gana el enfrentamiento el equipoLiga Visitante y pierde el Local.
				- Incrementamos una unidad los puntosVisitante del partido
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Ganados del equipoLiga Visitante.
					- Incrementamos una unidad los enfrentamientos Perdidos del equipoLiga Local.
			- Si puntos == 0: Empatan el enfrentamiento ambos equipos.
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Local
					- Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Visitante.

### jugar() → boolean
- Comprobamos que la lista de enfrentamientos no sea nula y que los puntos locales del partido y los puntos Visitante sean iguales que el total de enfrentamientos:
	- Si NO se cumple devuelve false.
	- En caso contrario recorremos la lista y obtenemos cada enfrentamiento. →Devuelve true
		- Jugamos cada enfrentamiento y comparamos los puntos de cada juego:
			- Si puntos > 0: Gana el enfrentamiento equipoLiga Local y pierde el Visitante.
				- Incrementamos una unidad los puntosLocales del partido
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Ganados del equipoLiga Local
					- Incrementamos una unidad los enfrentamientos Perdidos del equipoLiga Visitante.
			- Si puntos < 0: Gana el enfrentamiento equipoLiga Visitante y pierde el Local.
				- Incrementamos una unidad los puntosVisitante del partido
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Ganados del equipoLiga Visitante.
					- Incrementamos una unidad los enfrentamientos Perdidos del equipoLiga Local.
			- Si puntos == 0: Empatan el enfrentamiento ambos equipos.
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Local
					- Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Visitante.

### actualizarEstadistica() → void
- Comprobamos que la lista de enfrentamientos no esté vacía y que no sea nula:
	- Si NO se cumple, NO se actualizan los enfrentamientos ya que no hay enfrentamientos.
	- En caso contrario:
		- Incrementamos una unidad en estadística, los partidos jugados de ambos equipos.
		- Comparamos los puntos Locales con los puntos Visitante del partido:
			- Si los puntos locales del partido > los puntos Visitante del partido: Gana el partido equipoLiga Local y pierde el Visitante.
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los partidos Ganados del equipoLiga Local
					- Incrementamos una unidad los partidos Perdidos del equipoLiga Visitante.
			- Si los puntos locales del partido < los puntos Visitante del partido: Gana el partido equipoLiga Local y pierde el Visitante.
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los partidos Ganados del equipoLiga Visitante
					- Incrementamos una unidad los partidos Perdidos del equipoLiga Local.
			- Si los puntos locales del partido == los puntos Visitante del partido: Gana el partido equipoLiga Local y pierde el Visitante.
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los partidos Empatados del equipoLiga Local
					- Incrementamos una unidad los partidos Empatados del equipoLiga Visitante.

### crearEnfrentamientos(List<Jugador> lLocal, List<Jugador> lVis) →void
- Comprobamos si la lista de jugadores Locales y jugadores Visitante están vacías:
	- Si están vacías→ No creamos ningún enfrentamiento, ya que no hay jugadores.
	- En caso contrario:
		- Declaramos una variable de tipo entero, el cual será el identificador de cada enfrentamiento, se irá incrementando cada vez que creamos un enfrentamiento.
		- Desordenamos ambas listas de jugadores antes de crear los enfrentamientos para que los enfrentamientos entre jugadores sea aleatorio.
		- Recorremos la lista de enfrentamientos y creamos los enfrentamientos por cada item. pasándole el id y los jugadores.