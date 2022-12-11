# Diagrama

![umlPartido](https://github.com/Jloen1999/tramitesPlanificaciones/blob/3f992be0008cbe0472177ce3004849d8f8c301a7/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/PartidoPetanca/images/UMLPartidoPetanca.png)


# Métodos
## Prerrequisitos y Flujo normal y alterno
### simular() → boolean
- Comprobamos que la lista de enfrentamientos no esté vacía:
	- Si está vacía el método devuelve false.
	- En caso contrario recorremos la lista y obtenemos cada enfrentamiento. →Devuelve true
		- Comparamos los puntos de cada simulación:
			- Si puntos > 0: Gana el equipoLiga Local.
				- Incrementamos una unidad los puntosLocales del partido
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Ganados del equipoLiga Local
					- Incrementamos una unidad los enfrentamientos Perdidos del equipoLiga Visitante.
			- Si puntos < 0: Gana el equipoLiga Visitante.
				- Incrementamos una unidad los puntosVisitante del partido
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Ganados del equipoLiga Visitante.
					- Incrementamos una unidad los enfrentamientos Perdidos del equipoLiga Local.
			- Si puntos == 0: Empatan ambos equipos.
				- Incrementamos una unidad los puntosLocales del partido
				- Actualizamos las estadísticas:
					- Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Local
					- Incrementamos una unidad los enfrentamientos Empatados del equipoLiga Visitante.

### addEnfrentamientos(EnfrentamientoPetanca enf)  
- Comprobamos si el enfrentamiento existe en la lista de enfrentamientos reutilizando el método getEnfrentamientoId:
	- Si dicho método devuelve null es porque el enfrentamiento no existe, entonces procedemos a añadirlo → return true. 
	- En caso contrario, existe el enfrentamiento → return false.