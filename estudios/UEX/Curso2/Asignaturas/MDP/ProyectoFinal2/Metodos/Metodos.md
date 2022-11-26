# Metodos a implementar de la clase EquipoLiga

## getJugador(int id)→Jugador 
- Pasos: ^getJugador
	- Comprobamos que la lista de jugadores no sea nula.
	- Comprobamos que el id no se negativo o cero.
	- Inicializamos un objeto de la clase Jugador a NULL.
	- Recorremos la lista de jugadores con un for, while o Iterator, obtenemos el id de cada jugador y lo comparamos con el id del jugador buscado:
		- si coinciden almacenamos el jugador en el objeto inicializado y devolvemos el <font color="#00b050">jugador</font>.
		- si no coinciden devolvemos <font color="#ff0000">NULL</font>.

## addJugador(Jugador j)→boolean
- Pasos:  ^addJugador
	- Comprobamos que el jugador no sea nulo.
		- Si Jugador no nulo: 
			- Obtenemos el id del jugador.
			- Reutilizamos el metodo getJugador(id), obtenemos un objeto de tipo Jugador:
				- Si devuelve NULL, podemos añadir el jugador y devolvemos <font color="#00b050">True</font>.
				- Si no es NULL, no añadimos y devolvemos <font color="#ff0000">False</font>
		- Si Jugador es Nulo: Devolvemos <font color="#ff0000">false</font>.

# Métodos a implementar de la clase EnfrentamientoPetanca
## simular(intcoefEqLocal, int coefEqVis)→int
- Realizamos la siguiente operación:
```math
||{"id":455737260076}||
(local+jLocal1.getCoeficiente)-(visitante+jVis1.getCoeficiente)
```
- Valor de retorno:
	-  Valor positivo → gana el equipo Local
	- Valor 0 → empate(misma puntuación o coeficiente)
	-  Valor negativo → gana el equipo Visitante.

## jugar(int coefEqLocal, int coefEqVis)
- PreRequisito: <font color="red">Solo se usa cuando el juez anota el resultado del enfrentamiento</font>
- Realizamos la siguiente operación:
```math
||{"id":455737260076}||
local-visitante
```
