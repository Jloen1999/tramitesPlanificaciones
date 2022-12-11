# Diagrama

![umlPartido](https://github.com/Jloen1999/tramitesPlanificaciones/blob/3f992be0008cbe0472177ce3004849d8f8c301a7/estudios/UEX/Curso2/Asignaturas/MDP/ProyectoFinal2/Clases/Partido/images/UMLPartido.png)


# Métodos
## Prerrequisitos y Flujo normal y alterno
### getEnfrentamientoId(int id) →EnfrentamientoPetanca
- Comprobamos que el id pasado por parámetro no sea menor que 0 y que la lista de enfrentamientos no sea nula.
	- Si no se cumple el método devuelve null.
	- En caso contrario recorremos la lista de enfrentamientos y comparamos el id de cada enfrentamiento con el id pasado por parámetro:
		- Si son iguales el método devolverá el enfrentamiento que tenga dicho id.
		- En caso contrario el método devolverá null.

### addEnfrentamientos(EnfrentamientoPetanca enf)  →boolean
- Comprobamos si el enfrentamiento existe en la lista de enfrentamientos reutilizando el método getEnfrentamientoId:
	- Si dicho método devuelve null es porque el enfrentamiento no existe, entonces procedemos a añadirlo → return true. 
	- En caso contrario, existe el enfrentamiento → return false.
